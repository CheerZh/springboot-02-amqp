package ustc.sse.amqp.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZHGQ
 * @project springboot-02-amqp
 * @Package ustc.sse.amqp.config
 * @date 2019/6/12-14:30
 * @Copyright: (c) 2019 USTC. All rights reserved.
 * @Description:
 *
 * 配置 消息转换方式，采用Jason进行序列化
 *
 */
@Configuration
public class MyAMQPConfig {

    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
