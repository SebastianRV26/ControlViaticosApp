package app.data.network;

import app.data.model.Reason;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ReasonService {

    @POST("/reasons/AddReason")
    Completable addReason(@Body HashMap<String, Object> request);

    @GET("/reasons/GetReasons")
    Single<List<Reason>> getReasons();

    @PUT("/reasons/UpdateReason")
    Completable updateReason(@Body HashMap<String, Object> request);
}
