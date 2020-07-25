package app.ui.supportType.list;

import app.data.model.SupportType;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public class SupportTypeListContract {

    interface View extends IBaseView {

        void showSupportTypes(List<SupportType> clients);

        void refreshData();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void loadSupportTypes();

        void disableSupportType(int id);
    }
}
