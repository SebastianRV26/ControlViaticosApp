package app.ui.vehicle.list;

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
public class VehicleListPresenter<V extends VehicleListContract.View>
        extends BasePresenter<V> implements VehicleListContract.Presenter<V> {

    /**
     * Called when the view needs to load the vehicles from the database.
     */
    @Override
    public void loadVehicles() {
        Api.getInstance().getVehicleService().getVehicles()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((vehicles) -> {
                    getView().showVehicles(vehicles);
                }, throwable -> {
                    getView().onError("Error de conexión al cargar datos."
                            + "\nIntente de nuevo");
                });
    }

    /**
     * Called when the view needs to disable a vehicle from the database.
     *
     * @param vehicleId vehicle's id
     */
    @Override
    public void disableVehicle(int vehicleId) {
        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("id", vehicleId);
        request.put("isActive", 0);

        // Executes the request
        Api.getInstance().getVehicleService().updateVehicle(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request successful
                    getView().refreshData();
                }, throwable -> {
                    // Request error
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El vehiculo ya no existe.");
                        } else if (response.getStatusCode() == 2) {
                            getView().onError("El responsable no existe");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }
}
