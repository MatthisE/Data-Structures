package Trees;

public class BinarySearchTree<E> /*implements Tree<E>*/ {
    private int key;
    private E value;
    private BinarySearchTree<E> left;
    private BinarySearchTree<E> right;

    // other methods ingored

    public BinarySearchTree(int k, E v){
        this.key = k;
        this.value = v;
    }

    public BinarySearchTree<E> find(int k){
        if(this.key == k){
            return this;
        }
        else if(this.key > k){
            if(this.left == null){
                return null;
            }
            return this.left.find(k);
        }
        else{
            if(this.right == null){
                return null;
            }
            return this.right.find(k);
        }
    }

    public void add(int k, E v){
        BinarySearchTree<E> newTree = new BinarySearchTree<>(k, v);
        if(this.key == k){
            System.out.println("key already taken");
            return;
        }
        else if(this.key > k){
            if(left == null){
                left = newTree;
            }
            else{
                left.add(k, v);
            }
        }
        else{
            if(right == null){
                right = newTree;
            }
            else{
                right.add(k, v);
            }
        }
    }
}