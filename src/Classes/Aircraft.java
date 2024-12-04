package Classes;

public class Aircraft implements Flyable {

    // to do initialize?
    public long id;
    public String name;
    public Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinate)
    {
        //to do
    }

    public void updateConditions()
    {
        //to do
    }

    public void registerTower(WeatherTower p_tower)
    {
        //to do
    }

    class Coordinates {

        //to do initialize?
        private int longitude;
        private int latitute;
        private int height;

        Coordinates(int p_longitute, int p_latitute, int p_height)
        {
            //to do
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