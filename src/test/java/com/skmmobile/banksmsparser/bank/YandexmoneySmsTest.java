package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class YandexmoneySmsTest extends AbsXmlBankSmsTest {

    public YandexmoneySmsTest(Document xmlDocument) {
        super("yandexmoney", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Яндекс.Деньги. Кошелек *9360 пополнен на 2236,8р\n" +
                        "Доступно: 6751,71р",
                "popolnenie",
                "9360",
                "2236.8",
                ""
        );
        checkBankSms(
                "Яндекс.Деньги, кошелек *9360\n" +
                        "Вы заплатили 92,32р\n" +
                        "Доступно 0,54р\n",
                "payment",
                "9360",
                "92.32",
                ""
        );
    }
}
