import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Akio on 17/09/2015.
 */

public class SortingTest {
  private static final int ARRAY_LEN = 10;
// (!) To add a collection of sortings
  private static Integer[] generateArray(final int arrayLen)
  {
    final Random rand = new Random(System.currentTimeMillis());
    final Integer[] array = new Integer[arrayLen];
    for (int i = 0; i < array.length; i++)
      array[i] = rand.nextInt();
    return array;
  }

  public static <T> boolean containsAll(Sorting<T> sorting, final T[] array, Comparator<T> cmp)
  {
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
  public static <T> boolean isSorted(Sorting<T> sorting, final T[] array, Comparator<T> cmp)
  {
    sorting.sort(array, cmp);
    for (int i = 0; i < array.length - 1; i++) {
      if (0 < cmp.compare(array[i], array[i + 1]))
        return false;
    }
    return true;
  }

  @Test
  public void extremeCasesTest()
  {
    ComparatorInt cmpInt = new ComparatorInt();
    final Integer[] emptyArray = new Integer[0];
    final Integer[] sortedDescendingArray = new Integer[ARRAY_LEN];
    final Integer[] sortedAscendingArray = new Integer[ARRAY_LEN];

    for (int i = 0; i < sortedAscendingArray.length; i++) {
      sortedAscendingArray[i] = i;
      sortedDescendingArray[i] = sortedDescendingArray.length - i;
    }
    Assert.assertTrue(isSorted(CocktailSort::sort, emptyArray, cmpInt));
    Assert.assertTrue(isSorted(CocktailSort::sort, sortedDescendingArray, cmpInt));
    Assert.assertTrue(isSorted(CocktailSort::sort, sortedAscendingArray, cmpInt));
  }
  @Test
  public void isSortedTest()
  {
    ComparatorInt cmpInt = new ComparatorInt();
    final Integer[] array = generateArray(ARRAY_LEN);
    Assert.assertTrue(isSorted(CocktailSort::sort, array, cmpInt));
  }
  @Test
  public void containsAllTest()
  {
    ComparatorInt cmpInt = new ComparatorInt();
    final Integer[] array = generateArray(ARRAY_LEN);
    Assert.assertTrue(containsAll(CocktailSort::sort, array, cmpInt));
  }

  /*public static void main(String[] args)
  {
    final Integer[] array = generateArray(ARRAY_LEN);
  }*/

  class ComparatorInt implements Comparator<Integer> {
    @Override
    public int compare(Integer int1, Integer int2) {
      return int1.compareTo(int2);
    }
  }
}
