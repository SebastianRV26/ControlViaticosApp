package app.ui.taskType.detail;

import app.data.model.TaskType;
import app.util.DataChangedListener;
import app.util.Toast;
import javax.swing.JOptionPane;

public class TaskTypeDetailFrame extends javax.swing.JInternalFrame
        implements TaskTypeDetailContract.View {

    private TaskTypeDetailPresenter<TaskTypeDetailContract.View> presenter;
    private TaskType taskType;
    private DataChangedListener listener;

    /**
     * Creates new form TaskTypeDetailFrame
     *
     * @param taskType the task type to modify, null if we are adding a new task
     * type
     * @param listener allows the list view to know when a client was added or
     * modified
     */
    public TaskTypeDetailFrame(TaskType taskType,
            DataChangedListener listener) {
        this.taskType = taskType;
        this.listener = listener;

        initComponents();

        // Means we are adding a reason
        if (taskType == null) {
            setTitle("Agregar tipo de labor");
        } else {
            setTitle("Modificar tipo de labor");
            txtTaskType.setText(taskType.getDescripcion());
        }

        presenter = new TaskTypeDetailPresenter<>();
        presenter.attachView(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSocialReason = new javax.swing.JLabel();
        txtTaskType = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        lblSocialReason.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/social.png"))); // NOI18N
        lblSocialReason.setText("Descripción:");

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
                        .addComponent(txtTaskType)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTaskType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSocialReason))
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
        if (taskType == null) {
            presenter.addTaskType(txtTaskType.getText());
        } else {
            presenter.updateTaskType(taskType.getId(), txtTaskType.getText());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    @Override
    public void onSuccess(String message) {
        // Update the reason list view.
        this.listener.onDataChanged();
        // create a Toast message 
        Toast toast = new Toast(this ,message); 
        // call the method 
        toast.showToast(); 
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
    private javax.swing.JTextField txtTaskType;
    // End of variables declaration//GEN-END:variables

}
