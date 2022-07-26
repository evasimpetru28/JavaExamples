package luni_25_07;

class Test{
    public static void main(String[] args) {
        Grandparent grandparent = new Grandparent();
        grandparent.speak();

        System.out.println("------------------------");

        Parent parent = new Parent();
        parent.speak();
        parent.shoot();

        System.out.println("------------------------");

        Aunt aunt = new Aunt();
        aunt.speak();
        aunt.shoot();

        System.out.println("------------------------");

        Child child = new Child();
        child.speak();
        child.rideBike();
        child.shoot();

        System.out.println("------------------------");

        Child child2 = new Child(10, 150);
        child2.speak();
        child2.rideBike();
        child2.shoot();
        System.out.println(child2.getAge() + " " + child2.getHeight());
    }
}


public class Grandparent {
    public void speak() {
        System.out.println("I can speak!");
    }
}

class Parent extends Grandparent {
    public void shoot() {
        System.out.println("Bang!");
    }
    @Override
    public void speak() {
        System.out.println("Vorbesc!");
    }
}

class Aunt extends Grandparent {
    public void shoot() {
        System.out.println("Bang2!");
    }
    @Override
    public void speak() {
        System.out.println("Vorbesc2!");
    }
}

class Child extends Parent {
    private int age;
    private int height;
    public Child() {}

    public Child(int age) {
        this.age = age; // fundatia
    }
    public Child(int age, int height) {
        this(age); // fundatia // foloseste din constructorul anterior
        this.height = height; // acoperisul
    }

    public void rideBike() {
        System.out.println("I can ride a bike!");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void shoot() {

        System.out.println("Pac pac!");
    }
}