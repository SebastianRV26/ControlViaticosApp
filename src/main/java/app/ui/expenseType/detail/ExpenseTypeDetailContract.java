package app.ui.expenseType.detail;

import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface ExpenseTypeDetailContract {

    interface View extends IBaseView {
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void addExpenseType(String descripcion);

        void updateExpenseType(int id, String descripcion);
    }
}
