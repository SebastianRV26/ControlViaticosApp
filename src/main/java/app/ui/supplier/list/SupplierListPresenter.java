package app.ui.supplier.list;

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
public class SupplierListPresenter<V extends SupplierListContract.View>
        extends BasePresenter<V> implements SupplierListContract.Presenter<V> {

    /**
     * Called when the view needs to load the suppliers from the database.
     */
    @Override
    public void loadSuppliers() {
        Api.getInstance().getSupplierService().getSupplier()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((suppliers) -> {
                    getView().showSuppliers(suppliers);
                }, throwable -> {
                    getView().onError("Error de conexión al cargar datos."
                            + "\nIntente de nuevo");
                });
    }

    /**
     * Called when the view needs to disable a supplier from the database.
     *
     * @param id supplier's id
     */
    @Override
    public void disableSupplier(int id) {
        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("id", id);
        request.put("isActive", 0);

        // Executes the request
        Api.getInstance().getSupplierService().updateSupplier(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request successful
                    getView().refreshData();
                }, throwable -> {
                    // Request error
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El proveedor ya no existe.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }
}
