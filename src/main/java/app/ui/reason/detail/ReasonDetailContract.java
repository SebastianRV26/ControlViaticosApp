package app.ui.reason.detail;

import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface ReasonDetailContract {

    interface View extends IBaseView {

        void onSuccess();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void addReason(String descripcion);

        void updateReason(int id, String descripcion);
    }
}
