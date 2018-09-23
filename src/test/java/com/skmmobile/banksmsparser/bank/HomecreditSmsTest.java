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
    }
}
