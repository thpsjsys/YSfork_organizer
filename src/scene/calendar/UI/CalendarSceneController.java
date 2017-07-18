package scene.calendar.UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import scene.calendar.entity.CustomButton;
import scene.calendar.entity.CustomCalendar;

import java.io.IOException;
import java.net.URL;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

/**
 * Created by Liu Woon Kit on 23/5/2017.
 */
public class CalendarSceneController implements Initializable {
    // Database
    //private DB db = new DB();

    // Calendar
    private CustomCalendar calendar = new CustomCalendar();
    private final Label DAY_LABEL[] = {new Label("SUNDAY"), new Label("MONDAY"), new Label("TUESDAY"), new Label("WEDNESDAY"), new Label("THURSDAY"), new Label("FRIDAY"), new Label("SATURDAY")};
    private final CustomButton[] CALENDAR_BUTTON = new CustomButton[42];

    // Agenda
    private FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Agenda.fxml"));
    private AgendaController agendaController = new AgendaController();

    @FXML
    GridPane calGrid;

    @FXML
    Button modeDisplay;

    //Button dateDisplay;

    @FXML
    AnchorPane agendaPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Agenda
        fxmlLoader.setController(agendaController);
        try {agendaPane.getChildren().setAll((AnchorPane)fxmlLoader.load());} catch (IOException e) {}

        // Calendar
        populateGrid();
        dateSelector();
    }

    public void dateSelector() {
        //modeDisplay.setText(calendar.toString());
        modeDisplay.setText(calendar.formatDate("MMMM YYYY"));

        int startPoint = calendar.getFirstDayOfFirstWeek() - 1;
        int endPoint = startPoint + calendar.getMaxDaysInMonth();

        for(int i = 1; startPoint < endPoint; i++,startPoint++) {
            CustomButton customButton = CALENDAR_BUTTON[startPoint];
            GregorianCalendar gregorianCalendar = new GregorianCalendar(calendar.getSelectedYear(), calendar.getSelectedMonth(), i);

            customButton.setDateLbl(gregorianCalendar);
            customButton.setOnAction(event -> agendaController.getTimes(gregorianCalendar));
            //customButton.display();
        }

        /*for(int i = calendar.getFirstDayOfFirstWeek(); i < calendar.getMaxDaysInMonth() +  calendar.getFirstDayOfFirstWeek(); i++) {
            CALENDAR_BUTTON[i - 1].setDate(new GregorianCalendar(calendar.getSelectedYear(), calendar.getSelectedMonth(), i - calendar.getFirstDayOfFirstWeek() + 1));
            CALENDAR_BUTTON[i - 1].display();
        }*/
    }

    public void populateGrid() {
        // Set labels for first row
        for (int i = 0; i < 7; i++) {
            calGrid.add(DAY_LABEL[i], i, 0);
            DAY_LABEL[i].setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            //DAY_LABEL[i].setAlignment(Pos.BASELINE_LEFT);
            DAY_LABEL[i].getStylesheets().add(getClass().getResource("../../../resources/fonts/Roboto-Medium.css").toExternalForm());
        }

        // Fill remaining grid cells with CustomButtons
        int x = 0, y = 1;
        for (int i = 0; i <= 41; i++) {
            if (x >= 7) {
                x = 0;
                y++;
            }
            calGrid.add(CALENDAR_BUTTON[i] = new CustomButton(), x, y);
            x++;
        }
    }

    @FXML
    void previousMth(ActionEvent event) {
        calendar.manipulateMth(-1);
        clearGrid();
    }

    @FXML
    void nextMth(ActionEvent event) {
        calendar.manipulateMth(+1);
        clearGrid();
    }

    public void clearGrid() {
        for(CustomButton customButton : CALENDAR_BUTTON) {
            customButton.suicide();
        }
        dateSelector();
    }
}