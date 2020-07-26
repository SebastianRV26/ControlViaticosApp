package app.ui.expenseType.detail;

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
public class ExpenseTypeDetailPresenter<V extends ExpenseTypeDetailContract.View>
        extends BasePresenter<V> implements ExpenseTypeDetailContract.Presenter<V> {

    /**
     * Called everytime the view wants to add a new expense type.
     *
     * @param descripcion description of the expense type
     */
    @Override
    public void addExpenseType(String descripcion) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(descripcion)) {
            getView().onError("La descripción no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("descripcion", descripcion.trim());

        Api.getInstance().getExpenseTypeService().addExpenseType(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess();
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("Ya hay un tipo de viatico con"
                                    + " esos datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    /**
     * Called everytime the view wants to add a new expense type.
     *
     * @param id id of the expense type
     * @param descripcion description of the expense type
     */
    @Override
    public void updateExpenseType(int id, String descripcion) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(descripcion)) {
            getView().onError("La descripción no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("expenseTypeId", id);
        request.put("descripcion", descripcion.trim());

        Api.getInstance().getExpenseTypeService().updateExpenseType(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess();
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El tipo de viatico ya no "
                                    + "existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("Ya existe un tipo de viatico con"
                                    + " esos datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

}
