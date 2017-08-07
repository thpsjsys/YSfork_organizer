package scene.Task.UI;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import resources.database.entity.User;
import scene.Task.TaskControllerKt;
import scene.Task.entity.Task;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by hhf on 7/4/17.
 */
public class TaskMainController implements Initializable {
    private User user;



    @FXML
    private VBox taskContainer;

    @FXML
    private AnchorPane taskDetailsContainer;
    @FXML

    private JFXButton addTaskButton;
    private ArrayList<Task> taskArr;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //user=new User();
        //taskArr=TaskControllerKt.getTaskByUser(user);
        updateTaskListContontainer(taskArr);

        //add add icon
        //addTaskButton.heightProperty().;
        Image plusImage=new Image(getClass().getResourceAsStream("/resources/images/icon/add-square-button.png"));
        ImageView plusImageView=new ImageView(plusImage);
        //plusImageView.fitHeightProperty().bind(addTaskButton.heightProperty());
        //plusImageView.fitWidthProperty().bind(addTaskButton.widthProperty());
        //plusImageView.setFitHeight(36);
        //plusImageView.setFitWidth(36);
        addTaskButton.setStyle("-fx-padding: 0px;");
        addTaskButton.setGraphic(plusImageView);
        //addTaskButton.setStyle("-fx-background-radius: 5em;");
    }

    @FXML
    void addTask(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("AddTask.fxml"));

        try {
            Parent addTaskScene=loader.load();

            Stage stage=new Stage(StageStyle.UNDECORATED);
            stage.setTitle("ADD TASK");
            stage.setScene(new Scene(addTaskScene));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void updateTaskListContontainer(ArrayList<Task> arr){
        for(Task t:taskArr){
            FXMLLoader loader=new FXMLLoader(getClass().getResource("TaskBar.fxml"));
            try {
                Parent node=loader.load();
                TaskBarController tc=loader.getController();
                /*tc.setTaskInfo(t);*/
                node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        FXMLLoader taskDetailSceneLoader=new FXMLLoader(getClass().getResource("TaskDetails.fxml"));
                        try{
                            AnchorPane ap=taskDetailSceneLoader.load();
                            TaskDetailsController tdc=taskDetailSceneLoader.getController();
                            /*tdc.setTask(tc.getTask());*/
                            taskDetailsContainer.getChildren().setAll(ap);

                        }catch (IOException e){ e.printStackTrace();}
                    }
                });
                taskContainer.getChildren().add(node);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
