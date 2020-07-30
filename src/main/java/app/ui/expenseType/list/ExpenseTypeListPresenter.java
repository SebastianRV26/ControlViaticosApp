package app.ui.expenseType.list;

import app.data.model.StatusResponse;
import app.data.network.Api;
import app.ui.base.BasePresenter;
import app.util.Utils;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.HashMap;

/**
 * The presenter class responsible for the communication between the view and
 * the API.
 *
 * @param <V> the view attached to this presenter
 */
public class ExpenseTypeListPresenter<V extends ExpenseTypeListContract.View>
        extends BasePresenter<V> implements ExpenseTypeListContract.Presenter<V> {

    /**
     * Called when the view needs to load the expense types from the database.
     */
    @Override
    public void loadExpenseTypes() {
        Api.getInstance().getExpenseTypeService().getExpenseTypes()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((expenseTypes) -> {
                    getView().showExpenseTypes(expenseTypes);
                }, throwable -> {
                    getView().onError("Error de conexión al cargar datos."
                            + "\nIntente de nuevo");
                });
    }

    /**
     * Called when the view needs to disable an expense type from the database.
     *
     * @param expenseTypeId id of the expense type
     */
    @Override
    public void disableExpenseType(int expenseTypeId) {
        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("expenseTypeId", expenseTypeId);
        request.put("isActive", 0);

        // Executes the request
        Api.getInstance().getExpenseTypeService().updateExpenseType(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request successful
                    getView().refreshData();
                    getView().onSuccess("Se eliminó el tipo de viatico");
                }, throwable -> {
                    // Request error
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El tipo de viatico ya no"
                                    + " existe.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }
}
