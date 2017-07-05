package scene.Task

import resources.database.entity.User
import scene.Task.entity.Priority
import scene.Task.entity.Repeat
import scene.Task.entity.Task
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by hhf on 6/29/17.
 */
//save task to database
fun addTask(task_name:String, start: Calendar, end: Calendar, description:String, priority: Priority, list:String, repeat: Repeat, location:String,event:String):Unit{
    val task= Task(task_name, start, end, description, priority, list, repeat, location,event)

}
fun getTaskByEvent(eventName:String){


}
fun getTaskByUser(user:User):ArrayList<Task>{
    val taskData=user.task;
    return taskData;
}

