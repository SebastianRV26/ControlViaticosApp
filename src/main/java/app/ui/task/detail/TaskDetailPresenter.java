package app.ui.task.detail;

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
public class TaskDetailPresenter<V extends TaskDetailContract.View>
        extends BasePresenter<V> implements TaskDetailContract.Presenter<V> {

    /**
     * Called everytime the view wants to add a new task type.
     *
     * @param description of the task type
     * @param taskId of the task type
     */
    @Override
    public void addTask(String description, int taskId) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(description)) {
            getView().onError("La descripción no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("descripcion", description.trim());
        request.put("idTipoLabor", taskId);

        Api.getInstance().getTaskService().addTask(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess("Se agrego una nueva labor");
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El tipo de labor no existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("Ya hay una labor con esos"
                                    + " datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    /**
     * Called everytime the view wants to update task.
     *
     * @param id id of the task
     * @param description of the task type
     * @param taskId of the task type
     */
    @Override
    public void updateTask(int id, String description, int taskId) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(description)) {
            getView().onError("La descripción no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(3);
        request.put("laborId", id);
        request.put("descripcion", description.trim());
        request.put("idTipoLabor", taskId);

        Api.getInstance().getTaskService().updateTask(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess("Se modifico la labor");
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El labor ya no existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("El tipo de labor no existe.");
                        } else if (response.getStatusCode() == 3) {
                            getView().onError("Ya existe una labor con esos "
                                    + "datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    @Override
    public void loadTaskTypes() {
        Api.getInstance().getTaskTypeService().getTaskTypes()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((taskTypes) -> {
                    getView().showTaskTypes(taskTypes);
                }, throwable -> {
                    getView().onError("Error de conexión al cargar datos."
                            + "\nIntente de nuevo");
                });
    }
}
