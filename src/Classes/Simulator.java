/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Simulator.java                                     :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: rgirondo <rgirondo@student.42.fr>          +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2024/12/14 19:56:51 by rgirondo          #+#    #+#             */
/*   Updated: 2024/12/15 21:55:13 by rgirondo         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package Classes;

import java.util.*;
import java.io.*;

class AircraftParse
{
    public String _type;
    public String _id;
    public int _longitude;
    public int _latitute;
    public int _height;

    AircraftParse(String[] parameters)
    {
        _type = parameters[0];
        _id = parameters[1];
        _longitude = Integer.parseInt(parameters[2]);
        _latitute = Integer.parseInt(parameters[3]);
        _height = Integer.parseInt(parameters[4]);
    }
}

public class Simulator
{
    static protected  int _loopNbr;
    static protected  List<AircraftParse> _aircrafts = new ArrayList<>();
    static protected  WeatherTower _wt = new WeatherTower();
    static protected  AircraftFactory _af = AircraftFactory.getInstance();
    static protected  PrintStream _ps;
    static public     File _f = new File("simulation.txt");;

    public static void start(String[] args)
    {
        try
        {
            _ps = new PrintStream(_f);
            if (args.length != 1)
            {
                System.out.print("Missing Scenario file\n");
                return ;
            }
            if (scenario(args[0]) == false)
            {
                System.out.print("Scenario Parse Error\n");
                return ;
            }

            System.setOut(_ps);
            //Test parsing
/*             System.out.print(   "# - - - - - - - - - - - - - - - - - #\n" +
                                "# - - - - - P A R S I N G - - - - - #\n" + 
                                "# - - - - - - - - - - - - - - - - - #\n\n");
            System.out.print("Loops Number : " + _loopNbr + "\n");
            for (int i = 0; i < _aircrafts.size(); i++)
            {
                System.out.print(_aircrafts.get(i)._type + " " + _aircrafts.get(i)._id + " "
                    + _aircrafts.get(i)._longitude + " " + _aircrafts.get(i)._latitute + " " + 
                    _aircrafts.get(i)._height + " " + "\n");
                
                    }
                    
                    
            //Start Simulation
            System.out.print(   "\n\n" +
                                "# - - - - - - - - - - - - - - - - - #\n" +
                                "# - - - - S I M U L A T I O N - - - #\n" + 
                                "# - - - - - - - - - - - - - - - - - #\n\n"); */
            Flyable a;
    
            for (int j = 0; j < _aircrafts.size(); j++)
            {
                if (_aircrafts.get(j)._height > 100)
                    _aircrafts.get(j)._height = 100;
                a = _af.newAircraft(_aircrafts.get(j)._type, _aircrafts.get(j)._id, 
                    new Coordinates(_aircrafts.get(j)._longitude, _aircrafts.get(j)._latitute, _aircrafts.get(j)._height));
                if (a != null)
                    a.registerTower(_wt);
                _wt.register(a);
            }
    
            for (int i = 0; i < _loopNbr; i++)
            {
                _wt.changeWeather();
            }
            System.setOut(System.out);
        }
        catch(FileNotFoundException e)
        {
            System.out.print("Error writing simulator.txt\n");
        }    
    }

    static private boolean idUsed(String id)
    {
        if (_aircrafts == null)
            return false;
        for (int i = 0; i < _aircrafts.size(); i++)
        {
            if (id == _aircrafts.get(i)._id)
                return true;
        }
        return false;
    }

    static public boolean scenario(String f_path)
    {            
        try (BufferedReader buffer = new BufferedReader(new FileReader(f_path)))
        {
            String line;
            String[] aux;

            line = buffer.readLine();
            
            if (line == null)
                throw new IOException("Empty file error");
            if (!line.matches("[0-9]+"))
                throw new IOException("Loop number not valid");
            _loopNbr = Integer.parseInt(line);
            while ((line = buffer.readLine()) != null)
            {
                aux = line.split("[ ]");
                
                if (aux.length <= 1)
                    throw new IOException("Empty line error");
                if (aux.length != 5)
                    throw new IOException("Missing parameter on Aircraft");
                if ((aux[0].equals("Helicopter") || aux[0].equals("Baloon") || aux[0].equals("JetPlane")) 
                    && aux[1].matches("[a-zA-Z0-9]+") && aux[2].matches("[0-9]+") && aux[3].matches("[0-9]+") 
                        && aux[4].matches("[0-9]+"))
                {
                    if (idUsed(aux[1]))
                        throw new IOException("Duplicated Id : " + aux[1]);
                    else
                        _aircrafts.add(new AircraftParse(aux));
                }
                else
                    throw new IOException("Aircraft format error");
            }
            if (line == null && _aircrafts.size() <= 0)
                throw new IOException("Missing Aircrafts");
        }
        catch (IOException error)
        {
            System.out.print(error.getMessage() + "\n");
            return false;
        }
        return true;
    }
}