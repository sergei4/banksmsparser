package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class DevonCreditSmsTest extends AbsXmlBankSmsTest {

    public DevonCreditSmsTest(Document xmlDocument) {
        super("devoncredit", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "*0633 Oplata 72r\n" +
                        "Ostatok 31619.16r\n" +
                        "ZELENAYA ROSHCHA 13\n" +
                        "18:05 23.09",
                "payment",
                "0633",
                "72",
                ""
        );
        checkBankSms(
                "*0633 Popolnenie perevodom na kartu 300r\n" +
                        "Ostatok 31919.16r\n" +
                        "mib.devoncredit.ru\n" +
                        "04:40 24.09",
                "popolnenie",
                "0633",
                "300",
                ""
        );
    }
}
