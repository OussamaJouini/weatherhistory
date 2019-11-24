package com.data.weatherHistory;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class WeatherHistoryDao implements Dao<WeatherHistory> {

  @Resource(name = "sessionScopedWeatherHistory")
  private ArrayList<WeatherHistory> weatherHistoryCollection;

  @Override
  public ArrayList<WeatherHistory> getAll() {
    return weatherHistoryCollection;
  }

  @Override
  public ArrayList<WeatherHistory> filter(Date minRange, Date maxRange) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public WeatherHistory get(Integer index) {
    return weatherHistoryCollection.get(index);
  }

  
  
}