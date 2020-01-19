package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class KreditEuroBankSmsTest extends AbsXmlBankSmsTest {

    public KreditEuroBankSmsTest(Document xmlDocument) {
        super("krediteuropabank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Na kartu MEGACARD #6277 postupilo 650.00RUR 20/02/18 19:53 Dostupniy limit:90009.10RUR",
                "popolnenie",
                "MEGACARD #6277",
                "650.00",
                ""
        );
        checkBankSms(
                "Pokupka po karte MEGACARD #6277 21/02/18 19:26 Summa: 100.00RUB Ballov nachisleno: 1.00 Itogo balli MEGA: 274.75BB Dostupniy limit: 89909.10RUR MOSMETRO.RU AKRASNOPRE MOSCOW",
                "expense",
                "MEGACARD #6277",
                "100",
                ""
        );
        checkBankSms(
                "Pokupka po karte #2013, schet nomer #1229 12.03.2018 08:57 Summa: 500.00 RUB Megafon. Platezhny limit: 13357.26 RUB",
                "expense",
                "#2013",
                "500",
                ""
        );
        checkBankSms(
                "Pokupka po karte #3466, schet nomer #2463 21.03.2018 19:27 Summa: 116.62 RUB MAGNIT MM SITRA. Platezhny limit: 5096.04 RUB",
                "expense",
                "#3466",
                "116.62",
                ""
        );
        checkBankSms(
                "Na schet nomer * 2463 postupilo  10108.44 RUB 14.05 14:15 Platezhny limit: 15661.17 RUB",
                "popolnenie",
                "2463",
                "10108.44",
                ""
        );
        checkBankSms(
                "Pokupka po karte MEGACARD # 6277 17/01/20 17:47 Summa: 179.00 RUB Bally +: 1.79 Bally MEGA: 2020.22 BB Dostupniy limit: 56017.92 RUB YANDEX.TAXI MOSCOW",
                "expense",
                "MEGACARD # 6277",
                "179",
                ""
        );
    }
}
