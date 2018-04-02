一个使用java实现的sidekiq的worker
开发阶段，可以参考，请勿使用

必须在classpath下放置一个名为sidekiq.yml文件 用来声明redis配置，以及要消费的队列名称。

继承AbstractWorker类，实现里面的perform方法。

-----

a sidekiq worker by java
Development stage, can refer to, do not use.

A file named sidekiq.yml must be placed under the classpath to declare the redis configuration and the name of the queue to consume.

Inheritance AbstractWorker class implements the perform method。

----

```

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


```