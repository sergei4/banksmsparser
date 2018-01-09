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
                        "Summa: 1737.96 RUB \n" +
                        "Ostatok: 9906.21 RUB \n" +
                        "Term: 474  KIROVSKIY \n" +
                        "MCC: 5411 \n" +
                        "24.12.17 18:43",
                BankSmsParser.CATEGORY_EXPENSE,
                "4301****2661",
                "1737.96",
                "474  KIROVSKIY"
        );
    }
}
