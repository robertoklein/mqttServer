package main;

import java.net.URISyntaxException;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
//import static main.Connection.*;

public class Subscriber implements MqttCallback {
	
	//private static final int  QOS = 1;
	
	public Subscriber() throws MqttException{
	
		MqttClient client = Connection.getClient();
        MqttConnectOptions conOpt = Connection.getOptions();

        client.setCallback(this);
        client.connect(conOpt);

        //lista de topics ouvidos
        String[] list = Connection.TOPICS;
        client.subscribe(list);
	}
	
	@Override
	public void connectionLost(Throwable cause) {
		 System.out.println("Connection lost because: " + cause);
	        System.exit(1);
	}

	@Override
	public void messageArrived(String topic, MqttMessage message) throws Exception {
	
		String result = new String(message.getPayload());
		String topicResult = topic;
		
		System.out.println("a data was insert into the topic: " + topicResult);
		System.out.println("the msg is: " + result);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {}
	
	public static void main(String[] args) throws MqttException, URISyntaxException {
		/**
		 * deixa o subscriber esperando um callback
		 */
		Subscriber s = new Subscriber();
		
		/**
		 * envia uma mensagem que deve ser recebida pelo subscriber
		 */
		//Publisher p = new Publisher("roberto","msgn from publisher");
		

	}
}
