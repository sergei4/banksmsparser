package com.skmmobile.banksmsparser.bank.kz;

import com.skmmobile.banksmsparser.SmsParserFactory;
import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;

public class HalykbankSmsTest extends AbsXmlBankSmsTest {

    public HalykbankSmsTest(SmsParserFactory smsParserFactory) {
        super("halykbank", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "1192 Shotty tolyktyru/Popolnenie scheta. 14466.00 KZT; 16044000716101 NAO Gosudarstvennaa korporacia \"Pravitel'stvo dla grajdan\"; 04.12.2017 00:00. Kartadaghy kolzhetimdi soma/Dostupnaya summa po karte: 28609.66 KZT",
                "popolnenie",
                "1192",
                "14466.00",
                ""
        );
        checkBankSms(
                "VISA7074 Satyp alu/Pokupka. 1893.00 KZT; SHOP MAGNUM; 01.06.2018 17:58. Kartadaghy kolzhetimdi soma/Dostupnaya summa po karte: 5943.79 KZT; bonus:302.88",
                "expense",
                "VISA7074",
                "1893.00",
                ""
        );
        checkBankSms(
                "VISA7074 Esepten shygaru/Spisanie. 60095.00 KZT; Perevod na druguyu kartu; 05.06.2018 18:28. Kartadaghy kolzhetimdi soma/Dostupnaya summa po karte: 739143.32 KZT",
                "payment",
                "VISA7074",
                "60095",
                ""
        );
        checkBankSms(
                "VISA7074 Kolma-kol aksha beru/Vydacha nalichnyh. 30000.00 KZT; ATM 300 TRTS MAXIMA; 05.06.2018 17:44. Kartadaghy kolzhetimdi soma/Dostupnaya summa po karte: 799238.32 KZT",
                "cash_atm",
                "VISA7074",
                "30000",
                ""
        );
        checkBankSms(
                "VISA6681 Esepke alu/Zachislenie. 13950.00 KZT; Popolnenie kartochnogo scheta cherez platezhnyi terminal; 15.05.2018 10:34. Kartadaghy kolzhetimdi soma/Dostupnaya summa po karte: 25853.06",
                "zachislenie",
                "VISA6681",
                "13950",
                ""
        );
        checkBankSms(
                "ECMC0399 Kolma-kol aksha beru/Vydacha nalichnyh. 13000.00 KZT; ATM 670 MAGAZIN AGROMAX; 04.03.2018 12:57. Kartadaghy kolzhetimdi soma/Dostupnaya summa po karte: 686.00 KZT\n",
                "cash_atm",
                "ECMC0399",
                "13000",
                ""
        );
        checkBankSms(
                "VISA4866 Audarym zhoneltildi/otpravlen perevod. 100000.00 KZT; Postupleniye perevoda; 02.05.2018 10:39. Kartadaghy kolzhetimdi soma/Dostupnaya summa po karte: 98383.94 KZT",
                "perevod",
                "VISA4866",
                "100000",
                ""
        );
        checkBankSms(
                "2018-08-03 13:37:02 Operaciya po karte Retail 8888.00 KZT TOO DETSKIY MIR KZ 4**934 Dostupnaya summa:141885.93 KZT",
                "expense",
                "4**934",
                "8888",
                ""
        );
        checkBankSms(
                "2018-07-24 01:24:28  Operaciya po kartochke 5**9835 na summu -300.00KZT. Ostatok : 11712.35. Opisanie: Client SMS Charge",
                "payment",
                "5**9835",
                "300",
                ""
        );
        checkBankSms(
                "2018-11-15 23:05:04 Pokupka 10945.00 KZT PINTA BAR&GRILL MEGA 377514**8930 Ostatok 358448.28 Go! bonus 682.11",
                "expense",
                "377514**8930",
                "10945.00",
                ""
        );
        checkBankSms(
                "2018-11-14 17:41:07 Snyatie nalichnyh 10000.00 KZT ATM 1777 ALMATY KCELL 377514**8930 Ostatok 385483.28 KZT Go! bonus 682.11\n",
                "cash_atm",
                "377514**8930",
                "10000",
                ""
        );
        checkBankSms(
                "2018-11-09 00:00:00 Popolnenie 286328.00 KZT K**041 Dostupnaya summa:287709.56 KZT",
                "popolnenie",
                "K**041",
                "286328",
                ""
        );
        checkBankSms(
                "2018-11-12 22:41:04 Operaciya po karte CH Debit 23095.00 KZT P2P HB3 INNER 3D 4**744 Dostupnaya summa:164664.56 KZT",
                "popolnenie",
                "4**744",
                "23095",
                ""
        );
        checkBankSms(
                "2018-10-19 13:10:27 Operaciya po karte Pokupka 126.24 GEL ROMPETROL (KAKHETI HIGHW 410799**9398 Dostupnaya summa: 389595.42\n",
                "expense",
                "410799**9398",
                "126.24",
                ""
        );
        checkBankSms(
                "2018-10-03 16:00:06 Operaciya po karte Perevod na kartu 1600.00 KZT P2P HB TO OWN CARD 440563**0769 Dostupnaya summa: 514195.46 KZT",
                "perevod",
                "440563**0769",
                "1600",
                ""
        );
        checkBankSms(
                "2018-10-25 19:38:51 Operaciya po karte Pokupka 6850.00 KZT LA TARTIN LLP 410799**9398 Dostupnaya summa: 379032.45",
                "expense",
                "410799**9398",
                "6850",
                ""
        );
        checkBankSms(
                "2018-09-12 13:14:44 Operaciya po karte Snyatie nalichnyh 15000.00 KZT ATM 487 TTS RIO 400303**7816 Dostupnaya summa: 66791.00 KZT",
                "cash_atm",
                "400303**7816",
                "15000",
                ""
        );
        checkBankSms(
                "2018-10-28 07:57:40 Snyatie nalichnyh 1000.00 KZT ATM 1025 ASAR SHOP 410799**9398 Ostakok 340209.45 KZT",
                "cash_atm",
                "410799**9398",
                "1000",
                ""
        );
        checkBankSms(
                "2018-10-05 15:01:06 Operaciya po karte CH Payment 20000.00 KZT P2P HB TO OWN CARD 5**516 Dostupnaya summa:22848.36 KZT",
                "payment",
                "5**516",
                "20000",
                ""
        );
        checkBankSms(
                "2018-10-08 10:23:18 Operaciya po karte ATM 10000.00 KZT ATM 871 AYAN PASSAZH 5**569 Dostupnaya summa:4562.74 KZT",
                "cash_atm",
                "5**569",
                "10000",
                ""
        );
        checkBankSms(
                "2019-02-28 16:14:03 Operaciya po karte Платеж на Deposit HB 10000.00 KZT платеж на депозит HB K**274 Dostupnaya summa:12218.75 KZT",
                "payment",
                "K**274",
                "10000.00",
                ""
        );
        checkBankSms(
                "00:00 Popolnenie 172754.00 KZT *2327 Ostatok 173641.59",
                "popolnenie",
                "*2327",
                "172754",
                ""
        );
        checkBankSms(
                "16:54 Пополнение в терминале: 1000.00KZT, карта *7046. Доступно 1031.00KZT",
                "popolnenie",
                "*7046",
                "1000",
                ""
        );
    }
}
