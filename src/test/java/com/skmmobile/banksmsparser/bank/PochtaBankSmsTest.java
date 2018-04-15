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
        checkBankSms(
                parser,
                "Карта 4*8274 \n" +
                        "23.03.18 22:50 \n" +
                        "Получение наличных 16000.00 RUB  \n" +
                        "D. 30, KORP. 1, LIT. A, PR-KT SANKT-PETERBURG G Russia \n" +
                        "Доступно 14660.28 RUB",
                "cash_atm",
                "4*8274",
                "16000",
                ""
        );
        checkBankSms(
                parser,
                "Карта 4*8274 \n" +
                        "23.03.18 17:22 \n" +
                        "Зачислено 30000.00 RUB  \n" +
                        "VISA MONEY TRANSFER Visa Direct Russia \n" +
                        "Доступно 30660.28 RUB",
                "zachislenie",
                "4*8274",
                "30000",
                ""
        );
        checkBankSms(
                "Зачислено 20.00 р. на вклад 29130517. Сумма вклада 894.09 р. ПАО \"Почта Банк\"",
                "zachislenie",
                "29130517",
                "20",
                ""
        );
        checkBankSms(
                "Операция выполнена 07.03.2018 10:11.\n" +
                        " Внесение наличных на счет в Почта Банке.\n" +
                        "Сумма 5000.00 руб.\n" +
                        "Подробнее my.pochtabank.ru. ПАО \"Почта Банк\"",
                "popolnenie",
                "pochtabank",
                "5000",
                ""
        );
        checkBankSms(
                "По карте  08.04.2018 08:27 пополнение счёта на сумму 500.00 руб. ПАО \"Почта Банк\"",
                "popolnenie",
                "pochtabank_card",
                "500",
                ""
        );
        checkBankSms(
                "По договору  12.03.2018 19:47 пополнение счёта на сумму 5000.00 руб. ПАО \"Почта Банк\"",
                "popolnenie",
                "pochtabank_account",
                "5000",
                ""
        );
        checkBankSms(
                "По договору 22968660 выплачены проценты 4.84 р. за Март 2018.",
                "zachislenie",
                "22968660",
                "4.84",
                ""
        );
        checkBankSms(
                "По договору 18301374 06.04.2018 произведено списание со счёта на сумму 1020 руб. Баланс 60.00 руб. ПАО \"Почта Банк\"",
                "payment",
                "18301374",
                "1020",
                ""
        );
        checkBankSms(
                "Карта 4*3496 \n" +
                        "13.04.18 21:22 \n" +
                        "Списание 3531.19 RUB  \n" +
                        "web-zaim.ru NOVOSIBIRSK Russia \n" +
                        "Доступно 2324.54 RUB",
                "expense",
                "4*3496",
                "3531.19",
                ""
        );
    }
}
