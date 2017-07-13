package scene.Task.UI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;
import scene.Task.TaskControllerKt;


import javax.naming.spi.InitialContextFactory;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * Created by hhf on 6/29/17.
 */
public class AddTaskController implements Initializable{
    @FXML
    private JFXTextField taskNameTextField;

    @FXML
    private JFXTextField startDateTimeTextField;

    @FXML
    private JFXTextField endDateTimeTextField;

    @FXML
    private JFXTextField priorityTextField;

    @FXML
    private JFXTextField repeatTextField;

    @FXML
    private JFXTextField peopleTextField;

    @FXML
    private JFXTextField locationTextField;

    @FXML
    private JFXTextArea descriptionTextArea;

    @FXML
    void cancel(ActionEvent event) {
        Stage stage=(Stage)((Node)event.getTarget()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void save(ActionEvent event) {
        String task=taskNameTextField.getText();
        String start=startDateTimeTextField.getText();
        String end=endDateTimeTextField.getText();
        int priority=Integer.parseInt(priorityTextField.getText());

        int repeat=Integer.parseInt(repeatTextField.getText());
        String peoples=peopleTextField.getText();
        String location=locationTextField.getText();
        String description=descriptionTextArea.getText();

        TaskControllerKt.addTask(task,start,end,description,priority,repeat,location,"help hello","123456A");




    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }





}
