package Classes;

public class JetPlane extends Aircraft{

    private Boolean orbita = false;

    public JetPlane(long p_id, String p_name, Coordinates p_coordinate)
    {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions()
    {
        String Weather = weatherTower.getWeather(coordinates);

        if (orbita)
        {
            System.out.print("JetPlane#" + this.name + "(" + this.id + ")");
            System.out.print(": .........(Sonido del espacio).........\n");
        }
        if (Weather.equals("SUN") && !orbita)
        {
            System.out.print("JetPlane#" + this.name + "(" + this.id + ")");
            System.out.print(": Cielo despejado, procedo a ganar altura\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                (this.coordinates.getLatitute() + 10), (this.coordinates.getHeight() + 2));
            if (this.coordinates.getHeight() > 100)
            {
                System.out.print("JetPlane#" + this.name + "(" + this.id + ")");
                System.out.print(": ¡¡MAS POTEENCIAAAAAAAA!!\n");
                orbita = true;
            }
        }
        if (Weather.equals("RAIN") && !orbita)
        {
            System.out.print("JetPlane#" + this.name + "(" + this.id + ")");
            System.out.print(": Nos adentramos en una tormenta, por favor abrochense los cinturones\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 5));
        }
        if (Weather.equals("FOG") && !orbita)
        {
            System.out.print("JetPlane#" + this.name + "(" + this.id + ")");
            System.out.print(": Nos adentramos en un banco de niebla, esperamos indicaciones desde la torre de control\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 3));
        }
        if (Weather.equals("SNOW") && !orbita)
        {
            System.out.print("JetPlane#" + this.name + "(" + this.id + ")");
            System.out.print(": JetPlane#" + this.name + " a torre de control, solicitamos el estado de la pista de aterrizaje debido al riesgo de hielo\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 15));
        }
        if (this.coordinates.getHeight() <= 0)
        {
            System.out.print("JetPlane#" + this.name + "(" + this.id + ")");
            System.out.print(": Aterrizando\n");
            weatherTower.unregister(this);
        }
    }
}