package package115.algorithm.realization;

import package115.algorithm.base.Sorting;

public class ShakerSorting extends Sorting {

    @Override
    public void sort(int[] array) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            for (int i = leftIndex; i < rightIndex; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }

            rightIndex--;
            for (int j = rightIndex; j > leftIndex; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
            leftIndex++;
        }
    }

}
