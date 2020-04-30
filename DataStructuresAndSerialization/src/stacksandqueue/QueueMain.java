package stacksandqueue;

public class QueueMain {
    public static void main(String[] args) {
        JerQueue attention = new JerQueue();
        attention.enqueue("Andrew");
        attention.enqueue("Aaron");
        attention.enqueue("Chelsey");
        attention.enqueue("Hannah");
        attention.enqueue("Spencer");

        System.out.println(attention.dequeue());
        System.out.println(attention.dequeue());
        System.out.println(attention.dequeue());
        System.out.println(attention.dequeue());
        System.out.println(attention.dequeue());
    }
}
