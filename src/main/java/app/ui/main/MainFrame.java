package app.ui.main;

import app.ui.branchOffice.list.BranchOfficeListFrame;
import app.ui.client.list.ClientListFrame;
import app.ui.resource.list.ResourceListFrame;
import app.ui.reason.list.ReasonListFrame;
import app.ui.expenseType.list.ExpenseTypeListFrame;
import app.ui.taskType.list.TaskTypeListFrame;
import app.ui.task.list.TaskListFrame;
import app.ui.cost.list.CostListFrame;
import app.ui.vehicle.list.VehicleListFrame;
import app.ui.supportType.list.SupportTypeListFrame;
import javax.swing.JInternalFrame;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolbar = new javax.swing.JToolBar();
        btnEvent = new javax.swing.JButton();
        btnCustomer = new javax.swing.JButton();
        btnBranchOffice = new javax.swing.JButton();
        btnTask = new javax.swing.JButton();
        btnTaskType = new javax.swing.JButton();
        btnReasons = new javax.swing.JButton();
        btnSupportType = new javax.swing.JButton();
        btnCosts = new javax.swing.JButton();
        btnResources = new javax.swing.JButton();
        btnExpensesType = new javax.swing.JButton();
        btnVehicles = new javax.swing.JButton();
        desktopPane = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de Viaticos");
        setPreferredSize(new java.awt.Dimension(600, 400));

        toolbar.setRollover(true);

        btnEvent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/event.png"))); // NOI18N
        btnEvent.setText("Eventos");
        btnEvent.setToolTipText("Eventos");
        btnEvent.setFocusable(false);
        btnEvent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEvent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventActionPerformed(evt);
            }
        });
        toolbar.add(btnEvent);

        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/customer.png"))); // NOI18N
        btnCustomer.setText("Cliente");
        btnCustomer.setToolTipText("Cliente");
        btnCustomer.setFocusable(false);
        btnCustomer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCustomer.setMaximumSize(new java.awt.Dimension(45, 49));
        btnCustomer.setMinimumSize(new java.awt.Dimension(45, 49));
        btnCustomer.setPreferredSize(new java.awt.Dimension(45, 49));
        btnCustomer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });
        toolbar.add(btnCustomer);

        btnBranchOffice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/branch-office.png"))); // NOI18N
        btnBranchOffice.setText("Sucursal");
        btnBranchOffice.setToolTipText("Sucursal");
        btnBranchOffice.setFocusable(false);
        btnBranchOffice.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBranchOffice.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBranchOffice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBranchOfficeActionPerformed(evt);
            }
        });
        toolbar.add(btnBranchOffice);

        btnTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/tasks.png"))); // NOI18N
        btnTask.setText("Labor");
        btnTask.setToolTipText("Labor");
        btnTask.setFocusable(false);
        btnTask.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTask.setMaximumSize(new java.awt.Dimension(45, 49));
        btnTask.setMinimumSize(new java.awt.Dimension(45, 49));
        btnTask.setPreferredSize(new java.awt.Dimension(45, 49));
        btnTask.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaskActionPerformed(evt);
            }
        });
        toolbar.add(btnTask);

        btnTaskType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/task-type.png"))); // NOI18N
        btnTaskType.setText("Tipo labor");
        btnTaskType.setToolTipText("Tipo de labor");
        btnTaskType.setFocusable(false);
        btnTaskType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTaskType.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTaskType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaskTypeActionPerformed(evt);
            }
        });
        toolbar.add(btnTaskType);

        btnReasons.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/reason.png"))); // NOI18N
        btnReasons.setText("Motivo");
        btnReasons.setToolTipText("Motivos");
        btnReasons.setFocusable(false);
        btnReasons.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReasons.setMaximumSize(new java.awt.Dimension(45, 49));
        btnReasons.setMinimumSize(new java.awt.Dimension(45, 49));
        btnReasons.setPreferredSize(new java.awt.Dimension(45, 49));
        btnReasons.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReasons.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReasonsActionPerformed(evt);
            }
        });
        toolbar.add(btnReasons);

        btnSupportType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/support.png"))); // NOI18N
        btnSupportType.setText("Tipo soporte");
        btnSupportType.setToolTipText("Tipo de soporte");
        btnSupportType.setFocusable(false);
        btnSupportType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSupportType.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSupportType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupportTypeActionPerformed(evt);
            }
        });
        toolbar.add(btnSupportType);

        btnCosts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/costs.png"))); // NOI18N
        btnCosts.setText("Centro costo");
        btnCosts.setToolTipText("Centro de costo");
        btnCosts.setFocusable(false);
        btnCosts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCosts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCostsActionPerformed(evt);
            }
        });
        toolbar.add(btnCosts);

        btnResources.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/person.png"))); // NOI18N
        btnResources.setText("Recurso");
        btnResources.setToolTipText("Recurso");
        btnResources.setFocusable(false);
        btnResources.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnResources.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnResources.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResourcesActionPerformed(evt);
            }
        });
        toolbar.add(btnResources);

        btnExpensesType.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/expense.png"))); // NOI18N
        btnExpensesType.setText("Tipo viatico");
        btnExpensesType.setToolTipText("Tipo de viatico");
        btnExpensesType.setFocusable(false);
        btnExpensesType.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnExpensesType.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnExpensesType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpensesTypeActionPerformed(evt);
            }
        });
        toolbar.add(btnExpensesType);

        btnVehicles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/car.png"))); // NOI18N
        btnVehicles.setText("Vehiculo");
        btnVehicles.setToolTipText("Vehículo");
        btnVehicles.setFocusable(false);
        btnVehicles.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVehicles.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVehicles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiclesActionPerformed(evt);
            }
        });
        toolbar.add(btnVehicles);

        getContentPane().add(toolbar, java.awt.BorderLayout.NORTH);

        desktopPane.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 249, Short.MAX_VALUE)
        );

        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventActionPerformed

    }//GEN-LAST:event_btnEventActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        openFrame(new ClientListFrame());
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnBranchOfficeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBranchOfficeActionPerformed
        openFrame(new BranchOfficeListFrame());
    }//GEN-LAST:event_btnBranchOfficeActionPerformed

    private void btnTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaskActionPerformed
        openFrame(new TaskListFrame());
    }//GEN-LAST:event_btnTaskActionPerformed

    private void btnTaskTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaskTypeActionPerformed
        openFrame(new TaskTypeListFrame());
    }//GEN-LAST:event_btnTaskTypeActionPerformed

    private void btnReasonsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReasonsActionPerformed
        openFrame(new ReasonListFrame());
    }//GEN-LAST:event_btnReasonsActionPerformed

    private void btnSupportTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupportTypeActionPerformed
        openFrame(new SupportTypeListFrame());
    }//GEN-LAST:event_btnSupportTypeActionPerformed

    private void btnCostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCostsActionPerformed
        openFrame(new CostListFrame());
    }//GEN-LAST:event_btnCostsActionPerformed

    private void btnResourcesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResourcesActionPerformed
        openFrame(new ResourceListFrame());
    }//GEN-LAST:event_btnResourcesActionPerformed

    private void btnExpensesTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpensesTypeActionPerformed
        openFrame(new ExpenseTypeListFrame());
    }//GEN-LAST:event_btnExpensesTypeActionPerformed

    private void btnVehiclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehiclesActionPerformed
        openFrame(new VehicleListFrame());
    }//GEN-LAST:event_btnVehiclesActionPerformed

    private void openFrame(JInternalFrame frame) {
        desktopPane.add(frame);
        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBranchOffice;
    private javax.swing.JButton btnCosts;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnEvent;
    private javax.swing.JButton btnExpensesType;
    private javax.swing.JButton btnReasons;
    private javax.swing.JButton btnResources;
    private javax.swing.JButton btnSupportType;
    private javax.swing.JButton btnTask;
    private javax.swing.JButton btnTaskType;
    private javax.swing.JButton btnVehicles;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JToolBar toolbar;
    // End of variables declaration//GEN-END:variables
}
