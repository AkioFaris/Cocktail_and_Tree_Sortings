/**
 * Created by Akio on 19/09/2015.
 */
public class BinaryTree {
  /*
  * typedef struct tree
  {
    int a;              // ������
    struct tree *left;  // �����  ��������
    struct tree *right; // ������ ��������
  } TREE;

TREE *add_to_tree(TREE *root, int new_value)
{
   if (root==NULL)  // ���� ����� �� ����� - ������� ����� �������
     {
        root = (TREE*)malloc(sizeof(TREE));
        root->a = new_value;
        root->left = root->right = 0;
        return root;
     }
   if less(root->a, new_value)          // �������� �����
     root->right = add_to_tree(root->right, new_value);
   else
     root->left  = add_to_tree(root->left,  new_value);
   return root;
}

void tree_to_array(TREE *root, int a[]) // ��������� ���������� �������
  {
    static max2=0;                      // ������� ��������� ������ �������
    if (root==NULL) return;             // ������� ��������� - ������ ������
    tree_to_array(root->left, a);       // ����� ������ ���������
    a[max2++] = root->a;
    tree_to_array(root->right, a);      // ����� ������� ���������
    free(root);
  }
 */
}
