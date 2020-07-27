package app.ui.task.list;

import app.data.model.Task;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Allows to use a list of tasks in the table with custom data.
 */
public class TaskTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Descripción",
        "Tipo de labor"
    };

    private List<Task> tasks;

    public TaskTableModel() {
        tasks = new ArrayList<>();
    }

    public TaskTableModel(List<Task> clients) {
        this.tasks = clients;
    }

    public Task getValue(int index) {
        return tasks.get(index);
    }

    @Override
    public int getRowCount() {
        return tasks.size();
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
        Task task = tasks.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return task.getDescription();
            case 1:
                return task.getTaskType();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Task task = tasks.get(rowIndex);

        switch (columnIndex) {
            case 0:
                task.setDescription((String) aValue);
                break;
            case 1:
                task.setDescription((String) aValue);
                break;
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
