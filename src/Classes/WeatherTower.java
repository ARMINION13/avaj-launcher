package Classes;

import Classes.Aircraft.Coordinates;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates p_coordinates)
    {
        //to fix probably
        return p_coordinates.getLongitute() + " " + p_coordinates.getLatitute() + " " + p_coordinates.getHeight();
    }

    public void changeWeather()
    {
        //to do
    }
}