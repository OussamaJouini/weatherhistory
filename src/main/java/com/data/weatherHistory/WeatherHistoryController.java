package com.data.weatherHistory;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * WeatherHistoryController
 */
@Controller
public class WeatherHistoryController {
  private static final Logger Log = LoggerFactory.getLogger(WeatherHistoryController.class);
 
  @Autowired
  private WeatherHistoryService WeatherHistoryService;

  @GetMapping("/weatherHistory")
  public String weatherHistory(@RequestParam(name="startTime", required=false) String startTime, @RequestParam(name="endTime", required=false) String endTime, Model model) {
    Log.info("GET /weatherHistory");
    ArrayList<WeatherHistory> weatherHistoryList = new ArrayList<WeatherHistory>();
    if (startTime != null && startTime.length() > 0 && endTime != null && endTime.length() > 0) {
      weatherHistoryList = WeatherHistoryService.filter(startTime, endTime);
    } else {
      weatherHistoryList = WeatherHistoryService.getAll();
    }
    model.addAttribute("weatherHistories", weatherHistoryList);
    return "weather-history-page";
  }
  
  /**
   * 
   * @param id
   * @param model
   * @return
   */
  @GetMapping("/weatherHistory/{id}")
  public String weatherHistoryDetails(@PathVariable String id, Model model) {
    Log.info("GET /weatherHistory/:id");
    try {
      Integer index = Integer.parseInt(id);
      model.addAttribute("weatherHistory", WeatherHistoryService.getWeatherHistory(index));
      return "weather-history-detail-page";
    } catch (NumberFormatException e) {
      model.addAttribute("errorCode", "400 Bad Request");
      model.addAttribute("errorMessage", "Invalid path variable id");
      return "error";
    }
  }
}