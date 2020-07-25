package app.ui.supplier.detail;

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
public class SupplierDetailPresenter<V extends SupplierDetailContract.View>
        extends BasePresenter<V> implements SupplierDetailContract.Presenter<V> {

    /**
     * Called everytime the view wants to add a new supplier.
     *
     * @param description descripción
     */
    @Override
    public void addSupplier(String description) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(description)) {
            getView().onError("La descripción no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("descripcion", description.trim());

        Api.getInstance().getSupplierService().addSupplier(request)
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
                            getView().onError("Ya hay un proveedor con esos"
                                    + " datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    /**
     * Called everytime the view wants to add a new supplier.
     *
     * @param id supplier's id
     * @param description descripcion
     */
    @Override
    public void updateSupplier(int id, String description) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(description)) {
            getView().onError("La descripcion no puede estar vacía.");
            return;
        }
        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("id", id);
        request.put("descripcion", description.trim());
        Api.getInstance().getSupplierService().updateSupplier(request)
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
                            getView().onError("El proveedor ya no existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("Ya existe un proveedor con esos "
                                    + "datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

}
