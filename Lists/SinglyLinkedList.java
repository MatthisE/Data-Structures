package Lists;

//import java.util.List;

public class SinglyLinkedList<E>{
    private SinglyLinkedNode<E> head = null;

    public void add(E o) {
        SinglyLinkedNode<E> node = new SinglyLinkedNode<>();
        node.value = o;
        if (head == null) {
            head = node;
            return;
        }
        SinglyLinkedNode<E> cursor = head;
        while (cursor.next != null) {
            cursor = cursor.next;
        }
        cursor.next = node;
    }

    public void add(E o, int i){
        if (i < 0 || i >= this.size()) {
            throw new IndexOutOfBoundException();
        }
        SinglyLinkedNode<E> node = new SinglyLinkedNode<>();
        node.value=o;
        if(i==0){
            node.next=head;
            head=node;
        }
        else{
            SinglyLinkedNode<E> cursor = new SinglyLinkedNode<>();
            for(int c=0; c<i; c++){
                cursor=cursor.next;
            }
            cursor.next=node;
        }
    }

    public void addFirst(E o) {
        SinglyLinkedNode<E> node = new SinglyLinkedNode<>();
        node.value = o;
        node.next = head;
        head = node;
    }

    public void remove(int idx){
        int c = 0;
        if (idx < 0 || idx >= this.size()) {
            throw new IndexOutOfBoundException();
        }
        if (idx == 0){
            head = head.next;
            return;
        }
        SinglyLinkedNode<E> cursor = head;
        while (c < idx-1){
            cursor = cursor.next;
            c++;
        }
        cursor.next = cursor.next.next;
    }

    public void removeFirst(){
        head = head.next;
    }

    public void removeLast(){
        int c = 0;
        if (head == null) {
            throw new IndexOutOfBoundException();
        }
        int idx = this.size()-1;
        SinglyLinkedNode<E> cursor = head;
        while (c < idx-1){
            cursor = cursor.next;
            c++;
        }
        cursor.next = null;
    }

    public void clear(){
        this.head = null;
    }

    public E get(int i) {
        SinglyLinkedNode<E> cursor = head;
        int c = 0;
        while (c < i) {
            c++;
            cursor = cursor.next;
        }
        return cursor.value;
    }

    public void set(int idx, E ele){
        SinglyLinkedNode<E> cursor = head;
        int c = 0;
        while (c < idx) {
            c++;
            cursor = cursor.next;
        }
        cursor.value = ele;
    }

    public int size() {
        int c = 0;
        SinglyLinkedNode<E> cursor = head;
        while (cursor != null) {
            c++;
            cursor = cursor.next;
        }
        return c;
    }

    public int indexOf(Object obj) {
        int c = 0;
        SinglyLinkedNode<E> cursor = head;
        while (cursor != null) {
            if (cursor.value.equals(obj)) {
                return c;
            }
            c++;
            cursor = cursor.next;
        }
        return -1;
    }

    public E valueOfHead() {
        return head.value;
    }

    public SinglyLinkedList<E> tail() {
        if (head == null) {
            throw new EmptyListException();
        }
        SinglyLinkedList<E> newList = new SinglyLinkedList<>();
        newList.head = head.next;
        return newList;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public boolean contains(E o){
        SinglyLinkedNode<E> cursor = new SinglyLinkedNode<>();
        while(cursor.next!=null){
            if(cursor.value.equals(o)){
                return true;
            }
            cursor=cursor.next;
        }
        return false;
    }

    public int min(){
        int min=Integer.MAX_VALUE;
        SinglyLinkedNode<E> cursor = new SinglyLinkedNode<>();
        while(cursor.next!=null){
            if((int)cursor.value<min){
                min=(int)cursor.value;
            }
        }
        return min;
    }

    public SinglyLinkedList reverse(){
        SinglyLinkedList<E> SLL = new SinglyLinkedList<E>();
        for(int idx=size()-1; idx>-1; idx--){
            SLL.add(get(idx));
        }
        return SLL;
    }

    public String toString(){
        String s = "";
        for(int idx=0; idx<size(); idx++){
            s=s+get(idx).toString()+" ";
        }
        return s;
    }
}
