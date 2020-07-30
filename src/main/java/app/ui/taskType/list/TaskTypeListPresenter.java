package app.ui.taskType.list;

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
public class TaskTypeListPresenter<V extends TaskTypeListContract.View>
        extends BasePresenter<V> implements TaskTypeListContract.Presenter<V> {

    /**
     * Called when the view needs to load the task types from the database.
     */
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

    /**
     * Called when the view needs to disable an task type from the database.
     *
     * @param taskTypeId id of the task type
     */
    @Override
    public void disableTaskType(int taskTypeId) {
        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("taskTypeId", taskTypeId);
        request.put("isActive", 0);

        // Executes the request
        Api.getInstance().getTaskTypeService().updateTaskType(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request successful
                    getView().refreshData();
                    getView().onSuccess("Se eliminó el tipo de labor");
                }, throwable -> {
                    // Request error
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El tipo de labor ya no"
                                    + " existe.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }
}
