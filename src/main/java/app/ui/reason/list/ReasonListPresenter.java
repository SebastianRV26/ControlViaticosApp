package app.ui.reason.list;

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
public class ReasonListPresenter<V extends ReasonListContract.View>
        extends BasePresenter<V> implements ReasonListContract.Presenter<V> {

    /**
     * Called when the view needs to load the reasons from the database.
     */
    @Override
    public void loadReasons() {
        Api.getInstance().getReasonService().getReason()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((reasons) -> {
                    getView().showReasons(reasons);
                }, throwable -> {
                    getView().onError("Error de conexión al cargar datos."
                            + "\nIntente de nuevo");
                });
    }

    /**
     * Called when the view needs to disable a reason from the database.
     *
     * @param reasonId client's id
     */
    @Override
    public void disableReason(int reasonId) {
        // Create the request data
        HashMap<String, Object> request = new HashMap<>(2);
        request.put("reasonId", reasonId);
        request.put("isActive", 0);

        // Executes the request
        Api.getInstance().getReasonService().updateReason(request)
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
                            getView().onError("La razon ya no existe.");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }
}
