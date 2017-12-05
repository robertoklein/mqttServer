package main;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import static main.Connection.*;

public class Publisher{

	private MqttClient client ;
	
	private static final int  QOS = 1;
	
	public Publisher(String topic, String message) throws MqttException{
		
		client = Connection.getClient();
        MqttConnectOptions conOpt = Connection.getOptions();
        
        client.connect(conOpt);
        sendMessage(topic, message);
	}
	
	private void sendMessage(String topic, String payload) throws MqttException {
        MqttMessage message = new MqttMessage(payload.getBytes());
        message.setQos(QOS);
        this.client.publish(topic, message); // Blocking publish
    }
	
	
}
