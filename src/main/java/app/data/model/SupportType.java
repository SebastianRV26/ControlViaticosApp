package app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * This data class represents a support type from the database.
 */
public class SupportType {

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
        return "SupportTye{"
                + "id=" + id
                + ", descripcion=" + descripcion + '}';
    }
}
