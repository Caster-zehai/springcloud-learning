package com.caster.springcloud.nacosrabbitmq.config;

public class RabbitMQConfig {

    //rabbitMQ的队列主题名
    public static final String RABBITMQ_DEMO_TOPIC = "rabbitmqDemoTopic";

    //rabbitMQ的DIRECT交换机名称
    public static final String RABBITMQ_DEMO_DIRECT_EXCHANGE = "rabbitmqDemoDirectExchange";

    //rabbitMQ的DIRECT交换机和队列绑定的匹配键 DirectRouting
    public static final String RABBITMQ_DEMO_DIRECT_ROUTING = "rabbitmqDemoDirectRouting";
}

