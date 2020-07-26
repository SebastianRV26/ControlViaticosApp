package app.ui.cost.detail;

import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface CostDetailContract {

    interface View extends IBaseView {

        void onSuccess();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void addCost(String description);

        void updateCost(int id, String description);
    }
}
