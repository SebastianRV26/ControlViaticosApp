package app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * This data class represents a vehicle from the database.
 */
public class Vehicle {

    @SerializedName("id")
    private Integer id;

    @SerializedName("descripcion")
    private String descripcion;

    @SerializedName("montoKm")
    private Double montoKm;

    @SerializedName("idResponsable")
    private Integer idResponsable;

    @SerializedName("responsable")
    private String responsable;

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

    public Double getMontoKm() {
        return montoKm;
    }

    public void setMontoKm(Double montoKm) {
        this.montoKm = montoKm;
    }

    public Integer getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Integer idResponsable) {
        this.idResponsable = idResponsable;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Vehicle{"
                + "id=" + id
                + ", descripcion=" + descripcion
                + ", montoKm=" + montoKm
                + ", responsable=" + responsable
                + ", idResponsable=" + idResponsable + '}';
    }
}
