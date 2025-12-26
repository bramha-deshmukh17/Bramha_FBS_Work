package classwork.dec26;

public class StackChar {
    char[] arr;
    int top;

    public StackChar(int size) {
        arr = new char[size];
        top = -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(char num) {
        if (!isFull())
            arr[++top] = num;
        else
            System.out.println("Stack overflow");
    }

    public char pop() {
        if (!isEmpty())
            return arr[top--];
        else
            return '1';
    }

    public char peek() {
        if (!isEmpty())
            return arr[top];
        else
            return '1';
    }
}
