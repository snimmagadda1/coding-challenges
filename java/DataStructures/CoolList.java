package DataStructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A basic (cool) ArrayList implementation
 */
public class CoolList<E> implements Iterable<E> {

    private int size = 0;
    private static final int MIN_CAP = 10;
    private Object[] elements;

    public CoolList() {
        this.elements = new Object[MIN_CAP];
    }

    public Iterator<E> iterator() {
        return new CoolIterator();
    }

    public int size() {
        return size;
    }

    public boolean add(E e) {
        // Capacity case, double
        if (size >= elements.length) {
            this.increaseCap(elements);
        }

        elements[size++] = e;
        return true;
    }

    @SuppressWarnings("unchecked")
    public boolean addAll(CoolList<E> elems) {
        for (int i = 0; i < elems.size(); i++) {
            add((E) elems.get(i));
        }
        return true;
    }

    public Object get(int index) {
        if (index < size) {
            return elements[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index >= size) {
            throw new NoSuchElementException();
        }

        E popped = (E) elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }

        return popped;
    }

    private void increaseCap(Object[] current) {
        Object[] newList = new Object[size * 2];
        System.out.println("New length of CoolList: " + newList.length);
        for (int i = 0; i < current.length; i++) {
            newList[i] = current[i];
        }
    }

    class CoolIterator implements Iterator<E> {

        private int cursor = 0;

        // Checks if the next element exists
        public boolean hasNext() {
            return cursor < size;
        }

        // moves the cursor/iterator to next element
        @SuppressWarnings("unchecked")
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) elements[cursor++];
        }

        // Used to remove an element. Implement only if needed
        public void remove() {
            CoolList.this.remove(cursor--);
        }
    }

    public static void main(String[] args) {
        CoolList<String> l1 = new CoolList<String>();
        l1.add("hi");
        l1.add("sai");
        System.out.println(l1);

        CoolList<String> l2 = new CoolList<String>();
        l2.add("you");
        l2.add("are");
        l2.add("cool");

        for (int i = 0; i < l1.size(); i++) {
            System.out.println("The current element is: " + l1.get(i));
        }

        l1.addAll(l2);

        for (int i = 0; i < l1.size(); i++) {
            System.out.println("The current element is: " + l1.get(i));
        }

        // Iterator
        for (String s : l1) {
            System.out.println("The current iterator element is: " + s);
        }
    }
}
