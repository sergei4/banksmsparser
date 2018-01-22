package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class OtkritieSmsTest extends AbsXmlBankSmsTest {

    public OtkritieSmsTest(Document xmlDocument) {
        super("otkritie", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Вы заплатили 94.97 р. в UNIVERSAM картой *0988. Доступно 13 080.74 р.",
                "expense",
                "0988",
                "94.97",
                ""
        );
        checkBankSms(
                parser,
                "Вы заплатили 1 964.39 р. в GAZPROMNEFT AZS 143 картой *0988. Доступно 14 902.21 р.",
                "expense",
                "0988",
                "1964.39",
                ""
        );
        checkBankSms(
                parser,
                "Вы сняли 10 000 р. в банкомате CENTRAL OFFICE с карты *0988. Доступно 16 866.6 р.",
                "cash_atm",
                "0988",
                "10000",
                ""
        );
        checkBankSms(
                parser,
                "На карту *0988 зачислено 27 004.5 р. Доступно 27 004.5 р.",
                "popolnenie",
                "0988",
                "27004.5",
                ""
        );
        checkBankSms(
                parser,
                "На карту *0988 зачислено 27 004 р. Доступно 27 004.5 р.",
                "popolnenie",
                "0988",
                "27004",
                ""
        );
    }
}
