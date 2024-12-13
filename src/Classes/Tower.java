package Classes;

import java.util.*;

public class Tower {

    private List<Flyable> observers;

    public void register(Flyable p_flyable)
    {
        if (p_flyable instanceof Helicopter)
        {
            Helicopter helicopter = (Helicopter)p_flyable;
            if (this.observers.add(helicopter))
                return ;
            System.out.print("Tower says: " + helicopter.name + "#" + helicopter.id + "(" + (observers.size() + 1) + ")" + " registered to weather tower\n");
        }
        if (p_flyable instanceof Baloon)
        {
            Baloon baloon = (Baloon)p_flyable;
            if (this.observers.add(baloon))
                return ;
            System.out.print("Tower says: " + baloon.name + "#" + baloon.id + "(" + (observers.size() + 1) + ")" + " registered to weather tower\n");
        }
        if (p_flyable instanceof JetPlane)
        {
            JetPlane jetPlane = (JetPlane)p_flyable;
            if (this.observers.add(jetPlane))
                return ;
            System.out.print("Tower says: " + jetPlane.name + "#" + jetPlane.id + "(" + (observers.size() + 1) + ")" + " registered to weather tower\n");
        }
    }

    public void unregister(Flyable p_flyable)
    {
        if (p_flyable instanceof Helicopter)
        {
            Helicopter helicopter = (Helicopter)p_flyable;
            if (this.observers.remove(helicopter))
                return ;
            System.out.print("Tower says: " + helicopter.name + "#" + helicopter.id + "(" + (observers.size() + 1) + ")" + " unregistered from weather tower\n");
        }
        if (p_flyable instanceof Baloon)
        {
            Baloon baloon = (Baloon)p_flyable;
            if (this.observers.remove(baloon))
                return ;
            System.out.print("Tower says: " + baloon.name + "#" + baloon.id + "(" + (observers.size() + 1) + ")" + " unregistered from weather tower\n");
        }
        if (p_flyable instanceof JetPlane)
        {
            JetPlane jetPlane = (JetPlane)p_flyable;
            if (this.observers.remove(jetPlane))
                return ;
            System.out.print("Tower says: " + jetPlane.name + "#" + jetPlane.id + "(" + (observers.size() + 1) + ")" + " unregistered from weather tower\n");
        }
    }

    protected void conditionChanged()
    {
        //to improve
        for (int i = 0; i < this.observers.size(); i++)
            this.observers.get(i).updateConditions();
    }
}