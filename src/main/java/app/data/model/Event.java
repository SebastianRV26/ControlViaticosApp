package app.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;
import java.util.List;

/**
 * This data class represents an event from the database.
 */
public class Event {

    @SerializedName("id")
    private Integer id;

    @SerializedName("fecha")
    private Date date;

    @SerializedName("hora")
    private String hour;

    @SerializedName("trabajo")
    private String work;

    @SerializedName("duracion")
    private String duration;

    @SerializedName("problemaReportado")
    private String report;

    @SerializedName("problemaResuelto")
    private boolean reportSolved;

    @SerializedName("idSucursal")
    private Integer branchOfficeId;

    @SerializedName("idCliente")
    private Integer clientId;

    @SerializedName("idCentroCosto")
    private Integer costId;

    @SerializedName("idLabor")
    private Integer taskId;

    @SerializedName("idTipoLabor")
    private Integer taskTypeId;

    @SerializedName("idTipoSoporte")
    private Integer supportTypeId;

    @SerializedName("idMotivo")
    private Integer reasonId;

    @SerializedName("viaticos")
    private List<Expense> expenses;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public boolean isReportSolved() {
        return reportSolved;
    }

    public void setReportSolved(boolean reportSolved) {
        this.reportSolved = reportSolved;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getBranchOfficeId() {
        return branchOfficeId;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public void setBranchOfficeId(Integer branchOfficeId) {
        this.branchOfficeId = branchOfficeId;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getCostId() {
        return costId;
    }

    public void setCostId(Integer costId) {
        this.costId = costId;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(Integer taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public Integer getSupportTypeId() {
        return supportTypeId;
    }

    public void setSupportTypeId(Integer supportTypeId) {
        this.supportTypeId = supportTypeId;
    }

    public Integer getReasonId() {
        return reasonId;
    }

    public void setReasonId(Integer reasonId) {
        this.reasonId = reasonId;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "Event{"
                + "id=" + id
                + ", date=" + date
                + ", hour=" + hour
                + ", work=" + work
                + ", duration=" + duration
                + ", report=" + report
                + ", reportSolved=" + reportSolved
                + ", branchOfficeId=" + branchOfficeId
                + ", clientId=" + clientId
                + ", costId=" + costId
                + ", taskId=" + taskId
                + ", taskTypeId=" + taskTypeId
                + ", supportTypeId=" + supportTypeId
                + ", reasonId=" + reasonId
                + ", expenses=" + expenses + '}';
    }

}
