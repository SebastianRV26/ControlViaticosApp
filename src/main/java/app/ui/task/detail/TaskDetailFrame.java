package app.ui.task.detail;

import app.data.model.Task;
import app.data.model.TaskType;
import app.util.DataChangedListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class TaskDetailFrame extends javax.swing.JInternalFrame
        implements TaskDetailContract.View {

    private Task task;
    private DataChangedListener listener;
    private TaskDetailPresenter presenter = new TaskDetailPresenter();

    /**
     * Creates new form TaskDetailFrame
     *
     * @param task the task to modify, null if we are adding a new task
     * @param listener allows to update the list after a task is added or
     * modified
     */
    public TaskDetailFrame(Task task, DataChangedListener listener) {
        this.task = task;
        this.listener = listener;

        initComponents();
        cbTaskType.setRenderer(new TaskTypeListCellRenderer());

        // Means we are adding a client
        if (task == null) {
            setTitle("Agregar labor");
        } else {
            setTitle("Modificar labor");
            txtDescription.setText(task.getDescription());
        }

        presenter.attachView(this);
        presenter.loadTaskTypes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescription = new javax.swing.JLabel();
        lblTaskType = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        cbTaskType = new javax.swing.JComboBox();

        setClosable(true);
        setIconifiable(true);

        lblDescription.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/description.png"))); // NOI18N
        lblDescription.setText("Descripción:");

        lblTaskType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/type-task.png"))); // NOI18N
        lblTaskType.setText("Tipo de labor:");

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
                        .addGap(0, 162, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblTaskType)
                            .addComponent(lblDescription))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescription)
                            .addComponent(cbTaskType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                    .addComponent(lblTaskType)
                    .addComponent(cbTaskType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        TaskType taskType = (TaskType) cbTaskType.getSelectedItem();
        if (task == null) {
            presenter.addTask(txtDescription.getText(), taskType.getId());
        } else {
            presenter.updateTask(task.getId(),
                    txtDescription.getText(), taskType.getId());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    @Override
    public void showTaskTypes(List<TaskType> taskTypes) {
        cbTaskType.setModel(new DefaultComboBoxModel<>(taskTypes.toArray()));
        if (task != null) {
            for (int i = 0; i < taskTypes.size(); i++) {
                if (taskTypes.get(i).getId() == task.getIdTaskType()) {
                    cbTaskType.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    /**
     * This will be called if a task was added or updated successfully.
     */
    @Override
    public void onSuccess() {
        // Update the client list view.
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
    private javax.swing.JComboBox cbTaskType;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblTaskType;
    private javax.swing.JTextField txtDescription;
    // End of variables declaration//GEN-END:variables

}
