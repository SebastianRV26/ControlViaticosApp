package app.ui.client.list;

import app.data.model.Client;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Allows to use a list of clients in the table with custom data.
 */
public class ClientTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Razón social",
        "Razón comercial"
    };

    private List<Client> clients;

    public ClientTableModel() {
        clients = new ArrayList<>();
    }

    public ClientTableModel(List<Client> clients) {
        this.clients = clients;
    }

    public Client getValue(int index) {
        return clients.get(index);
    }

    @Override
    public int getRowCount() {
        return clients.size();
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
        Client client = clients.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return client.getRazonSocial();
            case 1:
                return client.getRazonComercial();
        }

        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Client client = clients.get(rowIndex);

        switch (columnIndex) {
            case 0:
                client.setRazonComercial((String) aValue);
                break;
            case 1:
                client.setRazonSocial((String) aValue);
                break;
        }

        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
