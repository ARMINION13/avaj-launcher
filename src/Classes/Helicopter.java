package Classes;

public class Helicopter extends Aircraft{

    public Helicopter(long p_id, String p_name, Coordinates p_coordinate)
    {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions()
    {
        //to improve
        if (weatherTower.getWeather(coordinates) == "SUN")
        {
            System.out.print("Helicopter#" + this.name + "(" + this.id + ")");
            System.out.print(": Tenemos vista de toda la ciudad desde aqui arriva\n");
            this.coordinates = new Coordinates((this.coordinates.getLongitute() + 10), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() + 2));
        }
        if (weatherTower.getWeather(coordinates) == "RAIN")
        {
            System.out.print("Helicopter#" + this.name + "(" + this.id + ")");
            System.out.print(": Se esta colando agua en la cabina\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 5));
        }
        if (weatherTower.getWeather(coordinates) == "FOG")
        {
            System.out.print("Helicopter#" + this.name + "(" + this.id + ")");
            System.out.print(": Casi chocamos con un rascacielos debido a la falta de visibilidad\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 1));
        }
        if (weatherTower.getWeather(coordinates) == "SNOW")
        {
            System.out.print("Helicopter#" + this.name + "(" + this.id + ")");
            System.out.print(": La nieve y las bajas temperaturas estan congelando las elices\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 12));
        }
        if (this.coordinates.getHeight() <= 0)
        {
            System.out.print("Helicopter#" + this.name + "(" + this.id + ")");
            System.out.print(": Aterrizando\n");
            weatherTower.unregister(this);
        }
    }
}