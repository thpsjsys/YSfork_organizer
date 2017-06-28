package scene.profile.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import resources.database.entity.User;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Liu Woon Kit on 28/6/2017.
 */
public class ProfileController implements Initializable {

    private User user;
    private String email, password;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextField emailField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        user = (User) passwordField.getScene().getWindow().getUserData();
        emailField.setText(user.getEmail());
    }


}
