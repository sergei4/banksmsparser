package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.SmsParserFactory;

public class RnkbSmsTest extends AbsXmlBankSmsTest {

    public RnkbSmsTest(SmsParserFactory smsParserFactory) {
        super("rnkb", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Vydacha nalichnyh Karta:1234 summa:1600.01 RUR  balans: 628,09 RUR ATM-1234 (vremya operatsii MSK 2018-03-26 08:57:32)",
                "cash_atm",
                "1234",
                "1600.01",
                ""
        );
        checkBankSms(
                "Popolnenie, Karta:7999 summa:25580.18 RUR  balans:25.580,58 RUR  (vremya \n" +
                        "operatsii MSK 2018-04-06 15:05:42)",
                "popolnenie",
                "7999",
                "25580.18",
                ""
        );
        checkBankSms(
                "Pokupka, Karta:6100 summa:665.81 RUR  balans:1.653,86 RUR AVTOMOJKA (vremya operatsii MSK 2018-04-07 18:58:32)",
                "expense",
                "6100",
                "665.81",
                ""
        );
        checkBankSms(
                "Beznalichnyj perevod Karta:7999 summa:442.00 RUR  balans:9.558,40 RUR Transfer (vremya operatsii MSK 2018-03-30 13:10:07)",
                "perevod",
                "7999",
                "442",
                ""
        );
        checkBankSms(
                "Списание по договору:03411504614 сумма:2000.00 RUR. ",
                "payment",
                "03411504614",
                "2000",
                ""
        );
        checkBankSms(
                "Пополнение по договору:03411504614 сумма:20000.00 RUR. ",
                "popolnenie",
                "03411504614",
                "20000",
                ""
        );
        checkBankSms(
                "Vydacha nalichnykh Karta:7999 summa:2000.00 RUR balans:11200.41 RUR \n" +
                        "ATM-4661 18-10-02 14:01:20",
                "cash_atm",
                "7999",
                "2000",
                ""
        );
        checkBankSms(
                "Vydacha nalichnykh karta:6129 summa:1900.00 RUR balans:3072.32 RUR 19-02-27 12:01:30",
                "cash_atm",
                "6129",
                "1900.00",
                ""
        );
        checkBankSms(
                "Beznalichnyy perevod Karta:6129 summa:1005.24 RUR balans:14057.45 RUR Transfer 19-01-22 20:16:24",
                "perevod",
                "6129",
                "1005.24",
                ""
        );
        checkBankSms(
                "Zachislenie zarplaty Karta:6129 summa:5220.00 RUR balans:9532.24 RUR 000000000000401000000611783271 19-02-20 13:20:24",
                "zachislenie",
                "6129",
                "5220.00",
                ""
        );
        checkBankSms(
                "Perevod denezhnykh sredstv po kartam Banka Karta:6129 summa:13500.00 RUR balans:15518.70 RUR CURR=RUR 19-01-30 15:37:02",
                "perevod",
                "6129",
                "13500",
                ""
        );
        checkBankSms(
                "Operatsii po vkladam: Karta: 4241 summa: 500.00 RUR Balans 524.61 RUR Zachislenie summy vklada 20-09-09 10:38:44",
                "unknown",
                "4241",
                "500",
                ""
        );
    }
}
