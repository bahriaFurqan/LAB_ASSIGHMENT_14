package task.myfurqancode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
       FXMLLoader loginloader = new FXMLLoader(getClass().getResource("login_page.fxml"));
       Parent loginroot = loginloader.load();
       LoginController loginController = loginloader.getController();
       loginController.setStage(primaryStage);

       FXMLLoader registerloader=new FXMLLoader(getClass().getResource("register_page.fxml"));
       Parent registerroot = registerloader.load();
       RegisterController registerController = registerloader.getController();
       registerController.setStage(primaryStage);

       Scene LoginScene=new Scene(loginroot, 815, 616);
       primaryStage.setScene(LoginScene);
       primaryStage.setTitle("Login Page");
       primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
