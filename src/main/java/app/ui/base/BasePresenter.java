package app.ui.base;

import app.exceptions.ViewNotAttachedException;

/**
 * Base class that implements the Presenter interface.
 *
 * @param <V> the base view for this presenter
 */
public class BasePresenter<V extends IBaseView> implements IBasePresenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    public V getView() {
        if (view == null) {
            throw new ViewNotAttachedException();
        }

        return view;
    }

}
