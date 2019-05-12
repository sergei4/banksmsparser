package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class SovcombankSmsTest extends AbsXmlBankSmsTest {

    public SovcombankSmsTest(Document xmlDocument) {
        super("sovcombank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Халва оплата 204 p OTVEDAJ, Ros баланс 135142.81 http://scb.im/hva",
                "expense",
                "halva",
                "204",
                ""
        );
        checkBankSms(
                "Халва пополнена 5000 р баланс 5138.33 Подробнее http://scb.im/hva",
                "popolnenie",
                "halva",
                "5000",
                ""
        );
    }
}
