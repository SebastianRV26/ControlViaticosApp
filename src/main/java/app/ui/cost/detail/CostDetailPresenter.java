package app.ui.cost.detail;

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
public class CostDetailPresenter<V extends CostDetailContract.View>
        extends BasePresenter<V> implements CostDetailContract.Presenter<V> {

    /**
     * Called everytime the view wants to add a new cost.
     *
     * @param description cost's description
     */
    @Override
    public void addCost(String description) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(description)) {
            getView().onError("La descripción no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(1);
        request.put("descripcion", description.trim());

        Api.getInstance().getCostService().addCost(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess("Se agrego un nuevo centro de costo");
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("Ya hay un centro de costo con "
                                    + "esos datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    /**
     * Called everytime the view wants to add a new cost.
     *
     * @param id id of the cost
     * @param description description of the cost
     */
    @Override
    public void updateCost(int id, String description) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(description)) {
            getView().onError("La descripción no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(3);
        request.put("costId", id);
        request.put("descripcion", description.trim());

        Api.getInstance().getCostService().updateCost(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request executed successfully
                    getView().onSuccess("Se modifico el centro de costo");
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El centro de costo ya no "
                                    + "existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("Ya existe un centro de costo con"
                                    + " esos datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

}
