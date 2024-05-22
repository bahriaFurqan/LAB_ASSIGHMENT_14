package task.myfurqancode;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterController
{
    @FXML
    private Stage stage;

    @FXML
    private TextField FullName;

    @FXML
    private TextField UserName;

    @FXML
    private PasswordField Password;

    @FXML
    private PasswordField ConfirmPassword;

    @FXML
    private TextField Email;

    @FXML
    private void handleRegisterButton() {
        String fullName = FullName.getText();
        String userName = UserName.getText();
        String password = Password.getText();
        String confirmPassword = ConfirmPassword.getText();
        String email = Email.getText();

        // Add your registration logic here
        if (password.equals(confirmPassword)) {
            // If the passwords match, proceed with registration
            registerUser(fullName, userName, password, email);
        } else {
            // If the passwords do not match, show an error message
            System.out.println("Passwords do not match!");

        }
    }

    private void registerUser(String fullName, String userName, String password, String email) {
        // Implement your user registration logic here
        System.out.println("User registered successfully!");
    }

    void setStage(Stage stage)
    {
        this.stage = stage;
    }
}