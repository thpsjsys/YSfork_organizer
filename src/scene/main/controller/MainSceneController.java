package scene.main.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Liu Woon Kit on 12/6/2017.
 */
public class MainSceneController implements Initializable{
    @FXML
    private AnchorPane content;

    @Override
    public void initialize(URL location, ResourceBundle resource) {
        Platform.runLater(() -> homeClick());
    }

    @FXML
    void homeClick() {
        try {content.getChildren().setAll((AnchorPane)FXMLLoader.load(getClass().getResource("../../home/Home.fxml")));} catch (IOException e) {}
    }

    @FXML
    void calendarClick(ActionEvent event) {
        try {content.getChildren().setAll((AnchorPane)FXMLLoader.load(getClass().getResource("../../calendar/Calendar.fxml")));} catch (IOException e) {}
    }

    @FXML
    void eventClick(ActionEvent event) {
        try {content.getChildren().setAll((AnchorPane)FXMLLoader.load(getClass().getResource("../../event/EventList.fxml")));} catch (IOException e) {}
    }

    @FXML
    void taskClick(ActionEvent event) {
        try {content.getChildren().setAll((AnchorPane)FXMLLoader.load(getClass().getResource("../../task/Task.fxml")));} catch (IOException e) {}
    }

    @FXML
    void profileClick() {
        try {content.getChildren().setAll((AnchorPane)FXMLLoader.load(getClass().getResource("../../profile/Profile.fxml")));} catch (IOException e) {}
    }

    @FXML
    void logoutClick(ActionEvent event) {
        Stage stage = (Stage) content.getScene().getWindow();
        stage.setUserData(null);
        try {stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../login/Login.fxml"))));} catch (IOException e) {}
    }

    /*private boolean displayStatus = false;
    @FXML
    void sceneSelectorClick(ActionEvent event) {
        int width = 1316;
        if(displayStatus == false) {
            displayStatus = true;
            KeyFrame start = new KeyFrame(Duration.ZERO,
                    new KeyValue(sceneSelector.translateXProperty(), 0));
            KeyFrame end = new KeyFrame(Duration.seconds(0.40),
                    new KeyValue(sceneSelector.translateXProperty(), width + 50));
            Timeline slide = new Timeline(start, end);
            slide.setOnFinished(e -> System.out.println("Done"));
            slide.play();
        }

        else {
            displayStatus = false;
            KeyFrame start = new KeyFrame(Duration.ZERO,
                    new KeyValue(sceneSelector.translateXProperty(), width + 50));
            KeyFrame end = new KeyFrame(Duration.seconds(0.5),
                    new KeyValue(sceneSelector.translateXProperty(), 0));
            Timeline slide = new Timeline(start, end);
            slide.setOnFinished(e -> System.out.println("Done"));
            slide.play();
        }
    }*/
}