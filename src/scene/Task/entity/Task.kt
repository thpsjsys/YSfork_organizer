package scene.Task.entity

import resources.database.DB
import java.util.*

/**
 * Created by hhf on 6/28/17.
 */
enum class Priority{NONE,LOW,MEDIUM,HIGH}
enum class Repeat{DAILY,WEEKLY}
class Task(var task_name:String, var start: Calendar, var end:Calendar, var description:String, var priority: Priority, var list:String, var repeat: Repeat, var location:String,var event:String){
    fun save():Unit{
        val db=DB()
        val query="INSERT INTO task VALUE(\"$task_name\",\"$start\",\"$end\",\"$description\",\"$priority\",\"$list\",\"$repeat,\"$location\",\"$event\")"
        println(query);
        //db.update(query);

    }


}