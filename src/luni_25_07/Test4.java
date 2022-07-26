package luni_25_07;

public class Test4 {
}

interface Geo {
    double computeArea();
}

class Square implements Geo {
    int l;

    @Override
    public double computeArea() {
        return l*l;
    }
}

class Circle implements Geo {
    int r;

    @Override
    public double computeArea() {
        return Math.PI*r*r;
    }
}

