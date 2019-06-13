package ustc.sse.amqp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ustc.sse.amqp.bean.Book;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createAmqp(){

        //创建交换器
        amqpAdmin.declareExchange(new DirectExchange("amqpAdmin.exchange"));
        System.out.println("创建交换器完成");

        //创建队列
        amqpAdmin.declareQueue(new Queue("amqpAdmin.queue",true));
        System.out.println("创建队列完成");

        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("amqpAdmin.queue",
                Binding.DestinationType.QUEUE,"amqpAdmin.exchange","amqp.haha",null));

        //删除操作
        amqpAdmin.deleteExchange("amqpAdmin.exchange");
        amqpAdmin.deleteQueue("amqpAdmin.queue");
    }


    /**
     * 1、单播（点对点）
     */
    @Test
    public void contextLoads() {
        //message需要自己定义；定制消息体内容和消息头
        //rabbitTemplate.send(exchange,routeKey,message);

        //只需要传入要发送的对象，自动序列化发送
        //rabbitTemplate.convertAndSend(exchange,routeKey,object);

        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloWorld",123,true));
        //对象被默认序列化以后发送出去
        //rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);

        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",
                new Book("西游记","吴承恩"));
    }

    /**
     * 接收数据
     */
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg(){
//        rabbitTemplate.convertAndSend("exchange.fanout","",
//                new Book("三国演义","罗贯中"));


        rabbitTemplate.convertAndSend("exchange.fanout","",
                new Book("红楼梦","曹雪芹"));
    }

}
