package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class MKBSmsTest extends AbsXmlBankSmsTest {

    public MKBSmsTest(Document xmlDocument) {
        super("mkb", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "MKB: 16.01.2018 11:58 5*3758 POKUPKA: 1 120.00 RUB BPMAZK BP MC316. Balance: 235 161.15 RUB. Blokirovka kart - SMS \"All\" na +79037672667",
                "expense",
                "5*3758",
                "1120.00",
                ""
        );
        checkBankSms(
                parser,
                "MKB: 11.01.2018 03:37 5*3758 SPISANIE: 3 895.95 RUB MCBA. Balance: 240 359.15. Blokirovka kart - SMS \"All\" na +79037672667",
                "payment",
                "5*3758",
                "3895.95",
                ""
        );
        checkBankSms(
                parser,
                "MKB: 10.01.2018 18:20 5*3758 POPOLNENIE: 10 000.00 RUB TRM 11821. Balance: 244 255.10 RUB. Blokirovka kart - SMS \"All\" na +79037672667",
                "popolnenie",
                "5*3758",
                "10000.00",
                ""
        );
        checkBankSms(
                parser,
                "MKB: 13.02.2018 16:20 4*2800 NALICHNIE: 50 000.00 RUB ATM 983 MKB 810. Balance: 13 616.24 RUB. Blokirovka kart - SMS \"All\" na +79037672667\n",
                "cash_atm",
                "4*2800",
                "50000",
                ""
        );
        checkBankSms(
                parser,
                "MKB Online: Sovershen platezh na summu 500 RUR Blokirovanie dostupa v sistemu SMS \"Online\" na nomer +79037672667.",
                "payment",
                "mkb",
                "500",
                ""
        );
        checkBankSms(
                parser,
                "Oplata sms-informirovaniya po karte *0895 60 RUR.",
                "payment",
                "0895",
                "60",
                ""
        );
    }
}
