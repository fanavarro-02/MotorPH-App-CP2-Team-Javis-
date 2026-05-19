import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    JLabel lblTitle;

    JButton btnEmployee;
    JButton btnAttendance;
    JButton btnPayroll;
    JButton btnExit;

    JPanel titlePanel;
    JPanel buttonPanel;

    public MainFrame() {

        // FRAME SETTINGS

        setTitle("MotorPH Payroll System");

        setSize(1920, 1080);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        // TITLE LABEL

        lblTitle = new JLabel(
            "MotorPH Payroll System",
            SwingConstants.CENTER
        );

        lblTitle.setFont(
            new Font("Arial", Font.BOLD, 32)
        );

        lblTitle.setForeground(Color.WHITE);

        // TITLE PANEL

        titlePanel = new JPanel();

        titlePanel.setBackground(
            new Color(0, 51, 102)
        );

        titlePanel.setPreferredSize(
            new Dimension(700, 100)
        );

        titlePanel.add(lblTitle);

        // BUTTONS

        btnEmployee =
            new JButton("Employee Form");

        btnAttendance =
            new JButton("Attendance Form");

        btnPayroll =
            new JButton("Payroll Form");

        btnExit =
            new JButton("Exit");

        // BUTTON STYLE

        Font buttonFont =
            new Font("Arial", Font.BOLD, 18);

        JButton[] buttons = {
            btnEmployee,
            btnAttendance,
            btnPayroll,
            btnExit
        };

        for(JButton button : buttons) {

            button.setFont(buttonFont);

            button.setFocusPainted(false);

            button.setBackground(
                new Color(0, 102, 204)
            );

            button.setForeground(Color.WHITE);

            button.setPreferredSize(
                new Dimension(200, 50)
            );

        }

        // BUTTON PANEL

        buttonPanel = new JPanel();

        buttonPanel.setLayout(
            new GridLayout(4, 1, 20, 20)
        );

        buttonPanel.setBorder(
            BorderFactory.createEmptyBorder(
                40,
                120,
                40,
                120
            )
        );

        buttonPanel.setBackground(Color.WHITE);

        buttonPanel.add(btnEmployee);

        buttonPanel.add(btnAttendance);

        buttonPanel.add(btnPayroll);

        buttonPanel.add(btnExit);

        // ADD PANELS

        add(titlePanel, BorderLayout.NORTH);

        add(buttonPanel, BorderLayout.CENTER);

        // BUTTON EVENTS

        btnEmployee.addActionListener(e -> {

            new EmployeeForm();

        });

        btnAttendance.addActionListener(e -> {

            new AttendanceForm();

        });

        btnPayroll.addActionListener(e -> {

            new PayrollForm();

        });

        btnExit.addActionListener(e -> {

            int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to exit?",
                "Exit Confirmation",
                JOptionPane.YES_NO_OPTION
            );

            if(choice == JOptionPane.YES_OPTION) {

                System.exit(0);

            }

        });

        setVisible(true);
    }

    public static void main(String[] args) {

        new MainFrame();

    }
}