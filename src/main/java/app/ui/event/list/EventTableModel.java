package app.ui.event.list;

import app.data.model.TableEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Allows to use a list of costs in the table with custom data.
 */
public class EventTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Fecha",
        "Sucursal",
        "Labor",
        "Motivo"
    };

    private List<TableEvent> events;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public EventTableModel() {
        events = new ArrayList<>();
    }

    public EventTableModel(List<TableEvent> events) {
        this.events = events;
    }

    public TableEvent getValue(int index) {
        return events.get(index);
    }

    @Override
    public int getRowCount() {
        return events.size();
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
        TableEvent event = events.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return dateFormat.format(event.getDate());
            case 1:
                return event.getBranchOffice();
            case 2:
                return event.getTask();
            case 3:
                return event.getReason();
        }

        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
