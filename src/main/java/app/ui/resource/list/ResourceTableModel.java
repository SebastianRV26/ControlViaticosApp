package app.ui.resource.list;

import app.data.model.Resource;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Allows to use a list of resources in the table with custom data.
 */
public class ResourceTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Responsable",
        "Descripción"
    };

    private List<Resource> resources;

    public ResourceTableModel() {
        resources = new ArrayList<>();
    }

    public ResourceTableModel(List<Resource> resources) {
        this.resources = resources;
    }

    public Resource getValue(int index) {
        return resources.get(index);
    }

    @Override
    public int getRowCount() {
        return resources.size();
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
        Resource resource = resources.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return resource.getResponsable();
            case 1:
                return resource.getDescripcion();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Resource resource = resources.get(rowIndex);

        switch (columnIndex) {
            case 0:
                resource.setResponsable((String) aValue);
                break;
            case 1:
                resource.setDescripcion((String) aValue);
                break;
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
