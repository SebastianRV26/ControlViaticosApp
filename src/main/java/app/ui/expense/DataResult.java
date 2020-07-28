package app.ui.expense;

import app.data.model.ExpenseType;
import app.data.model.Resource;
import app.data.model.Supplier;
import app.data.model.Vehicle;
import java.util.List;

public class DataResult {

    private List<ExpenseType> expenseTypes;
    private List<Supplier> suppliers;
    private List<Vehicle> vehicles;
    private List<Resource> resources;

    public DataResult(List<ExpenseType> expenseTypes, List<Supplier> suppliers,
            List<Vehicle> vehicles, List<Resource> resources) {
        this.expenseTypes = expenseTypes;
        this.suppliers = suppliers;
        this.vehicles = vehicles;
        this.resources = resources;
    }

    public List<ExpenseType> getExpenseTypes() {
        return expenseTypes;
    }

    public void setExpenseTypes(List<ExpenseType> expenseTypes) {
        this.expenseTypes = expenseTypes;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

}
