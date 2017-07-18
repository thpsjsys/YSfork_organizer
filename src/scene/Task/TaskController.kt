package scene.Task

import resources.database.entity.User

import scene.Task.entity.Task
import scene.event.entity.Event
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by hhf on 6/29/17.
 */
//save task to database
enum class Priority{NONE,LOW,MEDIUM,HIGH

}
enum class Repeat{NONE,DAILY,WEEKLY}
fun getMember(task:Task){

}
fun addTask(task_name:String, start: String, end: String, description:String, priorityInt: Int,repeatInt: Int, location:String,event:String,user:String){
    val task= Task(task_name,
            convertStringToDate(start),
            convertStringToDate(end),
            description,
            intToPriority(priorityInt),
            intToRepeat(repeatInt),
            location,
            event,
            user)
    task.save()

}
fun getTaskByEvent(event: Event){


}
fun getTaskByUser(user:User):ArrayList<Task>{
    val taskData=user.task;
    return taskData;
}
//datetime formal   :dd/mm/yyyy hh:mm
fun convertStringToDate(dateTime:String):Calendar{
    //[0] date [1]time
    val data=dateTime.split(" ");
    val dateString=data.get(0).split("/");
    val timeString=data.get(1).split(":")
    val date=Calendar.getInstance();
    date.set(Integer.parseInt(dateString.get(2)),
            Integer.parseInt(dateString.get(1))-1,
            Integer.parseInt(dateString.get(0)),
            Integer.parseInt(timeString.get(0)),
            Integer.parseInt(timeString.get(1)))
    date.set(Calendar.SECOND,0);
    return date
}
fun convertDateToString(date:Calendar):String{
    val year=date.get(Calendar.YEAR)
    val month=date.get(Calendar.MONTH)+1;
    val day=date.get(Calendar.DATE)
    val hour=date.get(Calendar.HOUR_OF_DAY)
    val minutes=date.get(Calendar.MINUTE)
    return "$year/$month/$day $hour:$minutes"
}
fun convertDateToStringYearAtEnd(date:Calendar):String{
    val year=date.get(Calendar.YEAR)
    val month=date.get(Calendar.MONTH)+1;
    val day=date.get(Calendar.DATE)
    val hour=date.get(Calendar.HOUR_OF_DAY)
    val minutes=date.get(Calendar.MINUTE)
    return "$day/$month/$year $hour:$minutes"
}

fun intToPriority(value:Int):Priority{
    when(value){
        1->return Priority.LOW
        2->return Priority.MEDIUM
        3->return Priority.HIGH
    }
    return Priority.NONE;
}
fun priorityToInt(priority: Priority)=priority.ordinal;
fun repeatToInt(repeat: Repeat)=repeat.ordinal;
fun intToRepeat(value:Int):Repeat{
    when(value){
        1-> return Repeat.DAILY
        2->return Repeat.WEEKLY
    }
    return Repeat.NONE;

}

