package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.SmsParserFactory;
import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

public class PriorBankSmsTest extends AbsXmlBankSmsTest {

    public PriorBankSmsTest(SmsParserFactory smsParserFactory) {
        super("priorbank", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Priorbank. Karta 4***7241. 13-01-18 18:26:08. Oplata 61.71 BYN. BLR GIPPO TRADE CENTRE. Dostupno:123.91BYN Spravka: 80172899292",
                "expense",
                "4***7241",
                "61.71",
                ""
        );
        checkBankSms(
                "Priorbank. Karta 5***5224. 15-01-18 18:12:39. Zachislenie perevoda 800.00 BYN. BLR P2P SDBO NO FEE. Dostupno:1412.76BYN Spravka: 80172899292",
                "popolnenie",
                "5***5224",
                "800",
                ""
        );
        checkBankSms(
                "Priorbank. Karta 4***4862. 15-01-18 18:12:39. Perevod 800.00 BYN. BLR P2P SDBO NO FEE. Dostupno:350.83BYN Spravka: 80172899292",
                "perevod",
                "4***4862",
                "800",
                ""
        );
        checkBankSms(
                "Priorbank 25/01 11:46. Na vashu kartu zachisleno 50.00 BYN. Dostupnaja summa: 50.41 BYN. Spravka: 80172899292",
                "zachislenie",
                "priorbank",
                "50",
                ""
        );
        checkBankSms(
                "Priorbank. Plata za uslugu SMS.PRO po karte 4***7241 za proshlyi mesyac = 1,5 BYN. Spravka 80172899292",
                "payment",
                "4***7241",
                "1.5",
                ""
        );
        checkBankSms(
                "Priorbank. Karta 4***6555. 09-02-18 18:41:19. Nalichnye v bankomate 10.00 BYN. BLR METRO BPSB ATM-42. Dostupno:1130.89BYN Spravka: 80172899292",
                "cash_atm",
                "4***6555",
                "10.00",
                ""
        );
        checkBankSms(
                "Priorbank. Karta 4***6521. 15-02-18 13:15:41. Nalichnye v bankomate 10.00 BYN. BLR ATM 621. Dostupno:172.12BYN Spravka: 80172899292",
                "cash_atm",
                "4***6521",
                "10.00",
                ""
        );
        checkBankSms(
                "Priorbank. Karta 4***9285. 21-02-18 17:35:19. Popolnenie 260.00 BYN. BLR CASH-IN 502 BYR. Dostupno:260.17BYN Spravka: 80172899292",
                "popolnenie",
                "4***9285",
                "260",
                ""
        );
        checkBankSms(
                "Priorbank. Karta 5***5243. 17-01-18 18:19:06. Nalichnye v kasse 650.00 BYN. BLR CBU 300 MOGILEV (PRK-2). Dostupno:542.63BYN ",
                "cash_atm",
                "5***5243",
                "650",
                ""
        );
    }
}
