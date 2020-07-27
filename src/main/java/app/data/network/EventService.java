package app.data.network;

import app.data.model.Event;
import app.data.model.TableEvent;
import io.reactivex.rxjava3.core.Single;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EventService {

    @GET("/events/GetTableEvents")
    Single<List<TableEvent>> getTableEvents();

    @GET("/events/GetEvent")
    Single<Event> getEvent(@Query("eventId") int eventId);
}
