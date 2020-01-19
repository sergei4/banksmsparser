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
        checkBankSms(
                "Vnesenie nalichnih 15 000.00 KZT adres ATM 2965 RCI URP TEMIRLAN, SHYMKENT, 06.01.2020 17:29, karta ***9166, ostatok 503 390.99 KZT",
                "popolnenie",
                "9166",
                "15000",
                ""
        );
//TODO: doesn't support 2 currency operations
//        checkBankSms(
//                "06.01.2020 14:18. Na kartu ***9166 sdelan perevod 2 000.00 RUB s karti ***8335. Ostatok 488 390.99 KZT.",
//                "perevod",
//                "9166",
//                "2000",
//                ""
//        );
    }
}
