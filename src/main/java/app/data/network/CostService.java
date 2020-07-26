package app.data.network;

import app.data.model.Cost;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface CostService {

    @POST("/costs/AddCost")
    Completable addCost(@Body HashMap<String, Object> request);

    @GET("/costs/GetCosts")
    Single<List<Cost>> getCosts();

    @PUT("/costs/UpdateCost")
    Completable updateCost(@Body HashMap<String, Object> request);
}
