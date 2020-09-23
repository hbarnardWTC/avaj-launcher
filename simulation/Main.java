package simulation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import aircraft.Baloon;
import aircraft.Helicopter;
import aircraft.JetPlane;

public class Main {
    public static void main(String[] args) {
        if (1 != args.length) {
            System.out.println("There should be one argument!");
            return;
        }
        
        String fileName = args[0];

        WeatherTower weatherTower = new WeatherTower();
        Printer.setFile("Result");
        int simulationCount = 0;

        try {
            File fileObj = new File(fileName);
            BufferedReader reader = new BufferedReader(new FileReader(fileObj));
            String line;
            int lines = 0;
            String[] banana;

            if ((line = reader.readLine()) != null){
                try {
                    simulationCount = Integer.parseInt(line);
                    lines++;
                    if (simulationCount < 0) {
                        System.out.println("The amount of simulations needs to be a positive number");
                    }
                } catch (Exception e) {
                    System.out.println("First line does not contain an integer!");
                    return;
                }
            } else {
                System.out.println("First line is empty! How will we know how many simulations to run?");
            }

            while ((line = reader.readLine()) != null) {
                lines++;
                banana = line.split(" ");
                if (banana.length != 5) {
                    System.out.println("Missing values on line " + Integer.toString(lines));
                    reader.close();
                    return;
                }
                if (!(banana[0].equalsIgnoreCase("Baloon") || banana[0].equalsIgnoreCase("Helicopter") || banana[0].equalsIgnoreCase("Jetplane"))) {
                    System.out.println("Nonexistent aircraft type on " + Integer.toString(lines));
                    reader.close();
                    return;
                }
                try {
                    int test = Integer.parseInt(banana[2]);
                    test = Integer.parseInt(banana[3]);
                    test = Integer.parseInt(banana[4]);
                } catch (Exception e) {
                    System.out.println("A non coordinate was parsed on line " + Integer.toString(lines));
                    reader.close();
                    return;
                }
                if (banana[0].toLowerCase().equals("baloon")){
                        new Baloon(banana[1], new Coordinates(Integer.parseInt(banana[2]),Integer.parseInt(banana[3]), Integer.parseInt(banana[4]))).registerTower(weatherTower);
                    } else if (banana[0].toLowerCase().equals("helicopter")){
                        new Helicopter(banana[1], new Coordinates(Integer.parseInt(banana[2]),Integer.parseInt(banana[3]), Integer.parseInt(banana[4]))).registerTower(weatherTower);
                    } else if (banana[0].toLowerCase().equals("jetplane")){
                        new JetPlane(banana[1], new Coordinates(Integer.parseInt(banana[2]),Integer.parseInt(banana[3]), Integer.parseInt(banana[4]))).registerTower(weatherTower);
                    }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        while (simulationCount > 0)
        {
            weatherTower.changeWeather();
            simulationCount--;
        }
    }
}