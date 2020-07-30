package app.ui.vehicle.detail;

import app.data.model.Resource;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public interface VehicleDetailContract {

    interface View extends IBaseView {

        void showResources(List<Resource> resources);

        void onErrorResources();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void addVehicle(String descripcion, Float montoKm, Integer idResponsable);

        void updateVehicle(int id, String descripcion, Float montoKm,
                Integer idResponsable);

        void loadResources();
    }
}
