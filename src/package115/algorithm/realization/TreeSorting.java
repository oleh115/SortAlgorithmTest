package package115.algorithm.realization;

import package115.algorithm.base.Sorting;
import package115.algorithm.base.Tree;

import java.util.Iterator;

public class TreeSorting extends Sorting {

    @Override
    public void sort(int[] array) {
        Tree tree = new Tree();
        tree.insert(array);
        Iterator<Integer> iterator = tree.getValuesSortList().iterator();
        int j = 0;
        while (iterator.hasNext()) {
            array[j] = iterator.next();
            j++;
        }
    }

}
