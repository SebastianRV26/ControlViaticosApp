package app.ui.expense;

import app.data.network.Api;
import app.ui.base.BasePresenter;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * The presenter class responsible for the communication between the view and
 * the API.
 *
 * @param <V> the view attached to this presenter
 */
public class ExpenseDetailPresenter<V extends ExpenseDetailContract.View>
        extends BasePresenter<V> implements ExpenseDetailContract.Presenter<V> {

    @Override
    public void loadData() {
        Single.zip(
                Api.getInstance().getExpenseTypeService().getExpenseTypes(),
                Api.getInstance().getSupplierService().getSuppliers(),
                Api.getInstance().getVehicleService().getVehicles(),
                Api.getInstance().getResourceService().getResources(),
                (taskTypes, suppliers, vehicles, resources) -> {
                    return new DataResult(taskTypes, suppliers, vehicles,
                            resources);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((DataResult result) -> {
                    // Request executed successfully
                    getView().onLoadData(result);
                }, throwable -> {
                    // Let's manage errors
                    getView().onError("Error de conexión."
                            + "\nIntente de nuevo");
                });
    }
}
