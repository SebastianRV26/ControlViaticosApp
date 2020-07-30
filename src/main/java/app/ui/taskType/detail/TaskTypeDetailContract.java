package app.ui.taskType.detail;

import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface TaskTypeDetailContract {

    interface View extends IBaseView {
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void addTaskType(String descripcion);

        void updateTaskType(int id, String descripcion);
    }
}
