package scene.event.UI;

import com.jfoenix.controls.JFXListView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewEventDetailController implements Initializable{
        @FXML
        private JFXListView<?> taskView;


        @FXML
        private Label evntLabel;

        @FXML
        private JFXListView<?> memberView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
