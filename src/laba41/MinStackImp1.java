package laba41;

public class MinStackImp1 implements MinStack<Integer> {

    private Node head;
    private int size;

    public MinStackImp1() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void push(Integer value) {
        if (head == null) {
            head = new Node(value, value, null);
        } else {
            int newMin = Math.min(value, head.min);
            head = new Node(value, newMin, head);
        }
        size++;
    }

    @Override
    public Integer pop() {
        if (head == null) {
            return null;
        }
        int result = head.value;
        head = head.next;
        size--;
        return result;
    }

    @Override
    public Integer top() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    @Override
    public Integer min() {
        if (head == null) {
            return null;
        }
        return head.min;
    }
}
