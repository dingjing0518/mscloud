package com.example.springcloud.entities;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        Set<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        List synchronizedList = Collections.synchronizedList(new ArrayList<>());
        Set<String> hashSet = new HashSet<>();
        Map<String, String> hashMap = new HashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(1, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        /**
         * 1.故障现象
         *  java.util.ConcurrentModificationException
         * 2.导致原因
         *    并发争抢修改导致
         * 3.解决方案
         *  3.1 new Vector<>()
         *  3.2 Collections.synchronizedList(new ArrayList<>());
         *  3.3 new CopyOnWriteArrayList<>();
         *
         *
         * 4.优化建议
         */
    }
}
