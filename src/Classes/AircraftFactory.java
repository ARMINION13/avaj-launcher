package Classes;

import Classes.Aircraft.Coordinates;

public class AircraftFactory
{
    private static final AircraftFactory INSTANCE = new AircraftFactory();

    private long aircraft_id;

    private AircraftFactory()
    {
        aircraft_id = 0;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
    {
        Flyable newFlyable;

        aircraft_id++;
        if (p_type == "Baloon")
            newFlyable = new Baloon(aircraft_id, p_name, p_coordinates);
        if (p_type == "JetPlane")
            newFlyable = new JetPlane(aircraft_id, p_name, p_coordinates);
        else
            newFlyable = new Helicopter(aircraft_id, p_name, p_coordinates);
        
        return newFlyable;
    }
}