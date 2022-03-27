import java.util.ArrayList;
import java.util.List;

public class ImplementationOfRaceOfThreads extends Thread {

    List<Integer> portionList;
    Thread t;
    String name;

    static List<Integer> oddList = new ArrayList<>();
    static List<Integer> evenList = new ArrayList<>();

    public ImplementationOfRaceOfThreads(String name, List<Integer> pL) {
        this.t = new Thread(this, name);
        this.portionList = pL;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (oddList) {
            portionList.forEach(value -> {
                if (value % 2 == 0) {
                    evenList.add(value);
                } else {
                    oddList.add(value);
                }
            });
        }
    }

    public static void main(String[] args) {

        List<Integer> listOfIntegers = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            listOfIntegers.add(i);
        }
        List<Integer> portion1 = listOfIntegers.subList(0, 2500);
        List<Integer> portion2 = listOfIntegers.subList(2500, 5000);
        List<Integer> portion3 = listOfIntegers.subList(5000, 7500);
        List<Integer> portion4 = listOfIntegers.subList(7500, 10000);

        new ImplementationOfRaceOfThreads("thread-1", portion1).start();
        new ImplementationOfRaceOfThreads("thread-2", portion2).start();
        new ImplementationOfRaceOfThreads("thread-3", portion3).start();
        new ImplementationOfRaceOfThreads("thread-4", portion4).start();

    }

}
