package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class RnkbSmsTest extends AbsXmlBankSmsTest {

    public RnkbSmsTest(Document xmlDocument) {
        super("rnkb", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Vydacha nalichnyh Karta:1234 summa:600,00 RUR  balans: 628,09 RUR ATM-1234 (vremya operatsii MSK 2018-03-26 08:57:32)",
                "cash_atm",
                "1234",
                "600",
                ""
        );
    }
}
