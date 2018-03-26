package com.skmmobile.banksmsparser.bank.kz;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;
import org.w3c.dom.Document;

public class FortebankSmsTest extends AbsXmlBankSmsTest {

    public FortebankSmsTest(Document xmlDocument) {
        super("fortebank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Postupilo 201073 KZT na schet #06334, ostatok 206 869.00 KZT. 20.03.2018 18:54. Platite kartoi I poluchaite cashback do 15%",
                "popolnenie",
                "06334",
                "201073",
                ""
        );
        checkBankSms(
                "Pokupka 2 210.00 KZT CAFE IZBUSHKA, CashBack(1%) 22.10 KZT,  13.03.2018 21:24, karta ***1405, ostatok 75 243.99 KZT.",
                "expense",
                "1405",
                "2210",
                ""
        );
    }
}
