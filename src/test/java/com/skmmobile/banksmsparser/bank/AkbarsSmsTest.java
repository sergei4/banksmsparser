package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.SmsParserFactory;

public class AkbarsSmsTest extends AbsXmlBankSmsTest {

    public AkbarsSmsTest(SmsParserFactory smsParserFactory) {
        super("akbars", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Karta *7814. Ezhegodnaya komissiya za obsluzhivanie scheta karty -200.00 RUR. Dostupno -227,86RUR",
                "payment",
                "7814",
                "200",
                ""
        );
        checkBankSms(
                "Karta *4692. Spisanie ezhemesyachnoj komissii za SMS Informirovanie -19.00 RUR.2018-03-07 21:17:04. Dostupno 65,68RUR",
                "payment",
                "4692",
                "19",
                ""
        );
        checkBankSms(
                "Karta *7521. Pokupka 4381.00RUR.MOSCOW, TINKOFF BANK CARD2CARD. Zarezervirovano 4381.00RUR. 2018-03-06 16:30:40. Dostupno 0.00RUR.",
                "expense",
                "7521",
                "4381",
                ""
        );
        checkBankSms(
                "Karta *4692. Vydacha v ATM 1600.00RUR.ZAINSK, ABB 37A NEFTYANIKOV PR.. Zarezervirovano 1600.00RUR. 2018-02-27 13:53:42. Dostupno 84.68RUR.",
                "cash_atm",
                "4692",
                "1600",
                ""
        );
        checkBankSms(
                "Popolnenie scheta kontrakta *5351. ZACHISLENIE SOGLASNO VEDOMOSTI. Summa popolneniya 6000,00RUR. Date 20.02.2018 00:00. Dostupno 6000,00RUR",
                "popolnenie",
                "5351",
                "6000",
                ""
        );
        checkBankSms(
                "Karta *3839. Popolnenie karty na summu 3500.00RUR. Perevod ot ДАВЫДОВА Р.Н. 2018-03-04 11:39:37. Dostupno 3547.83RUR.",
                "popolnenie",
                "3839",
                "3500",
                ""
        );
        checkBankSms(
                "Karta*0799. Pokupka 84.00RUR. Kazan, IP NESTYAGIN I V. 18.06.18 17:16. Ostatok 19094.52RUR.",
                "expense",
                "0799",
                "84",
                ""
        );
    }
}
