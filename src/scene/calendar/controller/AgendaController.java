package scene.calendar.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

/**
 * Created by Liu Woon Kit on 13/6/2017.
 */
public class AgendaController implements Initializable {
    @FXML
    AnchorPane eventsPane;

    @FXML
    GridPane agendaGrid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(int i = 0; i < 24; i++) {
            AnchorPane anchorPane = new AnchorPane();
            agendaGrid.add(anchorPane, 0, i);
            anchorPane.setPrefSize(Integer.MAX_VALUE, Integer.MAX_VALUE);

            if(i == 0)
                anchorPane.setStyle("-fx-border-color: white");
            else
                anchorPane.setStyle("-fx-border-color: transparent white white white");
        }
    }

    public void getTimes(GregorianCalendar date) {
        this.clearAgenda();
        insertTime(1000, 1200, "Do coding");
        /*ResultSet rs = null;
        try {
            while(rs.next()) {
                insertTime(Double.valueOf(String.valueOf(rs.getTime("startTime"))), Double.valueOf(String.valueOf(rs.getTime("endTime"))), rs.getString("eventName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public void insertTime(double startTime, double endTime, String eventName) {
        if(startTime < 0)
            startTime = 1;
        if(endTime > 2459)
            endTime = 2459;

        // Get last 2 digits
        double startTimeMinutes = (startTime % 100) / 1.2;
        double endTimeMinutes = (endTime % 100) / 1.2;

        startTime = (startTime - (startTime % 100)) / 2.0;
        startTime += startTimeMinutes;

        endTime = (endTime - (endTime % 100)) / 2.0;
        endTime += endTimeMinutes;

        System.out.println();

        //double x = eventsPane.getLayoutX();

        Button btn = new Button(eventName);
        btn.setLayoutX(10);
        //System.out.println("Layout Y: " + startTime);
        btn.setLayoutY(startTime);
        btn.setMinSize((eventsPane.getWidth()/2),endTime - startTime);
        //System.out.println("Height: " + (endTime - startTime));

        eventsPane.getChildren().add(btn);

        btn.setOnAction(event -> {
            //System.out.println("Hello");
        });
    }

    public void clearAgenda() {
        eventsPane.getChildren().clear();
    }
}