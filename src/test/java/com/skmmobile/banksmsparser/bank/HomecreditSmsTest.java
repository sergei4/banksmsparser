package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.SmsParserFactory;

public class HomecreditSmsTest extends AbsXmlBankSmsTest {

    public HomecreditSmsTest(SmsParserFactory smsParserFactory) {
        super("homecredit", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Oplata: 250.00 RUR. Karta *8349 Compass Group Rus. 06.09.2018 12:49:17. Dostupno: 43959.57 RUR.",
                "expense",
                "8349",
                "250",
                ""
        );
        checkBankSms(
                "Snyatie nalichnyh: 3000.00 RUR. Karta *8119. Dostupno: 9320.86 RUR. +74957858222",
                "cash_atm",
                "8119",
                "3000",
                ""
        );
        checkBankSms(
                "Spisanie:59.00 RUR za SMS-paket. Karta *8349",
                "payment",
                "8349",
                "59.00",
                ""
        );
        checkBankSms(
                "Popolnenie: 29000.00 RUR. Karta *3681. Otpravitel' perevoda HOMENKO IRINA. 11.03.2019 11:51:52.",
                "popolnenie",
                "3681",
                "29000",
                ""
        );
        checkBankSms(
                "Spisanie: 46.00 RUR. Karta *7857. 26.04.2019 08:28:27. Dostupno: 164458.97 RUR.",
                "payment",
                "7857",
                "46",
                ""
        );
        checkBankSms(
                "Popolnenie: 3376,14 RUB. Schet 423*16768.",
                "popolnenie",
                "Schet 423*16768",
                "3376.14",
                ""
        );
    }
}
