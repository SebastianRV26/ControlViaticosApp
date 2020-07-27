package app.ui.listRenderers;

import app.data.model.BranchOffice;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 * Allow a {@link JComboBox} how to render a branch office.
 */
public class BranchOfficeListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        if (value instanceof BranchOffice) {
            value = ((BranchOffice) value).getSucursal();
        }
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        return this;
    }
}
