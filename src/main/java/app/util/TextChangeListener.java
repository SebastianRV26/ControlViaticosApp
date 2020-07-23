package app.util;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Event that is called everytime the text in a {@link JTextField} is changed.
 */
@FunctionalInterface
public interface TextChangeListener extends DocumentListener {

    void onTextChange();

    @Override
    default void insertUpdate(DocumentEvent e) {
        onTextChange();
    }

    @Override
    default void removeUpdate(DocumentEvent e) {
        onTextChange();
    }

    @Override
    default void changedUpdate(DocumentEvent e) {
        onTextChange();
    }

}
