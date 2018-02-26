package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class KreditEuroBankSmsTest extends AbsXmlBankSmsTest {

    public KreditEuroBankSmsTest(Document xmlDocument) {
        super("krediteuropabank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Na kartu MEGACARD #6277 postupilo 650.00RUR 20/02/18 19:53 Dostupniy limit:90009.10RUR",
                "popolnenie",
                "MEGACARD #6277",
                "650.00",
                ""
        );
        checkBankSms(
                parser,
                "Pokupka po karte MEGACARD #6277 21/02/18 19:26 Summa: 100.00RUB Ballov nachisleno: 1.00 Itogo balli MEGA: 274.75BB Dostupniy limit: 89909.10RUR MOSMETRO.RU AKRASNOPRE MOSCOW",
                "expense",
                "MEGACARD #6277",
                "100",
                ""
        );
    }
}
