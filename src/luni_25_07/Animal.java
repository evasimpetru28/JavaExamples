package luni_25_07;

public class Animal {
    public void run() {
        System.out.println("run like an animal");
    }
}

class Cat extends Animal { // cat is ana animal
    public void run() {
        System.out.println("run like a cat");
    }
    public void meow() {
        System.out.println("Meow!");
    }
}

class Test2 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.run();

        Cat cat = new Cat();
        cat.run();
        cat.meow();

        Animal cat2 = new Cat();
        cat2.run();

    }
}
