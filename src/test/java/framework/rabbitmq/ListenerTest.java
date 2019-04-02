package framework.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitConfig.TEST_QUEUE)
public class ListenerTest {
    @RabbitHandler
    public void process(String msg) {
        System.out.println(msg);
    }
}
