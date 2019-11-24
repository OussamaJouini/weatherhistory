package com.data.weatherHistory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "weatherHistoryService")
public class WeatherHistoryService {
  private static final String DATE_FORMAT = "mm/dd/yyyy";

  @Autowired
  private Dao<WeatherHistory> weatherHistoryDao;

  public ArrayList<WeatherHistory> getAll() {
    return weatherHistoryDao.getAll();
  }

  public ArrayList<WeatherHistory> filter(String startTime, String endTime) {
    try{
      Date minRange = new SimpleDateFormat(DATE_FORMAT).parse(startTime);
      Date maxRange = new SimpleDateFormat(DATE_FORMAT).parse(endTime);
      return weatherHistoryDao.filter(minRange, maxRange);
    } catch(Exception e) {
      return null;
    }
  }

  public WeatherHistory getWeatherHistory(Integer index) {
    return weatherHistoryDao.get(index);
  }
}