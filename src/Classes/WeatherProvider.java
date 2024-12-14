package Classes;

import java.util.Random;

import Classes.Aircraft.Coordinates;

public class WeatherProvider
{
    //to do initialize?
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private static final WeatherProvider INSTANCE = new WeatherProvider();

    private long seed;

    private WeatherProvider ()
    {
        seed = 0;
    }

    protected void changeSeed()
    {
        seed++;
    }

    protected static WeatherProvider getInstance()
    {
        return INSTANCE;
    }

    public String getCurrentWeather(Coordinates p_coordinates)
    {
        //to do
       return ""; 
    }
}