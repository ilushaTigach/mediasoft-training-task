package org.telatenko.Multithreading;

public class Terminal {
    private String cargoType;
    private int unloadingRate;

    public Terminal(String cargoType, int unloadingRate) {
        this.cargoType = cargoType;
        this.unloadingRate = unloadingRate;
    }

    public void unloadAircraft(Aircraft aircraft) {
        System.out.println("Начинается разгрузка " + aircraft + " на терминале для " + cargoType);
        int remainingCargo = aircraft.getCargoCapacity();
        while (remainingCargo > 0) {
            try {
                Thread.sleep(1000);
                int unloadedCargo = Math.min(unloadingRate, remainingCargo);
                remainingCargo -= unloadedCargo;
                System.out.println("Разгружено " + unloadedCargo + " тонн. Осталось разгрузить: " + remainingCargo + " тонн.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Разгрузка " + aircraft + " завершена.");
    }

    public String getCargoType() {
        return cargoType;
    }
}
