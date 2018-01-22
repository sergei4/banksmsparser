package com.skmmobile.banksmsparser.bank;

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
        checkBankSms(
                parser,
                "Popolnenie karty \n" +
                        "4301****9962 \n" +
                        "Summa: 5500.00 RUB \n" +
                        "Ostatok: 9586.42 RUB \n" +
                        "Term: 64 SCHERTSA STR \n" +
                        "16.01.18 13:49",
                "popolnenie",
                "4301****9962",
                "5500",
                ""
        );
        checkBankSms(
                parser,
                "Vydacha nalichnyh \n" +
                        "4301****2661 \n" +
                        "Summa: 40000.00 RUB \n" +
                        "Ostatok: 36439.47 RUB \n" +
                        "Term: UBRD/V.Pyshma Uspenskij Ave., 48A \n" +
                        "22.12.17 23:27",
                "cash_atm",
                "4301****2661",
                "40000",
                ""
        );
    }
}
