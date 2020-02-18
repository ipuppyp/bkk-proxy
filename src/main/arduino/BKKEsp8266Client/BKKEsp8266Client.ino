#include <Arduino.h>
#include <ESP8266WiFi.h>
#include <ESP8266WiFiMulti.h>
#include <ESP8266HTTPClient.h>
#include "config.h"


ESP8266WiFiMulti WiFiMulti;

const long SLEEP = 60000;

unsigned long lastTime;


void setup() {
  Serial.begin(9600);

  for (uint8_t t = 4; t > 0; t--) {
    Serial.printf("[SETUP] WAIT %d...\n", t);
    Serial.flush();
    delay(1000);
  }

  WiFi.mode(WIFI_STA);
  WiFiMulti.addAP(SSID, PASSWORD);
}

void loop() {
  if (timePassed()) {
    // wait for WiFi connection
    if ((WiFiMulti.run() == WL_CONNECTED)) {
  
      WiFiClient client;
      HTTPClient http;
  
      //Serial.print("[HTTP] begin...\n");
      if (http.begin(client, URL)) { 
  
        //Serial.print("[HTTP] GET...\n");
        int httpCode = http.GET();
  
        if (httpCode > 0) {
          //Serial.printf("[HTTP] GET... code: %d\n", httpCode);
  
          if (httpCode == HTTP_CODE_OK || httpCode == HTTP_CODE_MOVED_PERMANENTLY) {
            String payload = http.getString();
            while (payload.length() > 0) {
              Serial.println(payload.substring(0, 50)); // 3 lines
              payload = payload.substring(51);
              delay(1000);
            }
          }
        } else {
          Serial.printf("[HTTP] GET... failed, error: %s\n", http.errorToString(httpCode).c_str());
        }
  
        http.end();
      } else {
        Serial.printf("[HTTP] Unable to connect\n");
      }
    }
  }
  delay(1000); 
}

boolean timePassed() {
  unsigned long time = millis();
  if (lastTime + SLEEP < time) {
    lastTime = time;
    return true;
  }
  return false;
}
