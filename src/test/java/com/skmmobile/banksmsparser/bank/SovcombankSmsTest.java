package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class SovcombankSmsTest extends AbsXmlBankSmsTest {

    public SovcombankSmsTest(Document xmlDocument) {
        super("sovcombank", xmlDocument);
    }

    @Override
    protected void smsTest() {

    }
}
