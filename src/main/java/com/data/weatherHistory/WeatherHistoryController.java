package com.data.weatherHistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherHistoryController {

  @Autowired
  private WeatherHistoryService WeatherHistoryService;

  @GetMapping("/weatherHistory")
  public String weatherHistory(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
    model.addAttribute("name", name);
    return "weather-history-page";
  }

  @GetMapping("/weatherHistory/:id")
  public String weatherHistoryDetails() {
    return "weather-history-detail-page";
  }



}