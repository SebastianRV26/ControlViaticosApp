package app.ui.event.detail;

import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface EventDetailContract {

    interface View extends IBaseView {

        void onSuccess();

        void onLoadData(DataResult result);

    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void addCost(String description);

        void updateCost(int id, String description);

        void loadData(int eventId);

        void loadData();
    }
}
