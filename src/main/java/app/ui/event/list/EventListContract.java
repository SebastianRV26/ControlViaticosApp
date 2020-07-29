package app.ui.event.list;

import app.data.model.TableEvent;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public class EventListContract {

    interface View extends IBaseView {

        void showEvents(List<TableEvent> events);

        void refreshData();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void loadEvents();

        void deleteEvent(int eventId);
    }
}
