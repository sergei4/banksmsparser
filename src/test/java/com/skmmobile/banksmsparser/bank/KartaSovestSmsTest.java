package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.SmsParserFactory;

public class KartaSovestSmsTest extends AbsXmlBankSmsTest {

    public KartaSovestSmsTest(SmsParserFactory smsParserFactory) {
        super("karta_sovest", smsParserFactory);
    }

    @Override
    protected void smsTest() {
//        checkBankSms(
//                parser,
//                "Счёт договора 20770680 пополнен на 11000.00р. Баланс 11157.56р.",
//                "popolnenie",
//                "20770680",
//                "11000.00",
//                ""
//        );
    }
}
