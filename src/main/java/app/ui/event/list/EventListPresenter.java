package app.ui.event.list;

import app.data.network.Api;
import app.ui.base.BasePresenter;
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

}
