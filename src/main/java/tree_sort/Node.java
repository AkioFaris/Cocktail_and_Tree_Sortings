package main.java.tree_sort;

/**
 * Created by Akio on 29/09/2015.
 */
public class Node<T> {
  private final T data;
  private Node<T> left;
  private Node<T> right;

  public Node(T d) {
    data = d;
    left = null;
    right = null;
  }

  public T getData() {
    return data;
  }

  public Node<T> getLeft() {
    return left;
  }

  public void setLeft(Node<T> left) {
    this.left = left;
  }

  public Node<T> getRight() {
    return right;
  }

  public void setRight(Node<T> right) {
    this.right = right;
  }
}

