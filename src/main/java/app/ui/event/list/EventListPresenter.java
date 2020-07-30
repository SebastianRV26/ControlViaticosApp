package app.ui.event.list;

import app.data.model.StatusResponse;
import app.data.network.Api;
import app.ui.base.BasePresenter;
import app.util.Utils;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * The presenter class responsible for the communication between the view and
 * the API.
 *
 * @param <V> the view attached to this presenter
 */
public class EventListPresenter<V extends EventListContract.View>
        extends BasePresenter<V> implements EventListContract.Presenter<V> {

    /**
     * Called when the view needs to load the events from the database.
     */
    @Override
    public void loadEvents() {
        Api.getInstance().getEventService().getTableEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe((events) -> {
                    getView().showEvents(events);
                }, throwable -> {
                    getView().onError("Error de conexión al cargar datos."
                            + "\nIntente de nuevo");
                });
    }

    /**
     * Called when the view wants to delete an event.
     *
     * @param eventId id of the event
     */
    @Override
    public void deleteEvent(int eventId) {
        Api.getInstance().getEventService().deleteEvent(eventId)
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(() -> {
                    // Success
                    getView().refreshData();
                    getView().onSuccess("Se eliminó el evento");
                }, throwable -> {
                    // Let's manage errors
                    StatusResponse response
                            = Utils.parseStatusResponse(throwable);
                    if (response != null) {
                        if (response.getStatusCode() == 1) {
                            getView().onError("El evento no existe");
                        } else {
                            getView().onError("Error de conexión."
                                    + "\nIntente de nuevo");
                        }
                    } else {
                        getView().onError("Error de conexión."
                                + "\nIntente de nuevo");
                    }
                });
    }

}
