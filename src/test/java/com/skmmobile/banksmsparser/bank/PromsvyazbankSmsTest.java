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
                parser,
                "Karta *2006: Perevod s karty na kartu - spisanie 10 000.00 RUR; 16/01, 11:14;PSBANK.RU;CARD2CARD PSB MOBILE.Dostupno 4 595.50 RUR.",
                "perevod",
                "2006",
                "10000",
                ""
        );
        checkBankSms(
                parser,
                "Kontrakt *3338: Zachislenie 34 500.00 RUR;2018-01-19.Dostupno 35 041.50 RUR.",
                "zachislenie",
                "Kontrakt *3338",
                "34500",
                ""
        );
        checkBankSms(
                parser,
                "Kontrakt *3338: Zachislenie 34 500.00 RUR;2018-01-19.Dostupno 35 041.50 RUR.",
                "zachislenie",
                "Kontrakt *3338",
                "34500",
                ""
        );
        checkBankSms(
                parser,
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
    }
}
