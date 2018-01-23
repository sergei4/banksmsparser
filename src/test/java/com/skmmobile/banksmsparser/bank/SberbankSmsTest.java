package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import org.w3c.dom.Document;

public class SberbankSmsTest extends AbsXmlBankSmsTest {

    public SberbankSmsTest(Document xmlDocument) {
        super("sberbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "VISA6168 06.12.17 11:30 списание 700р Баланс: 2682.45р",
                "payment",
                "VISA6168",
                "700",
                ""
        );
        checkBankSms(
                parser,
                "VISA6470 04.12.17 08:18 оплата 200р MTS OAO Баланс: 4278.81р",
                "expense",
                "VISA6470",
                "200",
                "MTS OAO"
        );
        checkBankSms(
                parser,
                "VISA6168 02.12.17 19:32 списание 30000р SBERBANK ONL@IN KARTA-VKLAD Баланс: 3382.45р",
                "payment",
                "VISA6168",
                "30000",
                ""
        );
        checkBankSms(
                parser,
                "VISA6168 02.12.17 08:45 зачисление 30000р ATM 335417 Баланс: 33382.45р",
                "zachislenie",
                "VISA6168",
                "30000",
                "ATM 335417"
        );
        checkBankSms(
                parser,
                "VISA6168 09.12.17 19:07 зачисление 10000р с Вашего вклада. Баланс: 12682.45р",
                "zachislenie",
                "VISA6168",
                "10000",
                ""
        );
        checkBankSms(
                parser,
                "VISA6168 11.12.17 18:13 зачисление 6300р с Вашего вклада. Баланс: 8982.45р",
                "zachislenie",
                "VISA6168",
                "6300",
                ""
        );
        checkBankSms(
                parser,
                "MIR-3075 12.12.17 19:31 покупка 171.76р PYATEROCHKA 8456 Баланс: 2476.46р",
                "expense",
                "MIR-3075",
                "171.76",
                "PYATEROCHKA 8456"
        );
        checkBankSms(
                parser,
                "VISA5538 13.12.17 16:18 покупка 558р SUPERMARKET EVROPA Баланс: 3256.88р",
                "expense",
                "VISA5538",
                "558",
                "SUPERMARKET EVROPA"
        );
        checkBankSms(
                parser,
                "VISA5538 11.12.17 20:46 покупка 557.90р BURGER KING 0287 Баланс: 279.88р",
                "expense",
                "VISA5538",
                "557.90",
                "BURGER KING 0287"
        );
        checkBankSms(
                parser,
                "MAES0515 11.12.17 12:24 зачисление пенсии 10471.91р Баланс: 12934.80р",
                "zachislenie",
                "MAES0515",
                "10471.91",
                ""
        );
        checkBankSms(
                parser,
                "MAES0515 11.12.17 12:27 списание 12000р SBERBANK ONL@IN KARTA-VKLAD Баланс: 934.80р",
                "payment",
                "MAES0515",
                "12000",
                ""
        );
        checkBankSms(
                parser,
                "MAES0515 10.12.17 05:43 зачисление 1856.68р SO VKLADA N*013008564017-1856.68RUR Баланс: 2462.89р",
                "zachislenie",
                "MAES0515",
                "1856.68",
                ""
        );
        checkBankSms(
                parser,
                "ORPS5161 09.12.17 11:44 списание 2000р Баланс: 229.11р",
                "payment",
                "ORPS5161",
                "2000",
                ""
        );
        checkBankSms(
                parser,
                "ORPS5161 08.12.17 16:25 списание 1р Баланс: 2229.11р",
                "payment",
                "ORPS5161",
                "1",
                ""
        );
        checkBankSms(
                parser,
                "ORPS5161 08.12.17 16:12 зачисление 1р Баланс: 2309.21р",
                "zachislenie",
                "ORPS5161",
                "1",
                ""
        );
        checkBankSms(
                parser,
                "ORPS5161 08.12.17 16:10 зачисление 5000р с Вашего вклада. Баланс: 6020.21р",
                "zachislenie",
                "ORPS5161",
                "5000",
                ""
        );
        checkBankSms(
                parser,
                "MIR-3075 13.12.17 22:51 зачисление 31600р Баланс: 32474.66р",
                "zachislenie",
                "MIR-3075",
                "31600",
                ""
        );
        checkBankSms(
                parser,
                "ECMC8559 13.12.17 16:49 зачисление 15000р ATM 10853020 Баланс: 0",
                "zachislenie",
                "ECMC8559",
                "15000",
                "ATM 10853020"
        );
        checkBankSms(
                parser,
                "VISA6168 13.12.17 14:18 выдача 5000р ATM 861320 Баланс: 97682.45р",
                "cash_atm",
                "VISA6168",
                "5000",
                "ATM 861320"
        );
        checkBankSms(
                parser,
                "VISA0000 10.12.17 оплата Мобильного банка за 10/12/2017-09/01/2018 60р Баланс: 00000.00р",
                "service_pay",
                "VISA0000",
                "60",
                ""
        );
        checkBankSms(
                parser,
                "VISA0000: перевод 400р. на карту получателя ВЕРОНИКА АЛЕКСАНДРОВНА П. выполнен. Подробнее в выписке по карте http://sberbank.ru/sms/h2/",
                "perevod",
                "VISA0000",
                "400",
                ""
        );
        checkBankSms(
                parser,
                "MAES7424 14.12.17 09:39 оплата 400р Баланс",
                "expense",
                "MAES7424",
                "400",
                "indefinite"
        );
        checkBankSms(
                parser,
                "MAES0151 14.12.17 10:05 покупка 95.60р Stolovaya 56 Баланс: 17.76р",
                "expense",
                "MAES0151",
                "95.60",
                "Stolovaya 56"
        );

        // Новые шаблоны
        checkBankSms(
                parser,
                "VISA0000 20.12.17 08:47 зачисление зарплаты 10000.00р Баланс: 00000.00р",
                "zachislenie",
                "VISA0000",
                "10000",
                ""
        );
        checkBankSms(
                parser,
                "MIR-3075 20.12.17 17:03 зачисление зарплаты 40933р Баланс: 41251.13р",
                "zachislenie",
                "MIR-3075",
                "40933",
                ""
        );
        checkBankSms(
                parser,
                "VISA0000  19.12.17 08:42 плата за выписку/запрос баланса 3р Баланс: 473.45р",
                "service_pay",
                "VISA0000",
                "3",
                ""
        );
        checkBankSms(
                parser,
                "VISA0000. Списание в сумме 2 923.55 RUR с карт.счета в погашение Вашего долга по другой карте. 2017-12-18 00:00:00",
                "payment",
                "VISA0000",
                "2923.55",
                ""
        );
        checkBankSms(
                parser,
                "VISA4812 19.12.17 возврат покупки 126.07р YM*AE Баланс: 316.31р",
                "vozvrat",
                "VISA4812",
                "126.07",
                ""
        );
        checkBankSms(
                parser,
                "ECMC1391 26.12.17 10:51 зачисление премии 20000.00р Баланс: 00000.00р",
                "zachislenie",
                "ECMC1391",
                "20000",
                ""
        );
        checkBankSms(
                parser,
                "VISA4696 25.12.17 09:10 зачисление аванса 19000р Баланс: 45654.73р",
                "zachislenie",
                "VISA4696",
                "19000",
                ""
        );
        checkBankSms(
                parser,
                "VISA4575 26.12.17 10:50 зачисление зарплаты 8132.35р Баланс: 8857.54р",
                "zachislenie",
                "VISA4575",
                "8132.35",
                ""
        );
        checkBankSms(
                parser,
                "MAES3781 07.01.18 08:05 перечисление процентов 277.41р Баланс: 15070.45р",
                "zachislenie",
                "MAES3781",
                "277.41",
                ""
        );
        checkBankSms(
                parser,
                "ECMC4773: пополнение Копилки на \"Пополняй ОнЛ йн 3м - 6м руб. \" на сумму 277.41руб. Дата следующего платежа 15.01.18",
                "popolnenie",
                "ECMC4773",
                "277.41",
                ""
        );
        checkBankSms(
                parser,
                "VISA1224 14.01.18 10:22 зачисление 3000р ITT 352056 Баланс: 4000р",
                "zachislenie",
                "VISA1224",
                "3000",
                ""
        );
        checkBankSms(
                parser,
                "VISA4993: оплата услуг 250р Megafon (9261393521)",
                "expense",
                "VISA4993",
                "250",
                ""
        );
        checkBankSms(
                parser,
                "Сбербанк Онлайн. С Вашей карты **** 2374 произведен перевод на счет № 40702810838040021360 на сумму 1000,00 RUB.",
                "perevod",
                "2374",
                "1000",
                ""
        );
        checkBankSms(
                parser,
                "Сбербанк Онлайн. С Вашей карты **** 2854 произведен перевод на карту № **** 6780 на сумму 335,00 RUB.",
                "perevod",
                "2854",
                "335",
                ""
        );
        checkBankSms(
                parser,
                "Сбербанк Онлайн. С Вашего счета 42307810670001922831 произведен перевод на счет № 42305810270001924299 на сумму 10000,00 RUB.",
                "perevod",
                "42307810670001922831",
                "10000",
                ""
        );
        checkBankSms(
                parser,
                "Сбербанк Онлайн. С Вашего счета 40817810438261833745 произведен перевод на карту № **** 2854 на сумму 3000,00 RUB.",
                "perevod",
                "40817810438261833745",
                "3000",
                ""
        );
        checkBankSms(
                parser,
                "Исполнение Автоплатежа \"ТВ\" прошло успешно. Ваш счет на сумму 185 руб. с карты ECMC7471 оплачен. Комиссия составила 0.00 руб. Дата следующего платежа 19.01.18",
                "payment",
                "ECMC7471",
                "185",
                ""
        );
        checkBankSms(
                parser,
                "Исполнение Автоплатежа \"ЖИЛИЩНОКОММУНАЛЬНЫЕ\" прошло успешно. Ваш счет на сумму 6751.9 руб. с карты VISA7353 оплачен. Комиссия составила 0.00 руб. Дата следующего платежа",
                "payment",
                "VISA7353",
                "6751.9",
                ""
        );
        checkBankSms(
                parser,
                "Автоплатеж \"Мегафон\" с карты ECMC3709 исполнен. Ваш счет на сумму 550 руб. оплачен. Комиссия составила 0.00 руб",
                "payment",
                "ECMC3709",
                "550",
                ""
        );
        checkBankSms(
                parser,
                "Автоплатеж \"Интернет Телевидение\" с карты VISA3872 исполнен. Ваш счет на сумму 825.36 руб. оплачен. Комиссия составила 0.00 руб",
                "payment",
                "VISA3872",
                "825.36",
                ""
        );
        checkBankSms(
                parser,
                "Сбербанк Бизнес Онлайн. No9 от 17.01.2018 на сумму 5000-00 RUB со счета 40802810016120100739 на счет 40702810400010000758 исполнен Банком 17.01.2018 11:22:24.",
                "payment",
                "40802810016120100739",
                "5000",
                ""
        );
        checkBankSms(
                parser,
                "VISA2020 21.12.17 06:23 оплата годового обслуживания карты 150р Баланс: 112.14р",
                "service_pay",
                "VISA2020",
                "150",
                ""
        );
        checkBankSms(
                parser,
                "VISA2243 16.08.17 13:15 выдача наличных 400р ATM 971126 Баланс: 9034.90р",
                "cash_atm",
                "VISA2243",
                "400",
                "ATM 971126"
        );
        checkBankSms(
                parser,
                "ECMC4756 18.01.18 06:14 выдача 282.96р OSB 8603 0061 Баланс: 22100.74р",
                "cash_atm",
                "ECMC4756",
                "282.96",
                "OSB 8603 0061"
        );

    }
}
