package app.ui.supplier.detail;

import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface SupplierDetailContract {

    interface View extends IBaseView {

        void onSuccess();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void addSupplier(String description);

        void updateSupplier(int id, String description);
    }
}
