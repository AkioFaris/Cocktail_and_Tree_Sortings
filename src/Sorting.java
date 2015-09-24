/**
 * Created by Akio on 18/09/2015.
 */
public interface Sorting<T> {
  void sort(final T[] array, Comparator<T> cmp);
}
