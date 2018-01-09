package com.skmmobile.banksmsparser.bank.uk;

import com.skmmobile.banksmsparser.BankSmsParser;
import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;
import org.w3c.dom.Document;

public class OschadbankSmsTest extends AbsXmlBankSmsTest {

    public OschadbankSmsTest(Document xmlDocument) {
        super("oschadbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "04.01.18 19:38\n" +
                        "Card:5167-6111\n" +
                        "Sum:-5,526.49 UAH\n" +
                        "Dom_Moskovs_013\n" +
                        "Balance=5,526.49 UAH\n" +
                        "Detali",
                "unknown",
                "5167-6111",
                "5526.49",
                ""
        );
    }
}
