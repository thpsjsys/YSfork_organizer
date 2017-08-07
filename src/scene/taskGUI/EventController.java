package scene.taskGUI;

import resources.database.DB;
import scene.taskGUI.Entity.Event;
import scene.taskGUI.Entity.User;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by eyoyu on 4/7/2017.
 */
public class EventController{

    public static ArrayList<User> getMemberDetail(Event event){
        ArrayList<User> arr=new ArrayList<>();
        DB db=new DB();

        CachedRowSet rs=db.read("SELECT u.name,school,hpNumber, t.taskDesc from organizer.user u INNER JOIN organizer.eventtask t on u.name=t.name where eventID='"+event+"'");
        if(rs!=null) {
            try {
                while (rs.next()) {
                    User user=new User();
                    user.setName(rs.getString("name"));
                    user.setSchool(rs.getString("school"));
                    user.setHpNumber(rs.getInt("hpNumber"));
                    user.setTask(rs.getString("taskDesc"));
                    arr.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //load data base on event info
        return arr;
    }
    public static User getUserInformation(String id){

        String query="SELECT u.name,school,hpNumber, t.taskDesc from organizer.user u inner join organizer.userevent ue on u.userID=ue.userID INNER JOIN organizer.eventtask t on u.name=t.name where u.userID='"+id+"'";
        DB db=new DB();
        User user=new User();
          CachedRowSet rs=db.read(query);
        if(rs!=null){
            try {
                while (rs.  next()) {
                    user.setName(rs.getString("name"));
                    user.setSchool(rs.getString("school"));
                    user.setHpNumber(rs.getInt("hpNumber"));
                    user.setTask(rs.getString("taskDesc"));
                    return user;
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static ArrayList<User> getMemberName(Event event){
            ArrayList<User> arr=new ArrayList<>();
            DB db=new DB();

            CachedRowSet rs=db.read("SELECT name,u.userID FROM userevent ue " +
                    "inner join user u on ue.userID=u.userID " +
                    "inner join event e on ue.eventID=e.eventID where e.eventID="+event.getEventID());
            try {
                while(rs.next()) {
                    User user=new User();
                    user.setName(rs.getString("name"));
                    user.setUserID(rs.getString("userID"));
                    arr.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //load data base on event info
            return arr;
    }

    public static ArrayList<Event> getEventTitle(Event event){
            ArrayList<Event> arr=new ArrayList<>();
            DB db=new DB();
            CachedRowSet rs=db.read("SELECT * FROM event;");
            try {
                while(rs.next()) {
                    event = new Event(rs.getString("eventTitle"));
                    event.setEventID(rs.getInt("eventID"));
                    arr.add(event);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //load data base on event info
            return arr;
        }
}
