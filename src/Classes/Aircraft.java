package Classes;

public class Aircraft extends Flyable {

    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate)
    {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    public void updateConditions()
    {

    }

    public void registerTower(WeatherTower p_tower)
    {
        this.weatherTower = p_tower;               
    }

}