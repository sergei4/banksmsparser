package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;
import org.w3c.dom.Document;

public class MinbankSmsTest extends AbsXmlBankSmsTest {

    public MinbankSmsTest(Document xmlDocument) {
        super("minbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Platezh cherez Telebank v Gazprom Mezhregiongaz Tula. Gazosnabzhenie Data: 07/08 10:59 Id.klienta: ****0967 Summa: 260.89RUB Komissija: 0.00RUB Dostupno: 1789.46RUB Terminal: Mbank_01",
                "payment",
                "0967",
                "260.89",
                ""
        );
        checkBankSms(
                parser,
                "Platej cherez Telebank v MTS\n" +
                        "Data: 17/01 10:58\n" +
                        "Id.klienta: ****1889\n" +
                        "Summa: 130.49RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 0.00RUB\n" +
                        "Terminal: Mbank_01",
                "payment",
                "1889",
                "130.49",
                ""
        );
        checkBankSms(
                parser,
                "Platej cherez Telebank v Vladimirskaya gorodskaya set\n" +
                        "Data: 10/01 11:16\n" +
                        "Id.klienta: ****9200\n" +
                        "Summa: 400.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 932.53RUB\n" +
                        "Terminal: TBank_v2",
                "payment",
                "9200",
                "400",
                ""
        );
        checkBankSms(
                parser,
                "Poluchenie nalichnyh cherez bankomat\n" +
                        "Data: 02/01 11:51\n" +
                        "Karta: ****3504\n" +
                        "Summa: 4900.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 421.64RUB\n" +
                        "Terminal: A3410004,MINB,Gorkogo str. d.27a,Gorohivec,RU",
                "popolnenie",
                "3504",
                "4900.00",
                ""
        );
        checkBankSms(
                parser,
                "Postuplenie na kartu\n" +
                        "Data: 30/12 09:20\n" +
                        "Karta: ****3504\n" +
                        "Summa: 5000.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 5321.64RUB\n" +
                        "Terminal: 20000016,TRANSFER,MOSCOW,RU",
                "popolnenie",
                "3504",
                "5000.00",
                ""
        );
        checkBankSms(
                parser,
                "Pokupka tovara/uslugi\n" +
                        "Data: 10/01 15:58\n" +
                        "Karta: ****3504\n" +
                        "Summa: 1.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 420.64RUB\n" +
                        "Terminal: 99990669,KINO1TV.RU,S-PETERBURG,RU",
                "expense",
                "3504",
                "1.00",
                ""
        );
        checkBankSms(
                parser,
                "Perevod cherez POS-terminal na kartu\n" +
                        "Data: 17/01 21:50\n" +
                        "Karta: ****3504\n" +
                        "Summa: 26500.00RUB\n" +
                        "Komissiia: 0.00RUB\n" +
                        "Dostupno: 8800.66RUB\n" +
                        "Terminal: 10000001,TINKOFF BANK CARD2CARD,MOSCOW,RU",
                "popolnenie",
                "3504",
                "26500",
                ""
        );
    }
}
