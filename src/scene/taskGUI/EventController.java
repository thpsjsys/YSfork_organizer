package scene.taskGUI;

import scene.taskGUI.Entity.Event;
import scene.taskGUI.Entity.User;

import java.util.ArrayList;

/**
 * Created by eyoyu on 4/7/2017.
 */
public class EventController{



    public static ArrayList<User> getMember(Event event){
        return User.getMemberDetail(event);

    }
    public static ArrayList<User> getMemberName(Event event){
        return User.getAllMemberName(event);

    }
    public static ArrayList<Event> getEventTitle(Event event){
        return Event.getEventTitle(event);

    }


}
