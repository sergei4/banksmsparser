package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.BankSmsParser;
import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

import org.w3c.dom.Document;

public class BelarusbankSmsTest extends AbsXmlBankSmsTest {

    public BelarusbankSmsTest(Document xmlDocument) {
        super("belarusbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "ZACHISLENIE 123.45 BYN KARTA #1234",
                "zachislenie",
                "1234",
                "123.45",
                ""
        );

        checkBankSms(
                parser,
                "OPLATA 123.45 BYN KARTA #1234 DATA 01.01.2018 10:30:30 PARIKMAHERSKAYZ\"DEVORA\"BAPB>GOMEL>BY OSTATOK 0.00 BYN",
                BankSmsParser.CATEGORY_EXPENSE,
                "1234",
                "123.45",
                "PARIKMAHERSKAYZ\"DEVORA\"BAPB>GOMEL>BY"
        );

        checkBankSms(
                parser,
                "NALICHNYE 123.45 BYN KARTA #5614 DATA 01.01.2018 10:30:30 ATM 039 TH RECHICKI>GOMEL>BY OSTATOK 123.45 BYN",
                "cash_ATM",
                "5614",
                "123.45",
                "ATM 039 TH RECHICKI>GOMEL>BY"
        );
    }
}
