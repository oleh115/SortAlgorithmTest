package package115.algorithm.realization;

import package115.algorithm.base.Sorting;

public class InsertionSorting extends Sorting {

    @Override
    public void sort(int[] array) {
        int j;
        int temp;
        for (int i = 1; i < array.length; i++) {
            j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }
    }

}
