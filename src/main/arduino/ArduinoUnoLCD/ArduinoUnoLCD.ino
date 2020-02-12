const int NEW_LINE = 10;

const int MAX_LINES = 30;
String lines[MAX_LINES];
int size = 0;
int counter = 0;

#include <LiquidCrystal.h>
LiquidCrystal lcd(8, 9, 4, 5, 6, 7);

 void setup() {
  lcd.begin(16, 2);
  Serial.begin(115200);
  delay(1000);
}

String message;
int lineNumber;

void loop() {
  readSerial();
  updateDisplay();
  delay(5000);
}

void readSerial() {
  if (Serial.available()) {
      size = 0;
      counter = 0;
      memset(lines,0,sizeof(lines));
      while (Serial.available()) {
        lines[size++] = Serial.readStringUntil(NEW_LINE);
      }
  }
}

void updateDisplay() {
  lcd.clear();
  lcd.setCursor(0,0);
  lcd.print(lines[counter]);
  Serial.println(lines[counter]);
  if (++counter == size) {
    counter = 0;  
  }
  lcd.setCursor(0,1);
  lcd.print(lines[counter]);
  Serial.println(lines[counter]);
  Serial.println(lines[counter].length());
}
