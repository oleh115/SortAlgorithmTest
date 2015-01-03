package package115.algorithm.realization;

import package115.algorithm.base.Sorting;

public class ShellSorting extends Sorting {

    @Override
    public void sort(int[] array) {
        int period = array.length / 2;
        int j;
        while (period > 0) {
            for (int i = period; i < array.length; i++) {
                j = i;
                while (j >= period && array[j] < array[j - period]) {
                    swap(array, j, j - period);
                    j--;
                }

            }

            period /= 2;
        }
    }

}
