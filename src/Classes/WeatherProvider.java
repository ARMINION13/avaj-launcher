package Classes;

import java.util.Random;

public class WeatherProvider
{
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private static final WeatherProvider INSTANCE = new WeatherProvider();

    private WeatherProvider ()
    {

    }

    protected static WeatherProvider getInstance()
    {
        return INSTANCE;
    }


    public String getCurrentWeather(Coordinates p_coordinates)
    {
        Random rng = new Random();
        return weather[rng.nextInt(4)];
    }
}