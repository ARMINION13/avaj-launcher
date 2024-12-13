package Classes;

public class JetPlane extends Aircraft{

    public JetPlane(long p_id, String p_name, Coordinates p_coordinate)
    {
        super(p_id, p_name, p_coordinate);
    }

    public void updateConditions()
    {
        //to improve
        if (weatherTower.getWeather(coordinates) == "SUN")
        {
            System.out.print("JetPlane#" + this.name + "(" + this.id + ")");
            System.out.print(": Estimados pasajeros les informamos de que ya se puede ver su destino desde sus ventanillas\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                (this.coordinates.getLatitute() + 10), (this.coordinates.getHeight() + 2));
        }
        if (weatherTower.getWeather(coordinates) == "RAIN")
        {
            System.out.print("JetPlane#" + this.name + "(" + this.id + ")");
            System.out.print(": Nos adentramos en una tormenta, por favor abrochense los cinturones\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 5));
        }
        if (weatherTower.getWeather(coordinates) == "FOG")
        {
            System.out.print("JetPlane#" + this.name + "(" + this.id + ")");
            System.out.print(": Nos adentramos en un banco de niebla, esperamos indicaciones desde la torre de control\n");
            this.coordinates = new Coordinates(this.coordinates.getLongitute(), 
                this.coordinates.getLatitute(), (this.coordinates.getHeight() - 3));
        }
        if (weatherTower.getWeather(coordinates) == "SNOW")
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