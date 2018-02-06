package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

import org.w3c.dom.Document;

public class BelapbSmsTest extends AbsXmlBankSmsTest {

    public BelapbSmsTest(Document xmlDocument) {
        super("belapb", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "OPLATA 1.76 BYN KARTA #1152 DATA 31.01.2018 15:14:08 BAPB - OPLATA USLUG>MINSK>BY OSTATOK 0.00 BYN",
                "expense",
                "1152",
                "1.76",
                ""
        );
        checkBankSms(
                parser,
                "POPOLNENIE 30.00 BYN KARTA #1152 DATA 04.02.2018 14:18:00 BAPB - OPLATA USLUG>MINSK>BY OSTATOK 30.00 BYN",
                "popolnenie",
                "1152",
                "30",
                ""
        );
    }
}
