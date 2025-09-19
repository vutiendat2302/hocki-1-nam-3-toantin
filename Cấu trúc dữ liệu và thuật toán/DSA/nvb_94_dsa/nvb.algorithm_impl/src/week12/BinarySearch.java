package week12;

public class BinarySearch<Key extends Comparable<Key>> {
    public int binarySearch(Key[] data ,Key key) {
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid].compareTo(key) == 0) {
                return mid;
            }
            if (data[mid].compareTo(key) < 0) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
