package app.ui.branchOffice.list;

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
public class BranchOfficeListPresenter<V extends BranchOfficeListContract.View>
        extends BasePresenter<V> implements BranchOfficeListContract.Presenter<V> {

    /**
     * Called when the view needs to load the clients from the database.
     */
    @Override
    public void loadBranchOffices() {
        Api.getInstance().getBranchOfficeService().getBranchOffices()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((clients) -> {
                    getView().showBranchOffices(clients);
                }, throwable -> {
                    getView().onError("Error de conexión al cargar datos."
                            + "\nIntente de nuevo");
                });
    }

    /**
     * Called when the view needs to disable a client from the database.
     *
     * @param id branch office's id
     */
    @Override
    public void disableBranchOffice(int id) {
        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("id", id);
        request.put("isActive", 0);

        // Executes the request
        Api.getInstance().getBranchOfficeService().updateBranchOffice(request)
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
                            getView().onError("La sucursal ya no existe.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }
}
