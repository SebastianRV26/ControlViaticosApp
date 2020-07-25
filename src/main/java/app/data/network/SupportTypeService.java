package app.data.network;

import app.data.model.SupportType;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface SupportTypeService {

    @POST("/supportTypes/addSupportType")
    Completable addSupportType(@Body HashMap<String, Object> request);

    @GET("/supportTypes/getSupportTypes")
    Single<List<SupportType>> getSupportTypes();

    @PUT("/supportTypes/updateSupportType")
    Completable updateSupportType(@Body HashMap<String, Object> request);
}
