package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.SmsParserFactory;
import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

public class BelgazprombankSmsTest extends AbsXmlBankSmsTest {

    public BelgazprombankSmsTest(SmsParserFactory smsParserFactory) {
        super("belgazprombank", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Card7357; Oplata: 1 000,07 BYN; 15.04.18 19:02:41; SHOP \"SANTA-76\" BAPB,ZHLOBIN,BLR; Dostupno: 639,36 BYN",
                "expense",
                "Card7357",
                "1000.07",
                ""
        );
        checkBankSms(
                "Card0428; Popolnenie scheta: 22,00 BYN; 13.04.18 12:04:07; BELGAZPROMBANK,MINSK,BLR; Dostupno: 979,57 BYN",
                "popolnenie",
                "Card0428",
                "22",
                ""
        );
        checkBankSms(
                "Card7566; Snyatie nalichnykh: 50,00 BYN; 08.03.20 11:04:06; ,GRODNO,BY; MCC: 6011; Dostupno: 226,76 BYN",
                "cash_atm",
                "Card7566",
                "50",
                ""
        );
    }
}
