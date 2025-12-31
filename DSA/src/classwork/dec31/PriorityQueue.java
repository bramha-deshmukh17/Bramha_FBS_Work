package classwork.dec31;

public class PriorityQueue {
    int front = -1, rear = -1;
    int[] arr;

    public PriorityQueue(int size) {
        arr = new int[size];
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("PriorityQueue is full");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
            arr[rear] = data;
        } else {
            int i = rear;
            int nextIdx = i+1;
            while (true) {
                //int nextIdx = (i + 1) % arr.length;
                if(i!=arr.length-1)
                    nextIdx++;
                else
                    nextIdx=0;
                if (arr[i] > data) {
                    arr[nextIdx] = arr[i];

                    if (i == front) {
                        arr[i] = data;
                        break;
                    }
                    // i = (i - 1 + arr.length) % arr.length;
                    if(i!=0)
                        i--;
                    else
                        i=arr.length-1;
                } else {
                    arr[nextIdx] = data;
                    break;
                }
            }
            rear = (rear + 1) % arr.length;
        }
    }

    public int dequeue() {
        int num = -1;
        if (!isEmpty()) {
            num = arr[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else if (front == arr.length - 1) {
                front = 0;
            } else {
                front++;
            }

        }
        return num;
    }

    public void display() {
        System.out.print("\nPriority Queue elements are: ");
        if (!isEmpty()) {
            int i = front;
            while (i != rear) {
                System.out.print(arr[i] + " ");
                if (i == arr.length - 1)
                    i = 0;
                else
                    i++;
            }
            System.out.print(arr[i]);
        }
    }

    boolean isEmpty() {
        return rear == -1;
    }

    boolean isFull() {
        if ((arr.length - 1 == rear && front == 0) || (front - 1 == rear)) {
            return true;
        } else {
            return false;
        }
    }
}
