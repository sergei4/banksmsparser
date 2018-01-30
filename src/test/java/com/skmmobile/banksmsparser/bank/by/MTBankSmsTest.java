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
                parser,
                "KARTA:4177*5654\n" +
                        "16/01/18 13:52\n" +
                        "OPLATA 6.48 BYN\n" +
                        "MTB INTERNET POS, PR. PARTIZANSKIY 6A, MINSK\n" +
                        "OSTATOK 19.75 BYN\n" +
                        "Spr.:5099999",
                "expense",
                "4177*5654",
                "6.48",
                ""
        );
        checkBankSms(
                parser,
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
                ""
        );
        checkBankSms(
                parser,
                "PAYOKAY 5351*7458 04/01/2018 PLATA ZA OBSLUZHIVANIE KARTY: SPISANO 2.50 BYN Spravka 5099999",
                "service_pay",
                "5351*7458",
                "2.50",
                ""
        );
        checkBankSms(
                parser,
                "Uvazhaemyj klient! Na Vash schet BY75MTBK*******6349 postupilo 7,61 BYN. Vash MTBank!",
                "popolnenie",
                "BY75MTBK*******6349",
                "7.61",
                ""
        );
        checkBankSms(
                parser,
                "KARTA:5351*3320\n" +
                        "18/01/18 16:01\n" +
                        "POPOLNENIE 50.00 BYN\n" +
                        "247195 MTB BELPOST, UNKNOWN, ZHLOBIN 5\n" +
                        "OSTATOK 50.00 BYN\n" +
                        "Spr.:5099999",
                "popolnenie",
                "5351*3320",
                "50.00",
                ""
        );
    }
}
