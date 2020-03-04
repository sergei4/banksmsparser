package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;
import org.w3c.dom.Document;

public class BelarusbankSmsTest extends AbsXmlBankSmsTest {

    public BelarusbankSmsTest(Document xmlDocument) {
        super("belarusbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "ZACHISLENIE 123.45 BYN KARTA #1234",
                "zachislenie",
                "1234",
                "123.45",
                ""
        );
        checkBankSms(
                "OPLATA 123.45 BYN KARTA #1234 DATA 01.01.2018 10:30:30 PARIKMAHERSKAYZ\"DEVORA\"BAPB>GOMEL>BY OSTATOK 0.00 BYN",
                "expense",
                "1234",
                "123.45",
                "PARIKMAHERSKAYZ\"DEVORA\"BAPB>GOMEL>BY"
        );
        checkBankSms(
                "NALICHNYE 123.45 BYN KARTA #5614 DATA 01.01.2018 10:30:30 ATM 039 TH RECHICKI>GOMEL>BY OSTATOK 123.45 BYN",
                "cash_ATM",
                "5614",
                "123.45",
                "ATM 039 TH RECHICKI>GOMEL>BY"
        );
        checkBankSms(
                "POPOLNENIE SCHETA 50.00 BYN KARTA #8626 DATA 07.02.2018 17:53:43 BR.511 CASH IN>MINSK>BY OSTATOK 50.00 BYN",
                "popolnenie",
                "8626",
                "50",
                ""
        );
        checkBankSms(
                "CREDIT 15.00 BYN KARTA #3503 DATA 31.01.2018 15:43:43 PEREVOD>MINSK>BY OSTATOK 15.77 BYN",
                "unknown",
                "3503",
                "15",
                ""
        );
    }
}
