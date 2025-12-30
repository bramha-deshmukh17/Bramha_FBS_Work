package assignment.assignment1;

public class StackEditor {
	String[] arr;
    int top;

    public StackEditor(int size) {
        arr = new String[size];
        top = -1;
    }

    public boolean isFull() {
        return top == arr.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(String str) {
        if (!isFull())
            arr[++top] = str;
        else
            System.out.println("Stack overflow");
    }

    public String pop() {
        if (!isEmpty())
            return arr[top--];
        else
            return null;
    }

    public void display() {
    	if(!isEmpty()) {
    		for (int i = 0; i <= top; i++) {
    			System.out.println(arr[i]);
    		}
    	}else {
    		System.out.println("Nothing to Undo");
    	}
    }
}
