package app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * This class represents a reason from the database.
 */
public class Reason {
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
        return "Reason{"
                + "id=" + id
                + ", descripcion=" + descripcion
                + '}';
    }
}
