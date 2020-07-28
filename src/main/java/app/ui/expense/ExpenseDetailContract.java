package app.ui.expense;

import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface ExpenseDetailContract {

    interface View extends IBaseView {

        void onLoadData(DataResult result);
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void loadData();
    }
}
