package com.data.weatherHistory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * WeatherHistoryService
 */
@Component(value = "weatherHistoryService")
public class WeatherHistoryService {
  private static final Logger Log = LoggerFactory.getLogger(WeatherHistoryService.class);
  private static final String DATE_FORMAT = "mm/dd/yyyy";

  @Autowired
  private Dao<WeatherHistory> weatherHistoryDao;

  public ArrayList<WeatherHistory> getAll() {
    return weatherHistoryDao.getAll();
  }

  public ArrayList<WeatherHistory> filter(String startTime, String endTime) {
    Log.info("WeatherHistoryService.filter");
    try{
      Date minRange = new SimpleDateFormat(DATE_FORMAT).parse(startTime);
      Date maxRange = new SimpleDateFormat(DATE_FORMAT).parse(endTime);
      return weatherHistoryDao.filter(minRange, maxRange);
    } catch(Exception e) {
      Log.warn(e.getMessage());
      return null;
    }
  }

  public WeatherHistory getWeatherHistory(Integer index) {
    return weatherHistoryDao.get(index);
  }
}