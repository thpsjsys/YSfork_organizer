package scene.Task

import java.util.*

/**
 * Created by hhf on 6/28/17.
 */
enum class Priority{NONE,LOW,MEDIUM,HIGH}
data class Task(var start: GregorianCalendar,var end:GregorianCalendar,var description:String)