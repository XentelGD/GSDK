package gsdk;

public class Random {

    public static int range(int from, int to) {
        return (int)(Math.random() * (from - to) + to);
    }

}
