package app.ui.vehicle.detail;

import app.data.model.Resource;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 * Allow a {@link JComboBox} how to render a vehicle.
 */
public class ResourceListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        if (value instanceof Resource) {
            value = ((Resource) value).getDescripcion();
        }
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        return this;
    }
}
