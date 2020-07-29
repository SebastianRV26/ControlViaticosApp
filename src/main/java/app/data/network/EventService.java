package app.data.network;

import app.data.model.Event;
import app.data.model.TableEvent;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface EventService {

    @POST("/events/AddEvent")
    Completable addEvent(@Body HashMap<String, Object> request);

    @GET("/events/GetTableEvents")
    Single<List<TableEvent>> getTableEvents();

    @GET("/events/GetEvent")
    Single<Event> getEvent(@Query("eventId") int eventId);
    
    @PUT("/events/UpdateEvent")
    Completable updateEvent(@Body HashMap<String, Object> request);

    @DELETE("/events/DeleteEvent")
    Completable deleteEvent(@Query("eventId") int eventId);
}
