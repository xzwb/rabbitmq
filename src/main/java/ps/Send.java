package ps;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 订阅模式
 */
public class Send {

    private static final String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout"); //分发
        // 发送消息
        String msg = "hello world";
        channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());

        System.out.println("send msg");

        channel.close();
        connection.close();
    }
}
