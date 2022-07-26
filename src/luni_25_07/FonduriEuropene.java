package luni_25_07;

interface Fonduri {
    void showMeTheDocuments(); // default abstract
}

public interface FonduriEuropene {
    void keepMinNUmberOfEmployees();
    int contributeWithMinimumAmount();
}

class PopescuSRL implements Fonduri, FonduriEuropene { // implementeaza functii din ambele interfete

    @Override
    public void showMeTheDocuments() {
        System.out.println("CNP, Carte de munca");
    }

    @Override
    public void keepMinNUmberOfEmployees() {
        System.out.println("Am angajat 5 persoane.");
    }

    @Override
    public int contributeWithMinimumAmount() {
        return 200;
    }
}

class IonescuSRL implements FonduriEuropene {

    @Override
    public void keepMinNUmberOfEmployees() {
        System.out.println("Am angajat 20 persoane.");
    }

    @Override
    public int contributeWithMinimumAmount() {
        return 300;
    }
}