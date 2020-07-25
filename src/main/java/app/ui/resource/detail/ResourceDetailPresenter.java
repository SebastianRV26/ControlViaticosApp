package app.ui.resource.detail;

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
public class ResourceDetailPresenter<V extends ResourceDetailContract.View>
        extends BasePresenter<V> implements ResourceDetailContract.Presenter<V> {

    /**
     * Called everytime the view wants to add a new resource.
     *
     * @param responsable resource's responsible
     * @param descripcion resource's description
     */
    @Override
    public void addResource(String responsable, String descripcion) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(responsable)) {
            getView().onError("El responsable no puede estar vacío.");
            return;
        } else if (Utils.textIsNullOrEmpty(descripcion)) {
            getView().onError("La descripcion no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("responsable", responsable.trim());
        request.put("descripcion", descripcion.trim());

        Api.getInstance().getResourceService().addResource(request)
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
                            getView().onError("Ya hay un recurso con esos"
                                    + " datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    /**
     * Called everytime the view wants to add a new client.
     *
     * @param id client's id
     * @param responsable resource's responsible
     * @param descripcion resource's description
     */
    @Override
    public void updateResource(int id, String responsable, String descripcion) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(responsable)) {
            getView().onError("El responsable no puede estar vacío.");
            return;
        } else if (Utils.textIsNullOrEmpty(descripcion)) {
            getView().onError("La descripcion no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(3);
        System.out.println(id);
        request.put("resourceId", id);
        request.put("responsable", responsable.trim());
        request.put("descripcion", descripcion.trim());

        Api.getInstance().getResourceService().updateResource(request)
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
                            getView().onError("El recurso ya no existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("Ya existe un recurso con esos "
                                    + "datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

}
