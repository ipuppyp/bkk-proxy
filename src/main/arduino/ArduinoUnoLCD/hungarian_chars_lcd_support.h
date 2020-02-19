int ch_aa = 0;
int ch_AA = 1;
int ch_ee = 2;
int ch_EE = 3;
int ch_ii = 4;
int ch_II = 5;
int ch_oo = 6;
int ch_OO = 7;
int ch_oe = 8;
int ch_OE = 9;
int ch_ooe = 10;
int ch_OOE = 11;
int ch_uu = 12;
int ch_UU = 13;
int ch_ue = 14;
int ch_UE = 15;
int ch_uue = 16;
int ch_UUE = 17;


//á
byte aa[] = {
  B00010,
  B00100,
  B00000,
  B01110,
  B00001,
  B01111,
  B10001,
  B01111
};

//Á
byte AA[] = {
  B00010,
  B00100,
  B00100,
  B01010,
  B10001,
  B11111,
  B10001,
  B10001
};

//é
byte ee[] = {
  B00010,
  B00100,
  B00000,
  B01110,
  B10001,
  B11111,
  B10000,
  B01110
};

//É
byte EE[] = {
  B00010,
  B00100,
  B00000,
  B11111,
  B10000,
  B11110,
  B10000,
  B11111
};

//í
byte ii[] = {
  B00000,
  B00010,
  B00100,
  B00000,
  B01110,
  B00100,
  B00100,
  B01110
};

//Í
byte II[] = {
  B00010,
  B00100,
  B00000,
  B01110,
  B00100,
  B00100,
  B00100,
  B01110
};


//ó
byte oo[] = {
  B01000,
  B00100,
  B00000,
  B01110,
  B10001,
  B10001,
  B10001,
  B01110
};

//Ó
byte OO[] = {
  B01000,
  B00100,
  B01110,
  B10001,
  B10001,
  B10001,
  B10001,
  B01110
};

//ö
byte oe[] = {
  B00000,
  B01010,
  B00000,
  B01110,
  B10001,
  B10001,
  B10001,
  B01110
};

//Ö
byte OE[] = {
  B01010,
  B00000,
  B01110,
  B10001,
  B10001,
  B10001,
  B10001,
  B01110
};


//ő
byte ooe[] = {
  B10100,
  B01010,
  B00000,
  B01110,
  B10001,
  B10001,
  B10001,
  B01110
};

//Ő
byte OOE[] = {
  B10100,
  B01010,
  B01110,
  B10001,
  B10001,
  B10001,
  B10001,
  B01110
};

//ú
byte uu[] = {
  B00010,
  B00100,
  B00000,
  B10001,
  B10001,
  B10001,
  B10011,
  B01101
};

//Ú
byte UU[] = {
  B00010,
  B00100,
  B10001,
  B10001,
  B10001,
  B10001,
  B10011,
  B01101
};

//ü
byte ue[] = {
  B00000,
  B01010,
  B00000,
  B10001,
  B10001,
  B10001,
  B10011,
  B01101
};

//Ü
byte UE[] = {
  B00101,
  B01010,
  B00000,
  B10001,
  B10001,
  B10001,
  B10011,
  B01101
};

//ű
byte uue[] = {
  B00101,
  B01010,
  B00000,
  B10001,
  B10001,
  B10001,
  B10011,
  B01101
};

//Ű
byte UUE[] = {
  B00101,
  B01010,
  B10001,
  B10001,
  B10001,
  B10001,
  B10001,
  B01110
};

int code_aa[] = {-61, -95};
int code_ee[] = {-61, -87};
int code_ii[] = {-61, -83};

void registerChars(LiquidCrystal lcd) {
  /*
  lcd.createChar(ch_aa, aa);
  lcd.createChar(ch_AA, AA);
  lcd.createChar(ch_ee, ee);
  lcd.createChar(ch_EE, EE);
  lcd.createChar(ch_ii, ii);
  lcd.createChar(ch_II, II);
  lcd.createChar(ch_oo, oo);
  lcd.createChar(ch_OO, OO);
  lcd.createChar(ch_oe, oe);
  lcd.createChar(ch_OE, OE);
  lcd.createChar(ch_ooe, ooe);
  lcd.createChar(ch_OOE, OOE); 
  lcd.createChar(ch_uu, uu);
  lcd.createChar(ch_UU, UU);
  lcd.createChar(ch_ue, ue);
  lcd.createChar(ch_UE, UE);
  lcd.createChar(ch_uue, uue); 
  lcd.createChar(ch_UUE, UUE); */
}

void lcdPrint(LiquidCrystal lcd, int row, String message) {
  lcd.setCursor(0,row);
  for (int i = 0; i < message.length(); i++) {    
    int asInt = message.charAt(i);
    //Serial.print(asInt);
    int nextAsInt = message.charAt(i+1);
    char d = message.charAt(i);
    if (asInt == code_aa[0] && nextAsInt == code_aa[1]) {
      lcd.write(byte(ch_aa));
      i++;
    }
    else if (asInt == code_ee[0] && nextAsInt == code_ee[1]) {
      lcd.write(byte(ch_ee));
      i++;
    }
    else if (asInt == code_ii[0] && nextAsInt == code_ii[1]) {
      lcd.write(byte(ch_ii));
      i++;
    }    
    else {
      lcd.print(d);  
    }
    
  }
}
