package com.example.springcloud.entities;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> addOrRemove = new ArrayBlockingQueue<>(3);
        BlockingQueue<String> offerOrPull = new ArrayBlockingQueue<>(3);
        BlockingQueue<String> putOrTake = new ArrayBlockingQueue<>(3);
        BlockingQueue<String> offerOrPull2 = new ArrayBlockingQueue<>(3);
        System.out.println(addOrRemove.add("a"));//true
        System.out.println(addOrRemove.add("b"));//true
        System.out.println(addOrRemove.add("c"));//true
//        System.out.println(blockingQueue.add("d"));//抛异常 java.lang.IllegalStateException

        System.out.println(addOrRemove.element());//a

        System.out.println(addOrRemove.remove());//a
        System.out.println(addOrRemove.remove());//b
        System.out.println(addOrRemove.remove());//c
//        System.out.println(addOrRemove.remove());//抛异常 java.util.NoSuchElementException

        System.out.println("========================");
        System.out.println(offerOrPull.offer("a"));//true
        System.out.println(offerOrPull.offer("b"));//true
        System.out.println(offerOrPull.offer("c"));//true
//        System.out.println(blockingQueue.offer("d"));//false

        System.out.println(offerOrPull.peek());//a

        System.out.println(offerOrPull.poll());//a
        System.out.println(offerOrPull.poll());//b
        System.out.println(offerOrPull.poll());//c
        System.out.println(offerOrPull.poll());//null

        System.out.println("========================");

        putOrTake.put("a");
        putOrTake.put("b");
        putOrTake.put("c");
//        putOrTake.put("d");//阻塞

        System.out.println(putOrTake.take());
        System.out.println(putOrTake.take());
        System.out.println(putOrTake.take());
//        System.out.println(putOrTake.take());//阻塞

        System.out.println("========================");
        System.out.println(offerOrPull2.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(offerOrPull2.offer("b", 2L, TimeUnit.SECONDS));
        System.out.println(offerOrPull2.offer("c", 2L, TimeUnit.SECONDS));
//        System.out.println(offerOrPull2.offer("d", 2L, TimeUnit.SECONDS));//超时退出

        System.out.println(offerOrPull2.poll(2L, TimeUnit.SECONDS));
        System.out.println(offerOrPull2.poll(2L, TimeUnit.SECONDS));
        System.out.println(offerOrPull2.poll(2L, TimeUnit.SECONDS));
        System.out.println(offerOrPull2.poll(2L, TimeUnit.SECONDS));

    }

}
