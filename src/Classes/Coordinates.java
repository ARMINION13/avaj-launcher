package Classes;

public class Coordinates {

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

