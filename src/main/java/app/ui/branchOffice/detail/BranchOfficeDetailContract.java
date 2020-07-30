package app.ui.branchOffice.detail;

import app.data.model.Client;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface BranchOfficeDetailContract {

    interface View extends IBaseView {

        void showClients(List<Client> clients);

        void onErrorClients();

    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void addBranchOffice(String sucursal, Integer idClient);

        void updateBranchOffice(int id, String sucursal, Integer idClient);

        void loadClients();
    }
}
