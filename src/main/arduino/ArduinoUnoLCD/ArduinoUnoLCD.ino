#include <LiquidCrystal.h>

const unsigned int NEW_LINE = 10;
const unsigned int MAX_LINES = 30;
const unsigned long SLEEP = 3000;


String lines[MAX_LINES];
unsigned int size = 0;
unsigned int counter = 0;
unsigned long lastTime;

LiquidCrystal lcd(8, 9, 4, 5, 6, 7);

 void setup() {
  lcd.begin(16, 2);
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print("   Welcome to   ");  
  lcd.setCursor(0,1);
  lcd.print("    BKK Proxy   ");  
  Serial.begin(9600);
  
  delay(1000);
}

String message;
int lineNumber;



void loop() {
  readSerial();
  updateDisplay();
  delay(500);
}

void readSerial() {
  if (Serial.available()) {
      size = 0;
      counter = 0;

      while (Serial.available()) {
        while (Serial.available()) {
          String line = Serial.readStringUntil(NEW_LINE);
          if (line.length() > 1) {
            lines[size++] = line;
          }
        }
        delay(1200); // waiting for the next 3 lines
      }
  }
}

void updateDisplay() {
  if (timePassed()) {
    lcd.clear();
    lcd.setCursor(0,0);
    lcd.print(lines[counter]);
    Serial.println(lines[counter]);
    if (++counter == size) {
      counter = 0;  
    }
    else {
      lcd.setCursor(0,1);
      lcd.print(lines[counter]);
      Serial.println(lines[counter]);      
    }
  }
}

boolean timePassed() {
  unsigned long time = millis();
  if (lastTime + SLEEP < time) {
    lastTime = time;
    return true;
  }
  return false;
}
