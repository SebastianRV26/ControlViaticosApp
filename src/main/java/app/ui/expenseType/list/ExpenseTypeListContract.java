package app.ui.expenseType.list;

import app.data.model.ExpenseType;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public class ExpenseTypeListContract {

    interface View extends IBaseView {

        void showExpenseTypes(List<ExpenseType> expenseTypes);

        void refreshData();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void loadExpenseTypes();

        void disableExpenseType(int expenseTypeId);
    }
}
