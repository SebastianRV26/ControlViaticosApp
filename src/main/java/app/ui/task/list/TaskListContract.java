package app.ui.task.list;

import app.data.model.Task;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public class TaskListContract {

    interface View extends IBaseView {

        void showTasks(List<Task> tasks);

        void refreshData();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void loadTasks();

        void disableTask(int taskId);
    }
}
