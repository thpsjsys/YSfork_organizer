package scene.profile.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Liu Woon Kit on 28/6/2017.
 */
public class ProfileController implements Initializable {
    @FXML
    private Label username;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextField emailField;

    //private User user = (User)username.getScene().getWindow().getUserData();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //username.setText(user.getName());
        //emailField.setText(user.getEmail());
    }


}
