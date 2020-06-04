package util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionUtil {

    /**
     * 获取mq的连接
     * @return
     */
    public static Connection getConnection() throws IOException, TimeoutException {
        // 定义一个连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 设置服务器地址
        connectionFactory.setHost("127.0.0.1");
        // 设置端口号
        connectionFactory.setPort(5672);
        // 设置数据库
        connectionFactory.setVirtualHost("/vhost_mmr");
        // 设置用户名
        connectionFactory.setUsername("xzwb");
        // 密码
        connectionFactory.setPassword("520520cw...");

        return connectionFactory.newConnection();
    }
}
