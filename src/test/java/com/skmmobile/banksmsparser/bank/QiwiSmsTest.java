package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import org.w3c.dom.Document;

public class QiwiSmsTest extends AbsXmlBankSmsTest {

    public QiwiSmsTest(Document xmlDocument) {
        super("qiwi", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Spisanie c +79036423128 na summu 50.00 rub.",
                "spisanie",
                "+79036423128",
                "50",
                ""
        );
        checkBankSms(
                parser,
                "Spisanie c +79036423128 na summu 1.00 rub.",
                "spisanie",
                "+79036423128",
                "1",
                ""
        );
    }
}
