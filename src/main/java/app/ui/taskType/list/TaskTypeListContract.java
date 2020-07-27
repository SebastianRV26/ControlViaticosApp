package app.ui.taskType.list;

import app.data.model.TaskType;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public class TaskTypeListContract {

    interface View extends IBaseView {

        void showTaskTypes(List<TaskType> taskTypes);

        void refreshData();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void loadTaskTypes();

        void disableTaskType(int taskTypeId);
    }
}
