package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class AkbarsSmsTest extends AbsXmlBankSmsTest {

    public AkbarsSmsTest(Document xmlDocument) {
        super("akbars", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Karta *7814. Ezhegodnaya komissiya za obsluzhivanie scheta karty -200.00 RUR. Dostupno -227,86RUR",
                "payment",
                "7814",
                "200",
                ""
        );
    }
}
