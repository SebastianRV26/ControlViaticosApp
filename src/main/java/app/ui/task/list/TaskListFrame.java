package app.ui.task.list;

import app.data.model.Task;
import app.ui.task.detail.TaskDetailFrame;
import app.util.DataChangedListener;
import app.util.TextChangeListener;
import app.util.Toast;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class TaskListFrame extends javax.swing.JInternalFrame
        implements TaskListContract.View, DataChangedListener {

    private TaskListPresenter presenter = new TaskListPresenter();
    private TableRowSorter trsFilter;

    /**
     * Creates new form TaskListFrame
     */
    public TaskListFrame() {
        initComponents();

        presenter.attachView(this);
        presenter.loadTasks();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSearch = new javax.swing.JLabel();
        lblFilter = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        cbFilter = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTasks = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnDisable = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Labores");

        lblSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        lblSearch.setText("Buscar:");

        lblFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/filter.png"))); // NOI18N
        lblFilter.setText("Filtro:");

        cbFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Descripción", "Tipo labor" }));
        cbFilter.setMinimumSize(new java.awt.Dimension(16, 20));
        cbFilter.setPreferredSize(new java.awt.Dimension(16, 20));

        jScrollPane1.setViewportView(tblTasks);

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
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblFilter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFilter, 0, 182, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDisable)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSearch)
                    .addComponent(lblFilter)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Checks if there is a selected item in the table
        if (tblTasks.getSelectedRow() != -1) {
            // Gets the data from that index
            int index = tblTasks.convertRowIndexToModel(tblTasks.getSelectedRow());
            Task task = ((TaskTableModel) tblTasks.getModel()).getValue(index);

            JInternalFrame frame = new TaskDetailFrame(task, this);
            getDesktopPane().add(frame);
            frame.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar una labor",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        };
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDisableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisableActionPerformed
        // Checks if there is a selected item in the table
        if (tblTasks.getSelectedRow() != -1) {
            // Gets the data from that index
            int index = tblTasks.convertRowIndexToModel(tblTasks.getSelectedRow());
            Task task = ((TaskTableModel) tblTasks.getModel()).getValue(index);

            int option = JOptionPane.showInternalConfirmDialog(this,
                    "¿Está seguro de que desea eliminar la labor?",
                    "Confirmar operación",
                    JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                presenter.disableTask(task.getId());
            }
        } else {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un labor",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDisableActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JInternalFrame frame = new TaskDetailFrame(null, this);
        getDesktopPane().add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * Called when the presenter finished to retrieve the tasks from the
     * database.
     *
     * @param tasks the list of tasks
     */
    @Override
    public void showTasks(List<Task> tasks) {
        tblTasks.setModel(new TaskTableModel(tasks));

        // Creates a filter and set it up to work everytime user types something
        trsFilter = new TableRowSorter(tblTasks.getModel());
        tblTasks.setRowSorter(trsFilter);
        filterData();

        // Typing event
        txtSearch.getDocument().addDocumentListener((TextChangeListener) () -> {
            filterData();
        });
    }

    @Override
    public void refreshData() {
        presenter.loadTasks();
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
        presenter.loadTasks();
    }

    /**
     * Applies the filter to the table.
     */
    private void filterData() {
        if (!txtSearch.getText().isEmpty()) {
            trsFilter.setRowFilter(RowFilter.regexFilter("(?i)"
                    + txtSearch.getText(), cbFilter.getSelectedIndex()));
        } else {
            trsFilter.setRowFilter(null);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDisable;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cbFilter;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFilter;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable tblTasks;
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
