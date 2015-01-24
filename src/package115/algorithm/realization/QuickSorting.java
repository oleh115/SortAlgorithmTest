package package115.algorithm.realization;

import package115.algorithm.base.Sorting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuickSorting extends Sorting {

    @Override
    public void sort(int[] array) {
        System.arraycopy(divideAndConcat(array), 0, array, 0, array.length);
    }

    private int[] divideAndConcat(int[] array) {
        if (array.length <= 1 || allElementsEqual(array)) {
            return array;
        }

        int[] part1 = divideAndConcat(getLeftHalf(array, evalBaseElement(array)));
        int[] part2 = divideAndConcat(getRightHalf(array, evalBaseElement(array)));
        return concatArrays(part1, part2);
    }

    private boolean allElementsEqual(int[] array) {
        int firstElement = array[0];
        for (int element : array) {
            if (element != firstElement) {
                return false;
            }
        }

        return true;
    }

    private int[] concatArrays(int[] array1, int[] array2) {
        int[] resultArray = new int[array1.length + array2.length];
        int j = 0;
        /*for (int element : array1) {
            resultArray[j] = element;
            j++;
        }*/
        System.arraycopy(array1, 0, resultArray, 0, array1.length);

        /*for (int element : array2) {
            resultArray[j] = element;
            j++;
        }*/
        System.arraycopy(array2, 0, resultArray, array1.length, array2.length);
        return resultArray;
    }

    private int[] getLeftHalf(int[] array, int baseElement) {
        List<Integer> resultList = new ArrayList<Integer>();
        for (int element : array) {
            if (element < baseElement) {
                resultList.add(element);
            }
        }

        Iterator<Integer> iterator = resultList.iterator();
        int[] resultArray = new int[resultList.size()];
        int j = 0;
        while (iterator.hasNext()) {
            resultArray[j] = iterator.next();
            j++;
        }

        if (resultArray.length == 0) {
            return getLeftHalf(array, maxElement(array));
        }
        return resultArray;
    }

    private int[] getRightHalf(int[] array, int baseElement) {
        List<Integer> resultList = new ArrayList<Integer>();
        for (int element : array) {
            if (element >= baseElement) {
                resultList.add(element);
            }
        }

        Iterator<Integer> iterator = resultList.iterator();
        int[] resultArray = new int[resultList.size()];
        int j = 0;
        while (iterator.hasNext()) {
            resultArray[j] = iterator.next();
            j++;
        }

        if (resultArray.length == array.length) {
            return getRightHalf(array, maxElement(array));
        }
        return resultArray;
    }

    private int evalBaseElement(int[] array) {
        double[] deltaArray = new double[array.length];
        long arraySum = 0;
        for (int element : array) {
            arraySum += element;
        }

        double arrayAvg = (double) arraySum / array.length;
        for (int i = 0; i < array.length; i++) {
            deltaArray[i] = Math.abs(array[i] - arrayAvg);
        }

        int deltaIndex = 0;
        for (int i = 1; i < deltaArray.length; i++) {
            if (deltaArray[i] < deltaArray[deltaIndex]) {
                deltaIndex = i;
            }
        }

        return array[deltaIndex];
    }

    private int maxElement(int[] array) {
        int maxElement = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxElement) {
                maxElement = array[i];
            }
        }

        return maxElement;
    }

}
