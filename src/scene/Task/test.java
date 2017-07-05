package scene.Task;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by hhf on 7/4/17.
 */
public class test extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("UI/TaskMain.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
