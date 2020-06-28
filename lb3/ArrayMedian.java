package lb3;
import java.util.NoSuchElementException;

public class ArrayMedian {
    private int medianIndex = -1;
    private Comparable[] array;
    private int n = 0;

    public ArrayMedian(int startSize) {
        if (startSize < 1) throw new NegativeArraySizeException();
        array = new Comparable[startSize];
    }

    private Comparable[] resize(Comparable[] array, int newSize) {
        Comparable[] old_array = array;
        array = new Comparable[newSize];
        for (int i = 0; i < old_array.length; i++) {
            array[i] = old_array[i];
        }
        return array;
    }

    private int add_item(Comparable[] array, Comparable item, int n) {
        int index = bin_search(array, item, n);
        free_index(array, index, n);
        array[index] = item;
        return index;
    }

    private void free_index(Comparable[] array, int index, int n) {
        int i = n-1;
        while (i > index-1) {
            array[i+1] = array[i];
            i--;
        }
    }

    private int bin_search(Comparable[] array, Comparable item, int n) {
        int position;
        int first = 0;
        int last = n-1;
        position = n / 2;
        if (n%2 == 0) position--;
        while (array[position] != item) {
            if (array[position].compareTo(item) > 0) {
                last = position - 1;
            } else {
                first = position + 1;
            }
            if (last < first) {
                return first;
            }
            if (last == first) {
                if (array[last].compareTo(item) <= 0) return last+1;
                return last;
            }
            position = (first + last) / 2;
        }
        return position+1;
    }

    private int findMedianIndex(int n) {
        return n/2;
    }

    public void push(Comparable item) {
        if (medianIndex == -1) {
            array[0] = item;
            n = 1;
            medianIndex = 0;
        } else {
            if (n == array.length)
                array = resize(array, n*2);

            add_item(array, item, n);
            n++;
            medianIndex = findMedianIndex(n);
        }
    }

    public Comparable getMedian() {
        if (medianIndex == -1) throw new NoSuchElementException("Array is empty!");
        return array[medianIndex];
    }
}
