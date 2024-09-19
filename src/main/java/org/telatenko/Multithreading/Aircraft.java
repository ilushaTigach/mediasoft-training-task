package org.telatenko.Multithreading;

public class Aircraft implements Runnable, CargoType {
    private String id;
    private int cargoCapacity;
    private String cargoType;

    public Aircraft(String id, int cargoCapacity, String cargoType) {
        this.id = id;
        this.cargoCapacity = cargoCapacity;
        this.cargoType = cargoType;
    }

    @Override
    public void run() {
        System.out.println("Самолет " + id + " прибыл с грузом " + cargoType + " (" + cargoCapacity + " тонн)");
        Airport.getInstance().landAircraft(this);
    }

    public String getId() {
        return id;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public String getCargoType() {
        return cargoType;
    }

    @Override
    public String toString() {
        return "Самолет " + id + " с грузом " + cargoType + " (" + cargoCapacity + " тонн)";
    }
}
