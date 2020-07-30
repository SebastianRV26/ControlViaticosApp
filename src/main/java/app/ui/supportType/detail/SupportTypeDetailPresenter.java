package app.ui.supportType.detail;

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
public class SupportTypeDetailPresenter<V extends SupportTypeDetailContract.View>
        extends BasePresenter<V> implements SupportTypeDetailContract.Presenter<V> {

    /**
     * Called everytime the view wants to add a new client.
     *
     * @param descripcion Support type
     */
    @Override
    public void addSupportType(String descripcion) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(descripcion)) {
            getView().onError("La razón social no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("descripcion", descripcion.trim());

        Api.getInstance().getSupportTypeService().addSupportType(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess("Se agrego un nuevo tipo de soporte");
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("Ya hay un tipo soporte con esos"
                                    + " datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    /**
     * Called everytime the view wants to add a new SupportType.
     *
     * @param id SupportType's id
     * @param descripcion Support Type
     */
    @Override
    public void updateSupportType(int id, String descripcion) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(descripcion)) {
            getView().onError("La descripcion no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("id", id);
        request.put("descripcion", descripcion.trim());

        Api.getInstance().getSupportTypeService().updateSupportType(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess("Se modifico el tipo de soporte");
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El tipo soporte ya no existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("Ya existe un tipo soporte con esos "
                                    + "datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

}
