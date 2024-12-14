package Classes;

public class AircraftFactory
{
    private static final AircraftFactory INSTANCE = new AircraftFactory();

    private long aircraft_id;

    private AircraftFactory()
    {
        aircraft_id = 0;
    }

    protected static AircraftFactory getInstance()
    {
        return INSTANCE;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
    {
        Flyable newFlyable = null;

        aircraft_id++;
        if (p_type.equals("Baloon"))
            newFlyable = new Baloon(aircraft_id, p_name, p_coordinates);
        if (p_type.equals("JetPlane"))
            newFlyable = new JetPlane(aircraft_id, p_name, p_coordinates);
        if (p_type.equals("Helicopter"))
            newFlyable = new Helicopter(aircraft_id, p_name, p_coordinates);
        
        return newFlyable;
    }
}