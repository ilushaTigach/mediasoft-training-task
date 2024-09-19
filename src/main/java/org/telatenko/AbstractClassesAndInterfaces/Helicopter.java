package org.telatenko.AbstractClassesAndInterfaces;

public class Helicopter extends Aircraft implements PassengerAircraft, CargoAircraft {
    private int numberOfSeats;
    private int cargoCapacity;
    private double rotorSize;

    public Helicopter(String registrationNumber, int numberOfSeats, int cargoCapacity, double rotorSize) {
        super(registrationNumber);
        this.numberOfSeats = numberOfSeats;
        this.cargoCapacity = cargoCapacity;
        this.rotorSize = rotorSize;
    }

    @Override
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public double getRotorSize() {
        return rotorSize;
    }

    @Override
    public String getDescription() {
        if (numberOfSeats > 0) {
            return String.format("%s - Пассажирский вертолет - %d пассажиров - размер винта %.1f метров",
                    registrationNumber, numberOfSeats, rotorSize);
        } else {
            return String.format("%s - Грузовой вертолет - %d тонн - размер винта %.1f метров",
                    registrationNumber, cargoCapacity, rotorSize);
        }
    }
}
