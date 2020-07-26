package app.ui.branchOffice.detail;

import app.data.model.StatusResponse;
import app.data.network.Api;
import app.ui.base.BasePresenter;
import app.util.Utils;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.HashMap;

/**
 * The presenter class responsible for the communication between the view and
 * the API.
 *
 * @param <V> the view attached to this presenter
 */
public class BranchOfficeDetailPresenter<V extends BranchOfficeDetailContract.View>
        extends BasePresenter<V> implements BranchOfficeDetailContract.Presenter<V> {

    /**
     * Called everytime the view wants to add a new branch office.
     *
     * @param sucursal branch office
     * @param idClient branch office's id
     */
    @Override
    public void addBranchOffice(String sucursal, Integer idClient) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(sucursal)) {
            getView().onError("La sucursal no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("sucursal", sucursal.trim());
        request.put("idCliente", idClient);

        Api.getInstance().getBranchOfficeService().addBranchOffice(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess();
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El cliente no existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("Ya hay un sucursal con esos"
                                    + " datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    /**
     * Called everytime the view wants to add a new branch office.
     *
     * @param id branch office's id
     * @param sucursal branch office
     * @param idClient client's id
     */
    @Override
    public void updateBranchOffice(int id, String sucursal, Integer idClient) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(sucursal)) {
            getView().onError("La sucursal no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(3);
        request.put("id", id);
        request.put("sucursal", sucursal.trim());
        request.put("idCliente", idClient);

        Api.getInstance().getBranchOfficeService().updateBranchOffice(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess();
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("La sucursal ya no existe.");
                        } else if (response.getStatusCode() == 3) {
                            getView().onError("El cliente no existe.");
                        } else if (response.getStatusCode() == 3) {
                            getView().onError("Ya existe una sucursal con esos "
                                    + "datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

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
                    getView().onErrorClients();
                });
    }

}
