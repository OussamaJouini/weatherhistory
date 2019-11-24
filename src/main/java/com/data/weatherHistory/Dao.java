package com.data.weatherHistory;

import java.util.ArrayList;
import java.util.Date;

public interface Dao<T> {
  ArrayList<T> getAll();
  ArrayList<T> filter(Date minRange, Date maxRange);
  WeatherHistory get(Integer index);
}