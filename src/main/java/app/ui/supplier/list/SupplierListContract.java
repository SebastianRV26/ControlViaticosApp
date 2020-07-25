package app.ui.supplier.list;

import app.data.model.Supplier;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public class SupplierListContract {

    interface View extends IBaseView {

        void showSuppliers(List<Supplier> suppliers);

        void refreshData();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void loadSuppliers();

        void disableSupplier(int id);
    }
}
