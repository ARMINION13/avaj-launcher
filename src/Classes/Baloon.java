package Classes;

public class Baloon extends Aircraft{

    public Baloon(long p_id, String p_name, Coordinates p_coordinate)
    {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions()
    {
        //to improve
        if (weatherTower.getWeather(coordinates) == "SUN")
        {
            System.out.print("Baloon#" + this.name + "(" + this.id + ")");
            System.out.print(": Hace sol, por fin voy a poder sacar la foto que queria\n");
            this.coordinates = new Coordinates((this.coordinates.getLongitute() + 2), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() + 4));
        }
        if (weatherTower.getWeather(coordinates) == "RAIN")
        {
            System.out.print("Baloon#" + this.name + "(" + this.id + ")");
            System.out.print(": Esta lloviendo, devemos tener cuidado con las rafagas de viento\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 5));
        }
        if (weatherTower.getWeather(coordinates) == "FOG")
        {
            System.out.print("Baloon#" + this.name + "(" + this.id + ")");
            System.out.print(": Menuda niebla, tenemos que ir con cuidado\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 3));
        }
        if (weatherTower.getWeather(coordinates) == "SNOW")
        {
            System.out.print("Baloon#" + this.name + "(" + this.id + ")");
            System.out.print(": La nieve sobre el globo nos esta haciendo perder altitud\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 15));
        }
        if (this.coordinates.getHeight() <= 0)
        {
            System.out.print("Baloon#" + this.name + "(" + this.id + ")");
            System.out.print(": Aterrizando\n");
            weatherTower.unregister(this);
        }
    }
}