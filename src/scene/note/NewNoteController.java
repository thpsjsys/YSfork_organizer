package scene.note;

import scene.note.entity.Note;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class NewNoteController implements Initializable{

    @FXML
    private Button saveButton;

    @FXML
    private ImageView pinImage;

    @FXML
    private TextField title;

    @FXML
    private TextArea content;

    private boolean isPined;

    private String currentGroup;

    private Image unpinnedImage;

    private Image pinnedImage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        isPined = false;
        pinnedImage=new Image(getClass().getResourceAsStream("../../resources/images/pinned.png"));
        unpinnedImage=new Image(getClass().getResourceAsStream("../../resources/images/pin.png"));
    }

    @FXML
    void save(ActionEvent event) {
        Note n = new Note(currentGroup, title.getText(), content.getText(),isPined);
        n.storeData();
        Stage currentWindow = (Stage) saveButton.getScene().getWindow();
        currentWindow.close();
    }

    @FXML
    void pinPressed(ActionEvent event) {

        isPined=!isPined;
        displayPin();
    }

    public void setCurrentGroup(String currentGroup) {
        this.currentGroup = currentGroup;
    }

    public void displayPin(){
        if(isPined){
            pinImage.setImage(pinnedImage);
        }else{
            pinImage.setImage(unpinnedImage);
        }
    }
}
