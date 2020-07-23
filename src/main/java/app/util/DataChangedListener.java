package app.util;

/**
 * Allows communication between detail view and list view, so that way everytime
 * data is added or modified in the database we can know when we have to update
 * the list view.
 */
public interface DataChangedListener {

    void onDataChanged();
}
