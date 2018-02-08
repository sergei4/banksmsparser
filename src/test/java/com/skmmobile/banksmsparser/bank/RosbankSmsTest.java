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
        checkBankSms(
                parser,
                "Karta **1234.Proizvedeno snjatie 100.00 RUR v ATM. ATM 751689 3 KOLLONTAY. Ostatok: 1765.77 RUR. 25/01/18.",
                "cash_atm",
                "1234",
                "100",
                ""
        );
        checkBankSms(
                parser,
                "Karta **9253.Proizvedeno snyatie 6200.00 RUR v ATM.CHAPAEVA, 5.So scheta spisano 6200.00 RUR.Ostatok:17.03 RUR.26/01/18.",
                "cash_atm",
                "9253",
                "6200",
                ""
        );
        checkBankSms(
                parser,
                "Schet A*123: Spisanie   15424.55 RUB; Dostupno: 23236.19 RUB; 07/02/18",
                "payment",
                "A*123",
                "15424.55",
                ""
        );
    }
}
