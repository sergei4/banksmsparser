package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

import org.w3c.dom.Document;

public class MTBankSmsTest extends AbsXmlBankSmsTest {

    public MTBankSmsTest(Document xmlDocument) {
        super("mtbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "KARTA:4177*5654\n" +
                        "16/01/18 13:52\n" +
                        "OPLATA 6.48 BYN\n" +
                        "MTB INTERNET POS, PR. PARTIZANSKIY 6A, MINSK\n" +
                        "OSTATOK 19.75 BYN\n" +
                        "Spr.:5099999",
                "expense",
                "4177*5654",
                "6.48",
                ""
        );
    }
}
