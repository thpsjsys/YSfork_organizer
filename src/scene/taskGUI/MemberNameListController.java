package scene.taskGUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import scene.taskGUI.Entity.Event;
import scene.taskGUI.Entity.User;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by eyoyu on 18/7/2017.
 */
public class MemberNameListController implements Initializable{
    private Event event;
    private ObservableList<String> eventMemberNameList= FXCollections.observableArrayList();
    private ArrayList<User> arr;
    @FXML
    private ListView<String> memberNameList;

    public void initialize(URL location, ResourceBundle resources) {
        memberNameList.setItems(eventMemberNameList);
        memberNameList.setOnMouseClicked(event->viewEventMemberName());
    }

    private void  retrieveEventMember(){
        arr=EventController.getMemberName(event);

        for(User userName:arr){
            eventMemberNameList.add(userName.getName());
        }
    }
    private void viewEventMemberName(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("memberDetail.fxml"));
            Parent root=loader.load();
            MemberDetailController ctr=loader.getController();
            int index=memberNameList.getSelectionModel().getSelectedIndex();

            ctr.setUser(arr.get(index));
            Scene scene=new Scene(root);
            Stage stage=new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setEvent(Event event) {
        this.event = event;
        retrieveEventMember();
        memberNameList.setItems(eventMemberNameList);
        memberNameList.setOnMouseClicked(e->viewEventMemberName());
    }
}
