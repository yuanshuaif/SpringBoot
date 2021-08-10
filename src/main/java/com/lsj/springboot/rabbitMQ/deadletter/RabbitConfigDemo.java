package com.lsj.springboot.rabbitMQ.deadletter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 10326 on 2021/7/3.
 */
@Configuration
@Slf4j
public class RabbitConfigDemo {


    //队列名称
    final static String queue = "queue_demo5";

    //交换机名称
    final static String exchangeName = "deom5Exchange";

    // routingKey
    final static String routingKey  = "keyDemo5";

    //死信消息队列名称
    final static String deal_queue = "deal_queue_demo5";

    //死信交换机名称
    final static String deal_exchangeName = "deal_deom5Exchange";

    //死信 routingKey
    final static String dead_RoutingKey  = "dead_routing_key";

    //死信队列 交换机标识符
    public static final String DEAD_LETTER_QUEUE_KEY = "x-dead-letter-exchange";

    //死信队列交换机绑定键标识符
    public static final String DEAD_LETTER_ROUTING_KEY = "x-dead-letter-routing-key";

    @Autowired
    private CachingConnectionFactory connectionFactory;

    /**
     *
     * @method 定义队列(队列 绑定一个死信交换机,并指定routing_key)
     * @author Mr yi
     * @time 2019年6月29日
     * @return
     */
    @Bean
    public Queue queueDemo5() {
        // 将普通队列绑定到死信队列交换机上
        Map<String, Object> args = new HashMap<>(2);
        //args.put("x-message-ttl", 5 * 1000);//直接设置 Queue 延迟时间 但如果直接给队列设置过期时间,这种做法不是很灵活
        //这里采用发送消息动态设置延迟时间,这样我们可以灵活控制
        args.put(DEAD_LETTER_QUEUE_KEY, deal_exchangeName);
        args.put(DEAD_LETTER_ROUTING_KEY, dead_RoutingKey);
        return new Queue(RabbitConfigDemo.queue, true, false, false, args);
    }

    //声明一个direct类型的交换机
    @Bean
    DirectExchange exchangeDemo5() {
        return new DirectExchange(RabbitConfigDemo.exchangeName);
    }

    //绑定Queue队列到交换机,并且指定routingKey
    @Bean
    Binding bindingDirectExchangeDemo5(   ) {
        return BindingBuilder.bind(queueDemo5()).to(exchangeDemo5()).with(routingKey);
    }

    //创建配置死信队列
    @Bean
    public Queue deadQueue5() {
        Queue queue = new Queue(deal_queue, true);
        return queue;
    }

    //创建死信交换机
    @Bean
    public DirectExchange deadExchange5() {
        return new DirectExchange(deal_exchangeName);
    }

    //死信队列与死信交换机绑定
    @Bean
    public Binding bindingDeadExchange5() {
        return BindingBuilder.bind(deadQueue5()).to(deadExchange5()).with(dead_RoutingKey);
    }

/**      @Bean
public RabbitTemplate rabbitTemplate(){
//若使用confirm-callback ，必须要配置publisherConfirms 为true
connectionFactory.setPublisherConfirms(true);
//若使用return-callback，必须要配置publisherReturns为true
connectionFactory.setPublisherReturns(true);
RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true
// rabbitTemplate.setMandatory(true);

// 如果消息没有到exchange,则confirm回调,ack=false; 如果消息到达exchange,则confirm回调,ack=true
rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
@Override
public void confirm(CorrelationData correlationData, boolean ack, String cause) {
if(ack){
log.info("消息发送成功:correlationData({}),ack({}),cause({})",correlationData,ack,cause);
}else{
log.info("消息发送失败:correlationData({}),ack({}),cause({})",correlationData,ack,cause);
}
}
});

//如果exchange到queue成功,则不回调return;如果exchange到queue失败,则回调return(需设置mandatory=true,否则不回回调,消息就丢了)
rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
@Override
public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}",exchange,routingKey,replyCode,replyText,message);
}
});
return rabbitTemplate;
}

 **/


}
