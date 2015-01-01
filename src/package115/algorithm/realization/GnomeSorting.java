package package115.algorithm.realization;

import package115.algorithm.base.Sorting;

public class GnomeSorting extends Sorting {

    @Override
    public void sort(int[] array) {
        int i = 0;
        while (i < array.length - 1) {
            if (array[i + 1] < array[i]) {
                swap(array, i, i + 1);
                if (i > 0) {
                    i--;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
    }

}
