package nl.lveekhout.threads;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by eekhout.l on 16-02-2015.
 * class MotionEventThread
 */

public class TestMotionEventThread {

    private Queue<String> queue;

    public static void main(String[] args) throws InterruptedException {
        new TestMotionEventThread().doThread();
    }

    private void doThread() throws InterruptedException {
        queue = new LinkedList<>();
        MotionEventThread motionEventThread = new MotionEventThread("procesqueuethread");
        motionEventThread.setPriority(Thread.MIN_PRIORITY);
        motionEventThread.start();
        Thread.sleep(1000);
        queue.add("Laurens");
        Thread.sleep(1000);
        queue.add("Laurens");
        Thread.sleep(10000);
        queue.add("Laurens");
        motionEventThread.interrupt();
    }

    private class MotionEventThread extends Thread {

        public MotionEventThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                while (true) {
                    if (queue.size()>0) {
                        System.out.println(queue.remove());
                    }
                    sleep(1);
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted...");
            }
        }
    }
}

