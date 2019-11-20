package com.data.weatherHistory;

import java.util.Collection;
import java.util.Date;

public interface Dao<T> {
  Collection<T> getAll();
  Collection<T> filter(Date minRange, Date maxRange);
}