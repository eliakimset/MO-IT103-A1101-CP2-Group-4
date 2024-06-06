package motorphemployee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LeaveOverviewForm extends javax.swing.JFrame {

    public LeaveOverviewForm() {
        initComponents();
        loadLeaveApplications();
    }

    private void initComponents() {
        jScrollPane1 = new javax.swing.JScrollPane();
        leaveTable = new javax.swing.JTable();
        editButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        leaveTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Employee Number", "Leave Type", "Start Date", "End Date", "Reason", "Status"
            }
        ));
        jScrollPane1.setViewportView(leaveTable);

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(editButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(editButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void loadLeaveApplications() {
        DefaultTableModel model = (DefaultTableModel) leaveTable.getModel();
        String csvFile = "/home/johnpaul/Documents/MO-IT103-A1101-CP2-Group-4-master/leave_applications.csv"; // Ensure this path is correct and matches the save path
        String line;
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                if (data.length == 6) { // Ensure that data has exactly 6 fields
                    model.addRow(data);
                } else {
                    JOptionPane.showMessageDialog(this, "Skipping invalid record: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading leave applications: " + e.getMessage());
        }
    }

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = leaveTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to edit.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) leaveTable.getModel();
        String employeeNumber = model.getValueAt(selectedRow, 0).toString();
        String leaveType = model.getValueAt(selectedRow, 1).toString();
        String startDate = model.getValueAt(selectedRow, 2).toString();
        String endDate = model.getValueAt(selectedRow, 3).toString();
        String reason = model.getValueAt(selectedRow, 4).toString();
        String status = model.getValueAt(selectedRow, 5).toString();

        String newEmployeeNumber = JOptionPane.showInputDialog(this, "Edit Employee Number", employeeNumber);
        String newLeaveType = JOptionPane.showInputDialog(this, "Edit Leave Type", leaveType);
        String newStartDate = JOptionPane.showInputDialog(this, "Edit Start Date", startDate);
        String newEndDate = JOptionPane.showInputDialog(this, "Edit End Date", endDate);
        String newReason = JOptionPane.showInputDialog(this, "Edit Reason", reason);
        String newStatus = JOptionPane.showInputDialog(this, "Edit Status", status);

        if (newEmployeeNumber != null && newLeaveType != null && newStartDate != null && newEndDate != null && newReason != null && newStatus != null) {
            model.setValueAt(newEmployeeNumber, selectedRow, 0);
            model.setValueAt(newLeaveType, selectedRow, 1);
            model.setValueAt(newStartDate, selectedRow, 2);
            model.setValueAt(newEndDate, selectedRow, 3);
            model.setValueAt(newReason, selectedRow, 4);
            model.setValueAt(newStatus, selectedRow, 5);
            saveLeaveApplications(model);
        }
    }

    private void saveLeaveApplications(DefaultTableModel model) {
        String csvFile = "leave_applications.csv"; // Ensure this path is correct and matches the save path
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    bw.write(model.getValueAt(row, col).toString());
                    if (col < model.getColumnCount() - 1) {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }
            JOptionPane.showMessageDialog(this, "Leave applications updated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving leave applications: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaveOverviewForm().setVisible(true);
            }
        });
    }

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable leaveTable;
    private javax.swing.JButton editButton;
}
