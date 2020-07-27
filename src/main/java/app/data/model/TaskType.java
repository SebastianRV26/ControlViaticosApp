package app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * This data class represents a task type from the database.
 */
public class TaskType {

    @SerializedName("id")
    private Integer id;

    @SerializedName("descripcion")
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TaskType{"
                + "id=" + id
                + ", descripcion=" + descripcion
                + '}';
    }
}
