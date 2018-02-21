package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class KreditEuroBankSmsTest extends AbsXmlBankSmsTest {

    public KreditEuroBankSmsTest(Document xmlDocument) {
        super("krediteuropabank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Na kartu MEGACARD #6277 postupilo 650.00RUR 20/02/18 19:53 Dostupniy limit:90009.10RUR",
                "popolnenie",
                "MEGACARD #6277",
                "650.00",
                ""
        );

    }
}
