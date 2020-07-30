package app.ui.base;

/**
 * Base interface that any class that wants to act as a View in the MVP (Model
 * View Presenter) pattern must implement.
 */
public interface IBaseView {

    void onError(String message);
    
    void onSuccess(String message);
}
