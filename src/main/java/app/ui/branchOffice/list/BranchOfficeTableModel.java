package app.ui.branchOffice.list;

import app.data.model.BranchOffice;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Allows to use a list of branchOffices in the table with custom data.
 */
public class BranchOfficeTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Sucursal",
        "Cliente"
    };

    private List<BranchOffice> branchOffices;

    public BranchOfficeTableModel() {
        branchOffices = new ArrayList<>();
    }

    public BranchOfficeTableModel(List<BranchOffice> branchOffices) {
        this.branchOffices = branchOffices;
    }

    public BranchOffice getValue(int index) {
        return branchOffices.get(index);
    }

    @Override
    public int getRowCount() {
        return branchOffices.size();
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
        BranchOffice branchOffice = branchOffices.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return branchOffice.getSucursal();
            case 1:
                return branchOffice.getClient();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        BranchOffice branchOffice = branchOffices.get(rowIndex);

        switch (columnIndex) {
            case 0:
                branchOffice.setSucursal((String) aValue);
                break;
            case 1:
                branchOffice.setClient((String) aValue);
                break;
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
