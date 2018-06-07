package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class PromsvyazbankSmsTest extends AbsXmlBankSmsTest {

    public PromsvyazbankSmsTest(Document xmlDocument) {
        super("promsvyazbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Karta *2006: Pokupka 329.00 RUR; 16/01, 17:44;MOSCOW;PODRUZHKA.Dostupno 541.50 RUR.",
                "expense",
                "2006",
                "329",
                ""
        );
        checkBankSms(
                "Karta *2006: Perevod s karty na kartu - spisanie 10 000.00 RUR; 16/01, 11:14;PSBANK.RU;CARD2CARD PSB MOBILE.Dostupno 4 595.50 RUR.",
                "perevod",
                "2006",
                "10000",
                ""
        );
        checkBankSms(
                "Karta *2006: Perevod s karty na kartu - spisanie 10 000,00 RUR; 16/01, 11:14;PSBANK.RU;CARD2CARD PSB MOBILE.Dostupno 4 595.50 RUR.",
                "perevod",
                "2006",
                "10000",
                ""
        );
        checkBankSms(
                "Kontrakt *3338: Zachislenie 34 500.00 RUR;2018-01-19.Dostupno 35 041.50 RUR.",
                "zachislenie",
                "Kontrakt *3338",
                "34500",
                ""
        );
        checkBankSms(
                "Karta *8139: Snyatie nalichnyh v bankomate 4 700.00 RUR; 11/01, 19:09;SAMARA;ATM 10150168 304A KIRO.Dostupno 42.78 RUR.",
                "cash_atm",
                "8139",
                "4700",
                ""
        );
        checkBankSms(
                "Karta *5131: Pokupka 5 471,00 RUR; 10/04, 20:29;Balashikha;FERMACH.Dostupno 5 199,35 RUR (v t.ch. kredit 5 199,35 RUR).",
                "expense",
                "5131",
                "5471",
                ""
        );
        checkBankSms(
                "Karta *2006: Pokupka 1 298.12 RUR; 22/02, 19:05;MOSCOW;TVOE.Dostupno 78 897.16 RUR.",
                "expense",
                "2006",
                "1298.12",
                ""
        );
        checkBankSms(
                "Karta *5131: Vnesenie sredstv 2 793.97 RUR; 03/05, 13:47;MOSCOW;PSB-RETAIL 00777781.Dostupno 15 994,59 RUR (v t.ch. kredit 15 000,00 RUR).",
                "popolnenie",
                "5131",
                "2793.97",
                ""
        );
        checkBankSms(
                "Karta *5131: Vnesenie sredstv 2 793,97 RUR; 03/05, 13:47;MOSCOW;PSB-RETAIL 00777781.Dostupno 15 994,59 RUR (v t.ch. kredit 15 000,00 RUR).",
                "popolnenie",
                "5131",
                "2793.97",
                ""
        );
        checkBankSms(
                "Kontrakt *5340: Zachislenie 86 358,53 RUR;2018-04-28.Dostupno 101 648,53 RUR  (v t.ch. kredit 15 000,00 RUR).",
                "zachislenie",
                "Kontrakt *5340",
                "86358.53",
                ""
        );
        checkBankSms(
                "Karta *8139: Snyatie nalichnyh v bankomate 4 700.00 RUR; 11/01, 19:09;SAMARA;ATM 10150168 304A KIRO.Dostupno 42.78 RUR.",
                "cash_atm",
                "8139",
                "4700",
                ""
        );
        checkBankSms(
                "Karta *2213: Snyatie nalichnyh v bankomate 200 000,00 RUR; 18/04, 19:14;MOSCOW;Alfa Iss 98 DMITROVSKO.Dostupno 88 529,99 RUR.",
                "cash_atm",
                "2213",
                "200000",
                ""
        );
        checkBankSms(
                "Karta *5131: Beznalichnoe spisanie 68 000.00 RUR; 28/04, 15:29;MOSCOW;00887750.Dostupno 33 427,53 RUR (v t.ch. kredit 15 000,00 RUR).",
                "unknown",
                "5131",
                "68000",
                ""
        );
        checkBankSms(
                "Karta *5131: Beznalichnoe spisanie 68 000,00 RUR; 28/04, 15:29;MOSCOW;00887750.Dostupno 33 427,53 RUR (v t.ch. kredit 15 000,00 RUR).",
                "unknown",
                "5131",
                "68000",
                ""
        );
    }
}
