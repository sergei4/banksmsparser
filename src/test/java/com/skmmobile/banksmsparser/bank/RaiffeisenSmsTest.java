package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class RaiffeisenSmsTest extends AbsXmlBankSmsTest {

    public RaiffeisenSmsTest(Document xmlDocument) {
        super("raiffeisen", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Karta *0853;\n" +
                        "Pokupka:734 RUR; RUS/VORONEZH/LENTA; Data: 2018-01-07;\n" +
                        "Dostupny Ostatok: 78667.73\n" +
                        "RUR. Raiffeisenbank\n",
                "expense",
                "0853",
                "734",
                "RUS/VORONEZH/LENTA"
        );
        checkBankSms(
                "Karta *0853;\n" +
                        "Pokupka:1488.5 RUR; RUS/VORONEZH/AUCHAN VORONEZH GRAD; Data: 2018-01-08;\n" +
                        "Dostupny Ostatok: 76223.23\n" +
                        "RUR. Raiffeisenbank",
                "expense",
                "0853",
                "1488.5",
                "RUS/VORONEZH/AUCHAN VORONEZH GRAD"
        );
        checkBankSms(
                "Karta *0853;\n" +
                        "Pokupka:1 RUR; RUS/VORONEZH/AUCHAN VORONEZH GRAD; Data: 2018-01-08;\n" +
                        "Dostupny Ostatok: 76223.23\n" +
                        "RUR. Raiffeisenbank",
                "expense",
                "0853",
                "1",
                "RUS/VORONEZH/AUCHAN VORONEZH GRAD"
        );
        checkBankSms(
                "Zachislena zarplata 8869.18 RUR na schet *4849. Balans 55122.34 RUR. Raiffeisenbank",
                "zachislenie",
                "schet *4849",
                "8869.18",
                ""
        );
        checkBankSms(
                "Karta *0853; Snyatie nalichnih: 8869.18 RUR; RUS/VORONEZH/GAZPROMBANK; Data: 2018-01-10; Dostupny Ostatok: 69636.73 RUR. Raiffeisenbank",
                "cash_atm",
                "0853",
                "8869.18",
                ""
        );
        checkBankSms(
                "Zachislenie summy 52978.4 RUR s deposita na schet *0123. Balans 0 RUR. Raiffeisenbank",
                "zachislenie",
                "schet *0123",
                "52978.4",
                ""
        );
        checkBankSms(
                "Karta *1118; Provedena tranzakcija: 3596 RUB; Data: 31/12/2017; OODJI Dostupny Ostatok: 135449.62 RUB. Raiffeisenbank",
                "expense",
                "1118",
                "3596",
                "OODJI"
        );
        checkBankSms(
                "Karta *1118; Provedena tranzakcija: 225 RUB; Data: 04/01/2018; Moy Magazin+ Dostupny Ostatok: 129797.04 RUB. Raiffeisenbank",
                "expense",
                "1118",
                "225",
                "Moy Magazin+"
        );
        checkBankSms(
                "Karta *1118; Provedena tranzakcija: 2140.3 RUB; Data: 04/01/2018; DIKSI  - 77410 KKM1 Dostupny Ostatok: 128991.78 RUB. Raiffeisenbank",
                "expense",
                "1118",
                "2140.3",
                "DIKSI  - 77410 KKM1"
        );
        checkBankSms(
                "Karta *1118; Provedena tranzakcija: 1 RUB; Data: 04/01/2018; DIKSI  - 77410 KKM1 Dostupny Ostatok: 128991.78 RUB. Raiffeisenbank",
                "expense",
                "1118",
                "1",
                "DIKSI  - 77410 KKM1"
        );
        checkBankSms(
                "Karta *2665; Provedena operacija: 10605 RUR; RU/MOSCOW/RCONNECT C2C; Data: 2018-02-22; Dostupny Ostatok: 3485.56 RUR. Raiffeisenbank",
                "payment",
                "2665",
                "10605",
                ""
        );
        checkBankSms(
                "Balans vashey karty *4180 popolnilsya 2018-02-10 na 11700 RUR. Dostupny ostatok: 18476.28 RUR. Raiffeisenbank",
                "popolnenie",
                "4180",
                "11700",
                ""
        );
        checkBankSms(
                "Balans vashey karty *1399 popolnilsya 22/02/2018 na: 10605 RUB. Dostupny Ostatok: 11277.9 RUB. Raiffeisenbank",
                "popolnenie",
                "1399",
                "10605",
                ""
        );
        checkBankSms(
                "баланс вашей карты *0015 пополнился 2018-05-13 на 3000 RUR. доступный остаток: 11938.27 RUR. raiffeisenbank",
                "popolnenie",
                "0015",
                "3000",
                ""
        );
        checkBankSms(
                "карта *6497; проведена транзакция: 310 RUB; дата: 30/04/2018; PIVNAYA 1 доступный остаток: 2886.77 RUB. raiffeisenbank",
                "expense",
                "6497",
                "310",
                "PIVNAYA 1"
        );
        checkBankSms(
                "Zachislen perevod 25000 RUR na schet *5842. Balans 32605.51 RUR. Raiffeisenbank",
                "zachislenie",
                "schet *5842",
                "25000",
                ""
        );
        checkBankSms(
                "Spisan perevod 13000 RUR so scheta *9362. Balans 14469.82 RUR. Raiffeisenbank",
                "perevod",
                "scheta *9362",
                "13000",
                ""
        );
        checkBankSms(
                "Karta *8104. Pokupka 20 RUR. ARPS.PRO. Balans 48885.88 RUR. 2018-10-09",
                "expense",
                "8104",
                "20",
                "ARPS.PRO"
        );
        checkBankSms(
                "Schet *6470. Zachislena zarplata 56885.05 RUR. Balans 105065.03 RUR.",
                "zachislenie",
                "Schet *6470",
                "56885.05",
                ""
        );
        checkBankSms(
                "Карта *9622. Покупка 1370.07 RUR. VKUSVILL 875_2. Balans 13975.15 RUR. 2019-02-05",
                "expense",
                "9622",
                "1370.07",
                "VKUSVILL 875_2"
        );
        checkBankSms(
                "Schet *9561. Zachislen perevod 400.00 RUB.",
                "zachislenie",
                "Schet *9561",
                "400",
                ""
        );
        checkBankSms(
                "Schet *7015. Spisan platezh po kreditu 6630.07 RUR. Balans 126.97 RUR.",
                "payment",
                "Schet *7015",
                "6630.07",
                ""
        );
        // Ukraine
        checkBankSms(
                "Vasha operatsija: 23.03.2019 16:27:58 VISA Gold/3306 98.00 UAH McDonald's 077 dostupna suma",
                "expense",
                "VISA Gold/3306",
                "98",
                ""
        );
        checkBankSms(
                "05.04.2019 na rakhunok 1120814700(UAH) zarakhovano 13845.30 UAH",
                "popolnenie",
                "1120814700",
                "13845.30",
                ""
        );
        checkBankSms(
                "Vasha operatsija: 04.03.2019 08:58:23 Visa Gold/1792 66.56 UAH Silpo dostupna suma 2706.77 UAH",
                "expense",
                "Visa Gold/1792",
                "66.56",
                ""
        );
        checkBankSms(
                "Vasha operatsija: 03.02.2019 11:21:40 Mastercard Instant/5619 146.30 UAH SHOP ATB PR199 dostupna suma 9709.70 UAH",
                "expense",
                "Mastercard Instant/5619",
                "146.30",
                ""
        );
        checkBankSms(
                "Karta *1427. Snyatie nalichnyh 1000.00 RUB. RU/ANAPA/RBA ATM 27811. Balans 1055.41 RUB. 05.06.2019",
                "cash_atm",
                "1427",
                "1000",
                ""
        );

    }
}
