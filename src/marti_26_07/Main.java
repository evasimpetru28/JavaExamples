package marti_26_07;

import org.w3c.dom.ls.LSException;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int[] myarr = new int[5];

        // ArrayList:
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("mere");
        fruits.add("pere");
        fruits.add("struguri");

        System.out.println("ArrayList are " + fruits.size() + " elemente.");
        for(String fruit : fruits) {
            System.out.println(fruit);
        }

        System.out.println("------------");

        fruits.remove(2);
        System.out.println("Fructele dupa ce s-a sters cel de la indexul 2:\n");
        for(String fruit : fruits) {
            System.out.println(fruit);
        }

        System.out.println("------------");

        System.out.println("Merele se afla la indexul " + fruits.indexOf("mere"));

        System.out.println("------------");

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person(11, "A"));
        personList.add(new Person(12, "B"));

        System.out.println("Persoanele din personList sunt:");

        for (Person persn: personList) {
            System.out.println(persn.getAge() + ": " + persn.getName());
        }

        System.out.println("------------");

        //////////////////////////////////////////////////////////////////////////
        // Collections:
        // LinkedList

        System.out.println("Afisarea unui LinkedList:\n");

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);

        System.out.println("------------");

        System.out.println("Afiseaza lungimea unui ArrayList si a unui LinkedLis folosind o singura functie:\n");

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        getSizeForList(list1);
        getSizeForList(list2);

        System.out.println("------------");

        System.out.println("Introduce elemente noi la inceput de lista: \n");
        doTimingsAtStartOfList(list1);
        doTimingsAtStartOfList(list2);
        System.out.println("\nIntroduce elemente noi la final de lista: \n");
        doTimingsAtEndOfList(list1);
        doTimingsAtEndOfList(list2);

        System.out.println("------------");

        // Set, HashSet, TreeSEt, LinkedHashSet

        System.out.println("ArrayList: ");
        List<String> animals = new ArrayList<>();
        animals.add("dog");
        animals.add("cat");
        animals.add("dog");

        System.out.println(animals);
        System.out.println("---");

        System.out.println("HashSet: ");
        Set<String> animals2 = new HashSet<>();
        animals2.add("dog");
        animals2.add("cat");
        animals2.add("dog");

        System.out.println(animals2);
        System.out.println("---");

        System.out.println("LinkedHashSet: ");
        Set<String> animals3 = new LinkedHashSet<>();
        animals3.add("dog");
        animals3.add("cat");
        animals3.add("dog");

        System.out.println(animals3);
        System.out.println("---");

        System.out.println("TreeSet: ");
        Set<String> animals4 = new TreeSet<>();
        animals4.add("rhyno");
        animals4.add("mouse");
        animals4.add("dog");
        animals4.add("cat");
        animals4.add("dog");
        animals4.add("giraffe");

        System.out.println(animals4);

        System.out.println("------------");

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new LinkedList<>();
        Set<Integer> l3 = new HashSet<>();
        Set<Integer> l4 = new LinkedHashSet<>();

        for(int i = 0; i<=1_000_000; i++) {
            l1.add(i);
            l2.add(i);
            l3.add(i);
            l4.add(i);
        }

        System.out.println("Cauta elementul 765432 din 1 milion numere introduce in fiecare lista:\n");

        compute(l1);
        compute(l2);
        compute(l3);
        compute(l4);

        System.out.println("------------");

        //////////////////////////////////////////////////////////
        // Map
        System.out.println("Map cu judete si orase:\n");

        Map<String, String> map = new HashMap<>();
        map.put("Dj", "Craiova");
        map.put("Gj", "Tg Jiu");
        map.put("B", "Bucuresti");

        System.out.println("Cheile sunt: " + map.keySet()); // cheile sunt unice
        System.out.println("Orasul din Gj: " + map.get("Gj")); // Tg Jiu
        System.out.println("Orasul din Tr: " + map.get("Tr")); // null

        map.put("Dj", "Bucuresti"); // inlocuieste valoarea de la Dj si pune Bucuresti
        System.out.println("Orasele sunt: " + map.values());
        System.out.println("Perechile: " + map.entrySet());

        map.put("Dj", "Craiova");

        for(String key : map.keySet()) {
            System.out.println("\nkey: " + key);
            System.out.println("value: " + map.get(key));
        }

        System.out.println("------------");

        // TreeMap ordoneaza crescator cheile

        System.out.println("TreeMap pentru taje si apartamente:\n");

        Map<Integer, List<Integer>> map2 = new TreeMap<>();
        map2.put(5, List.of(7,8));
        map2.put(1, List.of(1,2,3));
        map2.put(4, List.of(0,9));

        System.out.println(map2);

        System.out.println("------------");

        System.out.println("Map companii:\n");

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

        Map<String, List<String>> compMap = new HashMap<>();

        /*
        map = {S1=[C1,C3], S2 = [C2, C4, C9], etc}
         */

        for(Company company : companies) {
            List<String> comps = compMap.get(company.getSector());
            if(comps == null) {
                comps = new ArrayList<>(); // []
                compMap.put(company.getSector(), comps); // map -> S1 =  [C1, C3]
            }
            comps.add(company.getName());
        }

        System.out.println(compMap);

        System.out.println("------------");

        System.out.println("Studenti:\n");

        Student student1 = new Student(1, "Alex", 20);
        Student student2 = new Student(1, "Alex", 20);
        Student student3 = student1;

        System.out.println(student1 == student2); // F
        System.out.println(student1 == student3); // T
        System.out.println(student1.equals(student2)); // F

        System.out.println("------------");

        // Set de Studenti

        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());

        Set<Student> studentSet = new HashSet<>();
        studentSet.add(student1);
        studentSet.add(student2);

        System.out.println("------------");

        // Map Studenti
        System.out.println("Students Map:\n");

        Map<Student, Integer> stdMap = new HashMap<>();
        stdMap.put(new Student(1, "Alex", 20), 100);
        stdMap.put(new Student(1, "Andrei", 23), 101);
        System.out.println(stdMap);

        System.out.println("------------");

        ArrayList al = new ArrayList(); // se poate dar e deprecated
        al.add("apple");

        List<String> numbers = List.of("one", "two");
        List<String> fructe = List.of("mere", "pere");
        List<Integer> numbers2 = List.of(1,2,3);
        System.out.println("Numbers list:");
        showListElements(numbers);
        System.out.println("Fructe list:");
        showListElements(fructe);
        System.out.println("Numbers2 list:");
        showListElements(numbers2);

        List<Car> carList = List.of(new Car("Audi"), new Car("VW"));
        System.out.println("CarList list:");
        showListElements(carList);

        System.out.println("------------");

        Object o = showListElementsMap(false);
        System.out.println(o);

        System.out.println("------------");

        // Comparator
        // Sortarea unui array cu comparator folosind lungimea cuvintelor

        List<String> animalsArray = new ArrayList<>();
        animalsArray.add("snake");
        animalsArray.add("dog");
        animalsArray.add("elephant");
        animalsArray.add("cat");
        animalsArray.add("mouse");

        System.out.println("Lista animalelor sortate dupa lungimea cuvintelor(comparator):\n");

