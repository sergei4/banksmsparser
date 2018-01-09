package com.skmmobile.banksmsparser.bank.kz;

import com.skmmobile.banksmsparser.BankSmsParser;
import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;
import org.w3c.dom.Document;

public class QazkomSmsTest extends AbsXmlBankSmsTest {

    public QazkomSmsTest(Document xmlDocument) {
        super("qazkom", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "2017-12-31 12:27:59 Operaciya po karte Retail 1669.00 KZT YUBILEINYI SUPERMARKET 4**493 Dostupnaya summa:78649.63 KZT",
                BankSmsParser.CATEGORY_EXPENSE,
                "4**493",
                "1669.00",
                ""
        );
        checkBankSms(
                parser,
                "2017-12-31 13:49:59 Operaciya po karte Retail 4030.12 KZT MON AMIE SHOP 4**493 Dostupnaya summa:74619.63 KZT",
                BankSmsParser.CATEGORY_EXPENSE,
                "4**493",
                "4030.12",
                ""
        );
        checkBankSms(
                parser,
                "2018-01-05 15:02:45 Popolnenie 59535.01 KZT K**928 Dostupnaya summa:132446.63 KZT",
                "popolnenie",
                "K**928",
                "59535.01",
                ""
        );
    }
}
