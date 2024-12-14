package Classes;

import Classes.Aircraft.Coordinates;

public class WeatherTower extends Tower {

    //private WeatherProvider wp = WeatherProvider.getInstance();

    public String getWeather(Coordinates p_coordinates)
    {
        return ;
    }

    public void changeWeather()
    {
        wp.changeSeed();
    }
}