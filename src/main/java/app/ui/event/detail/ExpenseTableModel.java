package app.ui.event.detail;

import app.data.model.Expense;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Allows to use a list of expenses in the table with custom data.
 */
public class ExpenseTableModel extends AbstractTableModel {

    private String[] columnNames = {
        "Factura",
        "Monto",
        "Fecha",
        "Notas",
        "Boleta"
    };

    private List<Expense> expenses;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ExpenseTableModel() {
        expenses = new ArrayList<>();
    }

    public ExpenseTableModel(List<Expense> expenses) {
        this.expenses = expenses == null ? new ArrayList<>() : expenses;
    }

    public Expense getValue(int index) {
        return expenses.get(index);
    }

    @Override
    public int getRowCount() {
        return expenses.size();
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
        Expense expense = expenses.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return expense.getBill() != null ? expense.getBill() : "---";
            case 1:
                return expense.getPrice();
            case 2:
                return dateFormat.format(expense.getDate());
            case 3:
                return expense.getRemarks();
            case 4:
                return expense.getTicket();
        }

        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void addRow(Expense expense) {
        expenses.add(expense);
        fireTableRowsInserted(expenses.size() - 1, expenses.size() - 1);
    }

    public void updateRow(Expense expense) {
        if (expenses.contains(expense)) {
            int index = expenses.lastIndexOf(expense);
            fireTableRowsUpdated(index, index);
        }
    }

    public void removeRow(int index) {
        if (expenses.remove(index) != null) {
            fireTableRowsDeleted(index, index);
        }
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

}
