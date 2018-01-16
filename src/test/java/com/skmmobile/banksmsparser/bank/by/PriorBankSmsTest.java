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
    }
}
