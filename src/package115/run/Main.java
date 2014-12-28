package package115.run;

import package115.algorithm.base.Sorting;
import package115.algorithm.realization.InsertionSorting;

public class Main {

    public static void main(String[] args) {
        Executor executor = new Executor();
        int[] array = executor.createRandomArray(10000, 10000);
        Sorting sorting = new InsertionSorting();
        //executor.printArray(array);
        executor.start();
        sorting.sort(array);
        executor.end();
        //executor.printArray(array);
        System.out.println("Sorting was working = " + executor.getWorkTime() + " ms");
    }

}
