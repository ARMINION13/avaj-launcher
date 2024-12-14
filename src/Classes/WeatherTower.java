package Classes;

import java.util.*;

public class WeatherTower extends Tower {

    private Map<String, String> weatherMap = new HashMap<>();

    public String getWeather(Coordinates p_coordinates)
    {
        String coordinates = p_coordinates.getLongitute() + " " + p_coordinates.getLatitute() + " "
            + p_coordinates.getHeight();
        if (weatherMap.containsKey(coordinates))
            return weatherMap.get(coordinates);
        else
        {
            weatherMap.put(coordinates, (WeatherProvider.getInstance()).getCurrentWeather(p_coordinates));
            return weatherMap.get(coordinates);
        }
    }

    public void changeWeather()
    {
        weatherMap.clear();
        conditionChanged();
    }
}