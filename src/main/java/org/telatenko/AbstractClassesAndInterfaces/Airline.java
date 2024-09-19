package org.telatenko.AbstractClassesAndInterfaces;

import java.util.ArrayList;
import java.util.List;

public class Airline {
    private List<Aircraft> fleet;

    public Airline() {
        this.fleet = new ArrayList<>();
    }

    public void addAircraft(Aircraft aircraft) {
        fleet.add(aircraft);
    }

    public void displayFleet() {
        for (Aircraft aircraft : fleet) {
            System.out.println(aircraft.getDescription());
        }
    }

    public static void main(String[] args) {
        Airline airline = new Airline();

        airline.addAircraft(new Airplane("73089", 215, 0, 2100));
        airline.addAircraft(new Airplane("76501", 0, 60, 2300));
        airline.addAircraft(new Helicopter("68345", 12, 0, 16.4));

        airline.displayFleet();
    }
}
