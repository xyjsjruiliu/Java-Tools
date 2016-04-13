package com.xy.lr.java.activemq;


import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQDestination;

import javax.jms.*;

/**
 * Created by xylr on 16-4-13.
 * com.xy.lr.java.activemq
 */
public class ActiveMQ {
  public static void sendMessage(String url,  String Value, String queue)
          throws JMSException {
    ActiveMQConnectionFactory connectionFactory =
            new ActiveMQConnectionFactory(url);

    Connection conn = connectionFactory.createConnection();
    conn.start();

    Session session = conn.createSession(false, 1);

    Destination desion = session.createQueue(queue);//创建消息队列名称  名称+语言

    MessageProducer producer = session.createProducer(desion);
    TextMessage messages=session.createTextMessage();
    messages.setText(Value);
    producer.send(messages);
    conn.close();
  }

  public static String Receive(String url, String queue) throws JMSException {
    ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(url);

    Connection connection = factory.createConnection();

    connection.start();

    Session session = connection.createSession(false, 1);

    Destination desion = session.createQueue(queue);//结果返回队列

    MessageConsumer consumer = session.createConsumer(desion);
    String result = null;
    while (true) {
      ReadConfig config = ReadConfig.getInstance("config.properties");
      int waitTime = Integer.parseInt(config.getValue("MQ_wait_time").toString());

      TextMessage message = (TextMessage)consumer.receive(waitTime);

      if (message == null) {
        break;
      }

      result = message.getText();
    }

    connection.close();
    return result;
  }

  //暂时停止连接的传入消息传送
  public static void DelQueue(String que) {
    ActiveMQConnection con = null;
    try {
      ReadConfig config = ReadConfig.getInstance("config.properties");
      String url = config.getValue("MQ_URL").toString();

      con = (ActiveMQConnection)new ActiveMQConnectionFactory(url).createConnection();
    } catch (JMSException e2) {
      e2.printStackTrace();
    }

    Destination queue = null;

    try {
      queue = con.createSession(false, 1).createQueue(que);
      try {
        con.start();
      } catch (JMSException e) {
        e.printStackTrace();
      }
      try {
        con.destroyDestination((ActiveMQDestination)queue);
      }
      catch (JMSException e) {
        e.printStackTrace();
      }
    } catch (JMSException e1) {
      e1.printStackTrace();
      try {
        con.stop();
      } catch (JMSException e) {
        e.printStackTrace();
      }
    } finally {
      try {
        con.stop();
      } catch (JMSException e) {
        e.printStackTrace();
      }
    }
  }
}