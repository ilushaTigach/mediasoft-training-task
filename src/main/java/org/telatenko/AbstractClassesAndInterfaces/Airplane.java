package org.telatenko.AbstractClassesAndInterfaces;

public class Airplane extends Aircraft implements PassengerAircraft, CargoAircraft {
    private int numberOfSeats;
    private int cargoCapacity;
    private int runwayLength;

    public Airplane(String registrationNumber, int numberOfSeats, int cargoCapacity, int runwayLength) {
        super(registrationNumber);
        this.numberOfSeats = numberOfSeats;
        this.cargoCapacity = cargoCapacity;
        this.runwayLength = runwayLength;
    }

    @Override
    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    @Override
    public int getCargoCapacity() {
        return cargoCapacity;
    }

    public int getRunwayLength() {
        return runwayLength;
    }

    @Override
    public String getDescription() {
        if (numberOfSeats > 0) {
            return String.format("%s - Пассажирский самолет - %d пассажиров - полоса %d метров",
                    registrationNumber, numberOfSeats, runwayLength);
        } else {
            return String.format("%s - Грузовой самолет - %d тонн - полоса %d метров",
                    registrationNumber, cargoCapacity, runwayLength);
        }
    }
}
