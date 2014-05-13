package chapter8.question10;
import java.util.LinkedList;

public class Hash <K, V> {
    private final int MAX_SIZE = 5;
    LinkedList<Cell<K, V>>[] items;

    public Hash() {
        items = new LinkedList[MAX_SIZE];
    }

    public int hashCodeofKey(K key) {
        return key.toString().length() % items.length;
    }

    public void put(K key, V value) {
        int x= hashCodeofKey(key);
        if(items[x] == null) {
            items[x] = new LinkedList<Cell<K, V>>();
        }
        LinkedList<Cell<K, V>> collided = items[x];
        for (Cell<K, V> c : collided) {
            if(c.equivalent(key)) {
                collided.remove(c);
                break;
            }
        }
        Cell<K, V> cell = new Cell<K,V>(key, value);
        collided.add(cell);
    }

    public V get(K key) {
        int x = hashCodeofKey(key);
        if(items[x] == null) {
            return null;
        }
        LinkedList<Cell<K, V>> collided = items[x];
        for (Cell<K, V> cell : collided) {
            if(cell.equivalent(key)) {
                return cell.getValue();
            }
        }
        return null;
    }

    public void debugPrintHash() {
        for(int i = 0; i < items.length; i++) {
            System.out.print(i + ": ");
            LinkedList<Cell<K, V>> list = items[i];
            if(list != null) {
                for(Cell<K, V> cell : list) {
                    System.out.print(cell.toString() + ", ");
                }
            }
            System.out.println();
        }
    }
}
