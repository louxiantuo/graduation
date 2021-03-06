

/*
 Basic ESP8266 MQTT example

 This sketch demonstrates the capabilities of the pubsub library in combination
 with the ESP8266 board/library.

 It connects to an MQTT server then:
  - publishes "hello world" to the topic "outTopic" every two seconds
  - subscribes to the topic "inTopic", printing out any messages
    it receives. NB - it assumes the received payloads are strings not binary
  - If the first character of the topic "inTopic" is an 1, switch ON the ESP Led,
    else switch it off

 It will reconnect to the server if the connection is lost using a blocking
 reconnect function. See the 'mqtt_reconnect_nonblocking' example for how to
 achieve the same result without blocking the main loop.

 To install the ESP8266 board, (using Arduino 1.6.4+):
  - Add the following 3rd party board manager under "File -> Preferences -> Additional Boards Manager URLs":
       http://arduino.esp8266.com/stable/package_esp8266com_index.json
  - Open the "Tools -> Board -> Board Manager" and click install for the ESP8266"
  - Select your ESP8266 in "Tools -> Board"

*/

#include <Ethernet.h>
#include <Dns.h>
#include <EthernetClient.h>
#include <EthernetServer.h>
#include <Dhcp.h>
#include <EthernetUdp.h>

#include <ESP8266WiFi.h>
#include <PubSubClient.h>

// Update these with values suitable for your network.

const char* ssid = "downstairs";
const char* password = "19711219";
const char* mqtt_server = "loumqttserver.duckdns.org";
char message[128];
char get_message[128];

WiFiClient espClient;
PubSubClient client(espClient);
long lastMsg = 0;
char msg[50];
int  value = 0;
int key = 0;

void setup() {
  pinMode(BUILTIN_LED, OUTPUT);     // Initialize the BUILTIN_LED pin as an output
  pinMode(16,OUTPUT);
  Serial.begin(115200);
  setup_wifi();
  client.setServer(mqtt_server, 1883);
  client.setCallback(callback);
}

void setup_wifi() {

  delay(10);
  // We start by connecting to a WiFi network
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);

  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
}

void callback(char* topic, byte* payload, unsigned int length) {
  //Serial.print("Message arrived [");
  //Serial.print(topic);
  //Serial.print("] ");
  char test_off[128] = "turnoff";
  char test_on[128] = "turnon";
  for (int i = 0; i < length; i++) {
    
    //Serial.print((char)payload[i]);
    message[i] = (char)payload[i];
    
  }
  //message[length] = '\r';
  //message[length+1] = '\n';
  //char limit[3] = "\r\n";
  Serial.println(message);
  if(message[0] == 'b'){
    Serial.println("in2low");
    digitalWrite(16,LOW);  
    //int k = digitalRead(5);
    //Serial.println(k);
    
  }
  if(message[0] == 'a'){
    Serial.println("in2high");
    digitalWrite(16,HIGH);
    //int k = digitalRead(5);
    //Serial.println(k);
  }
  //Serial.print("\r\n");
  
  // Switch on the LED if an 1 was received as first character
  if ((char)payload[0] == '1') {
    digitalWrite(BUILTIN_LED, LOW);   // Turn the LED on (Note that LOW is the voltage level
    // but actually the LED is on; this is because
    // it is acive low on the ESP-01)
  } else {
    digitalWrite(BUILTIN_LED, HIGH);  // Turn the LED off by making the voltage HIGH
  }

}

void reconnect() {
                                                                                                                                                                                                                              // Loop until we're reconnected
  while (!client.connected()) {
    Serial.print("Attempting MQTT connection...");
    // Attempt to connect
    if (client.connect("ESP8266Client6")) {
      Serial.println("connected");
      // Once connected, publish an announcement...
      client.publish("outTopic", "hello world");
      // ... and resubscribe

      client.subscribe("inTopic");
    } else {
      Serial.print("failed, rc=");
      Serial.print(client.state());
      Serial.println(" try again in 5 seconds");
      // Wait 5 seconds before retrying
      delay(5000);
    }
  }
}
void loop() {

  if (!client.connected()) {
    reconnect();
  }
  client.loop();
  
  long now = millis();
  if (now - lastMsg > 2000) {
    lastMsg = now;
    ++value;
    snprintf (msg, 75, "hello world（lou） #%ld", value);
    //Serial.print("Publish message: ");
    //Serial.println(msg);
    //Serial.print(message);
    //Serial.print('\0\r');
    client.publish("outTopic", msg);
    client.publish("outTopic","WifiState6:true");
    key = digitalRead(16);
    if(key == 1)
    {
      client.publish("outTopic","MachineState6:true"); 
    }
    else
    {
      client.publish("outTopic","MachineState6:flase");
    }
    
  }

    int i = 0;
    
    while(Serial.available() > 0)
    {
        get_message[i++] =  Serial.read();       
    }
    get_message[i] = '\0';
    if(get_message[0] != '\0')
    {
      snprintf (msg, 75, get_message, value);
    
      client.publish("outTopic",msg);
      
    }
    
     // Serial.println(get_message);
    
    for(int n;n < 128 ;n++)
    {
        get_message[n] = ' ';
    }
    i = 0;

    
    
}
