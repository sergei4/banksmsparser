package com.skmmobile.banksmsparser.bank.kz;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;
import org.w3c.dom.Document;

public class HalykbankSmsTest extends AbsXmlBankSmsTest {

    public HalykbankSmsTest(Document xmlDocument) {
        super("halykbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "1192 Shotty tolyktyru/Popolnenie scheta. 14466.00 KZT; 16044000716101 NAO Gosudarstvennaa korporacia \"Pravitel'stvo dla grajdan\"; 04.12.2017 00:00. Kartadaghy kolzhetimdi soma/Dostupnaya summa po karte: 28609.66 KZT",
                "popolnenie",
                "1192",
                "14466.00",
                ""
        );
        checkBankSms(
                "VISA7074 Satyp alu/Pokupka. 1893.00 KZT; SHOP MAGNUM; 01.06.2018 17:58. Kartadaghy kolzhetimdi soma/Dostupnaya summa po karte: 5943.79 KZT; bonus:302.88",
                "expense",
                "VISA7074",
                "1893.00",
                ""
        );
        checkBankSms(
                "VISA7074 Esepten shygaru/Spisanie. 60095.00 KZT; Perevod na druguyu kartu; 05.06.2018 18:28. Kartadaghy kolzhetimdi soma/Dostupnaya summa po karte: 739143.32 KZT",
                "payment",
                "VISA7074",
                "60095",
                ""
        );
        checkBankSms(
                "VISA7074 Kolma-kol aksha beru/Vydacha nalichnyh. 30000.00 KZT; ATM 300 TRTS MAXIMA; 05.06.2018 17:44. Kartadaghy kolzhetimdi soma/Dostupnaya summa po karte: 799238.32 KZT",
                "cash_atm",
                "VISA7074",
                "30000",
                ""
        );
    }
}
