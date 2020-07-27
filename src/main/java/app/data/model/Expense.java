package app.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * This data class represents an expense from the database.
 */
public class Expense {

    @SerializedName("id")
    private Integer id;

    @SerializedName("fecha")
    private Date date;

    @SerializedName("factura")
    private String bill;

    @SerializedName("monto")
    private Float price;

    @SerializedName("numPagos")
    private Integer paymentsNumber;

    @SerializedName("notas")
    private String remarks;

    @SerializedName("boleta")
    private String ticket;

    @SerializedName("idTipoViatico")
    private Integer expenseTypeId;

    @SerializedName("idProveedor")
    private Integer supplierId;

    @SerializedName("idResponsable")
    private Integer resourceId;

    @SerializedName("idVehiculoG")
    private Integer vehicleIdG;

    @SerializedName("kmRecorridos")
    private Float traveledKm;

    @SerializedName("idVehiculoK")
    private Integer vehicleIdK;

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

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getPaymentsNumber() {
        return paymentsNumber;
    }

    public void setPaymentsNumber(int paymentsNumber) {
        this.paymentsNumber = paymentsNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getExpenseTypeId() {
        return expenseTypeId;
    }

    public void setExpenseTypeId(Integer expenseTypeId) {
        this.expenseTypeId = expenseTypeId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getVehicleIdG() {
        return vehicleIdG;
    }

    public void setVehicleIdG(Integer vehicleIdG) {
        this.vehicleIdG = vehicleIdG;
    }

    public Float getTraveledKm() {
        return traveledKm;
    }

    public void setTraveledKm(Float traveledKm) {
        this.traveledKm = traveledKm;
    }

    public Integer getVehicleIdK() {
        return vehicleIdK;
    }

    public void setVehicleIdK(Integer vehicleIdK) {
        this.vehicleIdK = vehicleIdK;
    }

    @Override
    public String toString() {
        return "Expense{"
                + "id=" + id
                + ", date=" + date
                + ", bill=" + bill
                + ", price=" + price
                + ", paymentsNumber=" + paymentsNumber
                + ", remarks=" + remarks
                + ", ticket=" + ticket
                + ", expenseTypeId=" + expenseTypeId
                + ", supplierId=" + supplierId
                + ", resourceId=" + resourceId
                + ", vehicleIdG=" + vehicleIdG
                + ", traveledKm=" + traveledKm
                + ", vehicleIdK=" + vehicleIdK + '}';
    }

}
