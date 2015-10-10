package main.java;

import java.util.Comparator;

/**
 * Created by Akio on 29/09/2015.
 */
public interface Sorter<T> {
  void sort(final T[] array, final Comparator<T> cmp);
}
