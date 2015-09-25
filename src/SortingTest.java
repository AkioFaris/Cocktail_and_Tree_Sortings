import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Akio on 17/09/2015.
 */

public class SortingTest {
  private static final int ARRAY_LEN = 100;
  private static final Collection<Sorting<Integer>> sortings = new ArrayList<>();

  static {
    sortings.add(CocktailSort::sort);
    sortings.add(TreeSort::sort);
  }

  private static Integer[] generateArray(final int arrayLen) {
    final Random rand = new Random(System.currentTimeMillis());
    final Integer[] array = new Integer[arrayLen];
    for (int i = 0; i < array.length; i++)
      array[i] = rand.nextInt();
    return array;
  }

  public static <T> boolean containsAll(Sorting<T> sorting, final T[] array, Comparator<T> cmp) {
    final T[] originalArray = Arrays.copyOf(array, array.length);
    sorting.sort(array, cmp);
    if (originalArray.length != array.length)
      return false;
    for (int i = 0; i < originalArray.length; i++) {
      int j;
      for (j = 0; j < array.length; j++) {
        if (0 == cmp.compare(array[j], originalArray[i]))
          break;
      }
      if (j == array.length)
        return false;
    }
    return true;
  }

  public static <T> boolean isSorted(Sorting<T> sorting, final T[] array, Comparator<T> cmp) {
    sorting.sort(array, cmp);
    for (int i = 0; i < array.length - 1; i++) {
      if (0 < cmp.compare(array[i], array[i + 1]))
        return false;
    }
    return true;
  }

  @Test
  public void extremeCasesTest() {
    ComparatorInt cmpInt = new ComparatorInt();
    final Integer[] emptyArray = new Integer[0];
    final Integer[] sortedDescendingArray = new Integer[ARRAY_LEN];
    final Integer[] sortedAscendingArray = new Integer[ARRAY_LEN];

    for (final Sorting<Integer> sort : sortings) {
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
    ComparatorInt cmpInt = new ComparatorInt();
    final Integer[] array = generateArray(ARRAY_LEN);
    for (final Sorting<Integer> sort : sortings)
      Assert.assertTrue(isSorted(sort, array, cmpInt));
  }

  @Test
  public void containsAllTest() {
    ComparatorInt cmpInt = new ComparatorInt();
    final Integer[] array = generateArray(ARRAY_LEN);
    for (final Sorting<Integer> sort : sortings)
      Assert.assertTrue(containsAll(sort, array, cmpInt));
  }

  class ComparatorInt implements Comparator<Integer> {
    @Override
    public int compare(Integer int1, Integer int2) {
      return int1.compareTo(int2);
    }
  }
}
