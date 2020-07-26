package app.ui.cost.list;

import app.data.model.Cost;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public class CostListContract {

    interface View extends IBaseView {

        void showCosts(List<Cost> costs);

        void refreshData();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void loadCosts();

        void disableCost(int costId);
    }
}
