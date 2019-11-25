package com.data.weatherHistory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeatherHistoryServiceTest {

    @Autowired
    WeatherHistoryService weatherHistoryService;

    @DisplayName("Test get all weather histories")
    @Test
    void testGetAll() {
        assertEquals(true, weatherHistoryService.getAll().size() > 0);
    }

    @DisplayName("Test get single weather history by index")
    @Test
    void testGetWeatherHistory() {
        assertEquals(true, weatherHistoryService.getWeatherHistory(0) != null);
    }
    
    @DisplayName("Test get filter by min and max date range")
    @Test
    void testFilter() {
      assertEquals(true, weatherHistoryService.filter("01/04/2018", "01/04/2018").size() > 0);
    }
}