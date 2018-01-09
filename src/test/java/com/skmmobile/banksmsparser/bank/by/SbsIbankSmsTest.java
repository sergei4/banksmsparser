package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;
import org.w3c.dom.Document;

public class SbsIbankSmsTest extends AbsXmlBankSmsTest {

    public SbsIbankSmsTest(Document xmlDocument) {
        super("sbsibank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        // Todo: доработать для 2-х валют
        //Karta 4.5614 23.12.2017 09:16:30 Retail -2.36 USD GOOGLE *Bini Bambini g.co/helppay# USA OK. Dostupno 41.00 BYN
        checkBankSms(
                parser,
                "Karta 4.5614 22.12.2017 15:53:16 Retail -10.52 BYN REST. \"PAPARATS-KVETKA\"BP MINSK BLR OK. Dostupno 45.86 BYN",
                "expense",
                "5614",
                "10.52",
                "REST. \"PAPARATS-KVETKA\"BP MINSK BLR OK."
        );

        checkBankSms(
                parser,
                "Karta 4.5614 18.12.2017 18:08:01 Popolnenie +81.28 BYN RKC6 K1 MINSK BLR OK. Dostupno 93.03 BYN",
                "popolnenie",
                "5614",
                "81.28",
                "RKC6 K1 MINSK BLR OK."
        );

        checkBankSms(
                parser,
                "Karta 4.5614 16.12.2017 15:12:11 ATM -100.00 BYN ATMTBK HO27 SKALA MINSK BLR OK. Dostupno 11.75 BYN",
                "cash_ATM",
                "5614",
                "100",
                "ATMTBK HO27 SKALA MINSK BLR OK."
        );
    }
}
