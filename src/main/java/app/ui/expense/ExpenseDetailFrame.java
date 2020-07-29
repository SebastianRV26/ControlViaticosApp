package app.ui.expense;

import app.data.model.Expense;
import app.data.model.ExpenseType;
import app.data.model.Resource;
import app.data.model.Supplier;
import app.data.model.Vehicle;
import app.ui.listRenderers.ExpenseTypeListCellRenderer;
import app.ui.listRenderers.ResourceListCellRenderer;
import app.ui.listRenderers.SupplierListCellRenderer;
import app.ui.listRenderers.VehicleListCellRenderer;
import app.util.ExpenseTableListener;
import app.util.Utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class ExpenseDetailFrame extends javax.swing.JInternalFrame
        implements ExpenseDetailContract.View {

    private ExpenseDetailPresenter presenter = new ExpenseDetailPresenter();
    private Expense expense;
    private ExpenseTableListener listener;
    private boolean firstTimeSetup = true;

    /**
     * Creates new form ExpenseDetailFrame
     *
     * @param expense the expense modify, null if we are adding a new expense
     */
    public ExpenseDetailFrame(Expense expense, ExpenseTableListener listener) {
        this.expense = expense;
        this.listener = listener;
        presenter.attachView(this);

        initComponents();
        setupCombos();

        // Means we are adding a client
        if (expense == null) {
            setTitle("Agregar viático");
            datePicker.setDateToToday();
        } else {
            setTitle("Modificar viático");
        }

        showExpenseData();
        presenter.loadData();
    }

    private void setupCombos() {
        cbExpenseType.setRenderer(new ExpenseTypeListCellRenderer());
        cbSupplier.setRenderer(new SupplierListCellRenderer());
        cbVehicle.setRenderer(new VehicleListCellRenderer());
        cbResource.setRenderer(new ResourceListCellRenderer());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblExpenseType = new javax.swing.JLabel();
        cbExpenseType = new javax.swing.JComboBox();
        lblSupplier = new javax.swing.JLabel();
        cbSupplier = new javax.swing.JComboBox();
        lblBill = new javax.swing.JLabel();
        txtBill = new javax.swing.JTextField();
        lblDate = new javax.swing.JLabel();
        datePicker = new com.github.lgooddatepicker.components.DatePicker();
        lblPrice = new javax.swing.JLabel();
        spPrice = new javax.swing.JSpinner();
        lblKmPrice = new javax.swing.JLabel();
        spKmPrice = new javax.swing.JSpinner();
        lblKm = new javax.swing.JLabel();
        spKm = new javax.swing.JSpinner();
        lblVehicle = new javax.swing.JLabel();
        cbVehicle = new javax.swing.JComboBox();
        lblPayments = new javax.swing.JLabel();
        spPayments = new javax.swing.JSpinner();
        lblTicket = new javax.swing.JLabel();
        lblRemarks = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaRemarks = new javax.swing.JTextArea();
        lblResource = new javax.swing.JLabel();
        cbResource = new javax.swing.JComboBox();
        cbResourceDesc = new javax.swing.JComboBox();
        txtTicket = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);

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

        lblExpenseType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/expense-small.png"))); // NOI18N
        lblExpenseType.setText("Tipo de viatico:");

        cbExpenseType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbExpenseTypeActionPerformed(evt);
            }
        });

        lblSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/supplier-small.png"))); // NOI18N
        lblSupplier.setText("Proveedor:");

        lblBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/task-small.png"))); // NOI18N
        lblBill.setText("Factura:");

        lblDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar.png"))); // NOI18N
        lblDate.setText("Fecha:");

        lblPrice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/costs-small.png"))); // NOI18N
        lblPrice.setText("Monto:");

        spPrice.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));

        lblKmPrice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/price.png"))); // NOI18N
        lblKmPrice.setText("Monto km:");

        spKmPrice.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));
        spKmPrice.setEnabled(false);

        lblKm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/kilometer.png"))); // NOI18N
        lblKm.setText("Km:");

        spKm.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 1.0f));
        spKm.setEnabled(false);
        spKm.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spKmStateChanged(evt);
            }
        });

        lblVehicle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/car-small.png"))); // NOI18N
        lblVehicle.setText("Vehiculo:");

        cbVehicle.setEnabled(false);
        cbVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbVehicleActionPerformed(evt);
            }
        });

        lblPayments.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/overflow.png"))); // NOI18N
        lblPayments.setText("Num pax:");

        spPayments.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        lblTicket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/report.png"))); // NOI18N
        lblTicket.setText("Boleta:");

        lblRemarks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/description.png"))); // NOI18N
        lblRemarks.setText("Notas:");

        txaRemarks.setColumns(20);
        txaRemarks.setRows(5);
        jScrollPane1.setViewportView(txaRemarks);

        lblResource.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/support-small.png"))); // NOI18N
        lblResource.setText("Recurso:");

        cbResource.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbResourceActionPerformed(evt);
            }
        });

        try {
            txtTicket.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UU-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblExpenseType)
                            .addComponent(lblBill)
                            .addComponent(lblSupplier)
                            .addComponent(lblRemarks)
                            .addComponent(lblPayments)
                            .addComponent(lblPrice)
                            .addComponent(lblKmPrice)
                            .addComponent(lblResource))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cbResource, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbResourceDesc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1)
                            .addComponent(cbExpenseType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(spPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                            .addComponent(txtBill, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                            .addComponent(spKmPrice, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblDate)
                                            .addComponent(lblKm)
                                            .addComponent(lblVehicle)
                                            .addComponent(lblTicket)))
                                    .addComponent(spPayments, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spKm, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbVehicle, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(datePicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                    .addComponent(txtTicket)))
                            .addComponent(cbSupplier, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblExpenseType)
                    .addComponent(cbExpenseType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSupplier))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBill)
                    .addComponent(lblDate)
                    .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrice)
                    .addComponent(spPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVehicle)
                    .addComponent(cbVehicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKmPrice)
                    .addComponent(spKmPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKm)
                    .addComponent(spKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPayments)
                    .addComponent(spPayments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTicket)
                    .addComponent(txtTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRemarks)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResource)
                    .addComponent(cbResource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbResourceDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        int expenseTypeId = cbExpenseType.getSelectedItem() != null
                ? ((ExpenseType) cbExpenseType.getSelectedItem()).getId() : -1;
        int supplierId = cbSupplier.getSelectedItem() != null
                ? ((Supplier) cbSupplier.getSelectedItem()).getId() : -1;
        int vehicleId = cbVehicle.getSelectedItem() != null
                ? ((Vehicle) cbVehicle.getSelectedItem()).getId() : -1;
        int resourceId = cbResource.getSelectedItem() != null
                ? ((Resource) cbResource.getSelectedItem()).getId() : -1;

        String bill = txtBill.isEnabled() ? txtBill.getText() : null;
        String date = datePicker.getDateStringOrEmptyString();
        String ticket = txtTicket.getText();
        String remarks = txaRemarks.getText();

        if (expenseTypeId == -1) {
            onError("Debe seleccionar un tipo de viático.");
        } else if (cbSupplier.isEnabled() && supplierId == -1) {
            onError("Debe seleccionar un proveedor.");
        } else if (txtBill.isEnabled() && Utils.textIsNullOrEmpty(bill)) {
            onError("La factura no puede estar vacia.");
        } else if (Utils.textIsNullOrEmpty(date)) {
            onError("La fecha no puede estar vacia.");
        } else if (cbVehicle.isEnabled() && vehicleId == -1) {
            onError("Debe seleccionar un vehículo.");
        } else if (Utils.textIsNullOrEmpty(ticket)) {
            onError("La boleta no puede estar vacia.");
        } else if (Utils.textIsNullOrEmpty(remarks)) {
            onError("Las notas no pueden estar vacias.");
        } else if (resourceId == -1) {
            onError("Debe seleccionar un recurso.");
        } else {
            float price = (float) spPrice.getValue();
            Float km = spKm.isEnabled() ? (float) spKm.getValue() : null;
            int numPaymets = (int) spPayments.getValue();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            // Means we are adding
            if (expense == null) {
                try {
                    Expense expense = new Expense(formatter.parse(date), bill,
                            price, numPaymets, remarks, ticket, expenseTypeId,
                            (supplierId != -1 ? supplierId : null),
                            resourceId, (vehicleId != -1 ? vehicleId : null),
                            km);
                    listener.addExpense(expense);
                    this.dispose();
                } catch (ParseException ex) {
                    Logger.getLogger(ExpenseDetailFrame.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            } else {
                try {
                    expense.setDate(formatter.parse(date));
                } catch (ParseException ex) {
                    Logger.getLogger(ExpenseDetailFrame.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
                expense.setBill(bill);
                expense.setPrice(0);
                expense.setPaymentsNumber(numPaymets);
                expense.setRemarks(remarks);
                expense.setTicket(ticket);
                expense.setExpenseTypeId(expenseTypeId);
                expense.setSupplierId((supplierId != -1 ? supplierId : null));
                expense.setResourceId(resourceId);
                expense.setTraveledKm(km);
                expense.setVehicleId(vehicleId != -1 ? vehicleId : null);

                listener.updateExpense(expense);
                dispose();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void cbExpenseTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbExpenseTypeActionPerformed
        if (cbExpenseType.getSelectedItem() != null) {
            ExpenseType expenseType
                    = (ExpenseType) cbExpenseType.getSelectedItem();

            // Gasolina
            if (expenseType.getId() == 2) {
                cbSupplier.setEnabled(true);
                txtBill.setEnabled(true);
                spPrice.setEnabled(true);
                cbVehicle.setEnabled(true);

                spKm.setEnabled(false);

                if (!firstTimeSetup) {
                    spPrice.setValue(0f);
                    spKm.setValue(0f);
                }
            } else if (expenseType.getId() == 3) {
                // Kilometraje
                cbSupplier.setEnabled(false);
                cbSupplier.setSelectedItem(null);
                txtBill.setEnabled(false);
                spPrice.setEnabled(false);

                cbVehicle.setEnabled(true);
                spKm.setEnabled(true);

                if (!firstTimeSetup) {
                    txtBill.setText("");
                    spPrice.setValue(0f);
                }
            } else {
                cbSupplier.setEnabled(true);
                txtBill.setEnabled(true);
                spPrice.setEnabled(true);

                cbVehicle.setEnabled(false);
                cbVehicle.setSelectedItem(null);
                spKm.setEnabled(false);

                if (!firstTimeSetup) {
                    spPrice.setValue(0f);
                    spKm.setValue(0f);
                    spKmPrice.setValue(0f);
                }
            }
            firstTimeSetup = false;
        }
    }//GEN-LAST:event_cbExpenseTypeActionPerformed

    private void cbResourceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbResourceActionPerformed
        Resource resource = (Resource) cbResource.getSelectedItem();
        if (resource != null) {
            cbResourceDesc.setModel(new DefaultComboBoxModel(
                    new String[]{resource.getDescripcion()}));
        }
    }//GEN-LAST:event_cbResourceActionPerformed

    private void cbVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbVehicleActionPerformed
        if (cbExpenseType.getSelectedItem() != null) {
            ExpenseType expenseType
                    = (ExpenseType) cbExpenseType.getSelectedItem();
            // Kilometraje
            if (expenseType.getId() == 3) {
                Vehicle vehicle = (Vehicle) cbVehicle.getSelectedItem();
                spKmPrice.setValue(vehicle.getMontoKm());
                spPrice.setValue(((float) spKm.getValue())
                        * ((float) spKmPrice.getValue()));
            }
        }
    }//GEN-LAST:event_cbVehicleActionPerformed

    private void spKmStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spKmStateChanged
        spPrice.setValue(
                ((float) spKm.getValue()) * ((float) spKmPrice.getValue()));
    }//GEN-LAST:event_spKmStateChanged

    @Override
    public void onLoadData(DataResult result) {
        loadExpenseTypeCombo(result.getExpenseTypes());
        loadResourceCombo(result.getResources());
        loadSupplierCombo(result.getSuppliers());
        loadVehicleCombo(result.getVehicles());
    }

    @Override
    public void onError(String message) {
        JOptionPane.showInternalMessageDialog(this,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    private void showExpenseData() {
        if (expense != null) {
            txtBill.setText(expense.getBill());

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            datePicker.setDate(
                    LocalDate.parse(dateFormat.format(expense.getDate())));
            spPrice.setValue(expense.getPrice());

            // Kilometraje
            if (expense.getExpenseTypeId() == 3) {
                spKm.setValue(expense.getTraveledKm());
            }
            spPayments.setValue(expense.getPaymentsNumber());
            txtTicket.setText(expense.getTicket());
            txaRemarks.setText(expense.getRemarks());
        }
    }

    public void loadExpenseTypeCombo(List<ExpenseType> expenseTypes) {
        cbExpenseType.setModel(new DefaultComboBoxModel(expenseTypes.toArray()));
        if (expense != null) {
            for (int i = 0; i < expenseTypes.size(); i++) {
                if (expenseTypes.get(i).getId() == expense.getExpenseTypeId()) {
                    cbExpenseType.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            cbExpenseType.setSelectedItem(null);
        }
    }

    public void loadSupplierCombo(List<Supplier> suppliers) {
        cbSupplier.setModel(new DefaultComboBoxModel(suppliers.toArray()));
        if (expense != null) {
            for (int i = 0; i < suppliers.size(); i++) {
                if (suppliers.get(i).getId() == expense.getSupplierId()) {
                    cbSupplier.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            cbSupplier.setSelectedItem(null);
        }
    }

    public void loadVehicleCombo(List<Vehicle> vehicles) {
        if (expense != null) {
            Integer vehicleId = expense.getVehicleId();

            if (vehicleId != null) {
                cbVehicle.setModel(new DefaultComboBoxModel(vehicles.toArray()));
                for (int i = 0; i < vehicles.size(); i++) {
                    if (vehicles.get(i).getId() == vehicleId) {
                        cbVehicle.setSelectedIndex(i);
                        break;
                    }
                }
            }
        } else {
            cbVehicle.setModel(new DefaultComboBoxModel(vehicles.toArray()));
            cbVehicle.setSelectedItem(null);
        }
    }

    public void loadResourceCombo(List<Resource> resources) {
        cbResource.setModel(new DefaultComboBoxModel(resources.toArray()));
        if (expense != null) {
            for (int i = 0; i < resources.size(); i++) {
                if (resources.get(i).getId() == expense.getResourceId()) {
                    cbResource.setSelectedIndex(i);
                    cbResourceDesc.setModel(new DefaultComboBoxModel(
                            new String[]{resources.get(i).getDescripcion()}));
                    break;
                }
            }
        } else {
            cbResource.setSelectedItem(null);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox cbExpenseType;
    private javax.swing.JComboBox cbResource;
    private javax.swing.JComboBox cbResourceDesc;
    private javax.swing.JComboBox cbSupplier;
    private javax.swing.JComboBox cbVehicle;
    private com.github.lgooddatepicker.components.DatePicker datePicker;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBill;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblExpenseType;
    private javax.swing.JLabel lblKm;
    private javax.swing.JLabel lblKmPrice;
    private javax.swing.JLabel lblPayments;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblRemarks;
    private javax.swing.JLabel lblResource;
    private javax.swing.JLabel lblSupplier;
    private javax.swing.JLabel lblTicket;
    private javax.swing.JLabel lblVehicle;
    private javax.swing.JSpinner spKm;
    private javax.swing.JSpinner spKmPrice;
    private javax.swing.JSpinner spPayments;
    private javax.swing.JSpinner spPrice;
    private javax.swing.JTextArea txaRemarks;
    private javax.swing.JTextField txtBill;
    private javax.swing.JFormattedTextField txtTicket;
    // End of variables declaration//GEN-END:variables

}
