package scene.event.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import resources.database.DB;
import scene.event.entity.Event;

import java.net.URL;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

/**
 * Created by Liu Woon Kit on 29/6/2017.
 */
public class EventViewController implements Initializable {
    private EventListController eventListController;
    private DB db = new DB();
    private Event event;

    @FXML
    private Label eventTitle;

    @FXML
    private Label eventOrganizer;

    @FXML
    private Label eventDate;

    @FXML
    private Label eventLocation;

    @FXML
    private Label eventDesc;

    @FXML
    private JFXButton buttonAction;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        eventTitle.setText(event.getEventTitle());
        eventOrganizer.setText("Organized by: " + "");
        eventDesc.setText(event.getEventDesc());
        eventDate.setText(event.getDateOfEvent().get(GregorianCalendar.DAY_OF_MONTH) + "/" + event.getDateOfEvent().get(GregorianCalendar.MONTH) + "/" + event.getDateOfEvent().get(GregorianCalendar.YEAR));
        eventLocation.setText("Marina Bay 8231");
    }

    public EventViewController(EventListController eventListController, Event event) {
            this.eventListController = eventListController;
        this.event = event;
    }

    @FXML
    void actionTrigger() {
        eventListController.clearDisplays();
    }
}