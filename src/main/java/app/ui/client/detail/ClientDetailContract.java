package app.ui.client.detail;

import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface ClientDetailContract {

    interface View extends IBaseView {

        void onSuccess();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void addClient(String socialReason, String tradeReason);

        void updateClient(int id, String socialReason, String tradeReason);
    }
}
