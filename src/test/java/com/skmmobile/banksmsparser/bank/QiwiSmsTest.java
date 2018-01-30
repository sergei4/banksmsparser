package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import org.w3c.dom.Document;

public class QiwiSmsTest extends AbsXmlBankSmsTest {

    public QiwiSmsTest(Document xmlDocument) {
        super("qiwi", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Spisanie c +79036423128 na summu 50.00 rub.",
                "spisanie",
                "+79036423128",
                "50",
                ""
        );
        checkBankSms(
                parser,
                "Spisanie c +79036423128 na summu 1.00 rub.",
                "spisanie",
                "+79036423128",
                "1",
                ""
        );
        checkBankSms(
                parser,
                "Oplata po karte 4150****9159 SUM: 45.00 RUB (45,00 RUR). BAL: 8389.25 RUR PRODUKTY PUSHKINA 2A",
                "payment",
                "4150****9159",
                "45",
                ""
        );
        checkBankSms(
                parser,
                "Oplata po karte 4150****9159 SUM: 750.00 RUB (750,00 RUR). BAL: 8434.25 RUR OAO Centralnaya PPK",
                "payment",
                "4150****9159",
                "750",
                ""
        );
    }
}
