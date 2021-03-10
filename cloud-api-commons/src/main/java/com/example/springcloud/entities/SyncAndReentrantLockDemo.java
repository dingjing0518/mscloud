package com.example.springcloud.entities;


import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目 ：Synchronized和 Lock有什么区别？用新的Lock有什么好处？你举例说说
 * 1.原始构成
 * Synchronized是关键字属于JVM层面
 * monitorenter(底层是通过monitor对象来完成，其实wait/notify等方法也依赖于monitor对象，只有在同步代码块中才能调用wait/notofy等方法)
 * monitoexit
 * Lock是具体类（java.util.concurrent.locks.Lock）是api层面的锁
 * 2.使用方法
 * Synchronized  不需要用户手动释放锁，系统在代码块执行完成后自动释放
 * Lock 则需要用户手动释放锁，若没有主动释放锁，就有可能出现死锁现象
 * 3.等待是否中断
 * Synchronized不可中断，除非抛异常或者正常运行完成
 * Lock可中断
 * 4.加锁是否公平
 * Synchronized是非公平锁
 * Lock默认非公平  可公平
 * 5.锁绑定多个条件Condition
 * Synchronized  没有
 * Lock 精确唤醒
 * <p>
 * ============================================================================
 * 题目：多线程之间按顺序调用，实现A-->B-->C三个线程启动，要求如下：
 * AA打印5次，BB打印 10次，CC打印15次
 * .....
 * 来 10轮
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {

    }
}
