package app.data.network;

import app.data.model.BranchOffice;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface BranchOfficeService {

    @POST("/branchOffices/addBranchOffice")
    Completable addBranchOffice(@Body HashMap<String, Object> request);

    @GET("/branchOffices/getBranchOffices")
    Single<List<BranchOffice>> getBranchOffices();

    @PUT("/branchOffices/updateBranchOffice")
    Completable updateBranchOffice(@Body HashMap<String, Object> request);
}
