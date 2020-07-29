package app.util;

import app.data.model.Expense;

public interface ExpenseTableListener {

    void addExpense(Expense expense);

    void updateExpense(Expense expense);

    void deleteExpense(Expense expense);
}
