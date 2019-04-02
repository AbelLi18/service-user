package framework.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public final static String TEST_QUEUE = "test";
    public final static String TEST_EXCHANGE = "test-exchange";

    @Bean
    public Queue newQueue() {
        return new Queue(TEST_QUEUE);
    }

    @Bean
    public Exchange newDirectExchange() {
        return new DirectExchange(TEST_EXCHANGE, true, true);
    }

    @Bean
    public Binding newDirectBinding() {
        return BindingBuilder.bind(newQueue()).to(newDirectExchange()).with(TEST_QUEUE).noargs();
    }
}
