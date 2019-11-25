package com.data.weatherHistory;

import java.util.Date;

import com.data.weatherHistory.util.LocalDateConverter;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 */
public class WeatherHistory {

  private int index;

  @CsvBindByPosition(position = 0)
  private String stationName;

  @CsvBindByPosition(position = 1)
  private String province;

  @CsvCustomBindByPosition(position = 2, converter = LocalDateConverter.class)
  private Date date;

  @CsvBindByPosition(position = 3)
  private Float meanTemp;

  @CsvBindByPosition(position = 4)
  private Float highestMonthlyMaxTemp;

  @CsvBindByPosition(position = 5)
  private Float lowestMonthlyMinTemp;

  public int getIndex() {
    return this.index;
  }

  public void setIndex(int index) {
    this.index = index;
  }
  public String getStationName() {
    return this.stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  public String getProvince() {
    return this.province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  @DateTimeFormat(pattern="dd-MMM-YYYY")
  public Date getDate() {
    return this.date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Float getMeanTemp() {
    return this.meanTemp;
  }

  public void setMeanTemp(Float meanTemp) {
    this.meanTemp = meanTemp;
  }

  public Float getHighestMonthlyMaxTemp() {
    return this.highestMonthlyMaxTemp;
  }

  public void setHighestMonthlyMaxTemp(Float highestMonthlyMaxTemp) {
    this.highestMonthlyMaxTemp = highestMonthlyMaxTemp;
  }

  public Float getLowestMonthlyMinTemp() {
    return this.lowestMonthlyMinTemp;
  }

  public void setLowestMonthlyMinTemp(Float lowestMonthlyMinTemp) {
    this.lowestMonthlyMinTemp = lowestMonthlyMinTemp;
  }





}