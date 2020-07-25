package app.ui.resource.list;

import app.data.model.Resource;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public class ResourceListContract {

    interface View extends IBaseView {

        void showResources(List<Resource> resources);

        void refreshData();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void loadResource();

        void disableResource(int resourceId);
    }
}
