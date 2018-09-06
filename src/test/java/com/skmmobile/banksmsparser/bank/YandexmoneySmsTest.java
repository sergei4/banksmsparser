package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class YandexmoneySmsTest extends AbsXmlBankSmsTest {

    public YandexmoneySmsTest(Document xmlDocument) {
        super("yandexmoney", xmlDocument);
    }

    @Override
    protected void smsTest() {
//        checkBankSms(
//                "Яндекс.Деньги, кошелек *9360\n" +
//                        "Вы заплатили 770,15р\n" +
//                        "Доступно 770,15р",
//                "expense",
//                "9360",
//                "770.15",
//                ""
//        );
    }
}
