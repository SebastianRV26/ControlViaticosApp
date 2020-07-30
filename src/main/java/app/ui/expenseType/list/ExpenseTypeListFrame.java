package app.ui.expenseType.list;

import app.data.model.ExpenseType;
import app.ui.expenseType.detail.ExpenseTypeDetailFrame;
import app.util.DataChangedListener;
import app.util.TextChangeListener;
import app.util.Toast;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class ExpenseTypeListFrame extends javax.swing.JInternalFrame
        implements ExpenseTypeListContract.View, DataChangedListener {

    /**
     * Creates new form ExpenseTypeListFrame
     */
    private ExpenseTypeListPresenter presenter = new ExpenseTypeListPresenter();
    private TableRowSorter trsFilter;

    public ExpenseTypeListFrame() {
        initComponents();
        presenter.attachView(this);
        presenter.loadExpenseTypes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblExpenseType = new javax.swing.JTable();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnDisable = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Tipo viático");

        jScrollPane1.setViewportView(tblExpenseType);

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        lblSearch.setText("Buscar:");

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch)))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisable)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnDisable)
                    .addComponent(btnAdd))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JInternalFrame frame = new ExpenseTypeDetailFrame(null, this);
        getDesktopPane().add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Checks if there is a selected item in the table
        if (tblExpenseType.getSelectedRow() != -1) {
            // Gets the data from that index
            int index = tblExpenseType.convertRowIndexToModel(tblExpenseType.getSelectedRow());
            ExpenseType expenseType = ((ExpenseTypeTableModel) tblExpenseType.getModel()).getValue(index);

            JInternalFrame frame = new ExpenseTypeDetailFrame(expenseType, this);
            getDesktopPane().add(frame);
            frame.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un tipo de viatico",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDisableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisableActionPerformed
        // Checks if there is a selected item in the table
        if (tblExpenseType.getSelectedRow() != -1) {
            // Gets the data from that index
            int index = tblExpenseType.convertRowIndexToModel(tblExpenseType.getSelectedRow());
            ExpenseType expenseType = ((ExpenseTypeTableModel) tblExpenseType.getModel()).getValue(index);

            int option = JOptionPane.showInternalConfirmDialog(this,
                    "¿Está seguro de que desea eliminar el tipo de viatico?",
                    "Confirmar operación",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                presenter.disableExpenseType(expenseType.getId());
            }
        } else {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un tipo de viatico",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDisableActionPerformed

    @Override
    public void showExpenseTypes(List<ExpenseType> ExpenseTypes) {
        tblExpenseType.setModel(new ExpenseTypeTableModel(ExpenseTypes));

        // Creates a filter and set it up to work everytime user types something
        trsFilter = new TableRowSorter(tblExpenseType.getModel());
        tblExpenseType.setRowSorter(trsFilter);
        filterData();

        // Typing event
        txtSearch.getDocument().addDocumentListener((TextChangeListener) () -> {
            filterData();
        });
    }

    @Override
    public void refreshData() {
        presenter.loadExpenseTypes();
    }

    @Override
    public void onError(String message) {
        JOptionPane.showInternalMessageDialog(this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void onDataChanged() {
        presenter.loadExpenseTypes();
    }

    private void filterData() {
        if (!txtSearch.getText().isEmpty()) {
            trsFilter.setRowFilter(RowFilter.regexFilter("(?i)"
                    + txtSearch.getText()));
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
    private javax.swing.JTable tblExpenseType;
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
