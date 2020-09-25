package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.SmsParserFactory;

public class MKBSmsTest extends AbsXmlBankSmsTest {

    public MKBSmsTest(SmsParserFactory smsParserFactory) {
        super("mkb", smsParserFactory);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "MKB: 16.01.2018 11:58 5*3758 POKUPKA: 1 120.00 RUB BPMAZK BP MC316. Balance: 235 161.15 RUB. Blokirovka kart - SMS \"All\" na +79037672667",
                "expense",
                "5*3758",
                "1120.00",
                ""
        );
        checkBankSms(
                "MKB: 11.01.2018 03:37 5*3758 SPISANIE: 3 895.95 RUB MCBA. Balance: 240 359.15. Blokirovka kart - SMS \"All\" na +79037672667",
                "payment",
                "5*3758",
                "3895.95",
                ""
        );
        checkBankSms(
                "MKB: 10.01.2018 18:20 5*3758 POPOLNENIE: 10 000.00 RUB TRM 11821. Balance: 244 255.10 RUB. Blokirovka kart - SMS \"All\" na +79037672667",
                "popolnenie",
                "5*3758",
                "10000.00",
                ""
        );
        checkBankSms(
                "MKB: 13.02.2018 16:20 4*2800 NALICHNIE: 50 000.00 RUB ATM 983 MKB 810. Balance: 13 616.24 RUB. Blokirovka kart - SMS \"All\" na +79037672667\n",
                "cash_atm",
                "4*2800",
                "50000",
                ""
        );
        checkBankSms(
                "MKB Online: Sovershen platezh na summu 500 RUR Blokirovanie dostupa v sistemu SMS \"Online\" na nomer +79037672667.",
                "payment",
                "mkb",
                "500",
                ""
        );
        checkBankSms(
                "Oplata sms-informirovaniya po karte *0895 60 RUR.",
                "payment",
                "0895",
                "60",
                ""
        );
        checkBankSms(
                "MKB: 01.06.18 Вам начислен cashback 1678.26 RUB по карте *3481. Баланс 9091.13 RUB. Расплачивайтесь картой и зарабатывайте на покупках.",
                "zachislenie",
                "3481",
                "1678.26",
                ""
        );
        checkBankSms(
                "Карта*1686 Пополнение 15660.00р Баланс 22624.28р",
                "popolnenie",
                "Карта*1686",
                "15660",
                ""
        );
        checkBankSms(
                "Карта*3444 Покупка 273.00р KFC XL MYTISCHI Баланс 47361.02р",
                "expense",
                "Карта*3444",
                "273",
                ""
        );
        checkBankSms(
                "MKB: 30.12.2018 21:24 5*7409 ПОКУПКА: 1 725.57 RUB KARUSEL. баланс: 1 403.14 RUB. ",
                "expense",
                "5*7409",
                "1725.57",
                ""
        );
        checkBankSms(
                "Карта*1686 Наличные 3000.00р Alfa Iss 66A ENTUZIAST Баланс 15587.79р",
                "cash_atm",
                "Карта*1686",
                "3000.00",
                ""
        );
    }
}
