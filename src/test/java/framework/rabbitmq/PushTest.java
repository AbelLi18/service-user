package framework.rabbitmq;

import framework.BaseTest;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class PushTest extends BaseTest {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void pushMsg() {
        amqpTemplate.convertAndSend(RabbitConfig.TEST_EXCHANGE, RabbitConfig.TEST_QUEUE, "hello world");
    }
}
