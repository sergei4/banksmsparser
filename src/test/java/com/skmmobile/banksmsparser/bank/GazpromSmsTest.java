package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class GazpromSmsTest extends AbsXmlBankSmsTest {

    public GazpromSmsTest(Document xmlDocument) {
        super("gazprom", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Telecard; Card8381; Oplata; Summa 559 RUR; 17.12.17 09:19:32; MONETKA; dostupno: 1790.52 RUR",
                "expense",
                "Card8381",
                "559",
                "MONETKA"
        );
        checkBankSms(
                "Telecard; Card1091; 15.05.14 12:31:11; SUPERMARKET TECHNO; Oplata; 9150 RUB; dostupno: 49794.88 RUB",
                "expense",
                "Card1091",
                "9150",
                "SUPERMARKET TECHNO"
        );
        checkBankSms(
                "Telecard; Card1745; Poluchen perevod; Summa 8000 RUR; 14.12.17 10:04:38; PEREVOD MEZHDU KARTAMI; dostupno: 10099.38 RUR; ispolzovano: 59900.62 RUR",
                "popolnenie",
                "Card1745",
                "8000",
                ""
        );
        checkBankSms(
                "Telecard; Card1745; Oplata; Summa 370 RUR; 22.12.17 08:36:33; YALYA; dostupno: 5953.47 RUR; ispolzovano: 64046.53 RUR",
                "expense",
                "Card1745",
                "370",
                "YALYA"
        );
        checkBankSms(
                parser,
                "Telecard; Card1745; Oplata; Summa 1 RUR; 22.12.17 08:36:33; YALYA; dostupno: 5953.47 RUR; ispolzovano: 64046.53 RUR",
                "expense",
                "Card1745",
                "1",
                "YALYA"
        );
        checkBankSms(
                "Telecard; Card1745; Oplata; Summa 237 RUR; 22.12.17 08:28:22; MOROSHKA; dostupno: 6323.47 RUR; ispolzovano: 63676.53 RUR",
                "expense",
                "Card1745",
                "237",
                "MOROSHKA"
        );
        checkBankSms(
                "Card8381; Oplata v I-net; Summa 165 RUR; 21.12.17 14:46:31; GOOGLE *androidmarket; dostupno: 112.36 RUR",
                "expense",
                "Card8381",
                "165",
                "GOOGLE *androidmarket"
        );
        checkBankSms(
                "Card8381; Oplata v I-net; Summa 1 RUR; 21.12.17 14:46:31; GOOGLE *androidmarket; dostupno: 112.36 RUR",
                "expense",
                "Card8381",
                "1",
                "GOOGLE *androidmarket"
        );
        checkBankSms(
                "Telecard; Card8381; Snyatie nalichnih; Summa 14900 RUR; 14.12.17 13:23:35; GAZPROMBANK; dostupno: 11599.23 RUR",
                "cash_atm",
                "Card8381",
                "14900",
                "GAZPROMBANK"
        );
        checkBankSms(
                "Telecard; Card8381; Snyatie nalichnih; Summa 1 RUR; 14.12.17 13:23:35; GAZPROMBANK; dostupno: 11599.23 RUR",
                "cash_atm",
                "Card8381",
                "1",
                "GAZPROMBANK"
        );
        checkBankSms(
                "Telecard; Card5621;Card1691;CUP Standard;Card1963;Card9047; 10.01.18 12:52:12; Zachislenie; 21162.48 RUR; dostupno: 46786.71 RUR",
                "zachislenie",
                "Card5621",
                "21162.48",
                ""
        );
        checkBankSms(
                "Telecard; Card5621;Card1691;CUP Standard;Card1963;Card9047; 10.01.18 12:52:12; Zachislenie; 1 RUR; dostupno: 46786.71 RUR",
                "zachislenie",
                "Card5621",
                "1",
                ""
        );
        checkBankSms(
                "Telecard; Card9047; Perevod; Summa 9000 RUR; 09.01.18 18:09:02; PEREVOD NA KARTU; dostupno: 44603.23 RUR",
                "perevod",
                "Card9047",
                "9000",
                ""
        );
        checkBankSms(
                "Telecard; Card9047; Perevod; Summa 1 RUR; 09.01.18 18:09:02; PEREVOD NA KARTU; dostupno: 44603.23 RUR",
                "perevod",
                "Card9047",
                "1",
                ""
        );
        checkBankSms(
                "Telecard; Card1691; Predauth; Summa 525 RUR; 15.01.18 17:16:56; YANDEX.TAXI; dostupno: 406651.48 RUR",
                "expense",
                "Card1691",
                "525",
                "YANDEX.TAXI"
        );
        checkBankSms(
                "Telecard; Card0125; Predauth; Summa 1 RUR; 06.01.18 12:35:39; YANDEX.TAXI; dostupno: 741.24 RUR",
                "expense",
                "Card0125",
                "1",
                "YANDEX.TAXI"
        );
        checkBankSms(
                "Telecard; Card9284; Cash-in; Summa 2000.3 RUR; 17.01.18 14:00:05; GAZPROMBANK; dostupno: 3164.42 RUR",
                "popolnenie",
                "Card9284",
                "2000.3",
                ""
        );
        checkBankSms(
                "Telecard; Card9284; Cash-in; Summa 1 RUR; 17.01.18 14:00:05; GAZPROMBANK; dostupno: 3164.42 RUR",
                "popolnenie",
                "Card9284",
                "1",
                ""
        );
        checkBankSms(
                "Telecard; Card9284; Cash-in; Summa 0.3 RUR; 17.01.18 14:00:05; GAZPROMBANK; dostupno: 3164.42 RUR",
                "popolnenie",
                "Card9284",
                "0.3",
                ""
        );
        checkBankSms(
                "Telecard; Card9284; Platezh; Summa 1000 RUR; 15.01.18 11:26:50; GAZPROMBANK; dostupno: 13089.42 RUR",
                "payment",
                "Card9284",
                "1000",
                ""
        );
        checkBankSms(
                "Telecard; Card9284; Platezh; Summa 1.0 RUR; 15.01.18 11:26:50; GAZPROMBANK; dostupno: 13089.42 RUR",
                "payment",
                "Card9284",
                "1",
                ""
        );
        checkBankSms(
                "Telecard; MC2591; Snyatie nalichnih; Summa 2800 RUR; 29.12.17 07:40:02; GAZPROMBANK; dostupno: 58.32 RUR",
                "cash_atm",
                "MC2591",
                "2800",
                "GAZPROMBANK"
        );
        checkBankSms(
                "Telecard; MC2591; Oplata; Summa 673 RUR; 28.12.17 09:30:29; WILDBERRIES; dostupno: 2858.32 RUR",
                "expense",
                "MC2591",
                "673",
                "WILDBERRIES"
        );
        checkBankSms(
                "Telecard; MC2591; 12.01.18 17:26:20; Zachislenie; 3525.54 RUR; dostupno: 3583.86 RUR",
                "zachislenie",
                "MC2591",
                "3525.54",
                ""
        );
        checkBankSms(
                "Telecard; Card9284; Poluchen perevod; Summa 160 RUR; 19.01.18 13:45:37; GAZPROMBANK; dostupno: 224.42 RUR",
                "popolnenie",
                "Card9284",
                "160",
                ""
        );
        checkBankSms(
                "Telecard; Card3086; Perevod; Summa 4500 RUR; 21.01.18 10:54:18; TINKOFF BANK CARD2CARD; dostupno: 1126.76 RUR",
                "perevod",
                "Card3086",
                "4500",
                ""
        );
        checkBankSms(
                "*5818 -423р MAGAZIN GORIZONT 01.03.18 13:46 Доступно 7323.53р",
                "expense",
                "5818",
                "423",
                ""
        );
        checkBankSms(
                "*3193 +1500р  07.03.18 09:58 Доступно 10369.58р",
                "popolnenie",
                "3193",
                "1500",
                ""
        );
        checkBankSms(
                "*9047 +45824.88р 07.03.18 15:27 Доступно 46140.08р",
                "popolnenie",
                "9047",
                "45824.88",
                ""
        );
        checkBankSms(
                "*1691 -111р YANDEX.TAXI 03.03.18 21:09 Доступно 2460.03р",
                "expense",
                "1691",
                "111",
                ""
        );
        checkBankSms(
                "*8381 -388.2р MAGNIT MK RIGODON 01.03.18 10:08 Доступно 28651.33р",
                "expense",
                "8381",
                "388.2",
                ""
        );
        checkBankSms(
                "*1691 -3900р Комиссия 19.5р PEREVOD NA KARTU 03.03.18 20:26 Доступно 2071.03р",
                "expense",
                "1691",
                "3900",
                ""
        );
        checkBankSms(
                "*1691 -5р YANDEX.TAXI 20.03.18 14:31 Доступно 7586.08р",
                "expense",
                "1691",
                "5",
                ""
        );
        checkBankSms(
                "*3164 Наличные 1р GAZPROMBANK 05.06.18 13:43:55 Доступно 12372.53р",
                "cash_atm",
                "3164",
                "1",
                ""
        );
        checkBankSms(
                "*3164 Покупка 1р VERNYY 01.06.18 17:59:50 Доступно 14798.44р",
                "expense",
                "3164",
                "1",
                ""
        );
        checkBankSms(
                "*3164 Зачисление 26090р 30.08.18 09:26 Доступно 26090р",
                "zachislenie",
                "3164",
                "26090",
                ""
        );
        checkBankSms(
                "*5818 Перевод 1500.1р BANK SPB IB 06.06.18 11:03:21 Доступно 6875.37р",
                "perevod",
                "5818",
                "1500.1",
                ""
        );
        checkBankSms(
                "*7726 Получен перевод 0.1р PEREVOD MEZHDU KARTAMI 16.06.18 19:26:29 Доступно 75511.83р",
                "popolnenie",
                "7726",
                "0.1",
                ""
        );
        checkBankSms(
                "*5563 Внесение 35000р GAZPROMBANK 24.06.18 13:46:16 Доступно 35056.89р",
                "popolnenie",
                "5563",
                "35000",
                ""
        );
        checkBankSms(
                "*8641 Пополнение 4000р IPT GPB KAZAN 28.07.18 09:39:52",
                "popolnenie",
                "8641",
                "4000",
                ""
        );
        checkBankSms(
                "*8260 Платеж 320р Mobilniye Tele Sistemy 10.09.18 06:03:44 Доступно 54701.43р",
                "payment",
                "8260",
                "320",
                ""
        );
        checkBankSms(
                "*1480 Предавторизация 2500р POGASH. ZADOLJENNOSTI 22.06.18 19:49:35 Доступно 9588.08р",
                "payment",
                "1480",
                "2500",
                ""
        );
        checkBankSms(
                "Списано с карты *3522; 08.06.2018; Погашение задолженности по кредиту.; Сумма платежа 7995.00RUR. Подробнее по тел. *0701  (Услуга доступна абонентам TELE2, МОТИВ, МТС, Билайн и Мегафон), 88001000089. Звонок на территории РФ бесплатный. Банк ГПБ (АО).",
                "payment",
                "3522",
                "7995.00",
                ""
        );
    }
}
