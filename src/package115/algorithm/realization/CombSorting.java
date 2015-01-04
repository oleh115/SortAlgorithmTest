package package115.algorithm.realization;

import package115.algorithm.base.Sorting;

public class CombSorting extends Sorting {

    @Override
    public void sort(int[] array) {
        double bubbleFactor = 1.247330950103979;
        int bubbleDistance = (int) (array.length / bubbleFactor);
        while (bubbleDistance > 1) {
            for (int i = 0; i < array.length - bubbleDistance; i++) {
                if (array[i] > array[i + bubbleDistance]) {
                    swap(array, i , i + bubbleDistance);
                }
            }

            bubbleDistance /= bubbleFactor;
        }
    }

}
