package package115.run;

import java.util.Date;
import java.util.Random;

public class Executor {

    private long startTime;
    private long endTime;

    public int[] createRandomArray(int size, int limitValue) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(limitValue);
        }

        return array;
    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.print("\n");
    }

    public void start() {
        startTime = new Date().getTime();
    }

    public void end() {
        endTime = new Date().getTime();
    }

    public long getWorkTime() {
        return endTime - startTime;
    }

}
