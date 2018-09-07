package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class HomecreditSmsTest extends AbsXmlBankSmsTest {

    public HomecreditSmsTest(Document xmlDocument) {
        super("homecredit", xmlDocument);
    }

    @Override
    protected void smsTest() {
//        checkBankSms(
//                "Карта 1139 07.01.2018 11:34 Покупка 1850.00 RUB. Доступно: 37203.74 RUR LUKOIL.AZS 87 59P CHUSOVOY",
//                "expense",
//                "1139",
//                "1850.00",
//                ""
//        );
    }
}
