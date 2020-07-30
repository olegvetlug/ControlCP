package ru.synergyIT;

import ru.synergyIT.service.Car;
import ru.synergyIT.service.CarIdEnums.Id;
import ru.synergyIT.service.CarIdEnums.Letter;
import ru.synergyIT.service.CarType;
import ru.synergyIT.service.exeption.WrongSizeExeption;
import ru.synergyIT.service.exeption.WrongSpeedExeption;

import java.util.Random;

public class CarExample {
    private static final int maxSpeed1 = 80;
    private static final int maxSpeed2 = 100;
    private static final double maxHeight = 4.0;
    private static final double maxWidth = 2.5;
    private static final double maxWeight = 8.0;

    public static void main(String[] args) {
        Random random = new Random ();

        Car car = new Car ();
        car.setSpeed ( random.nextInt ( 120 + 1 ) );
        car.setHeight ( random.nextInt ( 60 ) / 10 + 0.1 );
        car.setWidth ( random.nextInt ( 40 ) / 10 + 0.1 );
        car.setWeight ( random.nextInt ( 120 ) / 10 + 0.1 );
        car.setType ( CarType.getRandomType () );
        String carId = Letter.getRandomLetter () + Id.getRandomNum () + Id.getRandomNum () + Id.getRandomNum () + Letter.getRandomLetter () + Letter.getRandomLetter ();
        car.setCarId ( carId );

        try {
            if (checkSize ( car )) {
                System.out.println ( car.getType () + " Under the number " + car.getCarId () + ", passage is open" );
                try {
                    if (checkSpeed ( car )) {
                        System.out.println ( "Speed within tolerance" );
                        System.out.println ( "Speed " + car.getSpeed () );
                    }
                } catch (WrongSpeedExeption e) {
                    System.out.println ( "violation  " + car.getCarId () );
                    System.out.println ( "Speed " + car.getSpeed () );
                    e.printStackTrace ();
                }
            }

        } catch (WrongSizeExeption e) {
            System.out.println ( car.getType () + " under number " + car.getCarId () + ", the passage is closed" );
            e.printStackTrace ();
        } finally {
            System.out.println ( "Vehicle height " + car.getHeight () );
            System.out.println ( "Vehicle width " + car.getWidth () );
            System.out.println ( "car weight " + car.getWeight () );
        }
    }

    private static boolean checkSpeed(Car car) {
        if (car.getSpeed () >= maxSpeed1) {
            if (car.getSpeed () >= maxSpeed2) {
                throw new WrongSpeedExeption ( "Exceeding the speed limit with a visit to the traffic police" );
            } else {
                throw new WrongSpeedExeption ( "Over speeding" );
            }
        }
        return true;
    }

    private static boolean checkSize(Car car) {
        if (car.getHeight () > maxHeight) {
            throw new WrongSizeExeption ( "Vehicle height exceeded" );
        }
        if (car.getWidth () > maxWidth) {
            throw new WrongSizeExeption ( "Vehicle width exceeded" );
        }
        if (car.getWeight () > maxWeight) {
            throw new WrongSizeExeption ( "Vehicle weight exceeded" );
        }
        return true;
    }
}
