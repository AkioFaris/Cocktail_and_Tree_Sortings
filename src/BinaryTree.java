/**
 * Created by Akio on 19/09/2015.
 */
public class BinaryTree {
  /*
  * typedef struct tree
  {
    int a;              // данные
    struct tree *left;  // левый  преемник
    struct tree *right; // правый преемник
  } TREE;

TREE *add_to_tree(TREE *root, int new_value)
{
   if (root==NULL)  // если дошли до корня - создаем новый элемент
     {
        root = (TREE*)malloc(sizeof(TREE));
        root->a = new_value;
        root->left = root->right = 0;
        return root;
     }
   if less(root->a, new_value)          // добавлем ветвь
     root->right = add_to_tree(root->right, new_value);
   else
     root->left  = add_to_tree(root->left,  new_value);
   return root;
}

void tree_to_array(TREE *root, int a[]) // процедура заполнения массива
  {
    static max2=0;                      // счетчик элементов нового массива
    if (root==NULL) return;             // условие окончания - найден корень
    tree_to_array(root->left, a);       // обход левого поддерева
    a[max2++] = root->a;
    tree_to_array(root->right, a);      // обход правого поддерева
    free(root);
  }
 */
}
