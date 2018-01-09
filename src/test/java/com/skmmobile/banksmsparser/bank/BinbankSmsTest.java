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
                BankSmsParser.CATEGORY_EXPENSE,
                "8512",
                "1870",
                "KAZAN MYASNAYA KULINARIYA ITLE"
        );
    }
}
