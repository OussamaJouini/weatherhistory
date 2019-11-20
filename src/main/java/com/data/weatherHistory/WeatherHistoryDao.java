package com.data.weatherHistory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class WeatherHistoryDao implements Dao<WeatherHistory> {

  @Resource(name = "sessionScopedWeatherHistory")
  private List<WeatherHistory> weatherHistoryList = new ArrayList<>();
  @Override
  public Collection<WeatherHistory> getAll() {
    
    return null;
  }

  @Override
  public Collection<WeatherHistory> filter(Date minRange, Date maxRange) {
    // TODO Auto-generated method stub
    return null;
  }
  
}