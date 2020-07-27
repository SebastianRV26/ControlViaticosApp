package app.ui.task.detail;

import app.data.model.TaskType;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface TaskDetailContract {

    interface View extends IBaseView {

        void showTaskTypes(List<TaskType> taskTypes);

        void onSuccess();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void addTask(String description, int taskId);

        void updateTask(int id, String description, int taskId);

        void loadTaskTypes();
    }
}
