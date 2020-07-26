package app.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * This data class represents a client from the database.
 */
public class BranchOffice {

    @SerializedName("id")
    private Integer id;

    @SerializedName("sucursal")
    private String sucursal;

    @SerializedName("idCliente")
    private int clientId;

    @SerializedName("cliente")
    private String client;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public void setClientId(int idClient) {
        this.clientId = idClient;
    }

    public Integer getClientId() {
        return this.clientId;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "BranchOffice{"
                + "id=" + id
                + ", sucursal=" + sucursal
                + ", idCliente=" + clientId
                + ", cliente=" + client + '}';
    }
}
