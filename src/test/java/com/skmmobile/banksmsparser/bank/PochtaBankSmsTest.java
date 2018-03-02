package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class PochtaBankSmsTest extends AbsXmlBankSmsTest {

    public PochtaBankSmsTest(Document xmlDocument) {
        super("pochtabank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Счёт договора 20770680 пополнен на 11000.00р. Баланс 11157.56р.",
                "popolnenie",
                "20770680",
                "11000.00",
                ""
        );
    }
}
