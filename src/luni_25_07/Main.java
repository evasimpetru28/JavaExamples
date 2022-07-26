package luni_25_07;

public class Main {

    public static void main(String[] args) {

//        Car2 car1 = new Car2();
//        Car2 car2 = new Car2();
//        Car2 car3 = new Car2(5, "VW", "black",  100);
//        System.out.println(car3.getBrand());
////        System.out.println(car1.getBrand()); \\ null
//        System.out.println(car3);
    }

}

class Car {
    private int numberOfDoors ;
    private String brand;
    private String color;
    private int speed;

    Car() {}

    Car(int numberOfDoors, String brand, String color, int speed) {
        this.numberOfDoors = numberOfDoors;
        this.speed = speed;
        this.color = color;
        this.brand = brand;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String toString() {
        return "info about car: " +
                brand + ", " +
                color + ", " +
                speed + ", " +
                numberOfDoors;
    }
}