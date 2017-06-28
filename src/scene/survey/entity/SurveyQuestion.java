package scene.survey.entity;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

/**
 * Created by Liu Woon Kit on 12/6/2017.
 */
public class SurveyQuestion extends VBox {
    private int questionType;

    private Label questionLbl = new Label();

    private TextArea answerField = new TextArea();
    private ToggleGroup toggleGroup = new ToggleGroup();

    public SurveyQuestion(int qnNumber, String qn) {
        questionType = 1;

        questionLbl.setText("Q" + qnNumber + ". " + qn);
        super.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        super.getChildren().add(questionLbl);
        super.getChildren().add(answerField);
    }

    public SurveyQuestion(int qnNumber, String qn, String... qnOptions) {
        questionType = 2;

        questionLbl.setText("Q" + qnNumber + ". " + qn);
        super.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
        super.getChildren().add(questionLbl);

        HBox hBox = new HBox();
        for(String s : qnOptions) {
            RadioButton radioButton = new RadioButton(s);
            radioButton.setToggleGroup(toggleGroup);
            hBox.getChildren().add(radioButton);
        }

        super.getChildren().add(hBox);
    }

    public String getAnswer() {
        if(questionType == 1) {
            return answerField.getText();
        }
        else {
            return toggleGroup.getSelectedToggle().getClass().getName();
        }
    }

}
