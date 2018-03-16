package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class ChelinvestSmsTest extends AbsXmlBankSmsTest {

    public ChelinvestSmsTest(Document xmlDocument) {
        super("chelinvest", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "25.01.18 23:40 Spisanie 3262.55 RUB. Ostatok: 4194.09 RUB. Karta: *9770",
                "payment",
                "9770",
                "3262.55",
                ""
        );
        checkBankSms(
                parser,
                "25.01.18 11:25 Popolnenie na 6000.00 RUB. Ostatok: 7504.64 RUB. Karta: *9770",
                "popolnenie",
                "9770",
                "6000.00",
                ""
        );
        checkBankSms(
                parser,
                "27.02.18 13:19 Poluchenie nalichnymi 700.00 RUB. Ostatok: 5361.01 RUB. Karta: *9770. Adres: Chelyabinsk, pl.Mopra, d.3",
                "cash_atm",
                "9770",
                "700",
                ""
        );
    }
}
