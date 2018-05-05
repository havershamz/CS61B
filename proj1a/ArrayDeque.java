public class ArrayDeque<T> {
    private int beforeFirst;
    private int afterLast;
    private int size;
    private T[] items;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        beforeFirst = 0;
        afterLast = 1;
        size = 0;
    }

    public void addFirst(T item) {
        resize();
        items[beforeFirst] = item;
        beforeFirst = minusOne(beforeFirst);
        size++;
    }

    public void addLast(T item) {
        resize();
        items[afterLast] = item;
        afterLast = plusOne(afterLast);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
    }

    public T removeFirst() {
        if (size != 0) {
            T removed = get(0);
            set(0,null);
            beforeFirst = plusOne(beforeFirst);
            size--;
            resize();
            return removed;
        }
        return null;
    }

    public T removeLast() {
        if (size != 0) {
            T removed = get(size - 1);
            set(size-1, null);
            afterLast = minusOne(afterLast);
            size--;
            resize();
            return removed;

        }
        return null;
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            return items[getTrueIndex(index)];
        }
        return null;
    }

    private void set(int index, T item) {
        items[getTrueIndex(index)] = item;
    }

    private int getTrueIndex(int index) {
        return (index + beforeFirst + 1) % items.length;
    }

    private int minusOne(int index) {
        index--;
        if (index < 0) {
            index += items.length;
        }
        return index;
    }

    private int plusOne(int index) {
        index++;
        if (index >= items.length) {
            index = 0;
        }
        return index;
    }

    private void resize() {
        T[] newItems = null;
        if (size == items.length) {
            newItems = (T[]) new Object[2 * items.length];
        }else if (items.length * 0.25 > size && size > 16) {
            newItems = (T[]) new Object[items.length / 4];
        }
        if (newItems != null) {
            int first = plusOne(beforeFirst);
            int last = minusOne(afterLast);
            if (first <= last) {
                System.arraycopy(items, first, newItems, 1, size);
            } else {
                int firstLength = items.length - first;
                System.arraycopy(items, first, newItems, 1, firstLength);
                System.arraycopy(items, 0, newItems, firstLength + 1, afterLast);
            }
            items = newItems;
            beforeFirst = 0;
            afterLast = size + 1;
        }
    }
}
