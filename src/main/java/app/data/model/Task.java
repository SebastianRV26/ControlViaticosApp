package app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * This data class represents a labor from the database.
 */
public class Task {

    @SerializedName("id")
    private Integer id;

    @SerializedName("descripcion")
    private String description;

    @SerializedName("idTipoLabor")
    private int idTaskType;

    @SerializedName("tipoLabor")
    private String taskType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdTaskType() {
        return idTaskType;
    }

    public void setIdTaskType(int idTaskType) {
        this.idTaskType = idTaskType;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskTypeId(String taskType) {
        this.taskType = taskType;
    }

    @Override
    public String toString() {
        return "Task{"
                + "id=" + id
                + ", description=" + description
                + ", taskType=" + taskType
                + ", idTaskType=" + idTaskType + '}';
    }
}
