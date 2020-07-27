package app.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * This data class represents an event from the database.
 */
public class TableEvent {

    @SerializedName("id")
    private Integer id;

    @SerializedName("fecha")
    private Date date;

    @SerializedName("sucursal")
    private String branchOffice;

    @SerializedName("labor")
    private String task;

    @SerializedName("motivo")
    private String reason;

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

    public String getBranchOffice() {
        return branchOffice;
    }

    public void setBranchOffice(String branchOffice) {
        this.branchOffice = branchOffice;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "TableEvent{"
                + "id=" + id + ", date=" + date
                + ", branchOffice=" + branchOffice
                + ", task=" + task
                + ", reason=" + reason + '}';
    }

}
