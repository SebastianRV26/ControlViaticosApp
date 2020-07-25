package app.ui.reason.list;

import app.data.model.Reason;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public class ReasonListContract {

    interface View extends IBaseView {

        void showReasons(List<Reason> reasons);

        void refreshData();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void loadReasons();

        void disableReason(int reasonId);
    }
}
