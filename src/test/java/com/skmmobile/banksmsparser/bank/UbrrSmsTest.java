package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import org.w3c.dom.Document;

public class UbrrSmsTest extends AbsXmlBankSmsTest {

    public UbrrSmsTest(Document xmlDocument) {
        super("ubrr", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Pokupka \n" +
                        "4301****2661 \n" +
                        "Summa: 314.00 RUB \n" +
                        "Ostatok: 7002.36 RUB \n" +
                        "Term: GAZPROMNEFT AZS 100     > \n" +
                        "MCC: 5541 \n" +
                        "27.12.17 13:18",
                "expense",
                "4301****2661",
                "314",
                "GAZPROMNEFT AZS 100     >"
        );
    }
}
