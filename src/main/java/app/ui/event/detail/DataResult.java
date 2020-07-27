package app.ui.event.detail;

import app.data.model.BranchOffice;
import app.data.model.Client;
import app.data.model.Cost;
import app.data.model.Event;
import app.data.model.Reason;
import app.data.model.SupportType;
import app.data.model.Task;
import app.data.model.TaskType;
import java.util.List;

public class DataResult {

    private Event event;
    private List<Client> clients;
    private List<BranchOffice> branchOffices;
    private List<Reason> reasons;
    private List<SupportType> supportTypes;
    private List<Cost> costs;
    private List<TaskType> taskTypes;
    private List<Task> tasks;

    public DataResult(Event event, List<Client> clients,
            List<BranchOffice> branchOffices, List<Reason> reasons,
            List<SupportType> supportTypes, List<Cost> costs,
            List<TaskType> taskTypes, List<Task> tasks) {

        this.event = event;
        this.clients = clients;
        this.branchOffices = branchOffices;
        this.reasons = reasons;
        this.supportTypes = supportTypes;
        this.costs = costs;
        this.taskTypes = taskTypes;
        this.tasks = tasks;
    }

    public DataResult(List<Client> clients, List<BranchOffice> branchOffices,
            List<Reason> reasons, List<SupportType> supportTypes,
            List<Cost> costs, List<TaskType> taskTypes, List<Task> tasks) {

        this.clients = clients;
        this.branchOffices = branchOffices;
        this.reasons = reasons;
        this.supportTypes = supportTypes;
        this.costs = costs;
        this.taskTypes = taskTypes;
        this.tasks = tasks;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<BranchOffice> getBranchOffices() {
        return branchOffices;
    }

    public void setBranchOffices(List<BranchOffice> branchOffices) {
        this.branchOffices = branchOffices;
    }

    public List<Reason> getReasons() {
        return reasons;
    }

    public void setReasons(List<Reason> reasons) {
        this.reasons = reasons;
    }

    public List<SupportType> getSupportTypes() {
        return supportTypes;
    }

    public void setSupportTypes(List<SupportType> supportTypes) {
        this.supportTypes = supportTypes;
    }

    public List<Cost> getCosts() {
        return costs;
    }

    public void setCosts(List<Cost> costs) {
        this.costs = costs;
    }

    public List<TaskType> getTaskTypes() {
        return taskTypes;
    }

    public void setTaskTypes(List<TaskType> taskTypes) {
        this.taskTypes = taskTypes;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
