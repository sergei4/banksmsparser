package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

import org.w3c.dom.Document;

public class BelbankSmsTest extends AbsXmlBankSmsTest {

    public BelbankSmsTest(Document xmlDocument) {
        super("belbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "ZACHISLENIE: 254.56 BYN KARTA #8686 DATA 01.02.2018 14:36:10",
                "zachislenie",
                "8686",
                "254.56",
                ""
        );
        checkBankSms(
                parser,
                "CREDIT: 1.00 BYN KARTA #8586 DATA 29.01.2018 18:42:43 BR.312 CASH IN>ZHLOBIN>BY OSTATOK 673.80 BYN",
                "payment",
                "8586",
                "1.00",
                ""
        );
        checkBankSms(
                parser,
                "OPLATA: 4.41 BYN KARTA #8686 DATA 05.02.2018 15:53:52 PT MAGAZIN N20 OAO KOMPANON>ZHLOBIN>BY OSTATOK 5.59 BYN",
                "expense",
                "8686",
                "4.41",
                ""
        );
        checkBankSms(
                parser,
                "POPOLNENIE SCHETA: 5.00 BYN KARTA #8586 DATA 06.02.2018 13:11:56 BR.312 CASH IN>ZHLOBIN>BY OSTATOK 772.70 BYN",
                "popolnenie",
                "8586",
                "5",
                ""
        );
        checkBankSms(
                "NALICHNYE: 5.00 BYN KARTA #8586 DATA 09.03.2018 15:09:45 BR.312/42 ATM>ZHLOBIN>BY OSTATOK 224.77 BYN",
                "cash_atm",
                "8586",
                "5",
                ""
        );
    }
}
