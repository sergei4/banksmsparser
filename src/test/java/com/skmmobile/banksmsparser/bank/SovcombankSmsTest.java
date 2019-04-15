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
    }
}
