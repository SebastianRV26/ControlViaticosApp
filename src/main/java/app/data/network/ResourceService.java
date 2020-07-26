package app.data.network;

import app.data.model.Resource;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ResourceService {

    @POST("/resources/AddResource")
    Completable addResource(@Body HashMap<String, Object> request);

    @GET("/resources/GetResources")
    Single<List<Resource>> getResources();

    @PUT("/resources/UpdateResource")
    Completable updateResource(@Body HashMap<String, Object> request);
}
