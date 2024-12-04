package Classes;

import Classes.Aircraft.Coordinates;

public class AircraftFactory
{
    //to do initialize?
    private static final AircraftFactory INSTANCE = new AircraftFactory();

    private AircraftFactory()
    {
        //to do
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
    {
        //to do
        return ;
    }
}