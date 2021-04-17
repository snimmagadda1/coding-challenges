package DataStructures;

import java.util.ArrayList;

/**
 * A basic (cool) HashTable implementation
 */
public class CoolHashTable<K, V> {

    private int MIN_SIZE = 10;
    private int maxBuckets; // capacity
    private int numBuckets; // current size of list
    // Array to store "chains"
    private ArrayList<CoolNode<K, V>> buckets;

    public CoolHashTable() {
        buckets = new ArrayList<>();
        maxBuckets = MIN_SIZE;

        for (int i = 0; i < maxBuckets; i++) {
            buckets.add(null);
        }
        System.out.println("CoolHashTable initialized w/ capacity: " + buckets.size() + " and size: " + numBuckets);
    }

    public int size() {
        return numBuckets;
    }

    public boolean isEmpty() {
        return numBuckets == 0;
    }

    /**
     * Puts a K,V pair in the Table
     * 
     * @param key
     * @param value
     * @return Previous value if existing, null otherwise
     */
    public V put(K key, V value) {

        // Get index
        int index = getKeyIndex(key);
        System.out.println("Calculated index: " + index + " for key: " + key);

        // Get chain at index
        CoolNode<K, V> head = buckets.get(index);

        // Traverse chain to check if already existing, and update & return old if true
        while (head != null) {
            if (head.key.equals(key)) {
                V temp = head.value;
                head.value = value;
                return temp;
            }
        }

        // Else put new value at head
        this.numBuckets++;
        head = buckets.get(index);
        CoolNode<K, V> newNode = new CoolNode<>(key, value);
        newNode.next = head;
        buckets.set(index, newNode);

        // Lastly check if we need to increase capacity to maintain 0.7 Load factor
        if ((1.0 * numBuckets) / maxBuckets >= 0.7) {
            // Create new list that is double size
            ArrayList<CoolNode<K, V>> old = buckets;
            buckets = new ArrayList<>();
            maxBuckets = 2 * maxBuckets;
            for (int i = 0; i < maxBuckets; i++) {
                buckets.add(null);
            }
            // Copy over each element from old to new array
            for (CoolNode<K, V> headNode : old) {
                while (headNode != null) {
                    this.put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }

        return null;
    }

    public V remove(K key) {
        // Get index
        int index = getKeyIndex(key);

        // Traverse chain at index to find key. When found, break, set prev.next =
        // found.next
        CoolNode<K, V> head = buckets.get(index);
        CoolNode<K, V> previous = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            previous = head;
            head = head.next;
        }

        // Case key is not in buckets
        if (head == null) {
            return null;
        }

        // First element in chain
        if (previous == null) {
            buckets.set(index, head.next);
        } else {
            previous.next = head.next;
        }
        return head.value;
    }

    /**
     * Gets a V value
     * 
     * @param key
     * @return null if not found
     */
    public V get(K key) {
        int index = getKeyIndex(key);
        CoolNode<K, V> head = buckets.get(index);

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * Computes index w/ hashcode
     * 
     * @param key
     * @return key % capacity
     */
    private int getKeyIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % maxBuckets;
    }

    /**
     * Represents an item in a bucket
     */
    class CoolNode<K, V> {
        K key;
        V value;
        CoolNode<K, V> next;

        public CoolNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        CoolHashTable<String, Integer> test = new CoolHashTable();
        test.put("a", 1);
        test.put("b", 2);
        test.put("c", 3);
        test.put("d", 4);
        System.out.println(test.size());
        System.out.println(test.get("c"));
        System.out.println(test.remove("a"));

    }
}
