import javax.swing.*;
import java.awt.*;

public class EmployeeForm extends JFrame {

    JLabel lblEmployeeId;
    JLabel lblFirstName;
    JLabel lblLastName;
    JLabel lblDepartment;
    JLabel lblPosition;

    JTextField txtEmployeeId;
    JTextField txtFirstName;
    JTextField txtLastName;
    JTextField txtDepartment;
    JTextField txtPosition;

    JButton btnSave;
    JButton btnClear;
    JButton btnBack;

    public EmployeeForm() {

        setTitle("Employee Form");

        setSize(500, 400);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(7, 2, 10, 10));

        lblEmployeeId = new JLabel("Employee ID:");
        lblFirstName = new JLabel("First Name:");
        lblLastName = new JLabel("Last Name:");
        lblDepartment = new JLabel("Department:");
        lblPosition = new JLabel("Position:");

        txtEmployeeId = new JTextField();
        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtDepartment = new JTextField();
        txtPosition = new JTextField();

        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnBack = new JButton("Back");

        add(lblEmployeeId);
        add(txtEmployeeId);

        add(lblFirstName);
        add(txtFirstName);

        add(lblLastName);
        add(txtLastName);

        add(lblDepartment);
        add(txtDepartment);

        add(lblPosition);
        add(txtPosition);

        add(btnSave);
        add(btnClear);

        add(btnBack);

        btnSave.addActionListener(e -> {

            String employeeId = txtEmployeeId.getText();

            String firstName = txtFirstName.getText();

            String lastName = txtLastName.getText();

            if(employeeId.trim().isEmpty() ||
               firstName.trim().isEmpty() ||
               lastName.trim().isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please complete all required fields."
                );

                return;
            }

            JOptionPane.showMessageDialog(
                this,
                "Employee Saved Successfully!"
            );

        });

        btnClear.addActionListener(e -> {

            txtEmployeeId.setText("");

            txtFirstName.setText("");

            txtLastName.setText("");

            txtDepartment.setText("");

            txtPosition.setText("");

        });

        btnBack.addActionListener(e -> {

            dispose();

        });

        setVisible(true);
    }
}