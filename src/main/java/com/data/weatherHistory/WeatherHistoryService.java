package com.data.weatherHistory;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component(value = "weatherHistoryService")
public class WeatherHistoryService {

  @Autowired
  private Dao<WeatherHistory> weatherHistoryDao;

  public ArrayList<WeatherHistory> getAllWeatherHistory() {
    return null;
  }

  public WeatherHistory getWeatherHistory() {
    return null;
  }
}