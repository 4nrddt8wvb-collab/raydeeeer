package laba41;

public interface MinStack<T extends Number> {
    void push(T value);
    T pop();
    T top();
    T min();
}