package com.skmmobile.banksmsparser.bank.by;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;
import org.w3c.dom.Document;

public class MTBankSmsTest extends AbsXmlBankSmsTest {

    public MTBankSmsTest(Document xmlDocument) {
        super("mtbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "KARTA:4177*5654\n" +
                        "16/01/18 13:52\n" +
                        "OPLATA 6.48 BYN\n" +
                        "MTB INTERNET POS, PR. PARTIZANSKIY 6A, MINSK\n" +
                        "OSTATOK 19.75 BYN\n" +
                        "Spr.:5099999",
                "expense",
                "4177*5654",
                "6.48",
                "");
        checkBankSms(
                "KARTA:5351*1179\n" +
                        "05/12/17 20:05\n" +
                        "OPLATA 479.00 BYN\n" +
                        "I.-SHOP \"21VEK.BY\" BAP, , MINSK\n" +
                        "OST.DB 0.00 BYN\n" +
                        "OST.CR 464.37 BYN\n" +
                        "KOD AVT.075807 (WWW.MTBINGO.BY)\n" +
                        "Spr.:5099999",
                "expense",
                "5351*1179",
                "479",
                "");
        checkBankSms(
                "PAYOKAY 5351*7458 04/01/2018 PLATA ZA OBSLUZHIVANIE KARTY: SPISANO 2.50 BYN Spravka 5099999",
                "service_pay",
                "5351*7458",
                "2.50",
                "");
        checkBankSms(
                parser,
                "Uvazhaemyj klient! Na Vash schet BY75MTBK*******6349 postupilo 7,61 BYN. Vash MTBank!",
                "popolnenie",
                "BY75MTBK*******6349",
                "7.61",
                "");
        checkBankSms(
                "KARTA:5351*3320\n" +
                        "18/01/18 16:01\n" +
                        "POPOLNENIE 50.00 BYN\n" +
                        "247195 MTB BELPOST, UNKNOWN, ZHLOBIN 5\n" +
                        "OSTATOK 50.00 BYN\n" +
                        "Spr.:5099999",
                "popolnenie",
                "5351*3320",
                "50.00",
                "");
        checkBankSms(
                "HALVA 5351*1179 31/01/2018 PLATA ZA SMS-UVEDOMLENIYA: SPISANO 1.80 BYN Spravka 5099999",
                "service_pay",
                "5351*1179",
                "1.80",
                "");
        checkBankSms(
                "ZP KARTA 4177*5654 31/01/2018 PLATA ZA SMS-UVEDOMLENIYA: SPISANO 1.80 BYN Spravka 5099999",
                "service_pay",
                "4177*5654",
                "1.80",
                "");
        checkBankSms(
                "KORONA 5351*4690 16/01/2018 PLATA ZA OBSLUZHIVANIE KARTY: SPISANO 19.90 BYN Spravka 5099999",
                "service_pay",
                "5351*4690",
                "19.90",
                "");
        checkBankSms(
                "KARTA:4649*7095\n" +
                        "18/01/18 21:51\n" +
                        "NALICHNYE 200.00 BYN\n" +
                        "M6823027\n" +
                        "OSTATOK 4 080.23 BYN\n" +
                        "Spr.:5099999\n",
                "cash_atm",
                "4649*7095",
                "200.00",
                "");
        checkBankSms(
                "KARTA:5351*1199\n" +
                        "05/02/18 18:46\n" +
                        "PEREVOD 20.01 BYN\n" +
                        "P2P MTBANK, PEREVOD, MINSK\n" +
                        "OSTATOK 36.08 BYN\n" +
                        "Spr.:5099999",
                "perevod",
                "5351*1199",
                "20.01",
                "");
        checkBankSms(
                "KARTA:5351*3796\n" +
                        "29/03/19 17:43\n" +
                        "PEREVOD 1 100.36 BYN\n" +
                        "P2P_MTBANK, PEREVOD, MINSK\n" +
                        "OSTATOK 1 100.36 BYN\n" +
                        "Spr.:5099999",
                "perevod",
                "5351*3796",
                "1100.36",
                "");
        checkBankSms(
                "KARTA 535104******3796\n" +
                        "2019-05-16 17:59:23\n" +
                        "OPLATA 9.13BYN\n" +
                        "SHOP \"DOMASHNIY\" BAPB    LOGOYSK      BY\n" +
                        "OSTATOK 555.19BYN\n" +
                        "Spr.:5099999",
                "expense",
                "535104******3796",
                "9.13",
                "");
        checkBankSms(
                "KARTA 535104******3796\n" +
                        "2019-05-16 17:59:23\n" +
                        "OPLATA 9.13BYN\n" +
                        "SHOP \"DOMASHNIY\" BAPB    LOGOYSK      BY\n" +
                        "OSTATOK 555.19BYN\n" +
                        "Spr.:5099999",
                "expense",
                "535104******3796",
                "9.13");
        checkBankSms(
                "KARTA: 5*5291\n" +
                        "2020-03-02 22:30:45\n" +
                        "PLATA ZA OBSLUZHIVANIE KARTY:\n" +
                        "SPISANO 2.50 BYN\n" +
                        "Spr.:5099999",
                "service_pay",
                "5*5291",
                "2.50");
        checkBankSms(
                "KARTA 5*5291\n" +
                        "2020-02-14 08:40:22\n" +
                        "ZACHISLENIE PEREVOD 100.00 BYN\n" +
                        "P2PMTBANK / MINSK / BY\n" +
                        "OSTATOK 122.59 BYN\n" +
                        "Spr.:5099999",
                "popolnenie",
                "5*5291",
                "100");
        checkBankSms(
                "KARTA 5*5291\n" +
                        "2020-02-13 17:24:00\n" +
                        "SPISANIE PEREVOD 5.00 BYN\n" +
                        "P2PMTBANK / MINSK / BY\n" +
                        "OSTATOK 55.86 BYN\n" +
                        "Spr.:5099999",
                "payment",
                "5*5291",
                "5");
        checkBankSms(
                "KARTA 5*6339\n" +
                        "2019-12-15 04:30:02\n" +
                        "OPLATA 2.00 BYN\n" +
                        "MTB INTERNET POS / MINSK / BY\n" +
                        "OSTATOK 188.59 BYN\n" +
                        "Spr.:5099999",
                "expense",
                "5*6339",
                "2");
    }
}
