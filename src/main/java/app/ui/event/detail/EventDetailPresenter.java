package app.ui.event.detail;

import app.data.model.StatusResponse;
import app.data.network.Api;
import app.ui.base.BasePresenter;
import app.util.Utils;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.HashMap;

/**
 * The presenter class responsible for the communication between the view and
 * the API.
 *
 * @param <V> the view attached to this presenter
 */
public class EventDetailPresenter<V extends EventDetailContract.View>
        extends BasePresenter<V> implements EventDetailContract.Presenter<V> {

    /**
     * Called everytime the view wants to add a new cost.
     *
     * @param description cost's description
     */
    @Override
    public void addCost(String description) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(description)) {
            getView().onError("La descripción no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(1);
        request.put("descripcion", description.trim());

        Api.getInstance().getCostService().addCost(request)
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
                            getView().onError("Ya hay un centro de costo con "
                                    + "esos datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    /**
     * Called everytime the view wants to add a new cost.
     *
     * @param id id of the cost
     * @param description description of the cost
     */
    @Override
    public void updateCost(int id, String description) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(description)) {
            getView().onError("La descripción no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(3);
        request.put("costId", id);
        request.put("descripcion", description.trim());

        Api.getInstance().getCostService().updateCost(request)
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
                            getView().onError("El centro de costo ya no "
                                    + "existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("Ya existe un centro de costo con"
                                    + " esos datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    @Override
    public void loadData(int eventId) {
        Single.zip(
                Api.getInstance().getEventService().getEvent(eventId),
                Api.getInstance().getClientService().getClients(),
                Api.getInstance().getBranchOfficeService().getBranchOffices(),
                Api.getInstance().getReasonService().getReasons(),
                Api.getInstance().getSupportTypeService().getSupportTypes(),
                Api.getInstance().getCostService().getCosts(),
                Api.getInstance().getTaskTypeService().getTaskTypes(),
                Api.getInstance().getTaskService().getTasks(),
                (event, clients, branchOffices, reasons, supportTypes, costs,
                        taskTypes, tasks) -> {
                    return new DataResult(event, clients, branchOffices,
                            reasons, supportTypes, costs, taskTypes, tasks);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((DataResult result) -> {
                    // Request executed successfully
                    getView().onLoadData(result);
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El evento ya no existe.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    @Override
    public void loadData() {
        Single.zip(
                Api.getInstance().getClientService().getClients(),
                Api.getInstance().getBranchOfficeService().getBranchOffices(),
                Api.getInstance().getReasonService().getReasons(),
                Api.getInstance().getSupportTypeService().getSupportTypes(),
                Api.getInstance().getCostService().getCosts(),
                Api.getInstance().getTaskTypeService().getTaskTypes(),
                Api.getInstance().getTaskService().getTasks(),
                (clients, branchOffices, reasons, supportTypes, costs,
                        taskTypes, tasks) -> {
                    return new DataResult(clients, branchOffices,
                            reasons, supportTypes, costs, taskTypes, tasks);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((DataResult result) -> {
                    // Request executed successfully
                    getView().onLoadData(result);
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El evento ya no existe.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

}
