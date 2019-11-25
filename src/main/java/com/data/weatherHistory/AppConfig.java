package com.data.weatherHistory;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for the session scoped WeatherHistoryCollection 
 */
@Configuration
public class AppConfig {

  @Bean
  public ArrayList<WeatherHistory> sessionScopedWeatherHistory() {
    return new WeatherHistoryCollection().parseData();
  }
}