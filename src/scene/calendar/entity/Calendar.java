package scene.calendar.entity;

import java.util.GregorianCalendar;

/**
 * Created by Liu Woon Kit on 23/11/2016.
 */
public class Calendar {
    private GregorianCalendar date = new GregorianCalendar();

    private final String[] monthOfYear = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    private final int CURRENT_DAY = date.get(GregorianCalendar.DAY_OF_MONTH);
    private final int CURRENT_MONTH = date.get(GregorianCalendar.MONTH);
    private final int CURRENT_YEAR = date.get(GregorianCalendar.YEAR);

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public String[] getMonthOfYear() {
        return monthOfYear;
    }

    public int getCURRENT_DAY() {
        return CURRENT_DAY;
    }

    public int getCURRENT_MONTH() {
        return CURRENT_MONTH;
    }

    public int getCURRENT_YEAR() {
        return CURRENT_YEAR;
    }

    public int getSelectedDay() {
        return date.get(GregorianCalendar.DAY_OF_MONTH);
    }

    public int getSelectedMonth() {
        return date.get(GregorianCalendar.MONTH);
    }

    public int getSelectedYear() {
        return date.get(GregorianCalendar.YEAR);
    }

    public int getFirstDayOfWeek() {
        date.set(GregorianCalendar.DAY_OF_MONTH, 1);
        return date.get(GregorianCalendar.DAY_OF_WEEK);
    }

    public int getMaxDaysOfMonth() {
        return date.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
    }

    public String toString() {
        return monthOfYear[date.get(GregorianCalendar.MONTH)] + " " + date.get(GregorianCalendar.YEAR);
    }

    public void manipulateMth(int i) {
        date.add(GregorianCalendar.MONTH, i);
    }
}