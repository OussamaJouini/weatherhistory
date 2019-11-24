package com.data.weatherHistory;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "weatherHistoryService")
public class WeatherHistoryService {

  @Autowired
  private Dao<WeatherHistory> weatherHistoryDao;

  public ArrayList<WeatherHistory> getAll() {
    return weatherHistoryDao.getAll();
  }

  public WeatherHistory getWeatherHistory(Integer index) {
    return weatherHistoryDao.get(index);
  }
}