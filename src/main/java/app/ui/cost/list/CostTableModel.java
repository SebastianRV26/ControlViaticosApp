package app.ui.cost.list;

import app.data.model.Cost;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Allows to use a list of costs in the table with custom data.
 */
public class CostTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Descripción"
    };

    private List<Cost> costs;

    public CostTableModel() {
        costs = new ArrayList<>();
    }

    public CostTableModel(List<Cost> costs) {
        this.costs = costs;
    }

    public Cost getValue(int index) {
        return costs.get(index);
    }

    @Override
    public int getRowCount() {
        return costs.size();
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
        Cost cost = costs.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return cost.getDescription();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cost cost = costs.get(rowIndex);

        switch (columnIndex) {
            case 0:
                cost.setDescription((String) aValue);
                break;
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
