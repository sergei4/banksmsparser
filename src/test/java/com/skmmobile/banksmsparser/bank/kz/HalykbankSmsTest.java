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
                parser,
                "1192 Shotty tolyktyru/Popolnenie scheta. 14466.00 KZT; 16044000716101 NAO Gosudarstvennaa korporacia \"Pravitel'stvo dla grajdan\"; 04.12.2017 00:00. Kartadaghy kolzhetimdi soma/Dostupnaya summa po karte: 28609.66 KZT",
                "popolnenie",
                "1192",
                "14466.00",
                ""
        );
    }
}
