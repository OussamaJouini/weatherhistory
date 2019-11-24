package com.data.weatherHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherHistoryController {

  @Autowired
  private WeatherHistoryService WeatherHistoryService;

  @GetMapping("/weatherHistory")
  public String weatherHistory(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    model.addAttribute("weatherHistories", WeatherHistoryService.getAll());
    return "weather-history-page";
  }

  @GetMapping("/weatherHistory/{id}")
  public String weatherHistoryDetails(@PathVariable String id, Model model) {
    try {
      Integer index = Integer.parseInt(id);
      model.addAttribute("weatherHistory", WeatherHistoryService.getWeatherHistory(index));
      return "weather-history-detail-page";
    } catch (NumberFormatException e) {
      return "error";
    }
  }



}