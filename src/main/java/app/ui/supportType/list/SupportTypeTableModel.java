package app.ui.supportType.list;

import app.data.model.SupportType;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Allows to use a list of supportTypes in the table with custom data.
 */
public class SupportTypeTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Descripcion"
    };

    private List<SupportType> supportTypes;

    public SupportTypeTableModel() {
        supportTypes = new ArrayList<>();
    }

    public SupportTypeTableModel(List<SupportType> supportTypes) {
        this.supportTypes = supportTypes;
    }

    public SupportType getValue(int index) {
        return supportTypes.get(index);
    }

    @Override
    public int getRowCount() {
        return supportTypes.size();
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
        SupportType supportType = supportTypes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return supportType.getDescripcion();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        SupportType supportType = supportTypes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                supportType.setDescripcion((String) aValue);
                break;
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
