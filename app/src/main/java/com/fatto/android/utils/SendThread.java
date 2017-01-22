package com.fatto.android.utils;

import static com.fatto.android.utils.LogUtils.LOGE;

/**
 * TODO 线程队列执行测试的线程类
 *
 * @author fattoliu
 * @version V 1.0
 * @date 16/12/21 21:40.
 */

public class SendThread extends Thread {
    private boolean running = true;
    private MyQueue queue = new MyQueue();
    private int n;
    public SendThread(MyQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        super.run();

        while (running) {
            n++;
            if (n > 10) {
                stopThread();
            }
           String ss =  queue.pollFile();
            if (ss != null)
                LOGE(ss);
            else
                LOGE("空");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        running = false;
    }
}
