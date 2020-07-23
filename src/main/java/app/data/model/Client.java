package app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * This data class represents a client from the database.
 */
public class Client {

    @SerializedName("id")
    private Integer id;

    @SerializedName("razonSocial")
    private String razonSocial;

    @SerializedName("razonComercial")
    private String razonComercial;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRazonComercial() {
        return razonComercial;
    }

    public void setRazonComercial(String razonComercial) {
        this.razonComercial = razonComercial;
    }

    @Override
    public String toString() {
        return "Client{"
                + "id=" + id
                + ", razonSocial=" + razonSocial
                + ", razonComercial=" + razonComercial + '}';
    }
}
