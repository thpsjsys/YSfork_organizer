package scene.Task.entity

import resources.database.DB
import scene.Task.Priority
import scene.Task.Repeat
import java.util.*
import scene.Task.convertDateToString;

/**
 * Created by hhf on 6/28/17.
 */

class Task(var task_name:String, var start: Calendar, var end:Calendar, var description:String, var priority: Priority, var repeat: Repeat, var location:String, var event:String, var user:String){
    fun save():Unit{
        val startDT= convertDateToString(start)
        val endDT= convertDateToString(end)
        val rep=repeat.ordinal;
        val pri=priority.ordinal;


        val query="INSERT INTO task(name,start,end,taskDesc,priority,repeatType,location,eventID,userID) VALUES("+
                                     "'$task_name',$startDT,$endDT,'$description',$pri,$rep,'$location','event','$user')"
        println(query)






        //db.update(query);

    }



}