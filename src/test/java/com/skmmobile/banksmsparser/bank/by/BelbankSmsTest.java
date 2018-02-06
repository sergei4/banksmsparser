package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

import org.w3c.dom.Document;

public class BelbankSmsTest extends AbsXmlBankSmsTest {

    public BelbankSmsTest(Document xmlDocument) {
        super("belbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "ZACHISLENIE: 254.56 BYN KARTA #8686 DATA 01.02.2018 14:36:10",
                "zachislenie",
                "8686",
                "254.56",
                ""
        );
        checkBankSms(
                parser,
                "CREDIT: 1.00 BYN KARTA #8586 DATA 29.01.2018 18:42:43 BR.312 CASH IN>ZHLOBIN>BY OSTATOK 673.80 BYN",
                "cash_atm",
                "8586",
                "1.00",
                ""
        );
    }
}
