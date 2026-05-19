import javax.swing.*;
import java.awt.*;

public class PayrollForm extends JFrame {

    JLabel lblEmployeeId;
    JLabel lblBasicSalary;
    JLabel lblOvertimePay;
    JLabel lblDeduction;
    JLabel lblGrossPay;
    JLabel lblNetPay;

    JTextField txtEmployeeId;
    JTextField txtBasicSalary;
    JTextField txtOvertimePay;
    JTextField txtDeduction;
    JTextField txtGrossPay;
    JTextField txtNetPay;

    JButton btnCalculate;
    JButton btnClear;
    JButton btnBack;

    public PayrollForm() {

        setTitle("Payroll Form");

        setSize(500, 400);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(8, 2, 10, 10));

        lblEmployeeId = new JLabel("Employee ID:");
        lblBasicSalary = new JLabel("Basic Salary:");
        lblOvertimePay = new JLabel("Overtime Pay:");
        lblDeduction = new JLabel("Deduction:");
        lblGrossPay = new JLabel("Gross Pay:");
        lblNetPay = new JLabel("Net Pay:");

        txtEmployeeId = new JTextField();
        txtBasicSalary = new JTextField();
        txtOvertimePay = new JTextField();
        txtDeduction = new JTextField();
        txtGrossPay = new JTextField();
        txtNetPay = new JTextField();

        txtGrossPay.setEditable(false);
        txtNetPay.setEditable(false);

        btnCalculate =
            new JButton("Calculate Payroll");

        btnClear =
            new JButton("Clear");

        btnBack =
            new JButton("Back");

        add(lblEmployeeId);
        add(txtEmployeeId);

        add(lblBasicSalary);
        add(txtBasicSalary);

        add(lblOvertimePay);
        add(txtOvertimePay);

        add(lblDeduction);
        add(txtDeduction);

        add(lblGrossPay);
        add(txtGrossPay);

        add(lblNetPay);
        add(txtNetPay);

        add(btnCalculate);
        add(btnClear);

        add(btnBack);

        btnCalculate.addActionListener(e -> {

            try {

                String employeeId =
                    txtEmployeeId.getText();

                if(employeeId.trim().isEmpty()) {

                    JOptionPane.showMessageDialog(
                        this,
                        "Please enter Employee ID."
                    );

                    return;
                }

                double basicSalary =
                    Double.parseDouble(
                        txtBasicSalary.getText()
                    );

                double overtimePay =
                    Double.parseDouble(
                        txtOvertimePay.getText()
                    );

                double deduction =
                    Double.parseDouble(
                        txtDeduction.getText()
                    );

                if(basicSalary < 0 ||
                   overtimePay < 0 ||
                   deduction < 0) {

                    JOptionPane.showMessageDialog(
                        this,
                        "Values cannot be negative."
                    );

                    return;
                }

                double grossPay =
                    basicSalary + overtimePay;

                double netPay =
                    grossPay - deduction;

                txtGrossPay.setText(
                    String.format("%.2f", grossPay)
                );

                txtNetPay.setText(
                    String.format("%.2f", netPay)
                );

                JOptionPane.showMessageDialog(
                    this,
                    "Payroll calculated successfully."
                );

            }
            catch(NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please enter valid numeric values."
                );

            }

        });

        btnClear.addActionListener(e -> {

            txtEmployeeId.setText("");

            txtBasicSalary.setText("");

            txtOvertimePay.setText("");

            txtDeduction.setText("");

            txtGrossPay.setText("");

            txtNetPay.setText("");

        });

        btnBack.addActionListener(e -> {

            dispose();

        });

        setVisible(true);
    }
}