package scene.event;

import resources.database.DB;
import resources.database.UserAccess;
import scene.event.UI.EventListController;
import scene.event.entity.Event;
import scene.login.entity.User;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Liu Woon Kit on 5/7/2017.
 */
public class EventController {
    private static final String userID = UserAccess.getUser().getUserID();
    private static EventListController eventListController = null;

    public static ArrayList<Event> getEvents() {
        ArrayList<Event> eventArrayList = new ArrayList<>();
        CachedRowSet rs = DB.read("SELECT eventTitle, eventID, eventDesc, dateOfEvent, startTime, endTime FROM Events WHERE isApproved = true;");
        try {
            while (rs.next()) {
                eventArrayList.add(new Event(rs.getString("eventTitle"), rs.getInt("eventID"), rs.getString("eventDesc"), rs.getDate("dateOfEvent"), rs.getTime("startTime"), rs.getTime("endTime"), isRegistered(rs.getInt("eventID"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventArrayList;
    }

    public static boolean isRegistered(int eventID) {
        CachedRowSet cachedRowSet = DB.read("SELECT eventID, userID FROM UserEvents WHERE userID ='" + userID + "' && eventID ='" + eventID + "' ");
        try {
            if (cachedRowSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void update(Event event) {
        if(!event.isRegisteredByUser()) {
            DB.update("DELETE FROM UserEvents WHERE userID = '"+userID+"' && eventID = '"+event.getEventID()+"';");
        }
        else {
            DB.update("INSERT INTO UserEvents VALUES('"+event.getEventID()+"', '"+userID+"');");
        }
        refreshDisplay();
    }

    public static void refreshDisplay() {
        eventListController.displayEvents();
    }

    public static void setEventListController(EventListController e) {
        eventListController = e;
    }

    public static String getOrganizerName(String organizerID) {
        CachedRowSet rs = DB.read("SELECT name FROM User WHERE userID ='"+organizerID+"';");
        try {
            if(rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


}