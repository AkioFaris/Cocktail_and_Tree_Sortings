package main.java.tree_sort;

import java.util.Comparator;

/**
 * Created by Akio on 29/09/2015.
 */
public class TreeSort {

  public static <T> void sort(final T[] array, Comparator<T> cmp) {
    final BinTree<T> bst = new BinTree<>();
    for (final T anArrayElement : array) {
      bst.insert(anArrayElement, cmp);
    }
    if (!bst.isEmpty()) {
      bst.treeToArray(array);
    }
  }
}
