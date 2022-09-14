package Lists;

public class ArrayList<E> {
    private int capacity = 10;
    private E[] data = (E[])(new Object[capacity]);
    private int size = 0;

    public void add(E element) {
        if (size == capacity) {
            capacity = capacity * 2;
            E[] temp = (E[])(new Object[capacity]);
            System.arraycopy(data, 0, temp, 0, data.length);
            data = temp;
        }
        data[size] = element;
        size++;
    }

    public void add(int index, E element){
        if(index<size+1 && index>-1) {
            if (size == capacity) {
                capacity = capacity * 2;
            }

            E[] temp = (E[]) (new Object[capacity]);

            for (int i = 0; i < index; i++) {
                temp[i] = data[i];
            }

            temp[index] = element;

            for (int i = index + 1; i < size+1; i++) {
                temp[i] = data[i-1];
            }

            data = temp;
            size++;
        }
        else{
            throw new IndexOutOfBoundException();
        }
    }

    public void addFirst(E o){
        add(0, o);
    }

    public void remove(int idx) throws IndexOutOfBoundException {
        if (idx >= 0 && idx < size){
            for (int i = idx; i < size-1; i++) {
                data[i] = data[i+1];
            }
            size--;
        } else {
            throw new IndexOutOfBoundException();
        }
    }

    public void removeFirst(){
        remove(0);
    }

    public void removeLast(){
        remove(size-1);
    }

    public void clear(){
        E[] temp = (E[])(new Object[capacity]);
        data = temp;
        size = 0;
    }

    public E get(int idx) throws IndexOutOfBoundException{
        if (idx >= 0 && idx < size) {
            return data[idx];
        } else {
            throw new IndexOutOfBoundException();
        }
    }

    public void set(int idx, E ele){
        data[idx] = ele;
    }

    public int size() {
        return size;
    }

    public int indexOf(Object obj) throws IndexOutOfBoundException{
        for(int i = 0; i<size; i++){
            if(data[i].equals(obj)){
                return i;
            }
        }
        throw new IndexOutOfBoundException();
    }

    public E valueOfHead(){
        return data[0];
    }

    public ArrayList<E> tail(){
        ArrayList<E> tail = new ArrayList<E>();
        tail.capacity = this.capacity;
        tail.data = this.data;
        tail.size = this.size;
        tail.removeFirst();
        return tail;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E o){
        for(int i = 0; i<size; i++){
            if(data[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<E> reverse(){
        ArrayList<E> reverse = new ArrayList<E>();
        for(int i = this.size-1; i>-1; i--){
            reverse.add(data[i]);
        }
        return reverse;
    }

    public String toString(){
        String s = "";
        for(int i=0; i<size; i++){
            s=s+data[i].toString()+" ";
        }
        return s;
    }
}
