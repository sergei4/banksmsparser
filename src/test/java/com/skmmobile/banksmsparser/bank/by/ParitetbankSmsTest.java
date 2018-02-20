package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

import org.w3c.dom.Document;

public class ParitetbankSmsTest extends AbsXmlBankSmsTest {

    public ParitetbankSmsTest(Document xmlDocument) {
        super("paritetbank", xmlDocument);
    }

    @Override
    protected void smsTest() {

    }
}
