package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import org.w3c.dom.Document;

public class VozrogdenieSmsTest extends AbsXmlBankSmsTest {

    public VozrogdenieSmsTest(Document xmlDocument) {
        super("vozrogdenie", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Pokupka, Summa:531.70 RUR, Karta:2..7728, Data:03.06.18, Inf:BURGER KING 0129, Kod:181879. Dostupno:22780.27 RUR",
                "expense",
                "2..7728",
                "531.7",
                ""
        );
    }
}
