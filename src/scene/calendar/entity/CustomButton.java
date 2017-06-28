package scene.calendar.entity;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import scene.calendar.controller.AgendaController;

import java.util.GregorianCalendar;

/**
 * Created by Liu Woon Kit on 31/5/2017.
 */
public class CustomButton extends Button {
    private GregorianCalendar date;
    private AnchorPane content;
    private Label btnLabel = new Label();//, eventLabel = new Label();

    public CustomButton() {
        content = new AnchorPane();
        content.getChildren().add(btnLabel);
        //content.getChildren().add(eventLabel);

        super.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        super.setGraphic(content);
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public void display() {
        btnLabel.setText(null);

        if(date != null) {
            btnLabel.setText(Integer.toString(date.get(GregorianCalendar.DAY_OF_MONTH)));
        }
    }

    public void display(AgendaController agendaController) {
        display();
        super.setOnAction(event -> agendaController.getTimes(date));
    }

    public void suicide() {
        date = null;
        super.setOnAction(event -> {});
        display();
    }
}