package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import org.w3c.dom.Document;

public class RaiffeisenSmsTest extends AbsXmlBankSmsTest {

    public RaiffeisenSmsTest(Document xmlDocument) {
        super("raiffeisen", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Karta *5884;\n" +
                        "Pokupka:780 RUR; RUS/MOSCOW/KINOMAX; Data: 2018-01-02;\n" +
                        "Dostupny Ostatok: 44452.19\n" +
                        "RUR. Raiffeisenbank",
                BankSmsParser.CATEGORY_EXPENSE,
                "5884",
                "780",
                "RUS/MOSCOW/KINOMAX"
        );
        checkBankSms(
                parser,
                "Karta *5884;\n" +
                        "Pokupka:324.74 RUR; RUS/KRASNOYARSK/VKUSOMANIYA; Data: 2018-01-05;\n" +
                        "Dostupny Ostatok: 35233.45\n" +
                        "RUR. Raiffeisenbank",
                BankSmsParser.CATEGORY_EXPENSE,
                "5884",
                "324.74",
                "RUS/KRASNOYARSK/VKUSOMANIYA"
        );
        checkBankSms(
                parser,
                "Karta *5884;\n" +
                        "Pokupka:1894 RUR; RUS/KRASNOYARSK/PEOPLES; Data: 2018-01-04;\n" +
                        "Dostupny Ostatok: 35558.19\n" +
                        "RUR. Raiffeisenbank",
                BankSmsParser.CATEGORY_EXPENSE,
                "5884",
                "1894",
                "RUS/KRASNOYARSK/PEOPLES"
        );
    }
}
