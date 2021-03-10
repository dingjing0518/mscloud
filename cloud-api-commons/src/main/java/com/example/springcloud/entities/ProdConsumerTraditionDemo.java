package com.example.springcloud.entities;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 共享资源类
 */
class ShareData {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t lock.lock()");
        lock.lock();
        try {
            //判断
            while (num != 0) {
                //等待 不加1
                System.out.println(Thread.currentThread().getName() + "\t num != 0");
                condition.await();
            }
            //干活
            num++;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //通知唤醒
            condition.signalAll();
        } finally {
            System.out.println(Thread.currentThread().getName() + "\t lock.unlock()");
            lock.unlock();
        }
    }

    public void deIncrement() throws Exception {
        lock.lock();
        try {
            //判断
            while (num == 0) {
                //等待 不减一
                condition.await();
            }
            //干活
            num--;
            System.out.println(Thread.currentThread().getName() + "\t" + num);
            //通知唤醒
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * Description
 * 一个初始值为0的变量 两个线程交替操作 一个加1 一个减1来5轮
 * 1. 线程 操作 资源类
 * 2. 判断 干活 通知
 * 3. 防止虚假唤醒
 **/
public class ProdConsumerTraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    shareData.deIncrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
    }
}
