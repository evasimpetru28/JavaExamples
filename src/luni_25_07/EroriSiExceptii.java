package luni_25_07;// din interfata Throwable: Exceptii si Erori

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class EroriSiExceptii {
    public static void main(String[] args) {

        String x = null;
        x.toString();
        int y = 1/0;
        int[] arr = {1,2,3};
        System.out.println(arr[3]);

        File file = new File("aaa.txt");
        try {
            FileReader fileReader = new FileReader(file);
            System.out.println(".....");
        } catch (FileNotFoundException e) {
            System.out.println("Logare exceptie in kibana");
        }
    }
}
