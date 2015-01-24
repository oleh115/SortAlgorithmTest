package package115.algorithm.realization;

import package115.algorithm.base.Heap;
import package115.algorithm.base.Sorting;

public class HeapSorting extends Sorting {

    @Override
    public void sort(int[] array) {
        Heap heap = new Heap();
        heap.insert(array);
        int i = array.length - 1;
        while(heap.getSize() > 0) {
            array[i] = heap.rebuild(0);
            i--;
        }
    }

}
