package app.ui.client.detail;

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
public class ClientDetailPresenter<V extends ClientDetailContract.View>
        extends BasePresenter<V> implements ClientDetailContract.Presenter<V> {

    /**
     * Called everytime the view wants to add a new client.
     *
     * @param socialReason client's social reason
     * @param tradeReason client's trade reason
     */
    @Override
    public void addClient(String socialReason, String tradeReason) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(socialReason)) {
            getView().onError("La razón social no puede estar vacía.");
            return;
        } else if (Utils.textIsNullOrEmpty(tradeReason)) {
            getView().onError("La razón comercial no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("razonSocial", socialReason.trim());
        request.put("razonComercial", tradeReason.trim());

        Api.getInstance().getClientService().addClient(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess("Se agrego un cliente correctamente");
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("Ya hay un cliente con esos"
                                    + " datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    /**
     * Called everytime the view wants to add a new client.
     *
     * @param id client's id
     * @param socialReason client's social reason
     * @param tradeReason client's trade reason
     */
    @Override
    public void updateClient(int id, String socialReason, String tradeReason) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(socialReason)) {
            getView().onError("La razón social no puede estar vacía.");
            return;
        } else if (Utils.textIsNullOrEmpty(tradeReason)) {
            getView().onError("La razón comercial no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(3);
        request.put("clientId", id);
        request.put("razonSocial", socialReason.trim());
        request.put("razonComercial", tradeReason.trim());

        Api.getInstance().getClientService().updateClient(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess("Se modifico el cliente correctamente");
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El cliente ya no existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("Ya existe un cliente con esos "
                                    + "datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

}
