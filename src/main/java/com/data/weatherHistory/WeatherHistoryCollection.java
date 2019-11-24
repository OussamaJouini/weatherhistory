package com.data.weatherHistory;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

public class WeatherHistoryCollection {

  private static final String CSV_FILE_PATH = "src"+ File.separator + "eng-climate-summary.csv";

  @Bean
  @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
  public ArrayList<WeatherHistory> sessionScopedWeatherHistory() {
    return parseData();
  }

  public ArrayList<WeatherHistory> parseData() {
    try ( 
      Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
     
    ) {
      CsvToBean<WeatherHistory> csvToBean = new CsvToBeanBuilder<WeatherHistory>(reader)
        .withType(WeatherHistory.class)
        .withSkipLines(1)
        .withIgnoreLeadingWhiteSpace(true)
        .build();

      return (ArrayList<WeatherHistory>)csvToBean.parse();
    } catch(Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}