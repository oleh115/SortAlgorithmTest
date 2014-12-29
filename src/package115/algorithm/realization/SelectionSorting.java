package package115.algorithm.realization;

import package115.algorithm.base.Sorting;

public class SelectionSorting extends Sorting {
    @Override
    public void sort(int[] array) {
        int currentMinIndex;
        for (int i = 0; i < array.length; i++) {
            currentMinIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[currentMinIndex]) {
                    currentMinIndex = j;
                }
            }

            swap(array, i, currentMinIndex);
        }
    }

    public void sortWithSwapCheck(int[] array) {
        int currentMinIndex;
        boolean swapNeeded = false;
        for (int i = 0; i < array.length; i++) {
            currentMinIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[currentMinIndex]) {
                    currentMinIndex = j;
                    swapNeeded = true;
                }
            }

            if (swapNeeded) {
                swap(array, i, currentMinIndex);
                swapNeeded = false;
            }

        }
    }

}
