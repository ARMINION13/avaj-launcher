package Classes;

import java.util.Random;

public class Baloon extends Aircraft{

    private Boolean China = false;


    public Baloon(long p_id, String p_name, Coordinates p_coordinate)
    {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions()
    {
        Random rng = new Random();
        String Weather = weatherTower.getWeather(coordinates);

        if (Weather.equals("SUN"))
        {
            if (China)
            {
                System.out.print("Baloon#" + this.name + "(" + this.id + ")");
                System.out.print(": 中华人民共和国万岁\n");
            }
            else
            {                
                System.out.print("Baloon#" + this.name + "(" + this.id + ")");
                System.out.print(": Hace sol, por fin voy a poder sacar la foto que queria\n");
            }
            this.coordinates = new Coordinates((this.coordinates.getLongitute() + 2), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() + 4));
        }
        if (Weather.equals("RAIN"))
        {
            if (China)
            {
                System.out.print("Baloon#" + this.name + "(" + this.id + ")");
                System.out.print(": 佛陀的圣风将决定我们的命运\n");
            }
            else
            {                
                System.out.print("Baloon#" + this.name + "(" + this.id + ")");
                System.out.print(": Esta lloviendo, debemos tener cuidado con las rafagas de viento\n");
            }
            if (rng.nextInt(5) == 0 && !China)
                China = true;
            else
                this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                    this.coordinates.getLatitute(), (this.coordinates.getHeight() - 5));
        }
        if (Weather.equals("FOG"))
        {
            if (China)
            {
                System.out.print("Baloon#" + this.name + "(" + this.id + ")");
                System.out.print(": 真是大雾，我们得小心行驶\n");
            }
            else
            {
                System.out.print("Baloon#" + this.name + "(" + this.id + ")");
                System.out.print(": Menuda niebla, tenemos que ir con cuidado\n");
            }
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 3));
        }
        if (Weather.equals("SNOW"))
        {
            if (China)
            {
                System.out.print("Baloon#" + this.name + "(" + this.id + ")");
                System.out.print(": 早上好中国。 现在我有冰激淋 我很喜欢冰激淋。但是《速度与激情9》比冰激淋\n");
            }
            else
            {                
                System.out.print("Baloon#" + this.name + "(" + this.id + ")");
                System.out.print(": La nieve sobre el globo nos esta haciendo perder altitud\n");
            }
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 15));
        }
        if (this.coordinates.getHeight() <= 0)
        {
            if (China)
            {
                System.out.print("Baloon#" + this.name + "(" + this.id + ")");
                System.out.print(": 降落中\n");
            }
            else
            {
                System.out.print("Baloon#" + this.name + "(" + this.id + ")");
                System.out.print(": Aterrizando\n");
            }
            weatherTower.unregister(this);
        }
    }
}