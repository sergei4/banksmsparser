package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.SmsParserFactory;

public class BinbankSmsTest extends AbsXmlBankSmsTest {

    public BinbankSmsTest(SmsParserFactory smsParserFactory) {
        super("binbank", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Покупка по карте: *8512 1870.00 RUR Место KAZAN MYASNAYA KULINARIYA ITLE 06.12.17 21:23 Баланс: 5488.68 RUR i.binbank.ru",
                "expense",
                "8512",
                "1870",
                "KAZAN MYASNAYA KULINARIYA ITLE"
        );
        checkBankSms(
                "Pokupka po karte: *7858 1.01 RUR Mesto MOSCOW YANDEX.MONEY 26.01.18 18:58 Balans: 648.17 RUR i.binbank.ru",
                "expense",
                "7858",
                "1.01",
                "MOSCOW YANDEX.MONEY"
        );
        checkBankSms(
                "Пополнение карты *8512: BINBANK CARD2CARD 2000.00 RUR 10.01.18 18:34. Баланс: 4105.68 RUR. i.binbank.ru",
                "popolnenie",
                "8512",
                "2000",
                ""
        );
        checkBankSms(
                "Popolnenie karty *2651: BINBANK CARD2CARD 30000.00 RUR 20.01.18 13:05. Balans: 33687.20 RUR. i.binbank.ru",
                "popolnenie",
                "2651",
                "30000",
                ""
        );
        checkBankSms(
                "Zachislenie na kartu *7628: 40000.00 RUR 24.01.18 22:44,  Perevod schet-karta. Balans:102429.83 RUR. i.binbank.ru",
                "zachislenie",
                "7628",
                "40000",
                ""
        );
        checkBankSms(
                "Perevod s karty *2651 na schet 5000.00 RUR 21.01.18 23:22. Balans: 7648.33 RUR. i.binbank.ru",
                "perevod",
                "2651",
                "5000",
                ""
        );
        checkBankSms(
                "Pokupka *7402; Uspeshno; Summa: 499.00 RUR; Balans: 3212.68 RUR; SALE.ACTION-PRESS; 28.08.2018 9:54",
                "expense",
                "7402",
                "499",
                ""
        );
        checkBankSms(
                "Postuplenie *8610; Uspeshno; Summa: 8000.00 RUR; Balans: 12906.92 RUR; Alfa Acq; 14.08.2018 10:31",
                "popolnenie",
                "8610",
                "8000",
                ""
        );
        checkBankSms(
                "Spisanie *8610; Uspeshno; Summa: 9000.00 RUR; Balans: 3906.92 RUR; BINBANK CARD2CARD; 14.08.2018 10:34",
                "unknown",
                "8610",
                "9000",
                ""
        );
        checkBankSms(
                "Karta VISA *3872 popolnena na 3126,08 RUR. Dostupno vsego 13222,20 RUR. BINBANK Telefon 8 800 200 50 75",
                "popolnenie",
                "VISA *3872",
                "3126.08",
                ""
        );
        checkBankSms(
                "Karta MC *1304 popolnena na 3488,00 RUR. Dostupno vsego 8822,00 RUR. AO BINBANK Digital Telefon 8 800 200 50 75",
                "popolnenie",
                "MC *1304",
                "3488",
                ""
        );
    }
}
