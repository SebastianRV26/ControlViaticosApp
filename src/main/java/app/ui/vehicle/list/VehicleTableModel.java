package app.ui.vehicle.list;

import app.data.model.Vehicle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Allows to use a list of vehicles in the table with custom data.
 */
public class VehicleTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Descripción",
        "Monto por kilómetro",
        "Responsable"
    };

    private List<Vehicle> vehicles;

    public VehicleTableModel() {
        vehicles = new ArrayList<>();
    }

    public VehicleTableModel(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Vehicle getValue(int index) {
        return vehicles.get(index);
    }

    @Override
    public int getRowCount() {
        return vehicles.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vehicle vehicle = vehicles.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return vehicle.getDescripcion();
            case 1:
                return vehicle.getMontoKm();
            case 2:
                return vehicle.getResponsable();
        }

        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
