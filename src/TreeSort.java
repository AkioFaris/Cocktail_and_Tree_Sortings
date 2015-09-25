/**
 * Created by Akio on 19/09/2015.
 */
public class TreeSort {
  public static <T> void sort(final T[] array, Comparator<T> cmp) {
    final BinTree<T> bst = new BinTree<>();
    for (int i = 0; i < array.length; i++)
      bst.insert(array[i], cmp);
    if (bst.root_.data_ != null) {
      arrayInd = 0;
      treeToArray(bst.root_, array);
    }
  }

  private static <T> void treeToArray(final Node<T> node, final T[] array) {
    if (node == null)
      return;
    treeToArray(node.left_, array);
    array[arrayInd++] = node.data_;
    treeToArray(node.right_, array);
  }

  static int arrayInd;
}
