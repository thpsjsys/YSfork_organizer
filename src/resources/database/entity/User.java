package resources.database.entity;

import scene.Task.entity.Priority;
import scene.Task.entity.Repeat;
import scene.Task.entity.Task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Liu Woon Kit on 12/6/2017.
 */
public class User {
    private String userID, name;
    private GregorianCalendar birthDate;
    private String email;
    private int hpNumber;
    private char gender;

    // For debugging
    public User() {

    }

    public User(String userID, String name, GregorianCalendar birthDate, String email, int hpNumber, char gender) {
        this.userID = userID;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
        this.hpNumber = hpNumber;
        this.gender = gender;
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
    public ArrayList<Task> getTask(){
        ArrayList<Task> taskArr=new ArrayList<>();
        for(int i=0;i<20;i++) taskArr.add(new Task("test", Calendar.getInstance(),Calendar.getInstance(),"hello this is test", Priority.LOW,"today", Repeat.DAILY,"hell","1 day to hell"));
        return taskArr;


    }
}