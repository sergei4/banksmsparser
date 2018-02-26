package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

import org.w3c.dom.Document;

public class PriorBankSmsTest extends AbsXmlBankSmsTest {

    public PriorBankSmsTest(Document xmlDocument) {
        super("priorbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Priorbank. Karta 4***7241. 13-01-18 18:26:08. Oplata 61.71 BYN. BLR GIPPO TRADE CENTRE. Dostupno:123.91BYN Spravka: 80172899292",
                "expense",
                "4***7241",
                "61.71",
                ""
        );
        checkBankSms(
                parser,
                "Priorbank. Karta 5***5224. 15-01-18 18:12:39. Zachislenie perevoda 800.00 BYN. BLR P2P SDBO NO FEE. Dostupno:1412.76BYN Spravka: 80172899292",
                "popolnenie",
                "5***5224",
                "800",
                ""
        );
        checkBankSms(
                parser,
                "Priorbank. Karta 4***4862. 15-01-18 18:12:39. Perevod 800.00 BYN. BLR P2P SDBO NO FEE. Dostupno:350.83BYN Spravka: 80172899292",
                "perevod",
                "4***4862",
                "800",
                ""
        );
        checkBankSms(
                parser,
                "Priorbank 25/01 11:46. Na vashu kartu zachisleno 50.00 BYN. Dostupnaja summa: 50.41 BYN. Spravka: 80172899292",
                "zachislenie",
                "priorbank",
                "50",
                ""
        );
        checkBankSms(
                parser,
                "Priorbank. Plata za uslugu SMS.PRO po karte 4***7241 za proshlyi mesyac = 1,5 BYN. Spravka 80172899292",
                "payment",
                "4***7241",
                "1.5",
                ""
        );
        checkBankSms(
                parser,
                "Priorbank. Karta 4***6555. 09-02-18 18:41:19. Nalichnye v bankomate 10.00 BYN. BLR METRO BPSB ATM-42. Dostupno:1130.89BYN Spravka: 80172899292",
                "cash_atm",
                "4***6555",
                "10.00",
                ""
        );
        checkBankSms(
                parser,
                "Priorbank. Karta 4***6521. 15-02-18 13:15:41. Nalichnye v bankomate 10.00 BYN. BLR ATM 621. Dostupno:172.12BYN Spravka: 80172899292",
                "cash_atm",
                "4***6521",
                "10.00",
                ""
        );
    }
}
