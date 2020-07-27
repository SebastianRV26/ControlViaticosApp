package app.ui.task.list;

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
public class TaskListPresenter<V extends TaskListContract.View>
        extends BasePresenter<V> implements TaskListContract.Presenter<V> {

    /**
     * Called when the view needs to load the tasks from the database.
     */
    @Override
    public void loadTasks() {
        Api.getInstance().getTaskService().getTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((tasks) -> {
                    getView().showTasks(tasks);
                }, throwable -> {
                    getView().onError("Error de conexión al cargar datos."
                            + "\nIntente de nuevo");
                });
    }

    /**
     * Called when the view needs to disable a task from the database.
     *
     * @param taskId id of the task
     */
    @Override
    public void disableTask(int taskId) {
        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("laborId", taskId);
        request.put("isActive", 0);

        // Executes the request
        Api.getInstance().getTaskService().updateTask(request)
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
                            getView().onError("La labor ya no existe.");
                        } else if (response.getStatusCode() == 1) {
                            getView().onError("El tipo de labor ya no existe.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }
}
