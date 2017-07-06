package scene.event.entity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

/**
 * Created by Liu Woon Kit on 12/6/2017.
 */
public class Event {
    private String eventTitle;
    private int eventID;
    private String eventDesc;
    private GregorianCalendar dateOfEvent;
    private Time startTime;
    private Time endTime;
    private boolean isApproved;
    private boolean isRegisteredByUser;

    public Event(String eventTitle, int eventID, String eventDesc, Date dateOfEvent, Time startTime, Time endTime) {
        this.eventTitle = eventTitle;
        this.eventID = eventID;
        this.eventDesc = eventDesc;
        this.dateOfEvent = new GregorianCalendar();
        this.dateOfEvent.setTime(dateOfEvent);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Event(String eventTitle, int eventID, String eventDesc, Date dateOfEvent, Time startTime, Time endTime, boolean isRegisteredByUser) {
        this.eventTitle = eventTitle;
        this.eventID = eventID;
        this.eventDesc = eventDesc;
        this.dateOfEvent = new GregorianCalendar();
        this.dateOfEvent.setTime(dateOfEvent);
        this.startTime = startTime;
        this.endTime = endTime;
        this.isRegisteredByUser = isRegisteredByUser;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public GregorianCalendar getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(GregorianCalendar dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public boolean isRegisteredByUser() {
        return isRegisteredByUser;
    }

    public void setRegisteredByUser(boolean registeredByUser) {
        isRegisteredByUser = registeredByUser;
    }
}