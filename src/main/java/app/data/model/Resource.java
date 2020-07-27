package app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * This data class represents a resource from the database.
 */
public class Resource {

    @SerializedName("id")
    private Integer id;

    @SerializedName("responsable")
    private String responsable;

    @SerializedName("descripcion")
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Resource{"
                + "id=" + id
                + ", responsable=" + responsable
                + ", descripcion=" + descripcion + '}';
    }
}
