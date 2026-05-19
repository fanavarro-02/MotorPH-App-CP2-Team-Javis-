import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class AttendanceForm extends JFrame {

    JLabel lblEmployeeId;
    JLabel lblDate;
    JLabel lblTimeIn;
    JLabel lblTimeOut;
    JLabel lblHoursWorked;

    JTextField txtEmployeeId;
    JTextField txtHoursWorked;

    JSpinner dateSpinner;
    JSpinner timeInSpinner;
    JSpinner timeOutSpinner;

    JButton btnCalculate;
    JButton btnClear;
    JButton btnBack;

    public AttendanceForm() {

        setTitle("Attendance Form");

        setSize(500, 400);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new GridLayout(7, 2, 10, 10));

        // LABELS

        lblEmployeeId = new JLabel("Employee ID:");

        lblDate = new JLabel("Date:");

        lblTimeIn = new JLabel("Time In:");

        lblTimeOut = new JLabel("Time Out:");

        lblHoursWorked = new JLabel("Hours Worked:");

        // TEXT FIELDS

        txtEmployeeId = new JTextField();

        txtHoursWorked = new JTextField();

        txtHoursWorked.setEditable(false);

        // DATE SPINNER

        dateSpinner = new JSpinner(
            new SpinnerDateModel()
        );

        JSpinner.DateEditor dateEditor =
            new JSpinner.DateEditor(
                dateSpinner,
                "MM/dd/yyyy"
            );

        dateSpinner.setEditor(dateEditor);

        // TIME IN SPINNER

        timeInSpinner = new JSpinner(
            new SpinnerDateModel()
        );

        JSpinner.DateEditor timeInEditor =
            new JSpinner.DateEditor(
                timeInSpinner,
                "HH:mm"
            );

        timeInSpinner.setEditor(timeInEditor);

        // TIME OUT SPINNER

        timeOutSpinner = new JSpinner(
            new SpinnerDateModel()
        );

        JSpinner.DateEditor timeOutEditor =
            new JSpinner.DateEditor(
                timeOutSpinner,
                "HH:mm"
            );

        timeOutSpinner.setEditor(timeOutEditor);

        // BUTTONS

        btnCalculate =
            new JButton("Calculate Hours");

        btnClear =
            new JButton("Clear");

        btnBack =
            new JButton("Back");

        // ADD COMPONENTS

        add(lblEmployeeId);
        add(txtEmployeeId);

        add(lblDate);
        add(dateSpinner);

        add(lblTimeIn);
        add(timeInSpinner);

        add(lblTimeOut);
        add(timeOutSpinner);

        add(lblHoursWorked);
        add(txtHoursWorked);

        add(btnCalculate);
        add(btnClear);

        add(btnBack);

        // CALCULATE BUTTON

        btnCalculate.addActionListener(e -> {

            try {

                Date timeIn =
                    (Date) timeInSpinner.getValue();

                Date timeOut =
                    (Date) timeOutSpinner.getValue();

                long difference =
                    timeOut.getTime() -
                    timeIn.getTime();

                double hoursWorked =
                    difference / (1000.0 * 60 * 60);

                if(hoursWorked < 0) {

                    JOptionPane.showMessageDialog(
                        this,
                        "Time Out cannot be earlier than Time In."
                    );

                    return;
                }

                txtHoursWorked.setText(
                    String.format("%.2f", hoursWorked)
                );

                JOptionPane.showMessageDialog(
                    this,
                    "Hours calculated successfully."
                );

            }
            catch(Exception ex) {

                JOptionPane.showMessageDialog(
                    this,
                    "Invalid attendance input."
                );

            }

        });

        // CLEAR BUTTON

        btnClear.addActionListener(e -> {

            txtEmployeeId.setText("");

            txtHoursWorked.setText("");

        });

        // BACK BUTTON

        btnBack.addActionListener(e -> {

            dispose();

        });

        setVisible(true);
    }
}