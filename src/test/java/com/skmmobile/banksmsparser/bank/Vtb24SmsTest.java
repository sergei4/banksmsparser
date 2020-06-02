package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class Vtb24SmsTest extends AbsXmlBankSmsTest {

    public Vtb24SmsTest(Document xmlDocument) {
        super("vtb24", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Karta *0000: Oplata 303.50 RUR; VREMYA ZDOROVYA; 14.11.2017 19:41, dostupno сумма RUR. VTB24",
                "expense",
                "0000",
                "303.5",
                "VREMYA ZDOROVYA"
        );
        checkBankSms(
                "Karta *1020: vnesenie 1000.00 RUR; D. 1, MKR. SOLNECHNYI; 14.12.2017 12:59, dostupno 200.00 RUR",
                "popolnenie",
                "1020",
                "1000",
                ""
        );
        checkBankSms(
                "Karta *1020: spisanie 600.00 RUR; 35, MYASNITSKAYA; 14.12.2017 16:43, dostupno 620.00 RUR",
                "payment",
                "1020",
                "600",
                ""
        );
        checkBankSms(
                "Karta *1020: spisanie 100.00 RUR; W.QIWI.RU; 20.12.2017 14:22, dostupno 100.00 RUR.",
                "payment",
                "1020",
                "100",
                ""
        );
        checkBankSms(
                "Karta *2134 Spisanie, 70.00 RUR za 2 poezdki MOSGORTRANS v dekabre (N bileta 2119696) 29.01.18 10:49 MSK Ostatok 51964.28 RUR",
                "payment",
                "2134",
                "70",
                ""
        );
        checkBankSms(
                "Schet *3318: postuplenie zarabotnoy plati 9200.00 RUB; 20.12.2017 19:38:07; Dostupno 9886.55 RUB. Vipiska po karte v VTB24-Online p.vtb24.ru/mob",
                "popolnenie",
                "Schet *3318",
                "9200",
                ""
        );
        checkBankSms(
                "Schet *4135: postuplenie 190.00 RUB; perevod 25.12.2017 06:43:33; dostupno 227.66 RUB (sobstv. sredstva: 227.66 RUB). http://p.vtb24.ru/smartb",
                "popolnenie",
                "Schet *4135",
                "190",
                ""
        );
        checkBankSms(
                "Karta *7398: snyatie 900.00 RUB; D. 26, PR-KT SHAHTEROV; 24.12.2017 09:52, dostupno 3407.44 RUB (sobstv. sredstva 3407.44 ).",
                "cash_atm",
                "7398",
                "900",
                ""
        );
        checkBankSms(
                "Karta *6634: 27.12 16:28 postuplenie zarabotnoy plati11000.00 RUR. Dostupno 11196.4 RUR. Vipiska po karte v VTB24-Online p.vtb24.ru/mob ",
                "popolnenie",
                "6634",
                "11000",
                ""
        );
        checkBankSms(
                "Karta *6634: 27.12 16:28 postuplenie zarabotnoy plati1.00 RUR. Dostupno 11196.4 RUR. Vipiska po karte v VTB24-Online p.vtb24.ru/mob ",
                "popolnenie",
                "6634",
                "1",
                ""
        );
        checkBankSms(
                "Karta *0755: zachislenie 9205.00 RUR; 35, MIYASNITSKAYA; 28.12.2017 12:13, dostupno 160988.72 RUR (v tom chisle kred. 160988.72 RUR).",
                "popolnenie",
                "0755",
                "9205",
                ""
        );
        checkBankSms(
                "Karta *0755: zachislenie 1.00 RUR; 35, MIYASNITSKAYA; 28.12.2017 12:13, dostupno 160988.72 RUR (v tom chisle kred. 160988.72 RUR).",
                "popolnenie",
                "0755",
                "1",
                ""
        );
        checkBankSms(
                "Schet *3100: postuplenie 100.00 RUB; 21.12.2017 12:07:47; dostupno 100.00 RUB (sobstv. sredstva: 100.00 RUB). http://p.vtb24.ru/smartb",
                "popolnenie",
                "Schet *3100",
                "100",
                ""
        );
        checkBankSms(
                "Schet *2024: spisanie 22431.85 RUB; 28.12.2017 01:58; dostupno 3907.67 RUB (sobstv. sredstva: 3907.67 RUB). http://p.vtb24.ru/s ",
                "payment",
                "Schet *2024",
                "22431.85",
                ""
        );
        checkBankSms(
                "Karta *2658: uvelichen balans scheta na 12.65 RUR; dostupno 50.69 RUR (v tom chisle kreditnie sredstva 50.69 RUR). Uchet rashodov http://p.vtb24.ru/smartc",
                "popolnenie",
                "2658",
                "12.65",
                ""
        );
        checkBankSms(
                "Karta *0755: umenshen balans scheta na 59.00 RUR; dostupno 162009.54 RUR (v tom chisle kreditnie sredstva 162009.54 RUR). Uchet rashodov http://p.vtb24.ru/smartc ",
                "payment",
                "0755",
                "59.00",
                ""
        );
        checkBankSms(
                "Karta *9950 Pokupka, 75.00 RUR .PEKARNYA NA KANTEMIRO 16.01.18 20:21 MSK Ostatok 11105.62 RUR",
                "expense",
                "9950",
                "75.00",
                ".PEKARNYA NA KANTEMIRO"
        );
        checkBankSms(
                "Karta *1602 Popolnenie, 11200.00 RUR  16.01.18 10:51 MSK Ostatok 11355.62 RUR",
                "popolnenie",
                "1602",
                "11200.00",
                ""
        );
        checkBankSms(
                "Karta *6958: oplata SMS-paketa \"Karti+ SMS\" 59 RUR; 01.03.2018. Ustanovite prilozhenie dly ucheta I kontrilyi Vashih pokupok: http://vtb.ru/smartsms",
                "payment",
                "6958",
                "59",
                ""
        );
        checkBankSms(
                "Karta *6070 Beznalichnoe popolnenie 1299.00 RUR 22.03.18 17:32 MSK Ostatok 1386.99 RUR",
                "popolnenie",
                "6070",
                "1299",
                ""
        );
        checkBankSms(
                "Karta *6070 vydacha nalichnyh 1100.00 RUR 52, UL. SVOBODY 23.03.18 08:00 MSK Ostatok 55.99 RUR\n",
                "cash_atm",
                "6070",
                "1100",
                ""
        );
        checkBankSms(
                "Karta *9837: Oplata 1426.18 RUB;MAGNIT GM KRASNODAR 15;18.02.2019 19:18,dostupno 1960.04 RUB",
                "expense",
                "9837",
                "1426.18",
                "indefinite"
        );
        checkBankSms(
                "Karta *0333: Oplata 643 RUB;STOLOVAYA;15.07.2019 12:24,dostupno 6785.69 RUB",
                "expense",
                "0333",
                "643",
                "indefinite"
        );
        checkBankSms(
                "Karta *0333: Oplata 52.5 RUB;SOCIALNAYA APTEKA 70;15.07.2019 08:45,dostupno 1477.19 RUB",
                "expense",
                "0333",
                "52.5",
                "indefinite"
        );
        checkBankSms(
                "Karta *3732: snyatie 2000 RUB;D. 5, SH. GOLOVINSKOE;15.07.2019 15:07,dostupno 34735.57 RUB",
                "cash_atm",
                "3732",
                "2000",
                ""
        );
        checkBankSms(
                "Schet *0745: spisanie 40 RUB;poluchatel Mitrohina Natalya Nikolaevna; 18.07.2019 18:24;dostupno 33485.85 RUB",
                "payment",
                "Schet *0745",
                "40",
                ""
        );
        checkBankSms(
                "Oplata 1072.00 RUB\n" +
                        "Karta *1247 Lenta LLC\n" +
                        "Balans 28732.62 RUB 12:01\n" +
                        "vtb.ru/app",
                "expense",
                "1247",
                "1072",
                "");
        checkBankSms(
                "Vnesenie 29000.00 RUB\n" +
                        "Karta *1247 D. 17, KORP. 1, LIT. A, UL. HA\n" +
                        "Balans 29804.62 RUB 11:33\n" +
                        "vtb.ru/app",
                "popolnenie",
                "1247",
                "29000",
                "");
        checkBankSms(
                "Spisanie 1000.00 RUB\n" +
                        "Karta *0977 CARD2CARD VK.COM\n" +
                        "Balans 13027.76 RUB 09:07\n" +
                        "vtb.ru/app",
                "payment",
                "0977",
                "1000",
                "");
        checkBankSms(
                "Postuplenie zarabotnoy plati\n" +
                        "4350.00 RUB schet *3815\n" +
                        "Balans 4350.00 RUB 16:20\n" +
                        "vtb.ru/app",
                "popolnenie",
                "schet *3815",
                "4350",
                "");
        checkBankSms(
                "Snyatie 10000.00 RUB\n" +
                        "Karta *9111 D. 101, UL. KARLA MARKSA\n" +
                        "Balans 79.89 RUB 10:13\n" +
                        "vtb.ru/app",
                "cash_atm",
                "9111",
                "10000",
                "");
        checkBankSms(
                "Spisano 3000.00 RUB\n" +
                        "Schet *8067 poluchatel AO \"DOM.RF\".\n" +
                        "Balans 1684.74 RUB 07:19\n" +
                        "vtb.ru/app",
                "payment",
                "Schet *8067",
                "3000",
                "");
        checkBankSms(
                "Postuplenie 10589.50 RUB\n" +
                        "Schet *1362 ot UFK po Kirovskoy oblasti (GU-K\n" +
                        "Balans 22080.23 RUB 15:57\n" +
                        "vtb.ru/app",
                "popolnenie",
                "Schet *1362",
                "10589.50",
                "");
    }
}
