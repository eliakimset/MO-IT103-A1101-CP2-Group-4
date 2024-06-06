package motorphemployee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("unused")
public class LeaveApplicationForm extends javax.swing.JFrame {

    public LeaveApplicationForm() {
        initComponents();
    }

    private void initComponents() {
        employeeNumberLabel = new javax.swing.JLabel();
        employeeNumberTextField = new javax.swing.JTextField();
        leaveTypeLabel = new javax.swing.JLabel();
        leaveTypeComboBox = new javax.swing.JComboBox<>();
        startDateLabel = new javax.swing.JLabel();
        startDateChooser = new com.toedter.calendar.JDateChooser();
        endDateLabel = new javax.swing.JLabel();
        endDateChooser = new com.toedter.calendar.JDateChooser();
        reasonLabel = new javax.swing.JLabel();
        reasonTextArea = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        employeeNumberLabel.setText("Employee Number");

        leaveTypeLabel.setText("Leave Type");

        leaveTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sick Leave", "Vacation Leave" }));

        startDateLabel.setText("Start Date");

        endDateLabel.setText("End Date");

        reasonLabel.setText("Reason");

        reasonTextArea.setColumns(20);
        reasonTextArea.setRows(5);

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeNumberLabel)
                    .addComponent(employeeNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaveTypeLabel)
                    .addComponent(leaveTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDateLabel)
                    .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateLabel)
                    .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reasonLabel)
                    .addComponent(reasonTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(employeeNumberLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(leaveTypeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(leaveTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(endDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reasonLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reasonTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submitButton)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String employeeNumber = employeeNumberTextField.getText();
        String leaveType = leaveTypeComboBox.getSelectedItem().toString();
        Date startDate = startDateChooser.getDate();
        Date endDate = endDateChooser.getDate();
        String reason = reasonTextArea.getText();

        if (employeeNumber.isEmpty() || startDate == null || endDate == null || reason.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.");
        } else {
            saveLeaveApplication(employeeNumber, leaveType, startDate, endDate, reason);
        }
    }

    private void saveLeaveApplication(String employeeNumber, String leaveType, Date startDate, Date endDate, String reason) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String filePath = "leave_applications.csv"; // Adjust the path accordingly
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(employeeNumber + "," + leaveType + "," + dateFormat.format(startDate) + "," + dateFormat.format(endDate) + "," + reason + ",Pending\n");
            JOptionPane.showMessageDialog(this, "Leave application submitted successfully!");
            this.dispose();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error submitting leave application: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeaveApplicationForm().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel employeeNumberLabel;
    private javax.swing.JTextField employeeNumberTextField;
    private javax.swing.JLabel leaveTypeLabel;
    private javax.swing.JComboBox<String> leaveTypeComboBox;
    private javax.swing.JLabel startDateLabel;
    private com.toedter.calendar.JDateChooser startDateChooser;
    private javax.swing.JLabel endDateLabel;
    private com.toedter.calendar.JDateChooser endDateChooser;
    private javax.swing.JLabel reasonLabel;
    private javax.swing.JTextArea reasonTextArea;
    private javax.swing.JButton submitButton;
}
