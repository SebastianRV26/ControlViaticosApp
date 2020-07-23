package app.ui.client.list;

import app.data.model.Client;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public class ClientListContract {

    interface View extends IBaseView {

        void showClients(List<Client> clients);
        
        void refreshData();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void loadClients();

        void disableClient(int clientId);
    }
}
