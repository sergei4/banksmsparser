package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.SmsParserFactory;

public class RoundbankSmsTest extends AbsXmlBankSmsTest {

    public RoundbankSmsTest(SmsParserFactory smsParserFactory) {
        super("roundbank", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Покупка на сумму 253.34 RUB MAGNIT MM ETKARA, RU 10.02.19 15:40. Карта ***5466. Доступно: 1836.61 RUB.",
                "expense",
                "5466",
                "253.34",
                ""
        );
    }
}
