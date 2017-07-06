package scene.event.UI;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import resources.database.DB;
import scene.event.EventController;
import scene.event.entity.Event;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Liu Woon Kit on 29/6/2017.
 */
public class EventListController implements Initializable {
    private EventController eventController = new EventController();
    private EventListController eventListController = this;
    private DB db = new DB();

    @FXML
    Label clockDisplay;

    @FXML
    HBox newEventListBox;

    @FXML
    HBox eventListBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startClock();
        addEventsToDisplay();
    }

    public void addEventsToDisplay() {
        clearDisplays();
        for(Event event : eventController.getEvents()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EventObject.fxml"));
            fxmlLoader.setController(new EventObjectController(eventListController, event));
            try {
                if(event.isRegisteredByUser()) {
                    eventListBox.getChildren().add(fxmlLoader.load());
                }
                else {
                    newEventListBox.getChildren().add(fxmlLoader.load());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void clearDisplays() {
        newEventListBox.getChildren().clear();
        eventListBox.getChildren().clear();
    }

    // Unimportant
    private static Date date;
    private static Timer timer = new Timer();
    private static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    public void startClock() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                date = new Date();
                Platform.runLater(() -> clockDisplay.setText(dateFormat.format(date)));
            }
        },0, 1000);
    }


}