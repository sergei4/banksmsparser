package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class KartaSovestSmsTest extends AbsXmlBankSmsTest {

    public KartaSovestSmsTest(Document xmlDocument) {
        super("karta_sovest", xmlDocument);
    }

    @Override
    protected void smsTest() {
//        checkBankSms(
//                parser,
//                "Счёт договора 20770680 пополнен на 11000.00р. Баланс 11157.56р.",
//                "popolnenie",
//                "20770680",
//                "11000.00",
//                ""
//        );
    }
}
