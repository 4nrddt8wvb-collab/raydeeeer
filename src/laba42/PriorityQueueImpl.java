package laba42;
import java.util.Arrays;

public class PriorityQueueImpl implements PriorityQueue<Integer> {

    private static class Entry implements Comparable<Entry> {
        final long operation;
        final int value;
        final int version;

        Entry(long operation, int value, int version) {
            this.operation = operation;
            this.value = value;
            this.version = version;
        }

        @Override
        public int compareTo(Entry other) {
            int cmp = Integer.compare(other.value, this.value);
            if (cmp != 0) {
                return cmp;
            }
            return Long.compare(this.operation, other.operation);
        }
    }

    private final java.util.PriorityQueue<Entry> heap = new java.util.PriorityQueue<>();

    private long counter = 0;

    private int[] values;
    private int[] versions;
    private boolean[] active;

    public PriorityQueueImpl() {
        int initialCapacity = 17;
        values = new int[initialCapacity];
        versions = new int[initialCapacity];
        active = new boolean[initialCapacity];
    }

    private void ensureCapacity(long op) {
        if (op < values.length) {
            return;
        }
        int newCapacity = (int) Math.max(op + 1, values.length * 2L);
        values = Arrays.copyOf(values, newCapacity);
        versions = Arrays.copyOf(versions, newCapacity);
        active = Arrays.copyOf(active, newCapacity);
    }

    @Override
    public void enqueue(Integer value) {
        counter++;
        ensureCapacity(counter);

        int op = (int) counter;
        values[op] = value;
        versions[op] = 0;
        active[op] = true;

        heap.add(new Entry(counter, value, 0));
    }

    public long[] dequeueMaxWithInfo() {
        while (!heap.isEmpty()) {
            Entry top = heap.peek();
            int op = (int) top.operation;

            if (!active[op] || versions[op] != top.version) {
                heap.poll();
                continue;
            }

            heap.poll();
            active[op] = false;
            return new long[]{top.operation, top.value};
        }
        return null;
    }

    @Override
    public Integer dequeueMax() {
        long[] result = dequeueMaxWithInfo();
        if (result == null) {
            return null;
        }
        return (int) result[1];
    }

    @Override
    public void increment(long operation, Integer addition) {
        if (operation < 1 || operation > counter) {
            return;
        }

        int op = (int) operation;

        if (!active[op]) {
            return;
        }

        values[op] += addition;
        versions[op]++;

        heap.add(new Entry(operation, values[op], versions[op]));
    }
}