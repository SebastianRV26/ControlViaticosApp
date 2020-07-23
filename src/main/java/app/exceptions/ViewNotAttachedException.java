package app.exceptions;

/**
 * Exception thrown if the programmer forgets to attach the presenter to the
 * view.
 */
public class ViewNotAttachedException extends RuntimeException {

    public ViewNotAttachedException() {
        super("The view is not attached to the presenter. "
                + "Call onAttach(view) before requesting data");
    }
}
