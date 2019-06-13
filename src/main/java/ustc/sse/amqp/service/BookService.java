package ustc.sse.amqp.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ustc.sse.amqp.bean.Book;

/**
 * @author ZHGQ
 * @project springboot-02-amqp
 * @Package ustc.sse.amqp.service
 * @date 2019/6/13-15:16
 * @Copyright: (c) 2019 USTC. All rights reserved.
 * @Description:
 */

@Service
public class BookService {

    @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
        System.out.println("收到消息："+book.toString());

    }

    @RabbitListener(queues = "atguigu")
    public void receive02(Message msg){
        System.out.println(msg.getBody());
        System.out.println(msg.getMessageProperties());

    }
}
