package package115.algorithm.realization;

import package115.algorithm.base.Sorting;

public class BubbleSorting extends Sorting {

    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }
}
