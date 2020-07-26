package app.ui.resource.list;

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
public class ResourceListPresenter<V extends ResourceListContract.View>
        extends BasePresenter<V> implements ResourceListContract.Presenter<V> {

    /**
     * Called when the view needs to load the resources from the database.
     */
    @Override
    public void loadResource() {
        Api.getInstance().getResourceService().getResources()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((resources) -> {
                    getView().showResources(resources);
                }, throwable -> {
                    getView().onError("Error de conexión al cargar datos."
                            + "\nIntente de nuevo");
                });
    }

    /**
     * Called when the view needs to disable a resource from the database.
     *
     * @param resourceId resource's id
     */
    @Override
    public void disableResource(int resourceId) {
        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("resourceId", resourceId);
        request.put("isActive", 0);

        // Executes the request
        Api.getInstance().getResourceService().updateResource(request)
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
                            getView().onError("El recurso ya no existe.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }
}
