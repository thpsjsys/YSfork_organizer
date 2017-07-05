package scene.Task.UI;

import javafx.fxml.Initializable;
import scene.Task.entity.Task;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by hhf on 7/5/17.
 */
public class TaskDetailsController implements Initializable{
    private Task task;
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    public void setTask(Task task){
        this.task=task;

    }
}
