package scene.event;

import resources.database.DB;
import resources.database.UserAccess;
import scene.event.entity.Event;
import scene.login.entity.User;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Liu Woon Kit on 5/7/2017.
 */
public class EventController {
    private DB db = new DB();

    private User user = (new UserAccess()).getUser();

    public ArrayList<Event> getEvents() {
        ArrayList<Event> eventArrayList = new ArrayList<>();
        CachedRowSet rs = db.read("SELECT e.eventTitle, e.eventID, e.eventDesc, e.dateOfEvent, e.startTime, e.endTime FROM Events e INNER JOIN UserEvents ue ON ue.eventID = e.eventID WHERE e.isApproved=true && ue.userID='" + user.getUserID() + "';");
        try {
            while (rs.next()) {
                eventArrayList.add(new Event(rs.getString("eventTitle"), rs.getInt("eventID"), rs.getString("eventDesc"), rs.getDate("dateOfEvent"), rs.getTime("startTime"), rs.getTime("endTime"), isRegistered(rs.getInt("eventID"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eventArrayList;
    }

    public boolean isRegistered(int eventID) {
        CachedRowSet cachedRowSet = db.read("SELECT eventID, userID FROM UserEvents WHERE userID ='" + user.getUserID() + "' && eventID ='" + eventID + "' ");
        try {
            if (cachedRowSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateEvent(Event event) {
        db.update("UPDATE Events SET ");
    }

    public void updateUserEvent(Event event) {
    }
}