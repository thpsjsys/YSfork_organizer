package scene.Task.UI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javax.naming.spi.InitialContextFactory;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * Created by hhf on 6/29/17.
 */
public class AddTaskController implements Initializable{
    @FXML
    private JFXTextField task_name_TextField;

    @FXML
    private JFXTextField start_dateTime_TextField;

    @FXML
    private JFXTextField end_dateTime_TextField;

    @FXML
    private JFXTextField priority_TextField;

    @FXML
    private JFXTextField list_TextField;

    @FXML
    private JFXTextField location_TextField;

    @FXML
    private JFXTextField repeat_TextField;

    @FXML
    private JFXButton cancel_button;

    @FXML
    private JFXButton listButton;

    @FXML
    private JFXButton repeat_button;

    @FXML
    private JFXButton priority_button;

    @FXML
    private JFXButton end_button;

    @FXML
    private JFXButton start_button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    @FXML
    void add(ActionEvent event) {
        String task_name=task_name_TextField.getText();
        String start_date_Time=start_dateTime_TextField.getText();
        String end_date_time=end_dateTime_TextField.getText();
        String priority=priority_TextField.getText();
        String list=list_TextField.getText();
        String location=location_TextField.getText();
        String repeat=repeat_TextField.getText();
        //TaskControllerKt.addTask(task_name,start_date_Time,end_date_time,priority,list,location,repeat);
    }
    void cancel(ActionEvent event) {
        //close stage
    }
    //datetime formal   :dd/mm/yyyy hh:mm
    public static Calendar convertToCalendar(String date_time){
        Calendar cal=Calendar.getInstance();
        String[] date_time_Data=date_time.split(" ");
        String[] date=date_time_Data[0].split("/");
        String[] time=date_time_Data[1].split("/");
        cal.set(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));
        /*cal.set(Calendar.HOUR_OF_DAY,Integer.parseInt(time[0]));
        cal.set(Calendar.MINUTE,Integer.parseInt(time[1]));*/
        return cal;

    }


}
