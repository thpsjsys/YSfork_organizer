package scene.login.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import resources.database.entity.User;

// awt for app to browser bridge
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private JFXTextField userIDField;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    void forgotPassword(ActionEvent event) {
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(new URI("https://cfapps.nyp.edu.sg/CF/SIMS/ResetPin/pin_reset_form.cfm"));
        } catch (IOException | URISyntaxException e) {}
    }

    @FXML
    void loginClick(ActionEvent event) {
        // Verify login
        User user = new User();// = new UserDA().checkLogin(userIDField.getText(), passwordField.getText());
        if(user == null) {
            // Error
            return;
        }

        // Continue to main scene
        Parent root= null;
        try {root = FXMLLoader.load(getClass().getResource("../../main/MainScene_2.fxml"));} catch (IOException e) {}

        Scene scene=new Scene(root);
        Stage stage = (Stage)((Node)event.getTarget()).getScene().getWindow();

        stage.hide();
        stage.setScene(scene);

        stage.setUserData(user);

        // Work around for setResizable bug
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();

        stage.show();
    }
}