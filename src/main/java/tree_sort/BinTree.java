package main.java.tree_sort;

import java.util.Comparator;

/**
 * Created by Akio on 29/09/2015.
 */
public class BinTree<T> {
  private Node<T> root;

  public BinTree() {
    root = new Node<>(null);
  }

  public boolean isEmpty() {
    return root.getData() == null;
  }

  public void insert(T data, final Comparator<T> cmp) {
    Node<T> node = new Node<>(data);
    root = insertNode(root, node, cmp);
  }

  public void treeToArray(final T[] array) throws RuntimeException {
    int arrayInd = 0;
    if (array.length == getSize()) {
      treeToArray(root, array, arrayInd);
    } else {
      throw new RuntimeException("The tree size differs from an array size.");
    }
  }

  private static <T> int treeToArray(final Node<T> node, final T[] array, int arrayInd) {
    if (node != null) {
      arrayInd = treeToArray(node.getLeft(), array, arrayInd);
      array[arrayInd] = node.getData();
      arrayInd = treeToArray(node.getRight(), array, arrayInd + 1);
    }
    return arrayInd;
  }

  private Node<T> insertNode(Node<T> tree, final Node<T> node, final Comparator<T> cmp) {
    if (tree == null) {
      tree = new Node<>(null);
    }
    if (tree.getData() == null) {
      tree = node;
    } else {
      if (cmp.compare(tree.getData(), node.getData()) > 0) {
        tree.setLeft(insertNode(tree.getLeft(), node, cmp));
      } else {
        tree.setRight(insertNode(tree.getRight(), node, cmp));
      }
    }
    return tree;
  }

  private int getSize() {
    int size = 0;
    return getSize(root, size);
  }

  private int getSize(final Node<T> node, int size) {
    if (node != null) {
      ++size;
      size = getSize(node.getLeft(), size);
      size = getSize(node.getRight(), size);
    }
    return size;
  }
}
