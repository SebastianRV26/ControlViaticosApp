package app.ui.branchOffice.list;

import app.data.model.BranchOffice;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public class BranchOfficeListContract {

    interface View extends IBaseView {

        void showBranchOffices(List<BranchOffice> clients);

        void refreshData();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void loadBranchOffices();

        void disableBranchOffice(int clientId);
    }
}
