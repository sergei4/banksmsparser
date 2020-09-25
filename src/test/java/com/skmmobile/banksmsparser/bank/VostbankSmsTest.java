package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.SmsParserFactory;

public class VostbankSmsTest extends AbsXmlBankSmsTest {

    public VostbankSmsTest(SmsParserFactory smsParserFactory) {
        super("vostbank", smsParserFactory);
    }

    @Override
    protected void smsTest() {
//        checkBankSms(
//                "Karta *7814. Ezhegodnaya komissiya za obsluzhivanie scheta karty -200.00 RUR. Dostupno -227,86RUR",
//                "payment",
//                "7814",
//                "200",
//                ""
//        );
    }
}
