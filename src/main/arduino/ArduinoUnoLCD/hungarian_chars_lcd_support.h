int ch_AA = 1;
int ch_EE = 2;
int ch_II = 3;
int ch_OO = 4;
int ch_OE = 5;
int ch_OOE = 6;
int ch_UU = 7;
int ch_UE = 8;

//Á
byte AA[] = {
  B00010,
  B00100,
  B11111,
  B10001,
  B11111,
  B10001,
  B10001,
  B00000
};

//É
byte EE[] = {
  B00010,
  B00100,
  B11111,
  B10000,
  B11110,
  B10000,
  B11111,
  B00000
};

//Í
byte II[] = {
  B00010,
  B00100,
  B01110,
  B00100,
  B00100,
  B00100,
  B01110,
  B00000
};


//Ó
byte OO[] = {
  B00010,
  B00100,
  B01110,
  B10001,
  B10001,
  B10001,
  B01110,
  B00000
};

//Ö
byte OE[] = {
  B01010,
  B00000,
  B01110,
  B10001,
  B10001,
  B10001,
  B01110,
  B00000
};


//Ő
byte OOE[] = {
  B00101,
  B01010,
  B01110,
  B10001,
  B10001,
  B10001,
  B01110,
  B00000
};

//Ú
byte UU[] = {
  B00010,
  B00100,
  B10001,
  B10001,
  B10001,
  B10001,
  B01110,
  B00000
};


//Ü
byte UE[] = {
  B01010,
  B00000,
  B10001,
  B10001,
  B10001,
  B10001,
  B01110,
  B00000
};


int code_AA[]  = {-61, -127}; //Á
int code_EE[]  = {-61, -119}; //É
int code_II[]  = {-61, -115}; //Í
int code_OO[]  = {-61, -109}; //Ó
int code_OE[]  = {-61, -106}; //Ö
int code_OOE[] = {-59, -112}; //Ő
int code_UU[]  = {-61, -102}; //Ú
int code_UE[]  = {-61, -100}; //Ü
int code_UUE[] = {-59,  -80}; //Ű



void registerChars(LiquidCrystal lcd) {
  lcd.createChar(ch_AA, AA);
  lcd.createChar(ch_EE, EE);
  lcd.createChar(ch_II, II);
  lcd.createChar(ch_OO, OO);
  lcd.createChar(ch_OE, OE);
  lcd.createChar(ch_OOE, OOE); 
  lcd.createChar(ch_UU, UU);
  lcd.createChar(ch_UE, UE);
}

void lcdPrint(LiquidCrystal lcd, int row, String message) {
  lcd.setCursor(0,row);
  for (int i = 0; i < message.length(); i++) {    
    int asInt = message.charAt(i);
    int nextAsInt = message.charAt(i+1);
    if (asInt == code_AA[0] && nextAsInt == code_AA[1]) {
      lcd.write(byte(ch_AA));
      i++;
    }
    else if (asInt == code_EE[0] && nextAsInt == code_EE[1]) {
      lcd.write(byte(ch_EE));
      i++;
    }
    else if (asInt == code_II[0] && nextAsInt == code_II[1]) {
      lcd.write(byte(ch_II));
      i++;
    }
    else if (asInt == code_OO[0] && nextAsInt == code_OO[1]) {
      lcd.write(byte(ch_OO));
      i++;
    }    
    else if (asInt == code_OE[0] && nextAsInt == code_OE[1]) {
      lcd.write(byte(ch_OE));
      i++;
    }    
    else if (asInt == code_OOE[0] && nextAsInt == code_OOE[1]) {
      lcd.write(byte(ch_OOE));
      i++;
    }    
        else if (asInt == code_UU[0] && nextAsInt == code_UU[1]) {
      lcd.write(byte(ch_UU));
      i++;
    }    
    else if (asInt == code_UE[0] && nextAsInt == code_UE[1] || asInt == code_UUE[0] && nextAsInt == code_UUE[1]) {
      lcd.write(byte(ch_UE));
      i++;
    }    
    else {
      lcd.print(message.charAt(i));  
    }
  }
}
