package test.java;

import main.java.Sorter;
import main.java.cocktail_sort.CocktailSort;
import main.java.tree_sort.TreeSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Akio on 29/09/2015.
 */
public class SortTest {
  private static final int ARRAY_LEN = 10;
  private static final Collection<Sorter<Integer>> sorts = new ArrayList<>();

  static {
    sorts.add(CocktailSort::sort);
    sorts.add(TreeSort::sort);
  }

  @Test
  public void extremeCasesTest() {
    Comparator<Integer> cmpInt = Integer::compareTo;
    final Integer[] emptyArray = new Integer[0];
    final Integer[] sortedDescendingArray = new Integer[ARRAY_LEN];
    final Integer[] sortedAscendingArray = new Integer[ARRAY_LEN];

    for (final Sorter<Integer> sort : sorts) {
      for (int i = 0; i < sortedAscendingArray.length; i++) {
        sortedAscendingArray[i] = i;
        sortedDescendingArray[i] = sortedDescendingArray.length - i;
      }
      Assert.assertTrue(isSorted(sort, emptyArray, cmpInt));
      Assert.assertTrue(containsAll(sort, emptyArray, cmpInt));
      Assert.assertTrue(isSorted(sort, sortedDescendingArray, cmpInt));
      Assert.assertTrue(containsAll(sort, sortedDescendingArray, cmpInt));
      Assert.assertTrue(isSorted(sort, sortedAscendingArray, cmpInt));
      Assert.assertTrue(containsAll(sort, sortedAscendingArray, cmpInt));
    }
  }

  @Test
  public void isSortedTest() {
    Comparator<Integer> cmpInt = Integer::compareTo;
    final Integer[] array = generateArray(ARRAY_LEN);
    for (final Sorter<Integer> sort : sorts) {
      Assert.assertTrue(isSorted(sort, array, cmpInt));
    }
  }

  @Test
  public void containsAllTest() {
    Comparator<Integer> cmpInt = Integer::compareTo;
    final Integer[] array = generateArray(ARRAY_LEN);
    for (final Sorter<Integer> sort : sorts) {
      Assert.assertTrue(containsAll(sort, array, cmpInt));
    }
  }

  private static <T> boolean containsAll(Sorter<T> sorting, final T[] array, Comparator<T> cmp) {
    final int arrayLen = array.length;
    final T[] originalArray = Arrays.copyOf(array, arrayLen);
    final Boolean[] alreadyFound = new Boolean[arrayLen];
    sorting.sort(array, cmp);
    if (originalArray.length != arrayLen)
      return false;
    for (int i = 0; i < alreadyFound.length; i++) {
      alreadyFound[i] = false;
    }
    for (final T anArrayElement : array) {
      int j;
      for (j = 0; j < originalArray.length; j++) {
        if (0 == cmp.compare(anArrayElement, originalArray[j]) && !alreadyFound[j]) {
          alreadyFound[j] = true;
          break;
        }
      }
      if (j == originalArray.length) {
        return false;
      }
    }
    return true;
  }

  private static <T> boolean isSorted(Sorter<T> sorting, final T[] array, Comparator<T> cmp) {
    sorting.sort(array, cmp);
    for (int i = 0; i < array.length - 1; i++) {
      if (0 < cmp.compare(array[i], array[i + 1])) {
        return false;
      }
    }
    return true;
  }

  private static Integer[] generateArray(final int arrayLen) {
    final Random rand = new Random(System.currentTimeMillis());
    final Integer[] array = new Integer[arrayLen];
    for (int i = 0; i < array.length; i++) {
      array[i] = rand.nextInt();
    }
    return array;
  }
}
