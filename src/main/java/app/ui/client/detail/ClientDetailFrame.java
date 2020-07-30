package app.ui.client.detail;

import app.data.model.Client;
import app.util.Toast;
import app.util.DataChangedListener;
import javax.swing.JOptionPane;

public class ClientDetailFrame extends javax.swing.JInternalFrame
        implements ClientDetailContract.View {

    private ClientDetailPresenter<ClientDetailContract.View> presenter;
    private Client client;
    private DataChangedListener listener;

    /**
     * Creates new form ClientDetailFrame
     *
     * @param client the client to modify, null if we are adding a new client
     * @param listener allows the list view to know when a client was added or
     * modified
     */
    public ClientDetailFrame(Client client, DataChangedListener listener) {
        initComponents();

        this.client = client;
        // Means we are adding a client
        if (client == null) {
            setTitle("Agregar cliente");
        } else {
            setTitle("Modificar cliente");
            txtSocialReason.setText(client.getRazonSocial());
            txtTradeReason.setText(client.getRazonComercial());
        }

        presenter = new ClientDetailPresenter<>();
        presenter.attachView(this);
        this.listener = listener;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSocialReason = new javax.swing.JLabel();
        lblTradeReason = new javax.swing.JLabel();
        txtSocialReason = new javax.swing.JTextField();
        txtTradeReason = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        lblSocialReason.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/social.png"))); // NOI18N
        lblSocialReason.setText("Razón social:");

        lblTradeReason.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trade.png"))); // NOI18N
        lblTradeReason.setText("Razón comercial:");

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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 143, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTradeReason)
                            .addComponent(lblSocialReason))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSocialReason)
                            .addComponent(txtTradeReason))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSocialReason)
                    .addComponent(txtSocialReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTradeReason)
                    .addComponent(txtTradeReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Check if we're adding or updating to call the correct method
        if (client == null) {
            presenter.addClient(txtSocialReason.getText(),
                    txtTradeReason.getText());
        } else {
            presenter.updateClient(client.getId(), txtSocialReason.getText(),
                    txtTradeReason.getText());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    @Override
    public void onError(String message) {
        JOptionPane.showInternalMessageDialog(this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * This will be called if a client was added or updated successfully.
     */
    @Override
    public void onSuccess(String message) {
        // Update the client list view.
        this.listener.onDataChanged();
        // create a Toast message 
        Toast toast = new Toast(this ,message); 
        // call the method 
        toast.showToast(); 
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblSocialReason;
    private javax.swing.JLabel lblTradeReason;
    private javax.swing.JTextField txtSocialReason;
    private javax.swing.JTextField txtTradeReason;
    // End of variables declaration//GEN-END:variables
}
