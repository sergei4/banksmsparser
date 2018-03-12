package com.skmmobile.banksmsparser.bank.uk;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;
import org.w3c.dom.Document;

public class RaiffeisenUkSmsTest extends AbsXmlBankSmsTest {

    public RaiffeisenUkSmsTest(Document xmlDocument) {
        super("raiffeisen_uk", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Vasha operatsija: 28.02.2018 17:56:44 VISA Gold/6155 131.00 UAH McDonald's 041 dostupna suma 7031.24 UAH",
                "unknown",
                "VISA Gold/6155",
                "131",
                ""
        );
        checkBankSms(
                parser,
                "28.02.2018 na Vash rakhunok kartkovyi 1219648400(UAH) bulo zarakhovano sumu 7090.26 UAH",
                "popolnenie",
                "1219648400",
                "7090.26",
                ""
        );
    }
}
