package package115.algorithm.base;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private Node baseNode;

    public void insert(int value) {
        if (baseNode != null) {
            Node iterNode = baseNode;
            while (true) {
                if (value < iterNode.getValue()) {
                    if (iterNode.getLeftChild() == null) {
                        iterNode.setLeftChild(new Node(value));
                        break;
                    } else {
                        iterNode = iterNode.getLeftChild();
                    }
                } else {
                    if (iterNode.getRightChild() == null) {
                        iterNode.setRightChild(new Node(value));
                        break;
                    } else {
                        iterNode = iterNode.getRightChild();
                    }
                }
            }
        } else {
            baseNode = new Node(value);
        }
    }

    public void insert(int[] array) {
        for (int element : array) {
            insert(element);
        }
    }

    public int sum(Node node) {
        if (node.getLeftChild() != null && node.getRightChild() != null) {
            return node.getValue() + sum(node.getLeftChild()) + sum(node.getRightChild());
        } else if (node.getLeftChild() != null) {
            return node.getValue() + sum(node.getLeftChild());
        } else if (node.getRightChild() != null) {
            return node.getValue() + sum(node.getRightChild());
        }

        return node.getValue();
    }

    public List<Integer> getValuesSortList() {
        List<Integer> list = new ArrayList<Integer>();
        addValuesByMin(baseNode, list);
        return list;
    }

    public void addValuesByMin(Node node, List<Integer> list) {
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            list.add(node.getValue());
            return;
        } else if (node.getLeftChild() != null && node.getRightChild() != null) {
            addValuesByMin(node.getLeftChild(), list);
            list.add(node.getValue());
            addValuesByMin(node.getRightChild(), list);
        } else if (node.getLeftChild() != null) {
            addValuesByMin(node.getLeftChild(), list);
            list.add(node.getValue());
        } else {
            list.add(node.getValue());
            addValuesByMin(node.getRightChild(), list);
        }
    }

}
