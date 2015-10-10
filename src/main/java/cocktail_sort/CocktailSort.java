package main.java.cocktail_sort;

import java.util.Comparator;

/**
 * Created by Akio on 29/09/2015.
 */
public class CocktailSort {
  public static <T> void sort(final T[] array, final Comparator<T> cmp) {
    int leftBorder = 0;
    int rightBorder = array.length - 1;
    do {
      for (int i = leftBorder; i < rightBorder; i++) {
        if (cmp.compare(array[i], array[i + 1]) > 0) {
          swap(array, i, i + 1);
        }
      }
      --rightBorder;
      for (int i = rightBorder; i > leftBorder; i--) {
        if (cmp.compare(array[i], array[i - 1]) < 0) {
          swap(array, i, i - 1);
        }
      }
      ++leftBorder;
    } while (leftBorder <= rightBorder);
  }

  private static <T> void swap(final T[] array, final int i, final int j) {
    final T tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
