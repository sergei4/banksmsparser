package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class RocketBankSmsTest extends AbsXmlBankSmsTest {

    public RocketBankSmsTest(Document xmlDocument) {
        super("rocketbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "−10 руб.\n" +
                        "Багет-Омлет\n" +
                        "Доступно: 1140 руб.",
                "payment",
                "rocketbank",
                "10",
                ""
        );

    }
}
