package app.ui.supplier.list;

import app.data.model.Supplier;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Allows to use a list of suppliers in the table with custom data.
 */
public class SupplierTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Descripcion"
    };

    private List<Supplier> suppliers;

    public SupplierTableModel() {
        suppliers = new ArrayList<>();
    }

    public SupplierTableModel(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Supplier getValue(int index) {
        return suppliers.get(index);
    }

    @Override
    public int getRowCount() {
        return suppliers.size();
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
        Supplier supplier= suppliers.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return supplier.getDescripcion();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Supplier supplier = suppliers.get(rowIndex);

        switch (columnIndex) {
            case 0:
                supplier.setDescripcion((String) aValue);
                break;
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
