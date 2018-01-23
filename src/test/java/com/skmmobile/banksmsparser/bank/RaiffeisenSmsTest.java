package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import org.w3c.dom.Document;

public class RaiffeisenSmsTest extends AbsXmlBankSmsTest {

    public RaiffeisenSmsTest(Document xmlDocument) {
        super("raiffeisen", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
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
                parser,
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
                parser,
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
                parser,
                "Zachislena zarplata 8869.18 RUR na schet *4849. Balans 55122.34 RUR. Raiffeisenbank",
                "zachislenie",
                "schet *4849",
                "8869.18",
                ""
        );
        checkBankSms(
                parser,
                "Karta *0853; Snyatie nalichnih: 8869.18 RUR; RUS/VORONEZH/GAZPROMBANK; Data: 2018-01-10; Dostupny Ostatok: 69636.73 RUR. Raiffeisenbank",
                "cash_atm",
                "0853",
                "8869.18",
                ""
        );
        checkBankSms(
                parser,
                "Zachislenie summy 52978.4 RUR s deposita na schet *0123. Balans 0 RUR. Raiffeisenbank",
                "zachislenie",
                "schet *0123",
                "52978.4",
                ""
        );
        checkBankSms(
                parser,
                "Karta *1118; Provedena tranzakcija: 3596 RUB; Data: 31/12/2017; OODJI Dostupny Ostatok: 135449.62 RUB. Raiffeisenbank",
                "expense",
                "1118",
                "3596",
                "OODJI"
        );
        checkBankSms(
                parser,
                "Karta *1118; Provedena tranzakcija: 225 RUB; Data: 04/01/2018; Moy Magazin+ Dostupny Ostatok: 129797.04 RUB. Raiffeisenbank",
                "expense",
                "1118",
                "225",
                "Moy Magazin+"
        );
        checkBankSms(
                parser,
                "Karta *1118; Provedena tranzakcija: 2140.3 RUB; Data: 04/01/2018; DIKSI  - 77410 KKM1 Dostupny Ostatok: 128991.78 RUB. Raiffeisenbank",
                "expense",
                "1118",
                "2140.3",
                "DIKSI  - 77410 KKM1"
        );
        checkBankSms(
                parser,
                "Karta *1118; Provedena tranzakcija: 1 RUB; Data: 04/01/2018; DIKSI  - 77410 KKM1 Dostupny Ostatok: 128991.78 RUB. Raiffeisenbank",
                "expense",
                "1118",
                "1",
                "DIKSI  - 77410 KKM1"
        );
    }
}
