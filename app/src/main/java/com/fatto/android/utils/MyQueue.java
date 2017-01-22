package com.fatto.android.utils;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue {
    private final ReentrantLock lock = new ReentrantLock();
    private Queue<String> fileNameQueue = new ConcurrentLinkedQueue<>();


    public String pollFile() {
        String fileName = null;
        try {
            if (lock.tryLock(0, TimeUnit.SECONDS)) {
                if (fileNameQueue.size() > 0) {
                    fileName = fileNameQueue.poll();
                }
                lock.unlock();
            }
        } catch (Exception ex) {
        }


        return fileName;
    }

    public void pushFile(String file) {
        try {
            if (lock.tryLock(30, TimeUnit.SECONDS)) {
                fileNameQueue.add(file);
                lock.unlock();
            }
        } catch (Exception ex) {
        }
    }
}
