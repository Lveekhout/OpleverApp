package nl.lveekhout.queues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eekhout.l on 16-02-2015.
 * class MotionEventQueue
 */

public class MotionEventQueue {
    public static void main(String[] args) {
        Queue<QueueElement> stringQueue = new LinkedList<>();
        stringQueue.add(new QueueElement("naam", "Laurens"));
        stringQueue.add(new QueueElement("naam", "Piet"));
        stringQueue.add(new QueueElement("naam", "Sjaak"));
        System.out.println(stringQueue.remove().toString());
        stringQueue.add(new QueueElement("naam", "Lisa"));
        System.out.println(stringQueue.remove().toString());
        stringQueue.add(new QueueElement("naam", "Nely"));
        System.out.println(stringQueue.remove().toString());
        stringQueue.add(new QueueElement("naam", "Sjoerd"));
        System.out.println(stringQueue.remove().toString());
        System.out.println(stringQueue.remove().toString());
        System.out.println(stringQueue.remove().toString());
    }
}

class QueueElement {
    private String key;
    private String value;

    public QueueElement(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "QueueElement{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
