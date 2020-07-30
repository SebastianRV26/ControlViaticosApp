package app.ui.branchOffice.detail;

import app.ui.listRenderers.ClientListCellRenderer;
import app.data.model.BranchOffice;
import app.data.model.Client;
import app.util.DataChangedListener;
import app.util.Toast;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class BranchOfficeDetailFrame extends javax.swing.JInternalFrame
        implements BranchOfficeDetailContract.View {

    private BranchOfficeDetailPresenter<BranchOfficeDetailContract.View> presenter;
    private BranchOffice branchOffice;
    private DataChangedListener listener;

    /**
     * Creates new form BranchOfficeDetailFrame
     *
     * @param branchOffice the branch Office to modify, null if we are adding a
     * new branch Office
     * @param listener allows the list view to know when a branch office was
     * added or modified
     */
    public BranchOfficeDetailFrame(BranchOffice branchOffice, DataChangedListener listener) {
        this.branchOffice = branchOffice;
        this.listener = listener;

        initComponents();
        cbClients.setRenderer(new ClientListCellRenderer());

        // Means we are adding a branch office
        if (branchOffice == null) {
            setTitle("Agregar sucursal");
        } else {
            setTitle("Modificar sucursal");
            txtDescription.setText(branchOffice.getSucursal());
        }

        presenter = new BranchOfficeDetailPresenter<>();
        presenter.attachView(this);
        presenter.loadClients();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescription = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtDescription = new javax.swing.JTextField();
        lblClient = new javax.swing.JLabel();
        cbClients = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);

        lblDescription.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/details.png"))); // NOI18N
        lblDescription.setText("Descripción:");

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

        lblClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/person.png"))); // NOI18N
        lblClient.setText("Cliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(97, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblDescription)
                            .addComponent(lblClient))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescription)
                            .addComponent(cbClients, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescription)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClient)
                    .addComponent(cbClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Client client = (Client) cbClients.getSelectedItem();
        if (branchOffice == null) {
            presenter.addBranchOffice(txtDescription.getText(), client.getId());
        } else {
            presenter.updateBranchOffice(branchOffice.getId(),
                    txtDescription.getText(), client.getId());
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
     * This will be called if a client were added or updated successfully.
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

    @Override
    public void showClients(List<Client> clients) {
        cbClients.setModel(new DefaultComboBoxModel<>(clients.toArray()));
        if (branchOffice != null) {
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getId() == branchOffice.getClientId()) {
                    cbClients.setSelectedIndex(i);
                    break;
                }
            }

        }
    }

    @Override
    public void onErrorClients() {
        onError("Error al cargar clientes");
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbClients;
    private javax.swing.JLabel lblClient;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JTextField txtDescription;
    // End of variables declaration//GEN-END:variables

}
