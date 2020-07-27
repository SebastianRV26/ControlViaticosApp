package app.ui.taskType.list;

import app.data.model.TaskType;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Allows to use a list of tasks in the table with custom data.
 */
public class TaskTypeTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Descripción"
    };

    private List<TaskType> taskTypes;

    public TaskTypeTableModel() {
        taskTypes = new ArrayList<>();
    }

    public TaskTypeTableModel(List<TaskType> taskTypes) {
        this.taskTypes = taskTypes;
    }

    public TaskType getValue(int index) {
        return taskTypes.get(index);
    }

    @Override
    public int getRowCount() {
        return taskTypes.size();
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
        TaskType taskType = taskTypes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return taskType.getDescripcion();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        TaskType taskType = taskTypes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                taskType.setDescripcion((String) aValue);
                break;
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
