package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.SmsParserFactory;

public class RocketBankSmsTest extends AbsXmlBankSmsTest {

    public RocketBankSmsTest(SmsParserFactory smsParserFactory) {
        super("rocketbank", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "−10 руб.\n" +
                        "Багет-Омлет\n" +
                        "Доступно: 1140 руб.",
                "payment",
                "rocketbank",
                "10",
                ""
        );
        checkBankSms(
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
