package routing;

import com.rabbitmq.client.*;
import util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Recv2 {
    private static final String EXCHANGE_NAME = "test_exchange_direct";

    private static final String QUEUE_NAME = "test_queue_direct2";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "error");
        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "info");
//        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "warn");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println(msg);
            }
        };

        channel.basicConsume(QUEUE_NAME,true, consumer);
    }
}
