package Classes;

import java.util.*;

public class Tower {

    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable)
    {
        if (p_flyable instanceof Helicopter)
        {
            Helicopter helicopter = (Helicopter)p_flyable;
            if (!this.observers.add(helicopter))
                return ;
            System.out.print("Tower says: Helicopter#" + helicopter.name + "(" + helicopter.id + ")" + " registered to weather tower\n");
        }
        if (p_flyable instanceof Baloon)
        {
            Baloon baloon = (Baloon)p_flyable;
            if (!this.observers.add(baloon))
                return ;
            System.out.print("Tower says: Baloon#" + baloon.name + "(" + baloon.id + ")" + " registered to weather tower\n");
        }
        if (p_flyable instanceof JetPlane)
        {
            JetPlane jetPlane = (JetPlane)p_flyable;
            if (!this.observers.add(jetPlane))
                return ;
            System.out.print("Tower says: JetPlane#" + jetPlane.name + "(" + jetPlane.id + ")" + " registered to weather tower\n");
        }
    }

    public void unregister(Flyable p_flyable)
    {
        if (p_flyable instanceof Helicopter)
        {
            Helicopter helicopter = (Helicopter)p_flyable;
            if (!this.observers.remove(helicopter))
                return ;
            System.out.print("Tower says: Helicopter#" + helicopter.name + "(" + helicopter.id + ")" + " unregistered from weather tower\n");
        }
        if (p_flyable instanceof Baloon)
        {
            Baloon baloon = (Baloon)p_flyable;
            if (!this.observers.remove(baloon))
                return ;
            System.out.print("Tower says: Baloon#" + baloon.name + "(" + baloon.id + ")" + " unregistered from weather tower\n");
        }
        if (p_flyable instanceof JetPlane)
        {
            JetPlane jetPlane = (JetPlane)p_flyable;
            if (!this.observers.remove(jetPlane))
                return ;
            System.out.print("Tower says: JetPlane#" + jetPlane.name + "(" + jetPlane.id + ")" + " unregistered from weather tower\n");
        }
    }

    protected void conditionChanged()
    {
        List<Flyable> copy = new ArrayList<>(observers);

        for (int i = 0; i < copy.size(); i++)
        {
            copy.get(i).updateConditions();
        }
    }
}