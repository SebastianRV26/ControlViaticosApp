package app.ui.expenseType.detail;

import app.data.model.ExpenseType;
import app.util.DataChangedListener;
import javax.swing.JOptionPane;

public class ExpenseTypeDetailFrame extends javax.swing.JInternalFrame
        implements ExpenseTypeDetailContract.View {

    /**
     * Creates new form ExpenseTypeDetailFrame
     *
     * @param expenseTypeId the id of the expense type to modify, -1 if we are
     * adding a new expense type
     * @param listener allows the list view to know when a expense type was
     * added or modified
     */
    private ExpenseTypeDetailPresenter<ExpenseTypeDetailContract.View> presenter;
    private ExpenseType expenseType;
    private DataChangedListener listener;

    public ExpenseTypeDetailFrame(ExpenseType expenseType,
            DataChangedListener listener) {

        this.expenseType = expenseType;
        this.listener = listener;

        initComponents();

        // Means we are adding a reason
        if (expenseType == null) {
            setTitle("Agregar tipo de viático");
        } else {
            setTitle("Modificar tipo de viático");
            txtDescripcion.setText(expenseType.getDescripcion());
        }

        presenter = new ExpenseTypeDetailPresenter<>();
        presenter.attachView(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSocialReason = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        lblSocialReason.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/social.png"))); // NOI18N
        lblSocialReason.setText("Descripción");

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 163, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblSocialReason)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcion)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSocialReason)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Check if we're adding or updating to call the correct method
        if (expenseType == null) {
            presenter.addExpenseType(txtDescripcion.getText());
        } else {
            presenter.updateExpenseType(expenseType.getId(), txtDescripcion.getText());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    @Override
    public void onSuccess() {
        // Update the reason list view.
        this.listener.onDataChanged();
        this.dispose();
    }

    @Override
    public void onError(String message) {
        JOptionPane.showInternalMessageDialog(this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblSocialReason;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables

}
