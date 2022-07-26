package marti_26_07;

import javax.swing.plaf.IconUIResource;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
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
//        toataLumea.stream() // array cu 2 array-uri
//                        .flatMap(Collection::stream) // reduce de la un array cu mai multe array-uri la un singur array cu toate elem
//                            .forEach(n -> System.out.println(n));

        toataLumea.stream()
                        .flatMap(lista -> lista.stream());

        System.out.println(toataLumea);

        System.out.println();

        // reduce
        System.out.println("reduce:");

        List<Integer> numbers = List.of(1,2,3,4,5,6,7);
        int res = numbers.stream()
                        .reduce(100, (subtotal, element) -> subtotal + element);
        System.out.println(res);

        System.out.println("--------------------------------------");

        // Method reference ::
        // atunci cand se apeleaza o singura data o functie a unei clase in interiorul unei expresii lambda
        // se elimina paratezele si se pune numai numele clasei din care este referentiata
        // intre clasa si metoda se pune ::

        System.out.println("Method reference:");

        List<String> numbersText = List.of("a", "b", "c");
        numbersText.stream()
//                        .map(t -> t.toUpperCase())
                        .map(String::toUpperCase)
                                .forEach(t -> System.out.println(t));

        List<Student> studs = List.of(
                new Student(1, "Alex", 20),
                new Student(2, "Dan", 27),
                new Student(3, "Marian", 20),
                new Student(4, "Ion", 18),
                new Student(5, "Luca", 11),
                new Student(6, "Vlad", 21)
        );

        studs.stream()
                        .map(Student::getName)
                                .forEach(System.out::println);

        System.out.println("--------------------------------------");

        List<Company> companies = List.of(
                new Company(1L, "C1", "S1"),
                new Company(2L, "C2", "S2"),
                new Company(3L, "C3", "S1"),
                new Company(4L, "C4", "S2"),
                new Company(5L, "C5", "S3"),
                new Company(6L, "C6", "S4"),
                new Company(7L, "C7", "S3"),
                new Company(8L, "C8", "S3"),
                new Company(9L, "C9", "S2")
        );

        Map<String, List<Company>> z = companies.stream()
                        .collect(Collectors.groupingBy(c -> c.getSector()));

        System.out.println(z);
        System.out.println();

        Map<String,  List<String>> numeCompanii = companies.stream()
                .collect(Collectors.groupingBy(c -> c.getSector(), // grupeaza: ii da o lista de companii dupa sector
                        Collectors.mapping(c -> c.getName(), Collectors.toList()) // rezultatul il mapeaza, apoi il repune in lista
                        ));
        System.out.println(numeCompanii);

        System.out.println("--------------------------------------");

        // Optional

        System.out.println("Optional:");

        Company company1 = new Company(1l, "C1", "S1");
        Company company2 = null;
        Optional<Company> company1Optional = Optional.ofNullable(company1); // pentru company2 ar da exceptia aruncata mai jos
        company1Optional.ifPresent(c -> c.getName()); //accepta un consumer
        String name = company1Optional.map(c -> c.getName())
                .orElseThrow(() -> new ArithmeticException("Operatiunea nu este corecta!"));
        System.out.println(name);

        if (company1 != null) {
            String n= company1.getName();
        }

        System.out.println("--------------------------------------");

        List<Integer> copy = List.copyOf(numbers);
        System.out.println(numbers);
        System.out.println(copy);

        Predicate<Integer> myFilter = n -> n % 2 == 0; // nr pare
        numbers.stream()
                        .filter(Predicate.not(myFilter)) // opusul a ceea ce este definit in myFilter => nr impare
                                .forEach(System.out::println);

        String text = "    ";
        if(text.isBlank()) {
            text.toUpperCase();
        }

        String t = "    AA       ";
        System.out.println(t.strip());

//        String str = null;
//        str.toString();

        var text2 = """
                    Hei, %s!
                CE MAI FACI, %s?
                    La revedere... %d
                """.formatted("Ana", "Dan", 20);
        System.out.println(text2);

        int x = 5;
        metoda(x);

        System.out.println("--------------------------------------");

    }

    private static void metoda(final int x) {
        switch (x) {
            case 1:
                System.out.println("este 1");
                break;
            case 2:
                System.out.println("este 2");
                break;
            default:
                System.out.println("este altceva");
                break;
        }
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



