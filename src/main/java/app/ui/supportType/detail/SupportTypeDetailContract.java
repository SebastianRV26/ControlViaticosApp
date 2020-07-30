package app.ui.supportType.detail;

import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface SupportTypeDetailContract {

    interface View extends IBaseView {
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void addSupportType(String descripcion);

        void updateSupportType(int id, String descripcion);
    }
}
