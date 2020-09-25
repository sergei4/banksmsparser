package com.skmmobile.banksmsparser.bank.uk;

import com.skmmobile.banksmsparser.SmsParserFactory;
import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

public class UkrsibbankSmsTest extends AbsXmlBankSmsTest {

    public UkrsibbankSmsTest(SmsParserFactory smsParserFactory) {
        super("ukrsibbank", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Oplata: 21600487 NOVA LINIYA, UA 19.02.2018 14:22. Kartka 5169***6047. Suma 240.00UAH. Dostupno 1544.64UAH",
                "expense",
                "5169***6047",
                "240.00",
                ""
        );
        checkBankSms(
                "Perekaz: MONO011  MONODirect, UA 24.01.2018 17:57 z kartky 5169***4474 na sumu 200.00UAH. Dostupno 710.00UAH. ",
                "perevod",
                "5169***4474",
                "200",
                ""
        );
        checkBankSms(
                "Perekaz: 24001010 WEBBANKING, UA 16.02.2018 18:33 na kartku 5169***4533 na sumu 8000.00UAH. Dostupno 14026.06UAH. ",
                "perevod",
                "5169***4533",
                "8000",
                ""
        );
        checkBankSms(
                "Otrymannia gotivky: A0308682 UKRSIBBANK, UA 24.01.2018 19:13. Kartka 5169***4474. Suma 400.00UAH. Dostupno 310.00UAH",
                "unknown",
                "5169***4474",
                "400",
                ""
        );
        checkBankSms(
                "Popovnennya rakhunku: 22.02.2018 14:15:26, rakhunok 26256003660397 na sumu 2,750.28UAH. Dostupniy zalyshok 2750.28UAH.",
                "popolnenie",
                "26256003660397",
                "2750.28",
                ""
        );
        checkBankSms(
                "Popovnennia rakhunku: A0309359 UKRSIBBANK, UA 09.02.2018 19:12. Kartka 5169***0937. Suma 7200.00UAH. Dostupno 7375.69UAH",
                "popolnenie",
                "5169***0937",
                "7200",
                ""
        );
    }
}
