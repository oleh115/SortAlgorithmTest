package package115.algorithm.realization;

import package115.algorithm.base.Sorting;

public class CountingSorting extends Sorting {

    @Override
    public void sort(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }

        int[] countArray = new int[max - min + 1];
        for (int element : array) {
            countArray[element - min]++;
        }

        int j = 0;
        for (int i = 0; i < countArray.length; i++) {
            int countElement = countArray[i];
            while (countElement > 0) {
                array[j] = i + min;
                j++;
                countElement--;
            }

        }
    }

}
