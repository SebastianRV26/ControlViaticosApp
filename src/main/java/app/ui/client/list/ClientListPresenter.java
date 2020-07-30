package app.ui.client.list;

import app.data.model.StatusResponse;
import app.data.network.Api;
import app.ui.base.BasePresenter;
import app.util.Utils;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.HashMap;

/**
 * The presenter class responsable for the communication between the view and
 * the API.
 *
 * @param <V> the view attached to this presenter
 */
public class ClientListPresenter<V extends ClientListContract.View>
        extends BasePresenter<V> implements ClientListContract.Presenter<V> {

    /**
     * Called when the view needs to load the clients from the database.
     */
    @Override
    public void loadClients() {
        Api.getInstance().getClientService().getClients()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((clients) -> {
                    getView().showClients(clients);
                }, throwable -> {
                    getView().onError("Error de conexión al cargar datos."
                            + "\nIntente de nuevo");
                });
    }

    /**
     * Called when the view needs to disable a client from the database.
     *
     * @param clientId client's id
     */
    @Override
    public void disableClient(int clientId) {
        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("clientId", clientId);
        request.put("isActive", 0);

        // Executes the request
        Api.getInstance().getClientService().updateClient(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request successful
                    getView().refreshData();
                    getView().onSuccess("Se eliminó el cliente correctamente");
                }, throwable -> {
                    // Request error
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El cliente ya no existe.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }
}
