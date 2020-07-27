package app.ui.taskType.detail;

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
public class TaskTypeDetailPresenter<V extends TaskTypeDetailContract.View>
        extends BasePresenter<V> implements TaskTypeDetailContract.Presenter<V> {

    /**
     * Called everytime the view wants to add a new task type.
     *
     * @param descripcion description of the task type
     */
    @Override
    public void addTaskType(String descripcion) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(descripcion)) {
            getView().onError("La descripción no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("descripcion", descripcion.trim());

        Api.getInstance().getTaskTypeService().addTaskType(request)
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
                            getView().onError("Ya hay un tipo de labor con"
                                    + " esos datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    /**
     * Called everytime the view wants to add a new task type.
     *
     * @param id id of the task type
     * @param descripcion description of the task type
     */
    @Override
    public void updateTaskType(int id, String descripcion) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(descripcion)) {
            getView().onError("La descripción no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("taskTypeId", id);
        request.put("descripcion", descripcion.trim());

        Api.getInstance().getTaskTypeService().updateTaskType(request)
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
                            getView().onError("El tipo de labor ya no "
                                    + "existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("Ya existe un tipo de labor con"
                                    + " esos datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

}
