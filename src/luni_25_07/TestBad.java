package luni_25_07;

public class TestBad {
}

interface BadToy {
    void setPrice(double price);
    void setColor(String color);
    void move();
    void fly();

}

class HouseBad implements BadToy {

    @Override
    public void setPrice(double price) {
        System.out.println("10.4");
    }

    @Override
    public void setColor(String color) {
        System.out.println("red");
    }

    @Override
    public void move() {
        System.out.println("nu se misca"); // BAD
    }

    @Override
    public void fly() {
        System.out.println("nu zboara"); // BAD
    }
}