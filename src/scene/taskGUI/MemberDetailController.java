package scene.taskGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import resources.database.DB;
import scene.taskGUI.Entity.Event;
import scene.taskGUI.Entity.User;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by eyoyu on 7/6/2017.
 */
public class MemberDetailController implements Initializable{

    @FXML
    private Label memberName;
    @FXML
    private Label memberSchool;
    @FXML
    private Label memberContactNo;
    @FXML
    private Label memberTask;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      }

    public void setUser(User user) {
        User fullUser=EventController.getUserInformation(user.getUserID());

        memberName.setText(fullUser.getName());
        memberSchool.setText(fullUser.getSchool());
        memberContactNo.setText(String.valueOf(fullUser.getHpNumber()));
        memberTask.setText(fullUser.getTask());

    }
}
