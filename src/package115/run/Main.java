package package115.run;

import package115.algorithm.base.Sorting;
import package115.algorithm.realization.*;

public class Main {

    public static void main(String[] args) {
        Executor executor = new Executor();
        int[] array = executor.createRandomArray(10000, 100);
        //Sorting sorting = new SelectionSorting();
        Sorting sorting = new TreeSorting();
        executor.printArray(array);
        executor.start();
        sorting.sort(array);
        executor.end();
        executor.printArray(array);
        System.out.println("Sorting was working = " + executor.getWorkTime() + " ms");
    }

}
