package DataStructures;

/**
 * Homegrown ArrayList
 */
public class CoolList<E> {

    private int size = 0;
    private static final int MIN_CAP = 10;
    private Object[] elements;

    public CoolList() {
        this.elements = new Object[MIN_CAP];
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

    public Object get(int index) {
        if (index < size) {
            return elements[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void increaseCap(Object[] current) {
        Object[] newList = new Object[size * 2];
        System.out.println("New length of CoolList: " + newList.length);
        for (int i = 0; i < current.length; i++) {
            newList[i] = current[i];
        }
    }

    public static void main(String[] args) {
        CoolList<String> saiList = new CoolList<String>();
        saiList.add("hi");
        saiList.add("sai");
        System.out.println(saiList);

        for (int i = 0; i < saiList.size(); i++) {
            System.out.println("The current element is: " + saiList.get(i));
        }
    }
}
