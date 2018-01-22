package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class RosbankSmsTest extends AbsXmlBankSmsTest {

    public RosbankSmsTest(Document xmlDocument) {
        super("rosbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Karta **0368.Sovershena pokupka na summu 1000.00 RUR. YOTA. Ostatok: 2482.77 RUR. 18/01/18.",
                "expense",
                "0368",
                "1000",
                ""
        );
        checkBankSms(
                parser,
                "Schet A*891: Popolnenie 9082.00 RUB; Dostupno: 10042.19 RUB; 19/01/18",
                "popolnenie",
                "A*891",
                "9082",
                ""
        );
        checkBankSms(
                parser,
                "Schet C*476: Popolnenie 36.02 RUB; Dostupno: 36.02 RUB; 15/01/18",
                "popolnenie",
                "C*476",
                "36.02",
                ""
        );
    }
}
