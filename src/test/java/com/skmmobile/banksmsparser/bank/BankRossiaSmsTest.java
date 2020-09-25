package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.SmsParserFactory;

public class BankRossiaSmsTest extends AbsXmlBankSmsTest {

    public BankRossiaSmsTest(SmsParserFactory smsParserFactory) {
        super("bankrossia", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "25.04.2019\n" +
                        "Сч *26719\n" +
                        "Зачисление 17600 р",
                "zachislenie",
                "Сч *26719",
                "17600",
                ""
        );
        checkBankSms(
                "10:15 21.04.19\n" +
                        "МИР5493\n" +
                        "Покупка 55 р\n" +
                        "BULOCHNAYA 9",
                "expense",
                "МИР5493",
                "55",
                ""
        );
    }
}
