package app.ui.event.detail;

import app.data.model.BranchOffice;
import app.data.model.Client;
import app.data.model.Cost;
import app.data.model.Event;
import app.data.model.Expense;
import app.data.model.Reason;
import app.data.model.SupportType;
import app.data.model.Task;
import app.data.model.TaskType;
import app.ui.expense.ExpenseDetailFrame;
import app.ui.listRenderers.BranchOfficeListCellRenderer;
import app.ui.listRenderers.ClientListCellRenderer;
import app.ui.listRenderers.CostsListCellRenderer;
import app.ui.listRenderers.ReasonListCellRenderer;
import app.ui.listRenderers.SupportTypeListCellRenderer;
import app.ui.listRenderers.TaskListCellRenderer;
import app.ui.listRenderers.TaskTypeListCellRenderer;
import app.util.DataChangedListener;
import app.util.ExpenseTableListener;
import app.util.Toast;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class EventDetailFrame extends javax.swing.JInternalFrame
        implements EventDetailContract.View, ExpenseTableListener {

    private EventDetailPresenter presenter = new EventDetailPresenter();
    private Event event;
    private DataChangedListener listener;

    private List<BranchOffice> branchOffices;
    private List<Task> tasks;

    /**
     * Creates new form EventDetailFrame
     *
     * @param eventId the id of the event to modify, null if we are adding a new
     * event
     * @param listener allows the list view to know when an event was added or
     * modified
     */
    public EventDetailFrame(int eventId, DataChangedListener listener) {
        this.listener = listener;
        presenter.attachView(this);

        initComponents();

        setupCombos();

        // Means we are adding an event
        if (eventId == -1) {
            setTitle("Agregar evento");
            datePicker.setDateToToday();
            presenter.loadData();
        } else {
            setTitle("Modificar evento");
            presenter.loadData(eventId);
        }
    }

    private void setupCombos() {
        cbClient.setRenderer(new ClientListCellRenderer());
        cbBranchOffice.setRenderer(new BranchOfficeListCellRenderer());
        cbCost.setRenderer(new CostsListCellRenderer());
        cbReason.setRenderer(new ReasonListCellRenderer());
        cbSupport.setRenderer(new SupportTypeListCellRenderer());
        cbTaskType.setRenderer(new TaskTypeListCellRenderer());
        cbTask.setRenderer(new TaskListCellRenderer());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDuration = new javax.swing.JLabel();
        lblReport = new javax.swing.JLabel();
        spMinutes = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaTaskPerformed = new javax.swing.JTextArea();
        datePicker = new com.github.lgooddatepicker.components.DatePicker();
        lblMinutes = new javax.swing.JLabel();
        lblClient = new javax.swing.JLabel();
        lblTaskPerformed = new javax.swing.JLabel();
        spDurationHours = new javax.swing.JSpinner();
        pnlExpenses = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblExpenses = new javax.swing.JTable();
        pnlButtons = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spDurationMinutes = new javax.swing.JSpinner();
        cbCost = new javax.swing.JComboBox();
        lblBranchOffice = new javax.swing.JLabel();
        lblTaskType = new javax.swing.JLabel();
        cbTask = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaReport = new javax.swing.JTextArea();
        chckSolveProblem = new javax.swing.JCheckBox();
        lblReason = new javax.swing.JLabel();
        lblTask = new javax.swing.JLabel();
        cbSupport = new javax.swing.JComboBox();
        cbBranchOffice = new javax.swing.JComboBox();
        lblSupport = new javax.swing.JLabel();
        lblCost = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        cbClient = new javax.swing.JComboBox();
        cbReason = new javax.swing.JComboBox();
        cbTaskType = new javax.swing.JComboBox();
        btnCancel = new javax.swing.JButton();
        spHours = new javax.swing.JSpinner();
        lblHours = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        lblDuration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/time.png"))); // NOI18N
        lblDuration.setText("Duración:");

        lblReport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report.png"))); // NOI18N
        lblReport.setText("<html>Problema<br>reportado:<html>");

        spMinutes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        txaTaskPerformed.setColumns(20);
        txaTaskPerformed.setRows(5);
        jScrollPane1.setViewportView(txaTaskPerformed);

        lblMinutes.setText("Minutos:");

        lblClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/client.png"))); // NOI18N
        lblClient.setText("Cliente:");

        lblTaskPerformed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/complete.png"))); // NOI18N
        lblTaskPerformed.setText("<html>Trabajo<br>realizado:</html>");

        spDurationHours.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        pnlExpenses.setBorder(javax.swing.BorderFactory.createTitledBorder("Viáticos"));
        pnlExpenses.setLayout(new java.awt.BorderLayout());

        tblExpenses.setModel(new ExpenseTableModel());
        tblExpenses.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblExpenses.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblExpenses);

        pnlExpenses.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        btnEdit.setText("Modificar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/disable.png"))); // NOI18N
        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonsLayout = new javax.swing.GroupLayout(pnlButtons);
        pnlButtons.setLayout(pnlButtonsLayout);
        pnlButtonsLayout.setHorizontalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelete)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        pnlButtonsLayout.setVerticalGroup(
            pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addContainerGap())
        );

        pnlExpenses.add(pnlButtons, java.awt.BorderLayout.SOUTH);

        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("h");
        pnlExpenses.add(jLabel1, java.awt.BorderLayout.LINE_START);

        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("h");
        pnlExpenses.add(jLabel2, java.awt.BorderLayout.LINE_END);

        spDurationMinutes.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));

        lblBranchOffice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/offices.png"))); // NOI18N
        lblBranchOffice.setText("Sucursal:");

        lblTaskType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/type-task.png"))); // NOI18N
        lblTaskType.setText("Tipo labor:");

        txaReport.setColumns(20);
        txaReport.setRows(5);
        jScrollPane2.setViewportView(txaReport);

        chckSolveProblem.setText("Resuelve el problema");

        lblReason.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reason-small.png"))); // NOI18N
        lblReason.setText("Motivo:");

        lblTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/task-small.png"))); // NOI18N
        lblTask.setText("Labor:");

        lblSupport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/support-small.png"))); // NOI18N
        lblSupport.setText("Tipo soporte:");

        lblCost.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/costs-small.png"))); // NOI18N
        lblCost.setText("<html>Centro<br>de costo:</html>");

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        cbClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClientActionPerformed(evt);
            }
        });

        cbTaskType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTaskTypeActionPerformed(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancel.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        spHours.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));

        lblHours.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clock.png"))); // NOI18N
        lblHours.setText("Hora:");

        lblDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.png"))); // NOI18N
        lblDate.setText("Fecha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlExpenses, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSave)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel)))
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblBranchOffice)
                                .addGap(11, 11, 11)
                                .addComponent(cbBranchOffice, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTaskType)
                                    .addComponent(lblReason)
                                    .addComponent(lblHours)
                                    .addComponent(lblClient)
                                    .addComponent(lblDate))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbClient, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTaskPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbCost, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                                        .addComponent(chckSolveProblem))
                                    .addComponent(jScrollPane2)
                                    .addComponent(jScrollPane1))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbTaskType, 0, 150, Short.MAX_VALUE)
                                            .addComponent(cbReason, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblSupport)
                                            .addComponent(lblTask)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(spHours, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblMinutes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                        .addComponent(lblDuration)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbTask, 0, 150, Short.MAX_VALUE)
                                        .addComponent(cbSupport, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(spDurationHours, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spDurationMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClient)
                    .addComponent(cbClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBranchOffice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBranchOffice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTaskType)
                    .addComponent(cbTaskType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTask, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTask))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSupport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbReason, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReason)
                    .addComponent(lblSupport))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHours)
                    .addComponent(lblMinutes)
                    .addComponent(spMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spDurationHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spDurationMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDuration)
                    .addComponent(spHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chckSolveProblem)))
                    .addComponent(lblTaskPerformed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCost, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlExpenses, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String hour = spHours.getValue().toString() + ":"
                + spMinutes.getValue().toString();
        String duration = spDurationHours.getValue().toString() + ":"
                + spDurationMinutes.getValue().toString();

        int branchOfficeId = cbBranchOffice.getSelectedItem() != null
                ? ((BranchOffice) cbBranchOffice.getSelectedItem()).getId() : -1;
        int costId = cbCost.getSelectedItem() != null
                ? ((Cost) cbCost.getSelectedItem()).getId() : -1;
        int taskId = cbTask.getSelectedItem() != null
                ? ((Task) cbTask.getSelectedItem()).getId() : -1;
        int supportTypeId = cbSupport.getSelectedItem() != null
                ? ((SupportType) cbSupport.getSelectedItem()).getId() : -1;
        int reasonId = cbReason.getSelectedItem() != null
                ? ((Reason) cbReason.getSelectedItem()).getId() : -1;

        // Means we are adding an event
        if (event == null) {
            presenter.addExpense(datePicker.getDateStringOrEmptyString(), hour,
                    txaTaskPerformed.getText(), duration, txaReport.getText(),
                    chckSolveProblem.isSelected(), branchOfficeId, costId,
                    taskId, supportTypeId, reasonId,
                    ((ExpenseTableModel) tblExpenses.getModel()).getExpenses());
        } else {
            presenter.updateExpense(event.getId(),
                    datePicker.getDateStringOrEmptyString(), hour,
                    txaTaskPerformed.getText(), duration, txaReport.getText(),
                    chckSolveProblem.isSelected(), branchOfficeId, costId,
                    taskId, supportTypeId, reasonId,
                    ((ExpenseTableModel) tblExpenses.getModel()).getExpenses());
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void cbClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClientActionPerformed
        if (branchOffices != null) {
            Client client = (Client) cbClient.getSelectedItem();
            Vector<BranchOffice> options = new Vector<>();

            for (BranchOffice office : branchOffices) {
                if (office.getClientId() == client.getId()) {
                    options.add(office);
                }
            }

            cbBranchOffice.setModel(new DefaultComboBoxModel(options));
        }
    }//GEN-LAST:event_cbClientActionPerformed

    private void cbTaskTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTaskTypeActionPerformed
        if (tasks != null) {
            TaskType taskType = (TaskType) cbTaskType.getSelectedItem();
            Vector<Task> options = new Vector<>();

            for (Task task : tasks) {
                if (task.getIdTaskType() == taskType.getId()) {
                    options.add(task);
                }
            }

            cbTask.setModel(new DefaultComboBoxModel(options));
        }
    }//GEN-LAST:event_cbTaskTypeActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        JInternalFrame frame = new ExpenseDetailFrame(null, this);
        getDesktopPane().add(frame);
        frame.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Check if an item is selected
        if (tblExpenses.getSelectedRow() != -1) {
            Expense expense = ((ExpenseTableModel) tblExpenses.getModel())
                    .getValue(tblExpenses.getSelectedRow());
            JInternalFrame frame = new ExpenseDetailFrame(expense, this);
            getDesktopPane().add(frame);
            frame.setVisible(true);
        } else {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un viático",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Check if an item is selected
        if (tblExpenses.getSelectedRow() != -1) {
            ((ExpenseTableModel) tblExpenses.getModel())
                    .removeRow(tblExpenses.getSelectedRow());
        } else {
            JOptionPane.showInternalMessageDialog(this,
                    "Debe seleccionar un viático",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
    public void onLoadData(DataResult result) {
        if (result.getEvent() != null) {
            setEvent(result.getEvent());
        }

        loadClientsCombo(result.getClients());
        loadBranchOfficesCombo(result.getBranchOffices());
        loadReasonsCombo(result.getReasons());
        loadSupportTypesCombo(result.getSupportTypes());
        loadCostsCombo(result.getCosts());
        loadTypeTaskCombo(result.getTaskTypes());
        loadTasksCombo(result.getTasks());
    }

    @Override
    public void onError(String message) {
        JOptionPane.showInternalMessageDialog(this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private void setEvent(Event event) {
        this.event = event;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        datePicker.setDate(LocalDate.parse(dateFormat.format(event.getDate())));
        tblExpenses.setModel(new ExpenseTableModel(event.getExpenses()));

        String[] hours = event.getHour().split(":");
        spHours.setValue(Integer.parseInt(hours[0]));
        spMinutes.setValue(Integer.parseInt(hours[1]));

        String[] duration = event.getDuration().split(":");
        spDurationHours.setValue(Integer.parseInt(duration[0]));
        spDurationMinutes.setValue(Integer.parseInt(duration[1]));

        txaReport.setText(event.getReport());
        txaTaskPerformed.setText(event.getWork());

        chckSolveProblem.setSelected(event.isReportSolved());
    }

    public void loadClientsCombo(List<Client> clients) {
        cbClient.setModel(new DefaultComboBoxModel(clients.toArray()));
        if (event != null) {
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getId() == event.getClientId()) {
                    cbClient.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            cbClient.setSelectedItem(null);
        }
    }

    public void loadBranchOfficesCombo(List<BranchOffice> branchOffices) {
        this.branchOffices = branchOffices;

        if (event != null) {
            Client client = (Client) cbClient.getSelectedItem();
            Vector<BranchOffice> options = new Vector<>();

            int index = 0;
            int indexToSelect = -1;

            for (BranchOffice branchOffice : branchOffices) {
                if (branchOffice.getClientId() == client.getId()) {
                    options.add(branchOffice);
                    if (event != null
                            && branchOffice.getClientId() == event.getClientId()) {
                        indexToSelect = index;
                    }
                    index++;
                }
            }

            cbBranchOffice.setModel(new DefaultComboBoxModel(options));
            if (indexToSelect != -1) {
                cbBranchOffice.setSelectedIndex(indexToSelect);
            }
        }
    }

    public void loadReasonsCombo(List<Reason> reasons) {
        cbReason.setModel(new DefaultComboBoxModel(reasons.toArray()));
        if (event != null) {
            for (int i = 0; i < reasons.size(); i++) {
                if (reasons.get(i).getId() == event.getReasonId()) {
                    cbReason.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            cbReason.setSelectedItem(null);
        }
    }

    public void loadSupportTypesCombo(List<SupportType> supportTypes) {
        cbSupport.setModel(new DefaultComboBoxModel(supportTypes.toArray()));
        if (event != null) {
            for (int i = 0; i < supportTypes.size(); i++) {
                if (supportTypes.get(i).getId() == event.getSupportTypeId()) {
                    cbSupport.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            cbSupport.setSelectedItem(null);
        }
    }

    public void loadCostsCombo(List<Cost> costs) {
        cbCost.setModel(new DefaultComboBoxModel(costs.toArray()));
        if (event != null) {
            for (int i = 0; i < costs.size(); i++) {
                if (costs.get(i).getId() == event.getCostId()) {
                    cbCost.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            cbCost.setSelectedItem(null);
        }
    }

    public void loadTypeTaskCombo(List<TaskType> tasks) {
        cbTaskType.setModel(new DefaultComboBoxModel(tasks.toArray()));
        if (event != null) {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getId() == event.getTaskId()) {
                    cbTaskType.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            cbTaskType.setSelectedItem(null);
        }
    }

    public void loadTasksCombo(List<Task> tasks) {
        this.tasks = tasks;
        if (event != null) {
            TaskType taskType = (TaskType) cbTaskType.getSelectedItem();
            Vector<Task> options = new Vector<>();

            int index = 0;
            int indexToSelect = -1;

            for (Task task : tasks) {
                if (task.getIdTaskType() == taskType.getId()) {
                    options.add(task);
                    if (event != null
                            && task.getIdTaskType() == event.getClientId()) {
                        indexToSelect = index;
                    }
                    index++;
                }
            }

            cbTask.setModel(new DefaultComboBoxModel(options));
            if (indexToSelect != -1) {
                cbTask.setSelectedIndex(indexToSelect);
            }
        }
    }

    @Override
    public void addExpense(Expense expense) {
        ((ExpenseTableModel) tblExpenses.getModel()).addRow(expense);
    }

    @Override
    public void updateExpense(Expense expense) {
        System.out.println("sdfsdfdsf");
        ((ExpenseTableModel) tblExpenses.getModel()).updateRow(expense);
    }

    @Override
    public void deleteExpense(Expense expense) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbBranchOffice;
    private javax.swing.JComboBox cbClient;
    private javax.swing.JComboBox cbCost;
    private javax.swing.JComboBox cbReason;
    private javax.swing.JComboBox cbSupport;
    private javax.swing.JComboBox cbTask;
    private javax.swing.JComboBox cbTaskType;
    private javax.swing.JCheckBox chckSolveProblem;
    private com.github.lgooddatepicker.components.DatePicker datePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBranchOffice;
    private javax.swing.JLabel lblClient;
    private javax.swing.JLabel lblCost;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDuration;
    private javax.swing.JLabel lblHours;
    private javax.swing.JLabel lblMinutes;
    private javax.swing.JLabel lblReason;
    private javax.swing.JLabel lblReport;
    private javax.swing.JLabel lblSupport;
    private javax.swing.JLabel lblTask;
    private javax.swing.JLabel lblTaskPerformed;
    private javax.swing.JLabel lblTaskType;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlExpenses;
    private javax.swing.JSpinner spDurationHours;
    private javax.swing.JSpinner spDurationMinutes;
    private javax.swing.JSpinner spHours;
    private javax.swing.JSpinner spMinutes;
    private javax.swing.JTable tblExpenses;
    private javax.swing.JTextArea txaReport;
    private javax.swing.JTextArea txaTaskPerformed;
    // End of variables declaration//GEN-END:variables

}
