package app.data.network;

import app.data.model.Supplier;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface SupplierService {

    @POST("/suppliers/addSupplier")
    Completable addSupplier(@Body HashMap<String, Object> request);

    @GET("/suppliers/getSuppliers")
    Single<List<Supplier>> getSuppliers();

    @PUT("/suppliers/updateSupplier")
    Completable updateSupplier(@Body HashMap<String, Object> request);
}
