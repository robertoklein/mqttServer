package main;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Connection {

	// ----- LISTA DE TOPICOS OUVIDOS -----
	public static final String[] TOPICS = {
											"roberto",
											"roberto2"
											};

	// ----- DADOS DE CONEXAO ----- 
	public static final String HOST_NAME = "m14.cloudmqtt.com";
	public static final int PORT_NUMBER = 19616;
	public static final String USERNAME = "axxfrycf";
	public static final String PASSWORD = "qAdD5bpKyIk4";

	
	public static MqttClient getClient() throws MqttException {
		MqttClient client;	
		String host = String.format("tcp://%s:%d", HOST_NAME, PORT_NUMBER);
        String clientId = MqttClient.generateClientId();
        client = new MqttClient(host, clientId, new MemoryPersistence());
        return client;
	}
	
	public static MqttConnectOptions getOptions() {
		MqttConnectOptions conOpt = new MqttConnectOptions();
        conOpt.setCleanSession(true);
        conOpt.setUserName(USERNAME);
        conOpt.setPassword(PASSWORD.toCharArray());
        return conOpt;
	}




}



