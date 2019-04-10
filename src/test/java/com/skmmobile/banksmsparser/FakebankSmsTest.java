package com.skmmobile.banksmsparser;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;
import org.w3c.dom.Document;

public class FakebankSmsTest extends AbsXmlBankSmsTest {

    public FakebankSmsTest(Document xmlDocument) {
        super("fakebank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "5*9857; Pokupka; Uspeshno; Summa: 110,00 RUR; Ostatok: 137372,27 RUR; RU/CHELYABINSK/SOKOL FIT DER NOVOE PO; 04.12.2017 13:33:17",
                "expense",
                "5*9857",
                "110",
                ""
        );
    }
}
