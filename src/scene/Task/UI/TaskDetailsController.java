package scene.Task.UI;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import scene.Task.entity.Task;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by hhf on 7/5/17.
 */
public class TaskDetailsController implements Initializable{
    private Task task;
    @FXML
    private Label taskTaskField;

    @FXML
    private JFXTextField startDateTimeTextField;

    @FXML
    private JFXTextField endDateTimeTextField;

    @FXML
    private JFXTextField priorityTextField;

    @FXML
    private JFXTextField repeatTextField;

    @FXML
    private JFXTextArea descTextArea;

    @FXML
    private JFXTextField locationTextField;

    @FXML
    private JFXListView<String> memberListView;
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    public void setTask(Task task){
        this.task=task;
        taskTaskField.setText(task.getTask_name());
        startDateTimeTextField.setText("time");
        endDateTimeTextField.setText("time");
        priorityTextField.setText("low");
        repeatTextField.setText("Daily");
        descTextArea.setText(task.getDescription());
        locationTextField.setText(task.getLocation());


    }
}
