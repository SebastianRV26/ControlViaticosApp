package app.ui.base;

/**
 * It's the base presenter. Every presenter in the app must either implement
 * this interface or extend BasePresenter.
 *
 * @param <V> the base view that will be linked to this presenter
 */
public interface IBasePresenter<V extends IBaseView> {

    void attachView(V view);
}
