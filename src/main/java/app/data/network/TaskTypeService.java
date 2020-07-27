package app.data.network;

import app.data.model.TaskType;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import java.util.HashMap;
import java.util.List;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface TaskTypeService {

    @POST("/taskTypes/AddTaskType")
    Completable addTaskType(@Body HashMap<String, Object> request);

    @GET("/taskTypes/GetTaskTypes")
    Single<List<TaskType>> getTaskTypes();

    @PUT("/taskTypes/UpdateTaskType")
    Completable updateTaskType(@Body HashMap<String, Object> request);
}
