package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import org.w3c.dom.Document;

public class BinbankSmsTest extends AbsXmlBankSmsTest {

    public BinbankSmsTest(Document xmlDocument) {
        super("binbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Покупка по карте: *8512 1870.00 RUR Место KAZAN MYASNAYA KULINARIYA ITLE 06.12.17 21:23 Баланс: 5488.68 RUR i.binbank.ru",
                "expense",
                "8512",
                "1870",
                "KAZAN MYASNAYA KULINARIYA ITLE"
        );
        checkBankSms(
                parser,
                "Pokupka po karte: *7858 1.01 RUR Mesto MOSCOW YANDEX.MONEY 26.01.18 18:58 Balans: 648.17 RUR i.binbank.ru",
                "expense",
                "7858",
                "1.01",
                "MOSCOW YANDEX.MONEY"
        );
        checkBankSms(
                parser,
                "Пополнение карты *8512: BINBANK CARD2CARD 2000.00 RUR 10.01.18 18:34. Баланс: 4105.68 RUR. i.binbank.ru",
                "popolnenie",
                "8512",
                "2000",
                ""
        );
        checkBankSms(
                parser,
                "Popolnenie karty *2651: BINBANK CARD2CARD 30000.00 RUR 20.01.18 13:05. Balans: 33687.20 RUR. i.binbank.ru",
                "popolnenie",
                "2651",
                "30000",
                ""
        );
        checkBankSms(
                parser,
                "Zachislenie na kartu *7628: 40000.00 RUR 24.01.18 22:44,  Perevod schet-karta. Balans:102429.83 RUR. i.binbank.ru",
                "zachislenie",
                "7628",
                "40000",
                ""
        );
        checkBankSms(
                parser,
                "Perevod s karty *2651 na schet 5000.00 RUR 21.01.18 23:22. Balans: 7648.33 RUR. i.binbank.ru",
                "perevod",
                "2651",
                "5000",
                ""
        );
    }
}
