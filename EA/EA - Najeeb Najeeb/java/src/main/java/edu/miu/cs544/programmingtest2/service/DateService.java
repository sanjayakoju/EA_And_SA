package edu.miu.cs544.programmingtest2.service;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;

public class DateService {

    private int SATURDAY= 7;
    private int SUNDAY= 1;

    public int getDayNumber() {
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        return  calendar.get(Calendar.DAY_OF_WEEK);
    }

    public boolean isTodayWeekend() {
        int dayNumber= getDayNumber();
        if ((dayNumber == SATURDAY) || (dayNumber == SUNDAY)) {
            return true;
        }
        return false;
    }
}
