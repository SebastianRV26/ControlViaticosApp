package app.data.network;

import app.data.model.Task;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface TaskService {

    @POST("/tasks/addTask")
    Completable addTask(@Body HashMap<String, Object> request);

    @GET("/tasks/getTasks")
    Single<List<Task>> getTasks();

    @PUT("/tasks/updateTask")
    Completable updateTask(@Body HashMap<String, Object> request);
}
