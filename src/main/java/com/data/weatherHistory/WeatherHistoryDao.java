package com.data.weatherHistory;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.Resource;

import com.data.weatherHistory.util.DateUtil;

import org.springframework.stereotype.Component;

/**
 * WeatherHistoryDao
 * The interaction with the session scoped collection is handled at this layer.
 */
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
    long minTime = DateUtil.atStartOfDay(minRange).getTime();
    long maxTime = DateUtil.atEndOfDay(maxRange).getTime();

    ArrayList<WeatherHistory> filteredList = new ArrayList<>();

    Iterator<WeatherHistory> iterator = weatherHistoryCollection.iterator();
    while(iterator.hasNext()) {
      WeatherHistory weatherHistory = iterator.next();
      if(weatherHistory.getDate().getTime() >= minTime && 
        weatherHistory.getDate().getTime() <= maxTime) {
          filteredList.add(weatherHistory);
      }
    }
    return filteredList;
  }

  @Override
  public WeatherHistory get(Integer index) {
    return weatherHistoryCollection.get(index);
  }
}