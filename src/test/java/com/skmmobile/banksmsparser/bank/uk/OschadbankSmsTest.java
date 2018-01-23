package com.skmmobile.banksmsparser.bank.uk;

import com.skmmobile.banksmsparser.BankSmsParser;
import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;
import org.w3c.dom.Document;

public class OschadbankSmsTest extends AbsXmlBankSmsTest {

    public OschadbankSmsTest(Document xmlDocument) {
        super("oschadbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "04.01.18 19:38\n" +
                        "Card:5167-6111\n" +
                        "Sum:-5,526.49 UAH\n" +
                        "Dom_Moskovs_013\n" +
                        "Balance=5,526.49 UAH\n" +
                        "Detali",
                "unknown",
                "5167-6111",
                "5526.49",
                ""
        );
        checkBankSms(
                parser,
                "PO DEPOZYTU N 12345678 VYPLACHENO VIDSOTKI U SUMI 100.00 UAH. DOVIDKA 0800210800",
                "popolnenie",
                "12345678",
                "100",
                ""
        );
        checkBankSms(
                parser,
                "DEPOZYT N 12345678 POPOVNENO NA SUMU 5,000.12 UAH. DOVIDKA 0800210800",
                "popolnenie",
                "12345678",
                "5000.12",
                ""
        );
        checkBankSms(
                parser,
                "11.01.2018 \n" +
                        "Acnt:130-262545-56\n" +
                        "Sum:8,455.67 UAH \n" +
                        "Zarakhuvannia na rakhunok \n" +
                        "Balance=8,646.80 UAH\n" +
                        "Detali www.oschadbank.ua/ib",
                "popolnenie",
                "130-262545-56",
                "8455.67",
                ""
        );
        checkBankSms(
                parser,
                "Z DEPOZYTU N148713013 ZNYATO SUMU 8455.67 UAH. DOVIDKA 0800210800",
                "unknown",
                "148713013",
                "8455.67",
                ""
        );
    }
}
