package com.itmei.mq.controller;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendMessageController {
    private final static String QUEUE_NAME = "hello";
    private static Logger logger = LoggerFactory.getLogger(SendMessageController.class);

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for (int i=0;i<1000;i++){
            String message = "Hello World!"+" "+i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
//            System.out.println(" [x] Sent '" + message + "'");
            logger.info(" [x] Sent '" + message + "'");
        }


        channel.close();
        connection.close();
    }
}
