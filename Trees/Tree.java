package Trees;

public interface Tree<E> {
    // all methods in an interface are public per default
    int getKey(); // index
    E getValue();
    int height();
    int size();
    Tree<E> find(int k); // find the subtree with given key
}