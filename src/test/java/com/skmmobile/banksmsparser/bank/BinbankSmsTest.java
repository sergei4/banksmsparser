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
                "Пополнение карты *8512: BINBANK CARD2CARD 2000.00 RUR 10.01.18 18:34. Баланс: 4105.68 RUR. i.binbank.ru",
                "popolnenie",
                "8512",
                "2000",
                ""
        );
    }
}
