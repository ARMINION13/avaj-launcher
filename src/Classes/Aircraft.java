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

    class Coordinates {

        private int longitude;
        private int latitute;
        private int height;

        Coordinates(int p_longitute, int p_latitute, int p_height)
        {
            this.longitude = p_longitute;
            this.latitute = p_latitute;
            this.height = p_height;
        }

        public int getLongitute()
        {
            return this.longitude;
        }

        public int getLatitute()
        {
            return this.latitute;
        }

        public int getHeight()
        {
            return this.height;
        }
    }

}