package app.ui.expenseType.list;

import app.data.model.ExpenseType;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Allows to use a list of reasons in the table with custom data.
 */
public class ExpenseTypeTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Descripción"
    };

    private List<ExpenseType> expenseTypes;

    public ExpenseTypeTableModel() {
        expenseTypes = new ArrayList<>();
    }

    public ExpenseTypeTableModel(List<ExpenseType> expenseTypes) {
        this.expenseTypes = expenseTypes;
    }

    public ExpenseType getValue(int index) {
        return expenseTypes.get(index);
    }

    @Override
    public int getRowCount() {
        return expenseTypes.size();
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
        ExpenseType expenseType = expenseTypes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return expenseType.getDescripcion();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        ExpenseType expenseType = expenseTypes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                expenseType.setDescripcion((String) aValue);
                break;
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
