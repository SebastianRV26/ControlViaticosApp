package app.ui.event.detail;

import app.data.model.Expense;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface EventDetailContract {

    interface View extends IBaseView {

        void onSuccess();

        void onLoadData(DataResult result);

    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void addExpense(String date, String hour, String taskPerformed,
                String duration, String report, boolean problemSolved,
                int branchOfficeId, int costId, int taskId,
                int supportTypeId, int reasonId, List<Expense> expenses);

        void updateExpense(int eventId, String date, String hour,
                String taskPerformed, String duration, String report,
                boolean problemSolved, int branchOfficeId, int costId,
                int taskId, int supportTypeId, int reasonId,
                List<Expense> expenses);

        void loadData(int eventId);

        void loadData();
    }
}
