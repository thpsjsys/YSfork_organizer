package scene.event.UI;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import scene.event.EventController;
import scene.event.entity.Event;

import java.net.URL;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

/**
 * Created by Liu Woon Kit on 29/6/2017.
 */
public class EventViewController implements Initializable {
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
        setButtonLabel();
    }

    public EventViewController(Event event) {
        this.event = event;
    }

    public void setButtonLabel() {
        if(event.isRegisteredByUser()) {
            buttonAction.setText("UNJOIN");
        }
        else
            buttonAction.setText("JOIN");
    }

    @FXML
    void actionTrigger() {
        event.setRegisteredByUser(!event.isRegisteredByUser());
        setButtonLabel();
        EventController.update(event);
    }
}