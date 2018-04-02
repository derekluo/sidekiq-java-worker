package com.zouyyu;

import com.zouyyu.job.Job;

import java.time.LocalDateTime;

/**
 * @author YuZou
 * @date 30/03/2018
 */
public class SNWorker extends AbstractWorker {

    @Override
    public void perform() {
        System.out.println("处理了一个任务，开始时间是" + LocalDateTime.now());
        Job job = fetchOne();
        System.out.println("处理的消息是：" + job);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("处理了一个任务，结束时间是" + LocalDateTime.now());
        System.out.println("=============================================");
    }
}
