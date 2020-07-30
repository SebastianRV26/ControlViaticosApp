package app.ui.supportType.list;

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
public class SupportTypeListPresenter<V extends SupportTypeListContract.View>
        extends BasePresenter<V> implements SupportTypeListContract.Presenter<V> {

    /**
     * Called when the view needs to load the supportTypes from the database.
     */
    @Override
    public void loadSupportTypes() {
        Api.getInstance().getSupportTypeService().getSupportTypes()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((supportTypes) -> {
                    getView().showSupportTypes(supportTypes);
                }, throwable -> {
                    getView().onError("Error de conexión al cargar datos."
                            + "\nIntente de nuevo");
                });
    }

    /**
     * Called when the view needs to disable a supportType from the database.
     *
     * @param id support type's id
     */
    @Override
    public void disableSupportType(int id) {
        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("id", id);
        request.put("isActive", 0);

        // Executes the request
        Api.getInstance().getSupportTypeService().updateSupportType(request)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Request successful
                    getView().refreshData();
                    getView().onSuccess("Se eliminó el tipo de soporte");
                }, throwable -> {
                    // Request error
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El tipo soporte ya no existe.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }
}
