package scene.taskGUI.Entity;
import resources.database.DB;
import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;


/**
 * Created by eyoyu on 4/7/2017.
 */
public class User {
    private String userID, name,task,school;
    private GregorianCalendar birthDate;
    private String email;
    private int hpNumber;
    private char gender;

    // For debugging

    public User() {
    }
    public User(String name) {
        this.name = name;
    }
    public User(String name,String school,int hpNumber,String task) {
        this.name = name;
        this.school=school;
        this.hpNumber = hpNumber;
        this.task=task;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHpNumber() {
        return hpNumber;
    }

    public void setHpNumber(int hpNumber) {
        this.hpNumber = hpNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public static ArrayList<User> getAllMemberName(Event event){
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
    public static ArrayList<User> getMemberDetail(Event event){
        ArrayList<User> arr=new ArrayList<>();
        DB db=new DB();

        CachedRowSet rs=db.read("SELECT u.name,school,hpNumber, t.taskDesc from organizer.user u INNER JOIN organizer.task t on u.name=t.name where eventID='"+event+"'");
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

        String query="SELECT u.name,school,hpNumber, t.taskDesc from organizer.user u inner join organizer.userevent ue on u.userID=ue.userID INNER JOIN organizer.task t on u.name=t.name where u.userID='"+id+"'";
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
}
