package app.ui.cost.list;

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
public class CostListPresenter<V extends CostListContract.View>
        extends BasePresenter<V> implements CostListContract.Presenter<V> {

    /**
     * Called when the view needs to load the costs from the database.
     */
    @Override
    public void loadCosts() {
        Api.getInstance().getCostService().getCosts()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((costs) -> {
                    getView().showCosts(costs);
                }, throwable -> {
                    getView().onError("Error de conexión al cargar datos."
                            + "\nIntente de nuevo");
                });
    }

    /**
     * Called when the view needs to disable a cost from the database.
     *
     * @param costId id of the cost
     */
    @Override
    public void disableCost(int costId) {
        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("costId", costId);
        request.put("isActive", 0);

        // Executes the request
        Api.getInstance().getCostService().updateCost(request)
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
                            getView().onError("El costo ya no existe.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }
}
