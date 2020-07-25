package app.ui.reason.list;

import app.data.model.Reason;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Allows to use a list of reasons in the table with custom data.
 */
public class ReasonTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Descripción"
    };

    private List<Reason> reasons;

    public ReasonTableModel() {
        reasons = new ArrayList<>();
    }

    public ReasonTableModel(List<Reason> reasons) {
        this.reasons = reasons;
    }

    public Reason getValue(int index) {
        return reasons.get(index);
    }

    @Override
    public int getRowCount() {
        return reasons.size();
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
        Reason reason = reasons.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return reason.getDescripcion();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Reason reason = reasons.get(rowIndex);

        switch (columnIndex) {
            case 0:
                reason.setDescripcion((String) aValue);
                break;
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
