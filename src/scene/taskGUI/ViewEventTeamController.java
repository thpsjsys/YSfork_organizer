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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by eyoyu on 7/6/2017.
 */
public class ViewEventTeamController implements Initializable{
    private ObservableList<String> eventNameList= FXCollections.observableArrayList();
    private ArrayList<Event> eventArr;

    @FXML
    private ListView<String> viewEventListView;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        retrieveEventName();
        viewEventListView.setItems(eventNameList);
        viewEventListView.setOnMouseClicked(event->viewEventMemberName());
    }

    private void  retrieveEventName(){

        eventArr=EventController.getEventTitle(new Event());

        for(Event eventname:eventArr){
            eventNameList.add(eventname.getEventTitle());
        }

    }
    private void viewEventMemberName(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("memberNameList.fxml"));
            Parent root=loader.load();
            MemberNameListController ctr=loader.getController();
            int index=viewEventListView.getSelectionModel().getSelectedIndex();

            ctr.setEvent(eventArr.get(index));
            Scene scene=new Scene(root);

            Stage stage=new Stage();
            stage.setScene(scene);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
