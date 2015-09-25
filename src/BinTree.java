/**
 * Created by Akio on 24/09/2015.
 */
public class BinTree<T> {
  public BinTree() {
    root_ = new Node<>(null);
  }

  private Node<T> insertNode(Node<T> tree, final Node<T> node, Comparator<T> cmp) {
    if (tree == null)
      tree = new Node<>(null);
    if (tree.data_ == null)
      tree = node;
    else {
      if (0 < cmp.compare(tree.data_, node.data_))
        tree.left_ = insertNode(tree.left_, node, cmp);
      else
        tree.right_ = insertNode(tree.right_, node, cmp);
    }
    return tree;
  }

  public void insert(T data, Comparator<T> cmp) {
    Node<T> node = new Node<>(data);
    root_ = insertNode(root_, node, cmp);
  }

  public Node<T> root_;
}
