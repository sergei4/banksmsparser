package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class MinbankSmsTest extends AbsXmlBankSmsTest {

    public MinbankSmsTest(Document xmlDocument) {
        super("minbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Platezh cherez Telebank v Gazprom Mezhregiongaz Tula. Gazosnabzhenie Data: 07/08 10:59 Id.klienta: ****0967 Summa: 260.89RUB Komissija: 0.00RUB Dostupno: 1789.46RUB Terminal: Mbank_01",
                "payment",
                "0967",
                "260.89",
                ""
        );
        checkBankSms(
                "Platej cherez Telebank v MTS\n" +
                        "Data: 17/01 10:58\n" +
                        "Id.klienta: ****1889\n" +
                        "Summa: 130.49RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 0.00RUB\n" +
                        "Terminal: Mbank_01",
                "payment",
                "1889",
                "130.49",
                ""
        );
        checkBankSms(
                "Платеж через Телебанк в TELE2\n" +
                        "Дата: 25/01 11:18\n" +
                        "Ид.клиента: ****8305\n" +
                        "Сумма: 100.00RUB\n" +
                        "Комиссия: 0.50RUB\n" +
                        "Доступно: 6606.23RUB\n" +
                        "Терминал: TBank_v2",
                "payment",
                "8305",
                "100.00",
                ""
        );
        checkBankSms(
                "Platej cherez Telebank v Vladimirskaya gorodskaya set\n" +
                        "Data: 10/01 11:16\n" +
                        "Id.klienta: ****9200\n" +
                        "Summa: 400.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 932.53RUB\n" +
                        "Terminal: TBank_v2",
                "payment",
                "9200",
                "400",
                ""
        );
        checkBankSms(
                "Poluchenie nalichnyh cherez bankomat\n" +
                        "Data: 02/01 11:51\n" +
                        "Karta: ****3504\n" +
                        "Summa: 4900.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 421.64RUB\n" +
                        "Terminal: A3410004,MINB,Gorkogo str. d.27a,Gorohivec,RU",
                "cash_atm",
                "3504",
                "4900.00",
                ""
        );
        checkBankSms(
                "Postuplenie na kartu\n" +
                        "Data: 30/12 09:20\n" +
                        "Karta: ****3504\n" +
                        "Summa: 5000.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 5321.64RUB\n" +
                        "Terminal: 20000016,TRANSFER,MOSCOW,RU",
                "popolnenie",
                "3504",
                "5000.00",
                ""
        );
        checkBankSms(
                "Pokupka tovara/uslugi\n" +
                        "Data: 10/01 15:58\n" +
                        "Karta: ****3504\n" +
                        "Summa: 1.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 420.64RUB\n" +
                        "Terminal: 99990669,KINO1TV.RU,S-PETERBURG,RU",
                "expense",
                "3504",
                "1.00",
                ""
        );
        checkBankSms(
                "Покупка товара/услуги\n" +
                        "Дата: 04/02 14:32\n" +
                        "Карта: ****2518\n" +
                        "Сумма: 818.80RUB\n" +
                        "Комиссия: 0.00RUB\n" +
                        "Доступно: 3831.11RUB\n" +
                        "Терминал: RU170150,LUKOIL.DD 4289 33V,MUROM,RU",
                "expense",
                "2518",
                "818.8",
                ""
        );
        checkBankSms(
                "Perevod cherez POS-terminal na kartu\n" +
                        "Data: 17/01 21:50\n" +
                        "Karta: ****3504\n" +
                        "Summa: 26500.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 8800.66RUB\n" +
                        "Terminal: 10000001,TINKOFF BANK CARD2CARD,MOSCOW,RU",
                "perevod",
                "3504",
                "26500",
                ""
        );
        checkBankSms(
                "Перевод через Телебанк на счет 40817***372\n" +
                        "Дата: 15/01 13:32\n" +
                        "Ид.клиента: ****8305\n" +
                        "Сумма: 1000.00RUB\n" +
                        "Комиссия: 0.00RUB\n" +
                        "Доступно: 106.73RUB\n" +
                        "Терминал: TBank_v2",
                "perevod",
                "40817***372",
                "1000",
                ""
        );
        checkBankSms(
                "Poluchenie nalichnyh cherez POS-terminal\n" +
                        "Data: 23/01 12:33\n" +
                        "Karta: ****3504\n" +
                        "Summa: 5000.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 350.66RUB\n" +
                        "Terminal: P0410014,MINB,Bratyev Besedinikh str., 5,Gorokhovets,RU",
                "cash_atm",
                "3504",
                "5000",
                ""
        );
        checkBankSms(
                "Zachislenie na schet 40817***539\n" +
                        "Data: 24/01 14:41\n" +
                        "Summa: 1568.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 1568.34RUB",
                "zachislenie",
                "40817***539",
                "1568.00",
                ""
        );
        checkBankSms(
                "Perevod cherez Telebank na schet 40817***878\n" +
                        "Data: 28/01 11:43\n" +
                        "Id.klienta: ****1600\n" +
                        "Summa: 1568.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 0.34RUB\n" +
                        "Terminal: Mbank_01",
                "perevod",
                "40817***878",
                "1568",
                ""
        );
        checkBankSms(
                "Списание со счета 40817***372\n" +
                        "Дата: 16/01 08:02\n" +
                        "Сумма: 298.63RUB\n" +
                        "Комиссия: 0.00RUB\n" +
                        "Доступно: 5631.91RUB\n" +
                        "Кредит: 15000.00RUB",
                "payment",
                "40817***372",
                "298.63",
                ""
        );
        checkBankSms(
                "Зачисление на счет 40817***372\n" +
                        "Дата: 09/02 10:26\n" +
                        "Сумма: 716.23RUB\n" +
                        "Комиссия: 0.00RUB\n" +
                        "Доступно: 1578.34RUB\n" +
                        "Кредит: 15000.00RUB",
                "zachislenie",
                "40817***372",
                "716.23",
                ""
        );
        checkBankSms(
                "07.02.18 40702810***063 IntBank Spisanie 10000RUB Doc 11",
                "payment",
                "40702810***063",
                "10000",
                ""
        );
        checkBankSms(
                "Перевод через Телебанк на карту ****6256\n" +
                        "Дата: 07/03 21:48\n" +
                        "Ид.клиента: ****8305\n" +
                        "Сумма: 2300.00RUB\n" +
                        "Комиссия: 50.00RUB\n" +
                        "Доступно: 1138.95RUB\n" +
                        "Терминал: Mbank_01",
                "perevod",
                "6256",
                "2300.00",
                ""
        );
        checkBankSms(
                "Predavtorizaciia\n" +
                        "Data: 30/03 06:24\n" +
                        "Karta: ****6206\n" +
                        "Summa: 1000.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 3542.83RUB\n" +
                        "Terminal: RU110076,LUKOIL.AZS 385 29S,ARHANGELSK,RU",
                "expense",
                "6206",
                "1000",
                ""
        );
        checkBankSms(
                "Перевод между своими счетами\n" +
                        "Дата: 26/02 20:52\n" +
                        "Ид.клиента: ****0285\n" +
                        "Сумма: 1000000.00RUB\n" +
                        "Комиссия: 0.00RUB\n" +
                        "Доступно: 0.00RUB\n" +
                        "Терминал: TBank_v2\n",
                "perevod",
                "0285",
                "1000000",
                ""
        );
        checkBankSms(
                "Vnesenie nalichnyh cherez bankomat\n" +
                        "Data: 14/03 19:23\n" +
                        "Karta: ****4211\n" +
                        "Summa: 2000.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 2000.00RUB\n" +
                        "Terminal: F0040013,MINB,Ryazanskiy pr-t, 2,str. 2,Moscow,RU",
                "popolnenie",
                "4211",
                "2000",
                ""
        );
        checkBankSms(
                "Perevod cherez Telebank na kartu ****6846\n" +
                        "Data: 09/04 11:28\n" +
                        "Id.klienta: ****8561\n" +
                        "Summa: 850.00RUB\n" +
                        "Komissiia: 50.00RUB\n" +
                        "Dostupno: 5395.63RUB\n" +
                        "Terminal: TBank?v2",
                "perevod",
                "6846",
                "850",
                ""
        );
        checkBankSms(
                "Платеж\n" +
                        "Сумма 400RUB\n" +
                        "TTK\n" +
                        "06/06 06:25 карта *8305\n" +
                        "Остаток 330.17RUB",
                "payment",
                "8305",
                "400",
                ""
        );
        checkBankSms(
                "Pokupka\n" +
                        "Summa 83.90RUB\n" +
                        "IP PAUTOV A.A.\n" +
                        "14/05 13:04 karta *6206\n" +
                        "Ostatok 9268.26RUB",
                "expense",
                "6206",
                "83.90",
                ""
        );
        checkBankSms(
                "Зачисление\n" +
                        "Сумма 948.91RUB\n" +
                        "Кредит 15000RUB\n" +
                        "03/06 12:21 счет 40817*372\n" +
                        "Остаток 2848.89RUB",
                "zachislenie",
                "40817*372",
                "948.91",
                ""
        );
        checkBankSms(
                "Предавторизация\n" +
                        "Дата: 31/03 21:55\n" +
                        "Карта: ****2518\n" +
                        "Сумма: 186.04RUB\n" +
                        "Комиссия: 0.00RUB\n" +
                        "Доступно: 661.57RUB\n" +
                        "Терминал: 20002101,YM*AliExpress,Moscow,RU\n",
                "expense",
                "2518",
                "186.04",
                ""
        );
        checkBankSms(
                "Списание\n" +
                        "Сумма 293.91RUB\n" +
                        "Кредит 15000RUB\n" +
                        "03/06 12:21 счет 40817*372\n" +
                        "Остаток 2554.98RUB",
                "payment",
                "40817*372",
                "293.91",
                ""
        );
        checkBankSms(
                "Получение наличных через банкомат\n" +
                        "Дата: 13/02 17:34\n" +
                        "Карта: ****2518\n" +
                        "Сумма: 1000.00RUB\n" +
                        "Комиссия: 49.00RUB\n" +
                        "Доступно: 281.51RUB\n" +
                        "Терминал: A0460033,MINB,Swerdlova str,d.12,Murom,RU",
                "cash_atm",
                "2518",
                "1000",
                ""
        );
        checkBankSms(
                "Перевод между своими счетами\n" +
                        "Сумма 5500RUB\n" +
                        "TBank_v2\n" +
                        "10/05 11:03 карта *8305\n" +
                        "Остаток 14798.93RUB",
                "perevod",
                "8305",
                "5500",
                ""
        );
        checkBankSms(
                "Zachislenie\n" +
                        "Summa 6282.21RUB\n" +
                        "03/05 18:09 schet 40817*260\n" +
                        "Ostatok 10542.16RUB",
                "zachislenie",
                "40817*260",
                "6282.21",
                ""
        );
        checkBankSms(
                "Popolnenie\n" +
                        "Summa 40000RUB\n" +
                        "F0200000\n" +
                        "11/05 20:38 karta *4211\n" +
                        "Ostatok 102597.17RUB",
                "popolnenie",
                "4211",
                "40000",
                ""
        );
        checkBankSms(
                "Перевод на карту *1707\n" +
                        "Сумма 4080RUB\n" +
                        "Телебанк\n" +
                        "29/05 09:27 карта *2099\n" +
                        "Остаток 219.86RUB",
                "perevod",
                "2099",
                "4080",
                ""
        );
        checkBankSms(
                "Перевод через POS-терминал на карту\n" +
                        "Дата: 07/04 10:28\n" +
                        "Карта: ****3489\n" +
                        "Сумма: 5526.44RUB\n" +
                        "Комиссия: 0.00RUB\n" +
                        "Доступно: 0.00RUB\n" +
                        "Терминал: ECOMMP2P,MCP2P MB,MOSKVA,RU",
                "popolnenie",
                "3489",
                "5526.44",
                ""
        );
        checkBankSms(
                "Покупка\n" +
                        "Сумма 270RUB\n" +
                        "RAZLIVNOJ MIR\n" +
                        "10/08 19:06 карта *0556",
                "expense",
                "0556",
                "270",
                ""
        );
        checkBankSms(
                "Vydacha\n" +
                        "Summa 500RUB\n" +
                        "A0430033\n" +
                        "28/08 14:18 karta *5581\n" +
                        "Ostatok 955.26RUB",
                "cash_atm",
                "5581",
                "500",
                ""
        );
        checkBankSms(
                "Platej\n" +
                        "Summa 294.70RUB\n" +
                        "VKS\n" +
                        "08/06 06:51 karta *9200\n" +
                        "Ostatok 2709.37RUB",
                "payment",
                "9200",
                "294.70",
                ""
        );
        checkBankSms(
                "Перевод на счет 40817*372\n" +
                        "Сумма 1000RUB\n" +
                        "Телебанк\n" +
                        "10/07 13:59 карта *8305\n" +
                        "Остаток 7896.11RUB",
                "perevod",
                "8305",
                "1000",
                ""
        );
        checkBankSms(
                "Perevod na schet 40817*088\n" +
                        "Summa 17.53RUB\n" +
                        "Telebank\n" +
                        "07/07 07:41 karta *7443\n" +
                        "Ostatok 0RUB",
                "perevod",
                "7443",
                "17.53",
                ""
        );
        checkBankSms(
                "Postuplenie\n" +
                        "Summa 26000RUB\n" +
                        "Telebank\n" +
                        "26/07 16:16 karta *3615\n" +
                        "Ostatok 34622.29RUB",
                "zachislenie",
                "3615",
                "26000",
                ""
        );
        checkBankSms(
                "Выдача\n" +
                        "Сумма 2000RUB\n" +
                        "A0460033\n" +
                        "13/08 11:24 карта *0556",
                "cash_atm",
                "0556",
                "2000",
                ""
        );
    }
}
