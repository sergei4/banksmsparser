package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class HomecreditSmsTest extends AbsXmlBankSmsTest {

    public HomecreditSmsTest(Document xmlDocument) {
        super("homecredit", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Oplata: 250.00 RUR. Karta *8349 Compass Group Rus. 06.09.2018 12:49:17. Dostupno: 43959.57 RUR.",
                "expense",
                "8349",
                "250",
                ""
        );
        checkBankSms(
                "Snyatie nalichnyh: 3000.00 RUR. Karta *8119. Dostupno: 9320.86 RUR. +74957858222",
                "cash_atm",
                "8119",
                "3000",
                ""
        );
        checkBankSms(
                "Spisanie:59.00 RUR za SMS-paket. Karta *8349",
                "payment",
                "8349",
                "59.00",
                ""
        );
    }
}
