package app.ui.vehicle.detail;

import app.ui.listRenderers.ResourceDesListCellRenderer;
import app.data.model.Resource;
import app.data.model.Vehicle;
import app.util.DataChangedListener;
import app.util.Toast;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class VehicleDetailFrame extends javax.swing.JInternalFrame
        implements VehicleDetailContract.View {

    private VehicleDetailPresenter<VehicleDetailContract.View> presenter;
    private Vehicle vehicle;
    private DataChangedListener listener;

    /**
     * Creates new form VehicleDetailFrame
     *
     * @param vehicle the vehicle to modify, null if we are adding a new vehicle
     * @param listener allows the list view to know when a branch office was
     * added or modified
     */
    public VehicleDetailFrame(Vehicle vehicle, DataChangedListener listener) {
        initComponents();
        cbUsernameResourse.setRenderer(new ResourceDesListCellRenderer());

        this.vehicle = vehicle;
        this.listener = listener;
        // Means we are adding a vehicle
        if (vehicle == null) {
            setTitle("Agregar vehículo");
        } else {
            setTitle("Modificar vehículo");
            txtDescription.setText(vehicle.getDescripcion());
            spKmCost.setValue(vehicle.getMontoKm());
        }
        presenter = new VehicleDetailPresenter<>();
        presenter.attachView(this);
        presenter.loadResources();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescription = new javax.swing.JLabel();
        lblTaskType = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cbUsernameResourse = new javax.swing.JComboBox();
        lblMontoPorKm = new javax.swing.JLabel();
        spKmCost = new javax.swing.JSpinner();

        setClosable(true);
        setIconifiable(true);

        lblDescription.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/description.png"))); // NOI18N
        lblDescription.setText("Descripción:");

        lblTaskType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/type-task.png"))); // NOI18N
        lblTaskType.setText("Responsable");

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

        lblMontoPorKm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/kilometer.png"))); // NOI18N
        lblMontoPorKm.setText("Monto por kilometro");

        spKmCost.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTaskType)
                            .addComponent(lblDescription)
                            .addComponent(lblMontoPorKm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescription)
                            .addComponent(cbUsernameResourse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(spKmCost, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 215, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)))
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
                    .addComponent(lblMontoPorKm)
                    .addComponent(spKmCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTaskType)
                    .addComponent(cbUsernameResourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Check if we're adding or updating to call the correct method
        Resource resourse = (Resource) cbUsernameResourse.getSelectedItem();
        if (vehicle == null) {
            presenter.addVehicle(txtDescription.getText(),
                    (Float) spKmCost.getValue(), resourse.getId());
        } else {
            presenter.updateVehicle(vehicle.getId(), txtDescription.getText(),
                    (Float) spKmCost.getValue(), resourse.getId());
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
    public void showResources(List<Resource> resources) {
        cbUsernameResourse.setModel(new DefaultComboBoxModel<>(resources.toArray()));
        if (vehicle != null) {
            for (int i = 0; i < resources.size(); i++) {
                if (resources.get(i).getId() == vehicle.getIdResponsable()) {
                    cbUsernameResourse.setSelectedIndex(i);
                    break;
                }
            }

        }
    }

    @Override
    public void onErrorResources() {
        onError("Error al cargar responsables");
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbUsernameResourse;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblMontoPorKm;
    private javax.swing.JLabel lblTaskType;
    private javax.swing.JSpinner spKmCost;
    private javax.swing.JTextField txtDescription;
    // End of variables declaration//GEN-END:variables

}
