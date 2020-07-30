package app.ui.resource.detail;

import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface ResourceDetailContract {

    interface View extends IBaseView {
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void addResource(String responsable, String descripcion);

        void updateResource(int id, String responsable, String descripcion);
    }
}
