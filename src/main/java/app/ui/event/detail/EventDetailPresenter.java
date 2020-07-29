package app.ui.event.detail;

import app.data.model.Expense;
import app.data.model.StatusResponse;
import app.data.network.Api;
import app.ui.base.BasePresenter;
import app.util.Utils;
import com.google.gson.Gson;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The presenter class responsible for the communication between the view and
 * the API.
 *
 * @param <V> the view attached to this presenter
 */
public class EventDetailPresenter<V extends EventDetailContract.View>
        extends BasePresenter<V> implements EventDetailContract.Presenter<V> {

    @Override
    public void addExpense(String date, String hour, String taskPerformed,
            String duration, String report, boolean problemSolved,
            int branchOfficeId, int costId, int taskId, int supportTypeId,
            int reasonId, List<Expense> expenses) {

        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(date)) {
            getView().onError("La fecha no puede estar vacía.");
            return;
        } else if (Utils.textIsNullOrEmpty(taskPerformed)) {
            getView().onError("La tarea realizada no puede estar vacía.");
            return;
        } else if (Utils.textIsNullOrEmpty(report)) {
            getView().onError("La problema reportado no puede estar vacío.");
            return;
        } else if (branchOfficeId == -1) {
            getView().onError("Debe seleccionar una sucursal.");
            return;
        } else if (costId == -1) {
            getView().onError("Debe seleccionar una centro de costo.");
            return;
        } else if (taskId == -1) {
            getView().onError("Debe seleccionar una labor.");
            return;
        } else if (supportTypeId == -1) {
            getView().onError("Debe seleccionar una tipo de soporte.");
            return;
        } else if (reasonId == -1) {
            getView().onError("Debe seleccionar un motivo.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(12);
        request.put("fecha", date);
        request.put("hora", hour);
        request.put("trabajo", taskPerformed.trim());
        request.put("duracion", duration);
        request.put("problemaReportado", report.trim());
        request.put("problemaResuelto", problemSolved);
        request.put("idSucursal", branchOfficeId);
        request.put("idCentroCosto", costId);
        request.put("idLabor", taskId);
        request.put("idTipoSoporte", supportTypeId);
        request.put("idMotivo", reasonId);
        request.put("viaticos", getExpensesReq(expenses));

        Api.getInstance().getEventService().addEvent(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess();
                }, throwable -> {
                    // Let's manage errors
                    System.out.println(throwable);
                    getView().onError("Error de conexión."
                            + "\nIntente de nuevo");
                });
    }

    @Override
    public void updateExpense(int eventId, String date, String hour,
            String taskPerformed, String duration, String report,
            boolean problemSolved, int branchOfficeId, int costId, int taskId,
            int supportTypeId, int reasonId, List<Expense> expenses) {

        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(date)) {
            getView().onError("La fecha no puede estar vacía.");
            return;
        } else if (Utils.textIsNullOrEmpty(taskPerformed)) {
            getView().onError("La tarea realizada no puede estar vacía.");
            return;
        } else if (Utils.textIsNullOrEmpty(report)) {
            getView().onError("La problema reportado no puede estar vacío.");
            return;
        } else if (branchOfficeId == -1) {
            getView().onError("Debe seleccionar una sucursal.");
            return;
        } else if (costId == -1) {
            getView().onError("Debe seleccionar una centro de costo.");
            return;
        } else if (taskId == -1) {
            getView().onError("Debe seleccionar una labor.");
            return;
        } else if (supportTypeId == -1) {
            getView().onError("Debe seleccionar una tipo de soporte.");
            return;
        } else if (reasonId == -1) {
            getView().onError("Debe seleccionar un motivo.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(13);
        request.put("idEvento", eventId);
        request.put("fecha", date);
        request.put("hora", hour);
        request.put("trabajo", taskPerformed.trim());
        request.put("duracion", duration);
        request.put("problemaReportado", report.trim());
        request.put("problemaResuelto", problemSolved);
        request.put("idSucursal", branchOfficeId);
        request.put("idCentroCosto", costId);
        request.put("idLabor", taskId);
        request.put("idTipoSoporte", supportTypeId);
        request.put("idMotivo", reasonId);
        request.put("viaticos", getExpensesReq(expenses));
        
        Api.getInstance().getEventService().updateEvent(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess();
                }, throwable -> {
                    // Let's manage errors
                    System.out.println(throwable);
                    getView().onError("Error de conexión."
                            + "\nIntente de nuevo");
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

    private List<HashMap<String, Object>> getExpensesReq(List<Expense> expenses) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<HashMap<String, Object>> list = new ArrayList<>();

        expenses.forEach((expense) -> {
            HashMap<String, Object> request = new HashMap<>(12);
            request.put("idEvento", expense.getId());
            request.put("fecha", formatter.format(expense.getDate()));
            request.put("factura", expense.getBill());
            request.put("monto", expense.getPrice());
            request.put("numPagos", expense.getPaymentsNumber());
            request.put("notas", expense.getRemarks());
            request.put("boleta", expense.getTicket());
            request.put("idTipoViatico", expense.getExpenseTypeId());
            request.put("idProveedor", expense.getSupplierId());
            request.put("idResponsable", expense.getResourceId());
            request.put("kmRecorridos", expense.getTraveledKm());
            request.put("idVehiculo", expense.getVehicleId());
            list.add(request);
        });

        return list;
    }

}
