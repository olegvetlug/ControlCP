package ru.synergyIT.service;

public class Car {
    private int speed;
    private double height;
    private double width;
    private double weight;
    private String carId;
    private CarType type;

    public Car() {
    }

    public String getType() {
        String usType;
        switch (type) {
            case Truck -> usType = "Truck";
            case autoCar -> usType = "Car";
            default -> throw new IllegalStateException ( "Unexpected value: " + type );
        }
        return usType;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public String getCarId() {
        return this.carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
