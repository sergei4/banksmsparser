package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.SmsParserFactory;

public class PochtaBankSmsTest extends AbsXmlBankSmsTest {

    public PochtaBankSmsTest(SmsParserFactory smsParserFactory) {
        super("pochtabank", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Счёт договора 20770680 пополнен на 11000.00р. Баланс 11157.56р.",
                "popolnenie",
                "20770680",
                "11000.00",
                ""
        );
        checkBankSms(
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
        checkBankSms(
                "Счёт договора 22806795. Пополнение на 3204.74р. Доступно 3228.53р",
                "popolnenie",
                "22806795",
                "3204.74",
                ""
        );
        checkBankSms(
                "Пополнение от Пенсионного Фонда РФ на 12018.87р. Доступно 12018.87р",
                "popolnenie",
                "pochtabank_account",
                "12018.87",
                ""
        );
        checkBankSms(
                "VISA5125\n" +
                        "19:31\n" +
                        "Oplata 776.97RUB\n" +
                        "PEREKRESTOK\n" +
                        "Balans 56776.61RUB",
                "expense",
                "VISA5125",
                "776.97",
                ""
        );
        checkBankSms(
                "VISA5125\n" +
                        "12:34\n" +
                        "Оплата 154.00RUB\n" +
                        "STOLOVAYA\n" +
                        "Баланс 29519.63RUB",
                "expense",
                "VISA5125",
                "154.00",
                ""
        );
        checkBankSms(
                "Карта 4*8100. Пополнение на 11000.00 руб",
                "popolnenie",
                "4*8100",
                "11000",
                ""
        );
        checkBankSms(
                "Договор 44853115. Пополнение на 1486.00р. Доступно 118687.51р",
                "popolnenie",
                "44853115",
                "1486",
                ""
        );
        checkBankSms(
                "MIR8943\n" +
                        "13:15\n" +
                        "Oplata 110.00 RUB\n" +
                        "KAFE\n" +
                        "Balans 722.26 RUB",
                "expense",
                "MIR8943",
                "110",
                ""
        );
    }
}
