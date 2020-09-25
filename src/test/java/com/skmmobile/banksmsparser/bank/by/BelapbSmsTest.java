package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.SmsParserFactory;
import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

public class BelapbSmsTest extends AbsXmlBankSmsTest {

    public BelapbSmsTest(SmsParserFactory smsParserFactory) {
        super("belapb", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "OPLATA 1.76 BYN KARTA #1152 DATA 31.01.2018 15:14:08 BAPB - OPLATA USLUG>MINSK>BY OSTATOK 0.00 BYN",
                "expense",
                "1152",
                "1.76",
                ""
        );
        checkBankSms(
                "POPOLNENIE 30.00 BYN KARTA #1152 DATA 04.02.2018 14:18:00 BAPB - OPLATA USLUG>MINSK>BY OSTATOK 30.00 BYN",
                "popolnenie",
                "1152",
                "30",
                ""
        );
        checkBankSms(
                "NALICHNYE 400.00 BYN KARTA #1152 DATA 17.02.2018 13:34:07 MYASNOY PAVILYON BAPB ATM>ZHLOBIN>BY OSTATOK 353.64 BYN",
                "cash_atm",
                "1152",
                "400.00",
                ""
        );
        checkBankSms(
                "ZACHISLENIE 0.02 BYN KARTA #1152",
                "popolnenie",
                "1152",
                "0.02",
                ""
        );
    }
}