//        Collections.sort(animalsArray, new LengthComparator());

        /*
        Comparator -> interfata functionala -> 1 singura metoda
         */


//        Collections.sort(animalsArray, new Comparator<String>() { // primeste o lista si o interfata functionala mereu
//            @Override
//            public int compare(String s, String t1) {
//                if(s.length() > t1.length()) {
//                    return 1;
//                } else if (s.length() == t1.length()) {
//                    return 0;
//                } else {
//                    return -1;
//                }
//            }
//        });

        // nu conteaza clasa, tipul parametrilor, numele functiei
        // are o singura functie de implementat
        // Lambda expression, arrowfunction

        Collections.sort(animalsArray, (s,t1) -> {
                if(s.length() > t1.length()) {
                    return 1;
                } else if (s.length() == t1.length()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        );

        System.out.println(animalsArray);

        System.out.println("------------");

        List<Employee> emps = Arrays.asList(
                new Employee("Alex", 20),
                new Employee("Ionut", 23),
                new Employee("Andreea", 31)
        );

        Collections.sort(emps, (e1,e2) -> {
            int x = 6;
            int y = 2;
            int z = x + y;
            return e2.getAge().compareTo(e1.getAge());
        }); // sortare descrescatoare
        System.out.println("Lista angajatilor sortati dupa varsta:\n" + emps);

        System.out.println("------------");

        final int x = 5; // constanta
        // x = 7; //  nu merge

        final List<String> fruitList = new ArrayList<>();
        fruitList.add("mere"); // se pot adauga elemente, se pot scoate
        fruitList.add("pere");
        // fruitList = new ArrayList<>(); // nu se poate modifica referinta listei pentru ca este final


        final Car car = new Car("Brand1");
        car.setBrand("Brand2"); // se poate schimba atributul
        Car car2 = new Car("Brand3");
        // car = car2; // NU se poate schimba referinta pentru ca este final

        System.out.println(sum(2, 3));
        System.out.println(sum2(2,3));

        System.out.println("------------");



    }

    public static int sum(final int x, final int y) {
        // x = 10; // nu se pot modifica valorile parametrilor in cadrul functiei
        return x + y;
    }

    public static final int sum2(final int x, final int y) {
        // copil care mosteneste clasa in care se afla metoda finala nu se poate suprascrie
        // clasa final nu poate fi extinsa
        return x + y;
    }

    public static <T> T showListElementsMap(boolean b) {
        Map<Integer, String > mapCeva = new HashMap<>();
        mapCeva.put(0, "ceva");
        mapCeva.put(1, "altceva");

        Map<Integer, Integer > mapCeva2 = new HashMap<>();
        mapCeva2.put(0, 0);
        mapCeva2.put(1, 1);

        if(b) {
            return (T) mapCeva.get(0);
        }
        return (T) mapCeva2.get(0);
    }
    public static void showListElements(List<?> list) { // generic
        for (Object elem : list) {
            System.out.println(elem);
        }
    }

    public static void showListElementsStr(List<String> list) {
    }

    public static void showListElementsInt(List<Integer> list) {
    }

    public static void compute(Collection collection) { // inglobeaza si seturi si liste
        long start = System.currentTimeMillis();
        collection.contains(765432);
        long end = System.currentTimeMillis();
        System.out.println(collection.getClass() + ": " + (end - start) + " milisecunde");
    }

    public static void getSizeForList(List<Integer> list) { // poate fi apelata si cu parametrii de tip ArrayList, LinkedList
        System.out.println(list.size());
    }

    public static void doTimingsAtStartOfList(List<Integer> list) {
        for (int i=0; i<100_000; i++) {
            list.add(i);
        } // 1,2,...100_000
        long startCron = System.currentTimeMillis();
        for (int i=100_000; i<200_000; i++) {
            list.add(0,i);
        } // 200_000, 199_999, ..., 100_002, 100_001, 1, 2, ...
        long endCron = System.currentTimeMillis();
        System.out.println(list.getClass() + " cron: " + (endCron - startCron) + " milisecunde");

    }

    public static void doTimingsAtEndOfList(List<Integer> list) {
        for (int i=0; i<100_000; i++) {
            list.add(i);
        } // 1,2,...100_000
        long startCron = System.currentTimeMillis();
        for (int i=100_000; i<200_000; i++) {
            list.add(i);
        } // 200_000, 199_999, ..., 100_002, 100_001, 1, 2, ...
        long endCron = System.currentTimeMillis();
        System.out.println(list.getClass() + " cron: " + (endCron - startCron) + " milisecunde");

    }


}
