public class LinkedListDeque<T> implements Deque<T> {
    private class StuffNode {
        T item;
        StuffNode next;
        StuffNode previous;

        StuffNode(T i, StuffNode n, StuffNode p) {
            item = i;
            next = n;
            previous = p;
        }
    }

    private StuffNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.previous = sentinel;
        size = 0;
    }
    @Override
    public void addFirst(T item) {
        StuffNode sn = new StuffNode(item, sentinel.next, sentinel);
        sentinel.next = sn;
        sn.next.previous = sn;
        size++;
    }

    @Override
    public void addLast(T item) {
        StuffNode sn = new StuffNode(item, sentinel, sentinel.previous);
        sentinel.previous = sn;
        sn.previous.next = sn;
        size++;
    }
    @Override
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        StuffNode sn = sentinel;
        while (sn.next != sentinel) {
            sn = sn.next;
            System.out.print(sn.item + " ");
        }
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        StuffNode sn = sentinel.next;
        sn.next.previous = sentinel;
        sentinel.next = sn.next;
        size--;
        return sn.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        StuffNode sn = sentinel.previous;
        sn.previous.next = sentinel;
        sentinel.previous = sn.previous;
        size--;
        return sn.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        StuffNode sn = sentinel.next;
        for (int i = 0; i < index; i++) {
            sn = sn.next;
        }
        return sn.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return getRecursiveHelper(sentinel.next, index);
    }

    private T getRecursiveHelper(StuffNode sn, int index) {
        if (index == 0) {
            return sn.item;
        }
        return getRecursiveHelper(sn.next, index - 1);
    }

}
