package app.ui.reason.detail;

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
public class ReasonDetailPresenter<V extends ReasonDetailContract.View>
        extends BasePresenter<V> implements ReasonDetailContract.Presenter<V> {

    /**
     * Called everytime the view wants to add a new reason.
     *
     * @param descripcion reason description
     */
    @Override
    public void addReason(String descripcion) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(descripcion)) {
            getView().onError("La descripción no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("descripcion", descripcion.trim());

        Api.getInstance().getReasonService().addReason(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess("Se agrego un nuevo motivo");
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("Ya hay un motivo con esos"
                                    + " datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    /**
     * Called everytime the view wants to add a new reason.
     *
     * @param id reason id
     * @param descripcion reason description
     */
    @Override
    public void updateReason(int id, String descripcion) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(descripcion)) {
            getView().onError("La descripción no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("reasonId", id);
        request.put("descripcion", descripcion.trim());

        Api.getInstance().getReasonService().updateReason(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess("Se modifico el motivo");
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El motivo ya no existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("Ya existe un motivo con esos "
                                    + "datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

}
