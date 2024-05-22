package task.myfurqancode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController
{
    @FXML
    private Stage stage;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registerButton;

    @FXML
    private void initialize() {
        // Optional: You can initialize anything here when the controller is loaded
    }

    @FXML
    private void handleLoginButton() {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        // Use the connection class to authenticate the user
        connection dbConnection = new connection();
        String sql = "SELECT * FROM logi WHERE username = ? AND password = ?";

        try {
            PreparedStatement statement = dbConnection.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                showAlert("Login Successful", "Welcome, " + username + "!");
                // Here you can switch to the main application or perform any other actions
            } else {
                showAlert("Login Failed", "Invalid username or password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleRegisterButton() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("register_page.fxml"));
            Stage stage = (Stage) registerButton.getScene().getWindow();
            stage.setTitle("Registration Page");
            stage.setScene(new Scene(root, 815, 616));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void setStage(Stage primaryStage)
    {
        this.stage=stage;
    }
}