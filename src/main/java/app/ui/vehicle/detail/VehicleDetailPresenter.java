package app.ui.vehicle.detail;

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
public class VehicleDetailPresenter<V extends VehicleDetailContract.View>
        extends BasePresenter<V> implements VehicleDetailContract.Presenter<V> {

    /**
     * Called everytime the view wants to add a new vehicle.
     *
     * @param descripcion vehicle's description
     * @param montoKm amount per kilometer
     * @param idResponsable responsible id
     */
    @Override
    public void addVehicle(String descripcion, Double montoKm, Integer idResponsable) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(descripcion)) {
            getView().onError("La descripcion no puede estar vacía.");
            return;
        } else if (montoKm == null) {
            getView().onError("El monto por km no puede estar vacío.");
            return;
        } else if (Utils.textIsNullOrEmpty(idResponsable.toString())) {
            getView().onError("El responsable no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(3);
        request.put("descripcion", descripcion.trim());
        request.put("montoKm", montoKm);
        request.put("idResponsable", idResponsable);

        Api.getInstance().getVehicleService().addVehicle(request)
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
                            getView().onError("El responsable no existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("Ya hay un vehículo con esos"
                                    + " datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    /**
     * Called everytime the view wants to add a new vehicle.
     *
     * @param id vehicle's id
     * @param descripcion vehicle's description
     * @param montoKm amount per kilometer
     * @param idResponsable responsible id
     */
    @Override
    public void updateVehicle(int id, String descripcion, Double montoKm, Integer idResponsable) {
        // Let's validate all the fields
        if (Utils.textIsNullOrEmpty(descripcion)) {
            getView().onError("La descripcion no puede estar vacía.");
            return;
        } else if (montoKm == null) {
            getView().onError("El monto por km no puede estar vacía.");
            return;
        } else if (Utils.textIsNullOrEmpty(idResponsable.toString())) {
            getView().onError("El responsable no puede estar vacía.");
            return;
        }

        // Create the request data
        HashMap<String, Object> request = new HashMap<>(4);
        request.put("id", id);
        request.put("descripcion", descripcion.trim());
        request.put("montoKm", montoKm);
        request.put("idResponsable", idResponsable);

        Api.getInstance().getVehicleService().updateVehicle(request)
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
                            getView().onError("El vehículo ya no existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("El responsable no existe");
                        } else if (response.getStatusCode() == 3) {
                            getView().onError("Ya existe un vehículo con esos "
                                    + "datos.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

    @Override
    public void loadResources() {
        Api.getInstance().getResourceService().getResources()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((resources) -> {
                    getView().showResources(resources);
                }, throwable -> {
                    getView().onErrorResources();
                });
    }

}
