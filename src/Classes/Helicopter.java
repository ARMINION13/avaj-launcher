package Classes;

import java.util.Random;

public class Helicopter extends Aircraft{

    public Helicopter(long p_id, String p_name, Coordinates p_coordinate)
    {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions()
    {
        Random rng = new Random();
        String Weather = weatherTower.getWeather(coordinates);

        if (Weather.equals("SUN"))
        {
            System.out.print("Helicopter#" + this.name + "(" + this.id + ")");
            System.out.print(": Tenemos vista de toda la ciudad desde aqui arriva\n");
            this.coordinates = new Coordinates((this.coordinates.getLongitute() + 10), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() + 2));
        }
        if (Weather.equals("RAIN"))
        {
            System.out.print("Helicopter#" + this.name + "(" + this.id + ")");
            System.out.print(": Se esta colando agua en la cabina\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 5));
        }
        if (Weather.equals("FOG"))
        {
            System.out.print("Helicopter#" + this.name + "(" + this.id + ")");
            System.out.print(": Casi chocamos con un rascacielos debido a la falta de visibilidad\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 1));
        }
        if (Weather.equals("SNOW"))
        {
            System.out.print("Helicopter#" + this.name + "(" + this.id + ")");
            System.out.print(": La nieve y las bajas temperaturas estan congelando las helices\n");
            if (rng.nextInt(7) == 0)
            {
                System.out.print("Helicopter#" + this.name + "(" + this.id + ")");
                System.out.print(": La helice ha dejado de funcionar agarrense a donde puedan\n");
                System.out.print("Helicopter#" + this.name + "(" + this.id + ")");
                System.out.print(": ¡¡BOOOOOOOOOM!!\n");
                weatherTower.unregister(this);
                return;
            }
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