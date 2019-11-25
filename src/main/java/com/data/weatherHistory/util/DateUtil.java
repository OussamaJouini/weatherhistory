package com.data.weatherHistory.util;

import java.util.Calendar;
import java.util.Date;

/**
 * DateUtil - Helper methods for date manipulation
 */
public class DateUtil {
  /**
   * Sets the Date to the end of day, needed when filtering by max range date to 
   * ensure that the it's the end of day
   * @param date
   * @return
   */
  public static Date atEndOfDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 999);
    return calendar.getTime();
  }

  /**
   * Sets the date to the start of day, needed when filtering by min range date to
   * ensure that it's the beginning of the day
   * @param date
   * @return
   */
  public static Date atStartOfDay(Date date) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      calendar.set(Calendar.HOUR_OF_DAY, 0);
      calendar.set(Calendar.MINUTE, 0);
      calendar.set(Calendar.SECOND, 0);
      calendar.set(Calendar.MILLISECOND, 0);
      return calendar.getTime();
  }
}