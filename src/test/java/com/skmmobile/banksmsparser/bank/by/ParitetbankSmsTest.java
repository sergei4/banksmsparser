package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

import org.w3c.dom.Document;

public class ParitetbankSmsTest extends AbsXmlBankSmsTest {

    public ParitetbankSmsTest(Document xmlDocument) {
        super("paritetbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "OPLATA 5.00 BYN KARTA #7390 DATA 22.02.2018 20:17:43 PAV. CHTUP \"DEDITSTAT\" BSB>MINSK>BY OSTATOK 3.14 BYN",
                "expense",
                "7390",
                "5",
                ""
        );
    }
}
