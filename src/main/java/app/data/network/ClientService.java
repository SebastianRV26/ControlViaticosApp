package app.data.network;

import app.data.model.Client;
import app.data.model.Reason;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ClientService {

    @POST("/clients/addClient")
    Completable addClient(@Body HashMap<String, Object> request);

    @GET("/clients/getClients")
    Single<List<Client>> getClients();

    @PUT("/clients/updateClient")
    Completable updateClient(@Body HashMap<String, Object> request);
}
