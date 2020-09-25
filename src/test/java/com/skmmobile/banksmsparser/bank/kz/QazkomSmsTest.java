package com.skmmobile.banksmsparser.bank.kz;

import com.skmmobile.banksmsparser.SmsParserFactory;
import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

public class QazkomSmsTest extends AbsXmlBankSmsTest {

    public QazkomSmsTest(SmsParserFactory smsParserFactory) {
        super("qazkom", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "2017-12-31 12:27:59 Operaciya po karte Retail 1669.00 KZT YUBILEINYI SUPERMARKET 4**493 Dostupnaya summa:78649.63 KZT",
                "expense",
                "4**493",
                "1669.00",
                ""
        );
        checkBankSms(
                "2017-12-31 13:49:59 Operaciya po karte Retail 4030.12 KZT MON AMIE SHOP 4**493 Dostupnaya summa:74619.63 KZT",
                "expense",
                "4**493",
                "4030.12",
                ""
        );
        checkBankSms(
                "2018-01-05 15:02:45 Popolnenie 59535.01 KZT K**928 Dostupnaya summa:132446.63 KZT",
                "popolnenie",
                "K**928",
                "59535.01",
                ""
        );
        checkBankSms(
                "2018-01-17 19:41:22 Operaciya po karte ATM 5000.00 KZT ATM 1270 SM 5 MINUT 4**446 Dostupnaya summa:37391.93 KZT",
                "cash_atm",
                "4**446",
                "5000.00",
                ""
        );
        checkBankSms(
                "2018-03-10 06:57:54 Card SMS Charge -200.00 KZT 4**446 Dostupnaya summa:184900.13 KZT",
                "payment",
                "4**446",
                "200",
                ""
        );
        checkBankSms(
                "2018-02-03 14:11:14 Operaciya po karte CH Debit 495.00 KZT P2P HOMEBANK 3D INNER 4**576 Dostupnaya summa:210808.86 KZT",
                "unknown",
                "4**576",
                "495",
                ""
        );
        checkBankSms(
                "2018-02-20 11:44:45 Operaciya po karte CH Payment 4000.00 KZT P2P HB TO OWN CARD 4**576 Dostupnaya summa:7595.85 KZT",
                "unknown",
                "4**576",
                "4000",
                ""
        );
        checkBankSms(
                "2018-02-26 12:23:59 Provedena operaciya Note Acceptance 5000.00 KZT ATM 2398 DOM SVYAZI 3**031 Dostupnaya summa:687938.00 KZT",
                "unknown",
                "3**031",
                "5000",
                ""
        );
        checkBankSms(
                "2018-02-26 06:48:44 Client SMS Charge -300.00 KZT 4**073 Dostupnaya summa:164467.23 KZT",
                "payment",
                "4**073",
                "300",
                ""
        );
        checkBankSms(
                "2018-03-21 19:36:47  Operaciya po kartochke 4**9744 na summu -1995.00KZT. Ostatok : 68994.31. Opisanie: TOO INTERTUR ASTANA",
                "payment",
                "4**9744",
                "1995.00",
                ""
        );
        checkBankSms(
                "2018-06-05 10:52:00  Operaciya po kartochke K**8911 na summu +83371.00KZT. Ostatok : 83371.00. Opisanie: NAO Gosudarstvennaya korporaciya \"Pravitel'stvo dlya gr",
                "popolnenie",
                "K**8911",
                "83371.00",
                ""
        );
        checkBankSms(
                "2018-04-09 07:35:08  Operaciya po kartochke 5**7383 na summu -300.00KZT. Ostatok : 6179.93. Opisanie: Client SMS Charge",
                "payment",
                "5**7383",
                "300",
                ""
        );
    }
}
