package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.SmsParserFactory;

public class TinkoffSmsTest extends AbsXmlBankSmsTest {

    public TinkoffSmsTest(SmsParserFactory smsParserFactory) {
        super("tinkoff", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Pokupka. Karta *9930. Summa 167.90 RUB. PYATEROCHKA, CHELYABINSK. 05.12.2017 16:20. Dostupno 41711.07 RUB. Tinkoff.ru",
                "expense",
                "9930",
                "167.90",
                "PYATEROCHKA, CHELYABINSK"
        );
        checkBankSms(
                "Покупка. Карта *0380. 126 RUB. YANDEX.GOODS. Баланс 22601 RUB",
                "expense",
                "0380",
                "126",
                "YANDEX.GOODS"
        );
        checkBankSms(
                "Покупка. Карта *9930. 175 RUB. GRANDVERA. Доступно 54093 RUB",
                "expense",
                "9930",
                "175",
                "GRANDVERA"
        );
        checkBankSms(
                "Jur. perevod. Karta *9930. Summa 3270.63 RUB. iBank. 07.12.2017 10:11. Dostupno 56644.39 RUB. Tinkoff.ru",
                "perevod",
                "9930",
                "3270.63",
                "iBank"
        );
        checkBankSms(
                "Jur. perevod. Karta *9930. Summa 0.3 RUB. iBank. 07.12.2017 10:11. Dostupno 56644.39 RUB. Tinkoff.ru",
                "perevod",
                "9930",
                "0.3",
                "iBank"
        );
        checkBankSms(
                "Popolnenie. Karta *9930. Summa 8000 RUB. Card2Card. 07.12.2017 15:31. Dostupno 61967.41 RUB. Tinkoff.ru",
                "popolnenie",
                "9930",
                "8000",
                "Card2Card"
        );
        checkBankSms(
                "Покупка. Карта *0380. 38 RUB. YANDEX.GOODS. Доступно 20225 RUB",
                "expense",
                "0380",
                "38",
                "YANDEX.GOODS"
        );
        checkBankSms(
                "Vnutrenniy perevod sebe. Karta *9930. Summa 25000 RUB. mBank. 09.12.2017 05:20. Dostupno 61972.03 RUB. Tinkoff.ru",
                "perevod",
                "9930",
                "25000",
                ""
        );
        checkBankSms(
                "Perevod na kartu. Karta *9930. Summa 1000 RUB. TINKOFF BANK CARD2CARD. 12.12.2017 18:06. Dostupno 56706 RUB. Tinkoff.ru",
                "perevod",
                "9930",
                "1000",
                ""
        );
        // Новые шаблоны
        checkBankSms(
                "Платеж. Карта *7733. 100 RUB. Megafon. Баланс *** RUB",
                "expense",
                "7733",
                "100",
                "Megafon"
        );
        checkBankSms(
                "Снятие. Карта *7733. 3000 RUB. ATM 450704 180-1. Доступно **** RUB",
                "cash_atm",
                "7733",
                "3000",
                "ATM 450704 180-1"
        );
        checkBankSms(
                "Jur. perevod. Karta *9930. Summa 6500 RUB. mBank. 23.12.2017 05:44. Dostupno 67592 RUB. Tinkoff.ru",
                "perevod",
                "9930",
                "6500",
                "mBank"
        );
        checkBankSms(
                "Перевод. Карта *9930. 100 RUB. . Баланс 63385.26 RUB",
                "perevod",
                "9930",
                "100",
                ""
        );
        checkBankSms(
                "Покупка. Карта *0380. Сумма 195 RUB. PROFKOSMETIK. 29.12.2017 14:44. Доступно 1455.03 RUB. Tinkoff.ru",
                "expense",
                "0380",
                "195",
                "PROFKOSMETIK"
        );
        checkBankSms(
                "Vyplata protsentov po vkladu 3416762155. Protsenty v razmere 339.73 RUB zachisleny na kartu. Summa vklada: 50000 RUB. Tinkoff.ru",
                "popolnenie",
                "3416762155",
                "339.73",
                ""
        );
        checkBankSms(
                "Снятие. Карта *7733. 3000 RUB. WSCB Malygin. Доступно ***.67 RUB",
                "cash_atm",
                "7733",
                "3000",
                "WSCB Malygin"
        );
        checkBankSms(
                "Пополнение. Карта *9930. 5000 RUB. Рапида. Доступно 44469.61 RUB",
                "popolnenie",
                "9930",
                "5000",
                "Рапида"
        );
        checkBankSms(
                "По карте *8534 начислено процентов 15.06 руб. Cashback: 97 руб",
                "popolnenie",
                "8534",
                "15.06",
                ""
        );
        checkBankSms(
                "Пополнение. Карта *6430. 1000 RUB. Киберплат. Доступно 1038.13 RUB",
                "popolnenie",
                "6430",
                "1000",
                "Киберплат"
        );
        checkBankSms(
                "Перевод. Карта *6430. 3000 RUB. Card2Card. Баланс 5155.13 RUB",
                "perevod",
                "6430",
                "3000",
                ""
        );
        checkBankSms(
                "Регулярная покупка. Карта *9771. 4212.66 RUB. iHerb. Доступно 6983.56 RUB",
                "payment",
                "9771",
                "4212.66",
                ""
        );
        checkBankSms(
                "Покупка 09.04.2018. Карта *0000. 1000.00 RUB. \"DELTA\". Доступно 1000.00 RUB",
                "expense",
                "0000",
                "1000",
                "\"DELTA\""
        );
        checkBankSms(
                "Карта *0636. Списано 102.99 RUB. Доступно 10399.64 RUB",
                "payment",
                "0636",
                "102.99",
                ""
        );
        checkBankSms(
                "Оплата. Карта *7733. 500 RUB. Баланс 000.87 RUB",
                "payment",
                "7733",
                "500",
                ""
        );
        checkBankSms(
                "Операция. Карта *2084. 213.42 RUB. WEBMONEY.RU. Доступно 4357.04 RUB",
                "payment",
                "2084",
                "213.42",
                "WEBMONEY.RU"
        );
        checkBankSms(
                "Покупка. Карта *2921. 900 RUB. REGISTRATURA. Доступно 12 RUB",
                "expense",
                "2921",
                "900",
                "REGISTRATURA"
        );
        //No-account transactions
        checkBankSms(
                "Покупка. Бесконтактная оплата. 785.9 RUB. PYATEROCHKA. Доступно 32504.63 RUB",
                "expense",
                "tinkoff",
                "785.9",
                ""
        );
        checkBankSms(
                "Платеж. Счет RUB. 500 RUB. GIBDD. Баланс 7499.96 RUB",
                "expense",
                "tinkoff",
                "500",
                ""
        );
        checkBankSms(
                "Пополнение. Счет RUB. 15000 RUB. Элекснет. Баланс -1026.57 RUB",
                "popolnenie",
                "tinkoff",
                "15000",
                ""
        );
        checkBankSms(
                "Перевод. Счет RUB. 500.01 RUB. Баланс 6999.96 RUB",
                "perevod",
                "tinkoff",
                "500.01",
                ""
        );
    }
}
