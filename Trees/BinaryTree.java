package Trees;

public class BinaryTree<E> implements Tree<E>{
    private int key; // index
    private E value;
    private BinaryTree<E> left = null;
    private BinaryTree<E> right = null;

    public BinaryTree(int k, E v){
        this.key = k;
        this.value = v;
    }

    public void setLeft(BinaryTree<E> left){
        this.left = left;
    }

    public void setRight(BinaryTree<E> right){
        this.right = right;
    }

    public E getValue(){
        return value;
    }

    public int getKey(){
        return key;
    }

    public int height(){
        int heightLeft = -1;
        int heightRight = -1;
        if(left != null){
            heightLeft = left.height();
        }
        if(right != null){
            heightRight = right.height();
        }
        return Math.max(heightLeft, heightRight) + 1;
    }

    public int size(){
        int sizeLeft = 0;
        int sizeRight = 0;
        if(left != null){
            sizeLeft = left.size();
        }
        if(right != null){
            sizeRight = right.size();
        }
        return sizeLeft + sizeRight + 1;
    }

    public BinaryTree<E> find(int k){
        if(key == k){
            return this;
        }
        if(left != null){
            BinaryTree<E> leftRes = left.find(k);
            if(leftRes != null){
                return leftRes;
            }
        }
        if(right != null){
            BinaryTree<E> rightRes = right.find(k);
            if(rightRes != null){
                return rightRes;
            }
        }
        return null;
    }

    public void preorder(){
        System.out.println(this.value);
        if(this.left != null){
            left.preorder();
        }
        if(this.right != null){
            right.preorder();
        }
    }

    public void postorder(){
        if(this.left != null){
            left.postorder();
        }
        if(this.right != null){
            right.postorder();
        }
        System.out.println(this.value);
    }

    public void inorder(){
        if(this.left != null){
            left.inorder();
        }
        System.out.println(this.value);
        if(this.right != null){
            right.inorder();
        }
    }
}