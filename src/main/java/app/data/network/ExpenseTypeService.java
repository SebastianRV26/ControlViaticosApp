package app.data.network;

import app.data.model.ExpenseType;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ExpenseTypeService {

    @POST("/expenseTypes/AddExpenseType")
    Completable addExpenseType(@Body HashMap<String, Object> request);

    @GET("/expenseTypes/GetExpenseTypes")
    Single<List<ExpenseType>> getExpenseTypes();

    @PUT("/expenseTypes/UpdateExpenseType")
    Completable updateExpenseType(@Body HashMap<String, Object> request);
}
