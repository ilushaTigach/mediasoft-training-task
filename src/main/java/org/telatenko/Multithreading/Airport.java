package org.telatenko.Multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Airport {
    private static Airport instance;
    private BlockingQueue<Aircraft> runway;
    private Terminal[] terminals;

    private Airport() {
        runway = new LinkedBlockingQueue<>();
        terminals = new Terminal[]{
                new Terminal("техника", 10),
                new Terminal("еда", 10),
                new Terminal("лекарства", 10)
        };
    }

    public static synchronized Airport getInstance() {
        if (instance == null) {
            instance = new Airport();
        }
        return instance;
    }

    public void landAircraft(Aircraft aircraft) {
        try {
            runway.put(aircraft);
            System.out.println("Самолет " + aircraft.getId() + " садится на полосу.");
            processAircraft();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void processAircraft() {
        new Thread(() -> {
            try {
                Aircraft aircraft = runway.take();
                System.out.println("Самолет " + aircraft.getId() + " приземлился.");
                Terminal terminal = getTerminalForCargoType(aircraft.getCargoType());
                terminal.unloadAircraft(aircraft);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private Terminal getTerminalForCargoType(String cargoType) {
        for (Terminal terminal : terminals) {
            if (terminal.getCargoType().equals(cargoType)) {
                return terminal;
            }
        }
        throw new IllegalArgumentException("Неизвестный тип груза: " + cargoType);
    }

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();

        for (int i = 1; i <= 10; i++) {
            String cargoType = getRandomCargoType();
            int cargoCapacity = getRandomCargoCapacity();
            Aircraft aircraft = new Aircraft("AC" + i, cargoCapacity, cargoType);
            new Thread(aircraft).start();
        }
    }

    private static String getRandomCargoType() {
        String[] cargoTypes = {"техника", "еда", "лекарства"};
        return cargoTypes[(int) (Math.random() * cargoTypes.length)];
    }

    private static int getRandomCargoCapacity() {
        int[] cargoCapacities = {20, 50, 100};
        return cargoCapacities[(int) (Math.random() * cargoCapacities.length)];
    }
}
