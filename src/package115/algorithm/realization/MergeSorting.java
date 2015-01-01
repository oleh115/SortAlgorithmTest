package package115.algorithm.realization;

import package115.algorithm.base.Sorting;

import java.util.Arrays;

public class MergeSorting extends Sorting {

    @Override
    public void sort(int[] array) {
        System.arraycopy(divideAndMerge(array), 0, array, 0, array.length);
    }

    private int[] divideAndMerge(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int[] part1 = divideAndMerge(Arrays.copyOfRange(array, 0, array.length / 2));
        int[] part2 = divideAndMerge(Arrays.copyOfRange(array, array.length / 2, array.length));
        return mergeArrays(part1, part2);
    }

    private int[] mergeArrays(int[] array1, int[] array2) {
        int[] mergeArray = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int mergeIndex = 0;
        while (mergeIndex < mergeArray.length) {
            if (i < array1.length && j < array2.length) {
                if (array1[i] < array2[j]) {
                    mergeArray[mergeIndex] = array1[i];
                    i++;
                } else {
                    mergeArray[mergeIndex] = array2[j];
                    j++;
                }
            } else if (i == array1.length) {
                mergeArray[mergeIndex] = array2[j];
                j++;
            } else if (j == array2.length) {
                mergeArray[mergeIndex] = array1[i];
                i++;
            }

            mergeIndex++;
        }

        return mergeArray;
    }

}
