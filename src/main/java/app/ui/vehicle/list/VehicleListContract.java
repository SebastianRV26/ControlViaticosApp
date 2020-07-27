package app.ui.vehicle.list;

import app.data.model.Vehicle;
import app.ui.base.IBasePresenter;
import app.ui.base.IBaseView;
import java.util.List;

/**
 * Contains the interface required for MVP pattern implementation.
 */
public class VehicleListContract {

    interface View extends IBaseView {

        void showVehicles(List<Vehicle> vehicles);

        void refreshData();
    }

    interface Presenter<V extends View> extends IBasePresenter<V> {

        void loadVehicles();

        void disableVehicle(int id);
    }
}
