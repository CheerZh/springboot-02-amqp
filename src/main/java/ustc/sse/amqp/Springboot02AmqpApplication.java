package ustc.sse.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置原理
 *  1、自动配置类RabbitAutoConfiguration
 *  2、自动配置了连接工厂ConnectionFactory
 *  3、RabbitProperties封装了RabbitMq的所有配置，绑定配置文件spring.rabbitmq
 *  4、RabbitTemplate：给RabbitMQ发送和接收消息
 *
 *  5、AmqpAdmin：系统管理组件
 *      创建和删除 Queue,exchange,Binding
 *
 *  6、@EnableRabbit + @RabbitListener 监听消息队列的内容
 */

@EnableRabbit   //开启基于注解的RabbitMQ
@SpringBootApplication
public class Springboot02AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02AmqpApplication.class, args);
    }

}
