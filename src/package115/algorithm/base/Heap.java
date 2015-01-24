package package115.algorithm.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap {

    private List<Integer> list = new ArrayList<Integer>();

    public void insert(int[] array) {
        for (int element : array) {
            insert(element);
        }
    }

    public void insert(int element) {
        list.add(element);
        int index = list.size() - 1;
        int parentIndex = getParentIndex(index);

        while (parentIndex >= 0 && list.get(index) > list.get(parentIndex)) {
            Collections.swap(list, index, parentIndex);
            index = getParentIndex(index);
            parentIndex = getParentIndex(index);
        }

    }

    private int getParentIndex(int index) {
        if (index % 2 != 0) {
            return (index - 1) / 2;
        } else {
            return (index - 2) / 2;
        }
    }

    public int rebuild(int voidIndex) {
        int leftChildIndex = getLeftChildIndex(voidIndex);
        int rightChildIndex = getRightChildIndex(voidIndex);
        while (leftChildIndex != -1 || rightChildIndex != -1) {
            if (leftChildIndex != -1 && rightChildIndex != -1) {
                if (list.get(leftChildIndex) > list.get(rightChildIndex)) {
                    Collections.swap(list, voidIndex, leftChildIndex);
                    voidIndex = leftChildIndex;
                    leftChildIndex = getLeftChildIndex(voidIndex);
                    rightChildIndex = getRightChildIndex(voidIndex);
                } else {
                    Collections.swap(list, voidIndex, rightChildIndex);
                    voidIndex = rightChildIndex;
                    leftChildIndex = getLeftChildIndex(voidIndex);
                    rightChildIndex = getRightChildIndex(voidIndex);
                }
            } else if (leftChildIndex != -1) {
                Collections.swap(list, voidIndex, leftChildIndex);
                voidIndex = leftChildIndex;
                break;
            } else {
                Collections.swap(list, voidIndex, rightChildIndex);
                voidIndex = rightChildIndex;
                break;
            }
        }

        int removeItem = list.get(voidIndex);
        list.remove(voidIndex);
        return removeItem;
    }

    private int getLeftChildIndex(int index) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex >= list.size()) {
            leftChildIndex = -1;
        }

        return leftChildIndex;
    }

    private int getRightChildIndex(int index) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex >= list.size()) {
            rightChildIndex = -1;
        }

        return rightChildIndex;
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 7, 0, 9, 8, 0, 9, 4, 8, 5};
        Heap heap = new Heap();
        heap.insert(array);
        System.out.println(heap.list);
        while (heap.getSize() > 0) {
            System.out.println(heap.rebuild(0));
            System.out.println(heap.list);
        }


        System.out.println(heap.list);
    }

}
