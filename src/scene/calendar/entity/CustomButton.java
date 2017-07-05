package scene.calendar.entity;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.GregorianCalendar;

/**
 * Created by Liu Woon Kit on 31/5/2017.
 */
public class CustomButton extends Button {
    //private DB db = new DB();
    //private AgendaController agendaController;

    private GregorianCalendar date;
    private AnchorPane content;

    private Label dateLabel = new Label();
    //private Label eventLabel = new Label();
    //private Label taskLabel = new Label();

    public CustomButton() {
        super();

        content = new AnchorPane();
        content.getChildren().add(dateLabel);
        //content.getChildren().add(eventLabel);
        //content.getChildren().add(taskLabel);

        super.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        super.setGraphic(content);
    }

    /*public CustomButton(AgendaController agendaController) {
        this.agendaController = agendaController;
        //db.read("SELECT * FROM userEvents WHERE userID = '"+content.getScene().getWindow().getUserData().getUserID()+"'");
        content = new AnchorPane();
        content.getChildren().add(dateLabel);
        //content.getChildren().add(eventLabel);

        super.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        super.setGraphic(content);
    }*/

    public void setDateLbl(GregorianCalendar date) {
        this.date = date;
        dateLabel.setText(Integer.toString(date.get(GregorianCalendar.DAY_OF_MONTH)));
    }

    /*public GregorianCalendar getDate() {
        return date;
    }*/

    public void display() {
        //super.setOnAction(event -> agendaController.getTimes(date));
        dateLabel.setText(Integer.toString(date.get(GregorianCalendar.DAY_OF_MONTH)));
    }

    /*public void display() {
        super.setOnAction(event -> agendaController.getTimes(date));
        dateLabel.setText(Integer.toString(date.get(GregorianCalendar.DAY_OF_MONTH)));
    }*/

    public void suicide() {
        dateLabel.setText(null);
        //eventLabel.setText(null);
        //taskLabel.setText(null);
        super.setOnAction(null);
    }
}