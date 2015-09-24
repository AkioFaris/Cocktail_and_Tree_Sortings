import java.util.Arrays;

/**
 * Created by Akio on 19/09/2015.
 */
public class CocktailSort {
  private static <T> void swap(final T[] array, final int i, final int j) {
    final T tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
  public static <T> void sort(final T[] array, Comparator<T> cmp){
    int leftBorder = 0, rightBorder = array.length - 1;
    for (int i = 0; i < array.length; i++) {
      if (!(array[i] instanceof Comparable))
        return;
    }
    do
    {
      for (int i = leftBorder; i < rightBorder; i++)
        if(0 < cmp.compare(array[i], array[i+1]))
          swap(array, i, i+1);
      --rightBorder;
      for (int i = rightBorder; i > leftBorder; i--)
        if(0 > cmp.compare(array[i], array[i-1]))
          swap(array, i, i-1);
      ++leftBorder;
    } while (leftBorder <= rightBorder);
  }
}
