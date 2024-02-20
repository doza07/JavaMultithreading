package collections;

import java.util.ArrayList;
import java.util.List;

public class ListThread extends Thread {

    private final List<Integer> integerList;

    public ListThread(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 1000; i++) {
                integerList.add(i);
        }
    }
}
