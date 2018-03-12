package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class PochtaBankSmsTest extends AbsXmlBankSmsTest {

    public PochtaBankSmsTest(Document xmlDocument) {
        super("pochtabank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Счёт договора 20770680 пополнен на 11000.00р. Баланс 11157.56р.",
                "popolnenie",
                "20770680",
                "11000.00",
                ""
        );
        checkBankSms(
                parser,
                "Карта 4*8274 \n" +
                        "12.03.18 12:19 \n" +
                        "Покупка 155.00 RUB  \n" +
                        "OOO GLOBAL FUDS SANKT-PETERBU Russia \n" +
                        "Доступно 891.96 RUB",
                "expense",
                "4*8274",
                "155.00",
                ""
        );
        checkBankSms(
                parser,
                "Операция выполнена 04.03.2018 17:44.\n" +
                        "Платеж Yota.\n" +
                        "Сумма 550.00 руб.\n" +
                        "Подробнее my.pochtabank.ru. ПАО \"Почта Банк\"",
                "payment",
                "pochtabank",
                "550",
                ""
        );
        checkBankSms(
                parser,
                "Операция выполнена 10.03.2018 19:38.\n" +
                        "Перевод в СЕВЕРО-ЗАПАДНОЕ ГУ БАНКА РОССИ, ГБДОУ детский сад 113 комбинированного вида Московского района СПб л/с 0591153.\n" +
                        "Сумма 871.36 руб.\n" +
                        "Подробнее my.pochtabank.ru. ПАО \"Почта Банк\"",
                "unknown",
                "pochtabank",
                "871.36",
                ""
        );
    }
}
