package app.ui.cost.list;

import app.data.model.Cost;
import app.ui.cost.detail.CostDetailFrame;
import app.util.DataChangedListener;
import app.util.TextChangeListener;
import app.util.Toast;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class CostListFrame extends javax.swing.JInternalFrame
        implements CostListContract.View, DataChangedListener {

    private CostListPresenter presenter = new CostListPresenter();
    private TableRowSorter trsFilter;

    /**
     * Creates new form CostListFrame
     */
    public CostListFrame() {
        initComponents();

        presenter.attachView(this);
        presenter.loadCosts();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCosts = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnDisable = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Centros de costos");

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        lblSearch.setText("Buscar:");

        jScrollPane1.setViewportView(tblCosts);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        btnEdit.setText("Modificar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDisable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/disable.png"))); // NOI18N
        btnDisable.setText("Deshabilitar");
        btnDisable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisableActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDisable)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDisable)
                    .addComponent(btnAdd))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Checks if there is a selected item in the table
        if (tblCosts.getSelectedRow() != -1) {
            // Gets the data from that index
            int index = tblCosts.convertRowIndexToModel(tblCosts.getSelectedRow());
            Cost cost = ((CostTableModel) tblCosts.getModel()).getValue(index);

            JInternalFrame frame = new CostDetailFrame(cost, this);
            getDesktopPane().add(frame);
            frame.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un centro de costo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDisableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisableActionPerformed
        // Checks if there is a selected item in the table
        if (tblCosts.getSelectedRow() != -1) {
            // Gets the data from that index
            int index = tblCosts.convertRowIndexToModel(tblCosts.getSelectedRow());
            Cost cost = ((CostTableModel) tblCosts.getModel()).getValue(index);

            int option = JOptionPane.showInternalConfirmDialog(this,
                    "¿Está seguro de que desea eliminar el centro de costo?",
                    "Confirmar operación",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                presenter.disableCost(cost.getId());
            }
        } else {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un cliente",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDisableActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JInternalFrame frame = new CostDetailFrame(null, this);
        getDesktopPane().add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * Called when the presenter finished to retrieve the costs from the
     * database.
     *
     * @param costs the list of clients
     */
    @Override
    public void showCosts(List<Cost> costs) {
        tblCosts.setModel(new CostTableModel(costs));

        // Creates a filter and set it up to work everytime user types something
        trsFilter = new TableRowSorter(tblCosts.getModel());
        tblCosts.setRowSorter(trsFilter);
        filterData();

        // Typing event
        txtSearch.getDocument().addDocumentListener((TextChangeListener) () -> {
            filterData();
        });
    }

    @Override
    public void refreshData() {
        presenter.loadCosts();
    }

    @Override
    public void onError(String message) {
        JOptionPane.showInternalMessageDialog(this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Called by the detail view everytime it need to update this view.
     */
    @Override
    public void onDataChanged() {
        presenter.loadCosts();
    }

    /**
     * Applies the filter to the table.
     */
    private void filterData() {
        if (!txtSearch.getText().isEmpty()) {
            trsFilter.setRowFilter(RowFilter.regexFilter("(?i)"
                    + txtSearch.getText(), 0));
        } else {
            trsFilter.setRowFilter(null);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDisable;
    private javax.swing.JButton btnEdit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable tblCosts;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onSuccess(String message) {
        // create a Toast message 
        Toast toast = new Toast(this ,message); 
        // call the method 
        toast.showToast(); 
    }

}
