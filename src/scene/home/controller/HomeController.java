package scene.home.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Liu Woon Kit on 7/6/2017.
 */
public class HomeController implements Initializable{
    @FXML
    AnchorPane webPane;

    private final WebView webView = new WebView();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        webView.getEngine().load("http://www.nyp.edu.sg/");
        webView.setPrefSize(1275, 763);
        webPane.getChildren().add(webView);
    }
}
