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
    public User(String adminNo, String school, String string, String email, String name) {
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
}
