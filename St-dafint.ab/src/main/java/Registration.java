
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

@RequestMapping(path = "/api/registration")
@CrossOrigin(origins = {"http://localhost:8080/"})
public class Registration extends JDialog {
    private JTextField tfFirst;
    private JTextField tfLast;
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btnRegister;
    private JButton btnCancel;
    private JPasswordField pfConfirm;
    private JLabel registerPanel;

    public Registration(JFrame parent) {
        super(parent);
        setTitle("Create new user");
        setContentPane((registerPanel));
        setMinimumSize(new Dimension(450, 474));
        setModal(true);
        setLocationRelativeTo(parent);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void registerUser() {
        String firstName = tfFirst.getText();
        String lastName = tfLast.getText();
        String email = tfEmail.getText();
        String password = String.valueOf(pfPassword.getPassword());
        String confirmPassword = String.valueOf(pfConfirm.getPassword());

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showConfirmDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this,
                    "Password do not match",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        user = addAppUserToDatabase(firstName, lastName, email, password);
        if (user != null) {
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Failed to register new user",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public User user;
    private User addAppUserToDatabase(String firstName, String lastName, String email, String password) {
        User user = null;
        final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        final String USERNAME ="postgres";
        final String PASSWORD ="admin";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (firstName, lastName, email, password)" + "VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(1, email);
            preparedStatement.setString(1, password);

            stmt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    public static void main(String[] args) {
        Registration myForm = new Registration(null);
        User user = myForm.user;;
        if (user!= null){
            System.out.println("Successful registration of;" + user.getUsername());
        } else {
            System.out.println("Registration canceled");
        }
    }
}
