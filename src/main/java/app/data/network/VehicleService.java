package app.data.network;

import app.data.model.Vehicle;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface VehicleService {

    @POST("/vehicles/addVehicle")
    Completable addVehicle(@Body HashMap<String, Object> request);

    @GET("/vehicles/getVehicles")
    Single<List<Vehicle>> getVehicles();

    @PUT("/vehicles/updateVehicle")
    Completable updateVehicle(@Body HashMap<String, Object> request);
}
