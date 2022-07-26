package marti_26_07;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {

        /////////////////////////////////////
        // Interfete functionale

        Gift gift1 = new Gift("masinuta");

        // Supplier: din nimic imi da ceva; return orice

        System.out.println("Supplier:");

        Supplier<Gift> giftSupplier = () -> new Gift("aaaa"); // nu folosim ca aici
        Supplier<Integer> randomSupplier = () -> new Random().nextInt();
        System.out.println(randomSupplier.get());

        System.out.println("--------------------------------------");

        // Consumer: accepta un parametru pe care il consuma; void

        System.out.println("Consumer:");

        Consumer<String> textConsumer = (x) -> System.out.println("Mananc un " + x);
        textConsumer.accept("mar");


        Consumer<String> textConsumer2 = (x) -> {
            System.out.println("Mananc o " + x);
            System.out.println("Mananc ceva");
            System.out.println("Mananc altceva");
        };
        textConsumer2.accept("pruna");

        List.of(1,2,3,4).forEach(x-> System.out.println(x)); // forEach cere Consumator

        System.out.println("--------------------------------------");

        // BiConsumer: void

        System.out.println("BiConsumer:");
        BiConsumer<Integer, String> sumAsText = (a,b) -> System.out.println(a+b);
        sumAsText.accept(10, "aaa");

        System.out.println("--------------------------------------");

        // Predicate: "filtreaza"; returneaza boolean; verifica o conditie

        System.out.println("Predicate:");
        Student stud1 = new Student(1, "Alex", 20);
        Student stud2 = new Student(2, "Alin", 23);
        Student stud3 = new Student(3, "Andreea", 28);

        Predicate<Student> studentPredicate = (student) -> student.getAge()>21;
        boolean b1 = studentPredicate.test(stud1);
        boolean b2 = studentPredicate.test(stud2);
        boolean b3 = studentPredicate.test(stud3);
        System.out.println(b1 + " " + b2 + " " + b3);

        System.out.println("--------------------------------------");

        // Function

        System.out.println("Function:");

        Function<Student, String> studentFunction = student -> student.getName();
        String n1 = studentFunction.apply(stud1);
        String n2 = studentFunction.apply(stud2);
        String n3 = studentFunction.apply(stud3);

        System.out.println(n1 + " " + n2 + " " + n3);

        System.out.println("--------------------------------------");

        /////////////////////////////////////////////
        // Stream-uri

        System.out.println("Stream:");

        List<Integer> list2 = List.of(1,2,3,4,5);
        list2.stream() // Stream de Integers: 1,2,3,4,5
                .map(x -> x * x) // Stream<Integer>: 1,4,9,16,25; function
                .filter(x -> x > 10) // Stream<Integer> filtrat: 16,25; predicate
                .map(x -> x + "") // Stream<String>: "16", "25"; function
                .forEach(x -> System.out.println(x + " " + x)); // metoda terminala: afiseaza fiecare elem din Stream; consumer

        long nr = list2.stream() // Stream de Integers: 1,2,3,4,5
                .map(x -> x * x) // Stream<Integer>: 1,4,9,16,25; function
                .filter(x -> x > 10) // Stream<Integer> filtrat: 16,25; predicate
                .map(x -> x + "") // Stream<String>: "16", "25"; function
                .count();
        System.out.println("Au ramas: " + nr + " elemente.");

        List<Student> stds = List.of(
                new Student(1, "Alex", 20),
                new Student(2, "Andrei", 27),
                new Student(3, "Maria", 20),
                new Student(4, "Ion", 18),
                new Student(5, "Diana", 11),
                new Student(6, "Alexandra", 21)
        );

        List<String> result = stds.stream()
                        .filter(s -> s.getAge() >= 18)
                                .map(s -> s.getName())
                                        .sorted(Comparator.reverseOrder())
                                                .collect(Collectors.toList());
        System.out.println(result);

        System.out.println("--------------------------------------");

        //flatMap
        System.out.println("flatMap:");

        List<List<Student>> toataLumea = new ArrayList<>();

        List<Student> fete = List.of(
                new Student(1, "Alexandra", 20),
                new Student(2, "Eva", 27),
                new Student(3, "Maria", 20),
                new Student(4, "Ioana", 18),
                new Student(5, "Diana", 11),
                new Student(6, "Bianca", 21)
        );

        List<Student> baieti = List.of(
                new Student(1, "Alex", 20),
                new Student(2, "Dan", 27),
                new Student(3, "Marian", 20),
                new Student(4, "Ion", 18),
                new Student(5, "Luca", 11),
                new Student(6, "Vlad", 21)
        );

        System.out.println("Toti studentii:");
        toataLumea.add(fete);
        toataLumea.add(baieti);
        toataLumea.stream() // array cu 2 array-uri
                        .flatMap(Collection::stream) // reduce de la un array cu mai multe array-uri la un singur array cu toate elem
                            .forEach(n -> System.out.println(n));

        System.out.println();

        // reduce
        System.out.println("reduce:");

        List<Integer> numbers = List.of(1,2,3,4,5,6,7);
        int res = numbers.stream()
                        .reduce(100, (subtotal, element) -> subtotal + element);
        System.out.println(res);

        System.out.println("--------------------------------------");

    }

    //supplier
    public static int getRandomNumber() {
        return new Random().nextInt();
    }

    //consumer
    public static void sum(int a, int b) {
        System.out.println(a+b);
    }
}



