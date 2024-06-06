package motorphemployee;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("unused")
public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
        loadCSVData();
        jTable1.setAutoCreateRowSorter(true);
    }

    private String csvFile = "src/motorphemployee/data.csv"; // Change depends on the file location of csv file (optional)

    private void loadCSVData() {
        String line = "";
        String cvsSplitBy = ",";
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            if ((line = br.readLine()) != null) {
                String[] columns = line.split(cvsSplitBy);
                model.setColumnIdentifiers(columns);
            }

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                model.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error loading data from CSV file: " + e.getMessage());
        }
    }

    private void saveCSVData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            for (int i = 0; i < model.getColumnCount(); i++) {
                bw.write(model.getColumnName(i));
                if (i < model.getColumnCount() - 1) {
                    bw.write(",");
                }
            }
            bw.newLine();

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    bw.write(model.getValueAt(i, j).toString());
                    if (j < model.getColumnCount() - 1) {
                        bw.write(",");
                    }
                }
                bw.newLine();
            }

            JOptionPane.showMessageDialog(this, "Saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving data to CSV file: " + e.getMessage());
        }
    }

    private void initComponents() {
        button_add = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_exit = new javax.swing.JButton();
        button_logout = new javax.swing.JButton();
        button_about = new javax.swing.JButton(); // New About button
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtlastname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfirstname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtbirthday = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtphonenumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtsss = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtphilhealth = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtpagibig = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtstatus = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtposition = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtsupervisor = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtrice = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtclothing = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtbasicsalary = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtgrosssemi = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txthourlyrate = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txttin = new javax.swing.JTextField();
        button_calculatesalary = new javax.swing.JButton();
        button_cleartext = new javax.swing.JButton();
        leave_overview = new javax.swing.JButton();
        button_information = new javax.swing.JButton();
        button_save = new javax.swing.JButton();
        leave_application = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button_add.setText("Add Employee");
        button_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addActionPerformed(evt);
            }
        });

        button_delete.setBackground(new java.awt.Color(204, 0, 0));
        button_delete.setText("Delete User");
        button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteActionPerformed(evt);
            }
        });

        button_exit.setText("Exit");
        button_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_exitActionPerformed(evt);
            }
        });

        button_logout.setText("Log Out");
        button_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_logoutActionPerformed(evt);
            }
        });

        button_about.setText("About"); // New About button text
        button_about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_aboutActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "Employee #", "Last Name", "First Name", "Birthday", "Address", "Phone Number", "SSS #", "Philhealth #", "TIN #", "Pag-ibig #", "Status", "Position", "Immediate Supervisor", "Basic Salary", "Rice Subsidy", "Phone Allowance", "Clothing Allowance", "Gross Semi-monthly Rate", "Hourly Rate"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 13));
        jLabel1.setText("Personal Information");

        jLabel2.setText("Employee Number");

        jLabel3.setText("Last Name");

        jLabel4.setText("First Name");

        jLabel5.setText("Birthday");

        jLabel6.setText("Phone Number");

        jLabel7.setText("Address");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 1, 13));
        jLabel8.setText("Tax Information");

        jLabel9.setText("SSS #:");

        jLabel10.setText("Philhealth #:");

        jLabel11.setText("Pagibig #:");

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 1, 13));
        jLabel12.setText("Employee Position:");

        jLabel13.setText("Status");

        jLabel14.setText("Position");

        jLabel15.setText("Immediate Supervisor");

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 1, 13));
        jLabel16.setText("Benefits:");

        jLabel17.setText("Rice Subsidy");

        jLabel18.setText("Phone Allowance");

        jLabel19.setText("Clothing Allowance");

        jLabel20.setFont(new java.awt.Font("Helvetica Neue", 1, 13));
        jLabel20.setText("Salary Information:");

        jLabel21.setText("Basic Salary");

        jLabel22.setText("Gross Semi-monthly Rate");

        jLabel23.setText("Hourly Rate");

        jLabel24.setText("TIN #:");

        button_calculatesalary.setText("Calculate Salary");
        button_calculatesalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_calculatesalaryActionPerformed(evt);
            }
        });

        button_cleartext.setText("Clear Text");
        button_cleartext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cleartextActionPerformed(evt);
            }
        });

        leave_overview.setText("Leave Overview");
        leave_overview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leave_overviewActionPerformed(evt);
            }
        });

        button_information.setText("View Information");
        button_information.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_informationActionPerformed(evt);
            }
        });

        button_save.setText("Save");
        button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_saveActionPerformed(evt);
            }
        });

        leave_application.setText("Leave Application");
        leave_application.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leave_applicationActionPerformed(evt);
            }
        });

        // Use BorderLayout for simplicity
        setLayout(new java.awt.BorderLayout());

        // Main panel for form inputs
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new java.awt.GridLayout(0, 2, 10, 10));

        formPanel.add(jLabel2);
        formPanel.add(txtid);
        formPanel.add(jLabel3);
        formPanel.add(txtlastname);
        formPanel.add(jLabel4);
        formPanel.add(txtfirstname);
        formPanel.add(jLabel5);
        formPanel.add(txtbirthday);
        formPanel.add(jLabel6);
        formPanel.add(txtphonenumber);
        formPanel.add(jLabel7);
        formPanel.add(txtaddress);
        formPanel.add(jLabel9);
        formPanel.add(txtsss);
        formPanel.add(jLabel10);
        formPanel.add(txtphilhealth);
        formPanel.add(jLabel11);
        formPanel.add(txtpagibig);
        formPanel.add(jLabel24);
        formPanel.add(txttin);
        formPanel.add(jLabel13);
        formPanel.add(txtstatus);
        formPanel.add(jLabel14);
        formPanel.add(txtposition);
        formPanel.add(jLabel15);
        formPanel.add(txtsupervisor);
        formPanel.add(jLabel17);
        formPanel.add(txtrice);
        formPanel.add(jLabel18);
        formPanel.add(txtphone);
        formPanel.add(jLabel19);
        formPanel.add(txtclothing);
        formPanel.add(jLabel21);
        formPanel.add(txtbasicsalary);
        formPanel.add(jLabel22);
        formPanel.add(txtgrosssemi);
        formPanel.add(jLabel23);
        formPanel.add(txthourlyrate);

        add(formPanel, java.awt.BorderLayout.CENTER);

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new java.awt.GridLayout(0, 2, 10, 10));

        buttonPanel.add(button_add);
        buttonPanel.add(button_update);
        buttonPanel.add(button_delete);
        buttonPanel.add(button_exit);
        buttonPanel.add(button_logout); // Add the logout button to the panel
        buttonPanel.add(button_save);
        buttonPanel.add(button_calculatesalary);
        buttonPanel.add(button_cleartext);
        buttonPanel.add(button_information);
        buttonPanel.add(leave_overview);
        buttonPanel.add(leave_application);
        buttonPanel.add(button_about); // Add the About button here

        add(buttonPanel, java.awt.BorderLayout.PAGE_END);

        // Scroll pane for the table
        add(jScrollPane1, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }

    private void button_addActionPerformed(java.awt.event.ActionEvent evt) {
        if(txtid.getText().isEmpty() || txtaddress.getText().isEmpty() || txtbasicsalary.getText().isEmpty() || txtbirthday.getText().isEmpty() || txtclothing.getText().isEmpty() || txtfirstname.getText().isEmpty() || txtgrosssemi.getText().isEmpty() || txthourlyrate.getText().isEmpty() || txtlastname.getText().isEmpty() || txtpagibig.getText().isEmpty() || txtphilhealth.getText().isEmpty() || txtphone.getText().isEmpty() || txtphonenumber.getText().isEmpty() || txtposition.getText().isEmpty() || txtrice.getText().isEmpty() || txtsss.getText().isEmpty() || txtstatus.getText().isEmpty() || txtsupervisor.getText().isEmpty() || txttin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please Enter All Data");
        } else {
            int id = Integer.parseInt(txtid.getText());
            String lastName = txtlastname.getText();
            String firstName = txtfirstname.getText();
            String birthday = txtbirthday.getText();
            String address = txtaddress.getText();
            String phoneNumber = txtphonenumber.getText();
            String sss = txtsss.getText();
            String philhealth = txtphilhealth.getText();
            String tin = txttin.getText();
            String pagibig = txtpagibig.getText();
            String status = txtstatus.getText();
            String position = txtposition.getText();
            String supervisor = txtsupervisor.getText();
            double basicSalary = Double.parseDouble(txtbasicsalary.getText());
            double clothingAllowance = Double.parseDouble(txtclothing.getText());
            double riceSubsidy = Double.parseDouble(txtrice.getText());
            double phoneAllowance = Double.parseDouble(txtphone.getText());
            double grossSemiMonthlyRate = Double.parseDouble(txtgrosssemi.getText());
            double hourlyRate = Double.parseDouble(txthourlyrate.getText());

            Object[] rowData = { id, lastName, firstName, birthday, address, phoneNumber, sss, philhealth, tin, pagibig, status, position, supervisor, basicSalary, riceSubsidy, phoneAllowance, clothingAllowance, grossSemiMonthlyRate, hourlyRate };
            DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
            tblModel.addRow(rowData);
        }
    }

    private void button_exitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void button_logoutActionPerformed(java.awt.event.ActionEvent evt) {                                              
        this.dispose();
        new Login().setVisible(true);
    }

    private void button_aboutActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "This project was made by Group 4");
    }

    @SuppressWarnings("unused")
    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();

        if (jTable1.getSelectedRowCount() == 1) {
            String id = txtid.getText();
            String lastName = txtlastname.getText();
            String firstName = txtfirstname.getText();
            String birthday = txtbirthday.getText();
            String address = txtaddress.getText();
            String phoneNumber = txtphonenumber.getText();
            String sss = txtsss.getText();
            String philhealth = txtphilhealth.getText();
            String tin = txttin.getText();
            String pagibig = txtpagibig.getText();
            String status = txtstatus.getText();
            String position = txtposition.getText();
            String supervisor = txtsupervisor.getText();
            String basicSalary = txtbasicsalary.getText();
            String riceSubsidy = txtrice.getText();
            String phoneAllowance = txtphone.getText();
            String clothingAllowance = txtclothing.getText();
            String grossSemiMonthlyRate = txtgrosssemi.getText();
            String hourlyRate = txthourlyrate.getText();

            tblModel.setValueAt(id, jTable1.getSelectedRow(), 0);
            tblModel.setValueAt(lastName, jTable1.getSelectedRow(), 1);
            tblModel.setValueAt(firstName, jTable1.getSelectedRow(), 2);
            tblModel.setValueAt(birthday, jTable1.getSelectedRow(), 3);
            tblModel.setValueAt(address, jTable1.getSelectedRow(), 4);
            tblModel.setValueAt(phoneNumber, jTable1.getSelectedRow(), 5);
            tblModel.setValueAt(sss, jTable1.getSelectedRow(), 6);
            tblModel.setValueAt(philhealth, jTable1.getSelectedRow(), 7);
            tblModel.setValueAt(tin, jTable1.getSelectedRow(), 8);
            tblModel.setValueAt(pagibig, jTable1.getSelectedRow(), 9);
            tblModel.setValueAt(status, jTable1.getSelectedRow(), 10);
            tblModel.setValueAt(position, jTable1.getSelectedRow(), 11);
            tblModel.setValueAt(supervisor, jTable1.getSelectedRow(), 12);
            tblModel.setValueAt(basicSalary, jTable1.getSelectedRow(), 13);
            tblModel.setValueAt(riceSubsidy, jTable1.getSelectedRow(), 14);
            tblModel.setValueAt(phoneAllowance, jTable1.getSelectedRow(), 15);
            tblModel.setValueAt(clothingAllowance, jTable1.getSelectedRow(), 16);
            tblModel.setValueAt(grossSemiMonthlyRate, jTable1.getSelectedRow(), 17);
            tblModel.setValueAt(hourlyRate, jTable1.getSelectedRow(), 18);

            JOptionPane.showMessageDialog(this, "Update Successfully");
        } else {
            if(jTable1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty");
            } else {
                JOptionPane.showMessageDialog(this, "Please select Single Row For Update");
            }
        }
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        if (selectedRowIndex != -1) {
            String id = tblModel.getValueAt(selectedRowIndex, 0).toString();
            String lastName = tblModel.getValueAt(selectedRowIndex, 1).toString();
            String firstName = tblModel.getValueAt(selectedRowIndex, 2).toString();
            String birthday = tblModel.getValueAt(selectedRowIndex, 3).toString();
            String address = tblModel.getValueAt(selectedRowIndex, 4).toString();
            String phoneNumber = tblModel.getValueAt(selectedRowIndex, 5).toString();
            String sss = tblModel.getValueAt(selectedRowIndex, 6).toString();
            String philhealth = tblModel.getValueAt(selectedRowIndex, 7).toString();
            String tin = tblModel.getValueAt(selectedRowIndex, 8).toString();
            String pagibig = tblModel.getValueAt(selectedRowIndex, 9).toString();
            String status = tblModel.getValueAt(selectedRowIndex, 10).toString();
            String position = tblModel.getValueAt(selectedRowIndex, 11).toString();
            String supervisor = tblModel.getValueAt(selectedRowIndex, 12).toString();
            String basicSalary = tblModel.getValueAt(selectedRowIndex, 13).toString();
            String riceSubsidy = tblModel.getValueAt(selectedRowIndex, 14).toString();
            String phoneAllowance = tblModel.getValueAt(selectedRowIndex, 15).toString();
            String clothingAllowance = tblModel.getValueAt(selectedRowIndex, 16).toString();
            String grossSemiMonthlyRate = tblModel.getValueAt(selectedRowIndex, 17).toString();
            String hourlyRate = tblModel.getValueAt(selectedRowIndex, 18).toString();

            txtid.setText(id);
            txtlastname.setText(lastName);
            txtfirstname.setText(firstName);
            txtbirthday.setText(birthday);
            txtaddress.setText(address);
            txtphonenumber.setText(phoneNumber);
            txtsss.setText(sss);
            txtphilhealth.setText(philhealth);
            txttin.setText(tin);
            txtpagibig.setText(pagibig);
            txtstatus.setText(status);
            txtposition.setText(position);
            txtsupervisor.setText(supervisor);
            txtbasicsalary.setText(basicSalary);
            txtrice.setText(riceSubsidy);
            txtphone.setText(phoneAllowance);
            txtclothing.setText(clothingAllowance);
            txtgrosssemi.setText(grossSemiMonthlyRate);
            txthourlyrate.setText(hourlyRate);
        }
    }

    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRowCount = jTable1.getSelectedRowCount();

        if (selectedRowCount == 1) {
            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected row?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
                tblModel.removeRow(jTable1.getSelectedRow());
            }
        } else {
            if (jTable1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty");
            } else {
                JOptionPane.showMessageDialog(this, "Please select a single row for deletion.");
            }
        }
    }

    private void button_calculatesalaryActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        if (selectedRowIndex != -1) {
            String lastName = tblModel.getValueAt(selectedRowIndex, 1).toString();
            String firstName = tblModel.getValueAt(selectedRowIndex, 2).toString();
            String hourlyRateStr = tblModel.getValueAt(selectedRowIndex, 18).toString();

            double hourlyRate = Double.parseDouble(hourlyRateStr);

            int workedDays = 0;
            boolean validInput = false;

            while (!validInput) {
                String input = JOptionPane.showInputDialog("Enter worked days:");

                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Operation cancelled.");
                    return;
                }

                try {
                    workedDays = Integer.parseInt(input);
                    if (workedDays <= 0) {
                        JOptionPane.showMessageDialog(null, "Please enter a positive number for worked days.");
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer for worked days.");
                }
            }

            double totalSalary = workedDays * hourlyRate * 8;

            double sssContribution = calculateSSSContribution(totalSalary);
            double philhealthContribution = calculatePhilHealthContribution(totalSalary);
            double pagibigContribution = calculatePagibigContribution(totalSalary);

            double grossDeductions = sssContribution + philhealthContribution + pagibigContribution;
            double salaryAfterTax = totalSalary - grossDeductions;
            double withholdingTax = calculateWithholdingTax(salaryAfterTax);
            double totalDeductions = grossDeductions + withholdingTax;
            double netPay = salaryAfterTax - withholdingTax;

            String message = "Employee: " + firstName + " " + lastName + "\n";
            message += "Worked Days: " + workedDays + "\n";
            message += "Gross Salary: PHP " + String.format("%.2f", totalSalary) + "\n";
            message += "SSS Contribution: PHP " + String.format("%.2f", sssContribution) + "\n";
            message += "PhilHealth Contribution: PHP " + String.format("%.2f", philhealthContribution) + "\n";
            message += "Pagibig Contribution: PHP " + String.format("%.2f", pagibigContribution) + "\n";
            message += "Withholding Tax: PHP " + String.format("%.2f", withholdingTax) + "\n";
            message += "Total Deduction: PHP " +  String.format("%.2f", totalDeductions) + "\n";
            message += "Net Pay: PHP " + String.format("%.2f", netPay) + "\n";

            JOptionPane.showMessageDialog(this, message);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to calculate salary.");
        }
    }

    private void button_cleartextActionPerformed(java.awt.event.ActionEvent evt) {
        txtid.setText("");
        txtaddress.setText("");
        txtbasicsalary.setText("");
        txtbirthday.setText("");
        txtclothing.setText("");
        txtfirstname.setText("");
        txtgrosssemi.setText("");
        txthourlyrate.setText("");
        txtlastname.setText("");
        txtpagibig.setText("");
        txtphilhealth.setText("");
        txtphone.setText("");
        txtphonenumber.setText("");
        txtposition.setText("");
        txtrice.setText("");
        txtsss.setText("");
        txtstatus.setText("");
        txtsupervisor.setText("");
        txttin.setText("");
    }

    @SuppressWarnings("unused")
    private void txtriceActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void button_informationActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();

        if (selectedRowIndex != -1) {
            String id = tblModel.getValueAt(selectedRowIndex, 0).toString();
            String lastName = tblModel.getValueAt(selectedRowIndex, 1).toString();
            String firstName = tblModel.getValueAt(selectedRowIndex, 2).toString();
            String birthday = tblModel.getValueAt(selectedRowIndex, 3).toString();
            String address = tblModel.getValueAt(selectedRowIndex, 4).toString();
            String phoneNumber = tblModel.getValueAt(selectedRowIndex, 5).toString();
            String sss = tblModel.getValueAt(selectedRowIndex, 6).toString();
            String philhealth = tblModel.getValueAt(selectedRowIndex, 7).toString();
            String tin = tblModel.getValueAt(selectedRowIndex, 8).toString();
            String pagibig = tblModel.getValueAt(selectedRowIndex, 9).toString();
            String status = tblModel.getValueAt(selectedRowIndex, 10).toString();
            String position = tblModel.getValueAt(selectedRowIndex, 11).toString();
            String supervisor = tblModel.getValueAt(selectedRowIndex, 12).toString();
            String basicSalary = tblModel.getValueAt(selectedRowIndex, 13).toString();
            String riceSubsidy = tblModel.getValueAt(selectedRowIndex, 14).toString();
            String phoneAllowance = tblModel.getValueAt(selectedRowIndex, 15).toString();
            String clothingAllowance = tblModel.getValueAt(selectedRowIndex, 16).toString();
            String grossSemiMonthlyRate = tblModel.getValueAt(selectedRowIndex, 17).toString();
            String hourlyRate = tblModel.getValueAt(selectedRowIndex, 18).toString();

            String message = "Employee ID: " + id + "\n";
            message += "Last Name: " + lastName + "\n";
            message += "First Name: " + firstName + "\n";
            message += "Birthday: " + birthday + "\n";
            message += "Address: " + address + "\n";
            message += "Phone Number: " + phoneNumber + "\n";
            message += "SSS: " + sss + "\n";
            message += "Philhealth: " + philhealth + "\n";
            message += "TIN: " + tin + "\n";
            message += "Pag-ibig: " + pagibig + "\n";
            message += "Status: " + status + "\n";
            message += "Position: " + position + "\n";
            message += "Supervisor: " + supervisor + "\n";
            message += "Basic Salary: " + basicSalary + "\n";
            message += "Rice Subsidy: " + riceSubsidy + "\n";
            message += "Phone Allowance: " + phoneAllowance + "\n";
            message += "Clothing Allowance: " + clothingAllowance + "\n";
            message += "Gross Semi-monthly Rate: " + grossSemiMonthlyRate + "\n";
            message += "Hourly Rate: " + hourlyRate + "\n";

            JOptionPane.showMessageDialog(this, message);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to view information.");
        }
    }

    private void leave_overviewActionPerformed(java.awt.event.ActionEvent evt) {
        new LeaveOverviewForm().setVisible(true);
    }

    private void button_saveActionPerformed(java.awt.event.ActionEvent evt) {
        saveCSVData();
    }

    private void leave_applicationActionPerformed(java.awt.event.ActionEvent evt) {
        new LeaveApplicationForm().setVisible(true);
    }

    public static double calculateSSSContribution(double totalSalary) {
        double sssContribution = 0;

        if (totalSalary <= 3250) {
            sssContribution = 135;
        } else if (totalSalary <= 3750) {
            sssContribution = 157.50;
        } else if (totalSalary <= 4250) {
            sssContribution = 180;
        } else if (totalSalary <= 4750) {
            sssContribution = 202.50;
        } else if (totalSalary <= 5250) {
            sssContribution = 225;
        } else if (totalSalary <= 5750) {
            sssContribution = 247.50;
        } else if (totalSalary <= 6250) {
            sssContribution = 270;
        } else if (totalSalary <= 6750) {
            sssContribution = 292.50;
        } else if (totalSalary <= 7250) {
            sssContribution = 315;
        } else if (totalSalary <= 7750) {
            sssContribution = 337.50;
        } else if (totalSalary <= 8250) {
            sssContribution = 360;
        } else if (totalSalary <= 8750) {
            sssContribution = 382.50;
        } else if (totalSalary <= 9250) {
            sssContribution = 405;
        } else if (totalSalary <= 9750) {
            sssContribution = 427.50;
        } else if (totalSalary <= 10250) {
            sssContribution = 450;
        } else if (totalSalary <= 10750) {
            sssContribution = 472.50;
        } else if (totalSalary <= 11250) {
            sssContribution = 495;
        } else if (totalSalary <= 11750) {
            sssContribution = 517.50;
        } else if (totalSalary <= 12250) {
            sssContribution = 540;
        } else if (totalSalary <= 12750) {
            sssContribution = 562.50;
        } else if (totalSalary <= 13250) {
            sssContribution = 585;
        } else if (totalSalary <= 13750) {
            sssContribution = 607.50;
        } else if (totalSalary <= 14250) {
            sssContribution = 630;
        } else if (totalSalary <= 14750) {
            sssContribution = 652.50;
        } else if (totalSalary <= 15250) {
            sssContribution = 675;
        } else if (totalSalary <= 15750) {
            sssContribution = 697.50;
        } else if (totalSalary <= 16250) {
            sssContribution = 720;
        } else if (totalSalary <= 16750) {
            sssContribution = 742.50;
        } else if (totalSalary <= 17250) {
            sssContribution = 765;
        } else if (totalSalary <= 17750) {
            sssContribution = 787.50;
        } else if (totalSalary <= 18250) {
            sssContribution = 810;
        } else if (totalSalary <= 18750) {
            sssContribution = 832.50;
        } else if (totalSalary <= 19250) {
            sssContribution = 855;
        } else if (totalSalary <= 19750) {
            sssContribution = 877.50;
        } else if (totalSalary <= 20250) {
            sssContribution = 900;
        } else if (totalSalary <= 20750) {
            sssContribution = 922.50;
        } else if (totalSalary <= 21250) {
            sssContribution = 945;
        } else if (totalSalary <= 21750) {
            sssContribution = 967.50;
        } else if (totalSalary <= 22250) {
            sssContribution = 990;
        } else if (totalSalary <= 22750) {
            sssContribution = 1012.50;
        } else if (totalSalary <= 23250) {
            sssContribution = 1035;
        } else if (totalSalary <= 23750) {
            sssContribution = 1057.50;
        } else if (totalSalary <= 24250) {
            sssContribution = 1080;
        } else if (totalSalary <= 24750) {
            sssContribution = 1102.50;
        } else {
            sssContribution = 1125;
        }

        return sssContribution;
    }

    public static double calculatePhilHealthContribution(double totalSalary) {
        double premiumRate = 0.03;
        double monthlyPremium;

        if (totalSalary <= 10000) {
            monthlyPremium = 300;
        } else if (totalSalary <= 59999.99) {
            monthlyPremium = Math.min(300 + (totalSalary - 10000) * premiumRate, 1800);
        } else {
            monthlyPremium = 1800;
        }

        return monthlyPremium;
    }

    public static double calculatePagibigContribution(double totalSalary) {
        double employeeContributionRate = 0;
        double employerContributionRate = 0;
        double totalContributionRate = 0;

        if (totalSalary >= 1000 && totalSalary <= 1500) {
            employeeContributionRate = 0.01;
            employerContributionRate = 0.02;
            totalContributionRate = employeeContributionRate + employerContributionRate;
        } else if (totalSalary > 1500) {
            employeeContributionRate = 0.02;
            employerContributionRate = 0.02;
            totalContributionRate = employeeContributionRate + employerContributionRate;
        }

        double totalContribution = Math.min(totalSalary * totalContributionRate, 100);
        return totalContribution;
    }

    public static double calculateWithholdingTax(double salaryAfterTax) {
        double withholdingTax = 0;

        if (salaryAfterTax <= 20832) {
            withholdingTax = 0;
        } else if (salaryAfterTax <= 33333) {
            withholdingTax = (salaryAfterTax - 20832) * 0.20;
        } else if (salaryAfterTax <= 66667) {
            withholdingTax = 2500 + (salaryAfterTax - 33333) * 0.25;
        } else if (salaryAfterTax <= 166667) {
            withholdingTax = 10833 + (salaryAfterTax - 66667) * 0.30;
        } else if (salaryAfterTax <= 666667) {
            withholdingTax = 40833.33 + (salaryAfterTax - 166667) * 0.32;
        } else {
            withholdingTax = 200833.33 + (salaryAfterTax - 666667) * 0.35;
        }

        return withholdingTax;
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    private javax.swing.JButton button_add;
    private javax.swing.JButton button_calculatesalary;
    private javax.swing.JButton button_cleartext;
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_exit;
    private javax.swing.JButton button_information;
    private javax.swing.JButton button_save;
    private javax.swing.JButton button_update;
    private javax.swing.JButton button_logout;
    private javax.swing.JButton button_about; // Declaration of the About button
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton leave_application;
    private javax.swing.JButton leave_overview;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtbasicsalary;
    private javax.swing.JTextField txtbirthday;
    private javax.swing.JTextField txtclothing;
    private javax.swing.JTextField txtfirstname;
    private javax.swing.JTextField txtgrosssemi;
    private javax.swing.JTextField txthourlyrate;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtlastname;
    private javax.swing.JTextField txtpagibig;
    private javax.swing.JTextField txtphilhealth;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtphonenumber;
    private javax.swing.JTextField txtposition;
    private javax.swing.JTextField txtrice;
    private javax.swing.JTextField txtsss;
    private javax.swing.JTextField txtstatus;
    private javax.swing.JTextField txtsupervisor;
    private javax.swing.JTextField txttin;
}
