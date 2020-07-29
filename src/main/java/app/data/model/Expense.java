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

    @SerializedName("idVehiculo")
    private Integer vehicleId;

    @SerializedName("kmRecorridos")
    private Float traveledKm;

    public Expense(Date date, String bill, Float price, Integer paymentsNumber,
            String remarks, String ticket, Integer expenseTypeId,
            Integer supplierId, Integer resourceId, Integer vehicleId,
            Float traveledKm) {
        this.date = date;
        this.bill = bill;
        this.price = price;
        this.paymentsNumber = paymentsNumber;
        this.remarks = remarks;
        this.ticket = ticket;
        this.expenseTypeId = expenseTypeId;
        this.supplierId = supplierId;
        this.resourceId = resourceId;
        this.vehicleId = vehicleId;
        this.traveledKm = traveledKm;
    }

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

    public Integer getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Integer vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Float getTraveledKm() {
        return traveledKm;
    }

    public void setTraveledKm(Float traveledKm) {
        this.traveledKm = traveledKm;
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
                + ", vehicleIdG=" + vehicleId
                + ", traveledKm=" + traveledKm + '}';
    }

}
