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
        checkBankSms(
                parser,
                "+5000 руб.\n" +
                        "Пополнение с карты «Сбербанк ***5673»\n" +
                        "Доступно: 5876 руб.",
                "popolnenie",
                "rocketbank",
                "5000",
                ""
        );
    }
}
