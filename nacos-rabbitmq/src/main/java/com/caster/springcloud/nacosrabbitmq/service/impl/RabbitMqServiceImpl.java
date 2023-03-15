package com.caster.springcloud.nacosrabbitmq.service.impl;

import com.caster.springcloud.nacosrabbitmq.config.RabbitMQConfig;
import com.caster.springcloud.nacosrabbitmq.service.RabbitMQService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class RabbitMqServiceImpl implements RabbitMQService {

    private Logger logger=LoggerFactory.getLogger(RabbitTemplate.class);

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public String sendMsg(String msg) {
        try {
            String msgId = UUID.randomUUID().toString().replace("-","").substring(0,32);
            String sendTime = sdf.format(new Date());
            Map<String,Object> map=new HashMap<>();
            map.put("msgId",msgId);
            map.put("sendTime",sendTime);
            map.put("msg",msg);
            /**Confirm 模式
             * @param correlationData 相关配置信息
             * @param ack 交换机是否成功收到消息
             * @param cause 错误信息
             */
            rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
                if (ack){
                    logger.info("消息成功发送");
                }else {
                    logger.info("消息发送失败");
                    logger.info("错误原因"+cause);
                }
            });
            rabbitTemplate.convertAndSend(RabbitMQConfig.RABBITMQ_DEMO_DIRECT_EXCHANGE,RabbitMQConfig.RABBITMQ_DEMO_DIRECT_ROUTING,map);
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }

}
