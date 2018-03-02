package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import org.w3c.dom.Document;

public class Vtb24SmsTest extends AbsXmlBankSmsTest {

    public Vtb24SmsTest(Document xmlDocument) {
        super("vtb24", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Karta *0000: Oplata 303.50 RUR; VREMYA ZDOROVYA; 14.11.2017 19:41, dostupno сумма RUR. VTB24",
                "expense",
                "0000",
                "303.5",
                "VREMYA ZDOROVYA"
        );
        checkBankSms(
                parser,
                "Karta *1020: vnesenie 1000.00 RUR; D. 1, MKR. SOLNECHNYI; 14.12.2017 12:59, dostupno 200.00 RUR",
                "popolnenie",
                "1020",
                "1000",
                ""
        );
        checkBankSms(
                parser,
                "Karta *1020: spisanie 600.00 RUR; 35, MYASNITSKAYA; 14.12.2017 16:43, dostupno 620.00 RUR",
                "payment",
                "1020",
                "600",
                ""
        );
        checkBankSms(
                parser,
                "Karta *1020: spisanie 100.00 RUR; W.QIWI.RU; 20.12.2017 14:22, dostupno 100.00 RUR.",
                "payment",
                "1020",
                "100",
                ""
        );
        checkBankSms(
                parser,
                "Karta *2134 Spisanie, 70.00 RUR za 2 poezdki MOSGORTRANS v dekabre (N bileta 2119696) 29.01.18 10:49 MSK Ostatok 51964.28 RUR",
                "payment",
                "2134",
                "70",
                ""
        );
        checkBankSms(
                parser,
                "Schet *3318: postuplenie zarabotnoy plati 9200.00 RUB; 20.12.2017 19:38:07; Dostupno 9886.55 RUB. Vipiska po karte v VTB24-Online p.vtb24.ru/mob",
                "popolnenie",
                "Schet *3318",
                "9200",
                ""
        );
        checkBankSms(
                parser,
                "Schet *4135: postuplenie 190.00 RUB; perevod 25.12.2017 06:43:33; dostupno 227.66 RUB (sobstv. sredstva: 227.66 RUB). http://p.vtb24.ru/smartb",
                "popolnenie",
                "Schet *4135",
                "190",
                ""
        );
        checkBankSms(
                parser,
                "Karta *7398: snyatie 900.00 RUB; D. 26, PR-KT SHAHTEROV; 24.12.2017 09:52, dostupno 3407.44 RUB (sobstv. sredstva 3407.44 ).",
                "cash_atm",
                "7398",
                "900",
                ""
        );
        checkBankSms(
                parser,
                "Karta *6634: 27.12 16:28 postuplenie zarabotnoy plati11000.00 RUR. Dostupno 11196.4 RUR. Vipiska po karte v VTB24-Online p.vtb24.ru/mob ",
                "popolnenie",
                "6634",
                "11000",
                ""
        );
        checkBankSms(
                parser,
                "Karta *6634: 27.12 16:28 postuplenie zarabotnoy plati1.00 RUR. Dostupno 11196.4 RUR. Vipiska po karte v VTB24-Online p.vtb24.ru/mob ",
                "popolnenie",
                "6634",
                "1",
                ""
        );
        checkBankSms(
                parser,
                "Karta *0755: zachislenie 9205.00 RUR; 35, MIYASNITSKAYA; 28.12.2017 12:13, dostupno 160988.72 RUR (v tom chisle kred. 160988.72 RUR).",
                "popolnenie",
                "0755",
                "9205",
                ""
        );
        checkBankSms(
                parser,
                "Karta *0755: zachislenie 1.00 RUR; 35, MIYASNITSKAYA; 28.12.2017 12:13, dostupno 160988.72 RUR (v tom chisle kred. 160988.72 RUR).",
                "popolnenie",
                "0755",
                "1",
                ""
        );
        checkBankSms(
                parser,
                "Schet *3100: postuplenie 100.00 RUB; 21.12.2017 12:07:47; dostupno 100.00 RUB (sobstv. sredstva: 100.00 RUB). http://p.vtb24.ru/smartb",
                "popolnenie",
                "Schet *3100",
                "100",
                ""
        );
        checkBankSms(
                parser,
                "Schet *2024: spisanie 22431.85 RUB; 28.12.2017 01:58; dostupno 3907.67 RUB (sobstv. sredstva: 3907.67 RUB). http://p.vtb24.ru/s ",
                "payment",
                "Schet *2024",
                "22431.85",
                ""
        );
        checkBankSms(
                parser,
                "Karta *2658: uvelichen balans scheta na 12.65 RUR; dostupno 50.69 RUR (v tom chisle kreditnie sredstva 50.69 RUR). Uchet rashodov http://p.vtb24.ru/smartc",
                "popolnenie",
                "2658",
                "12.65",
                ""
        );
        checkBankSms(
                parser,
                "Karta *0755: umenshen balans scheta na 59.00 RUR; dostupno 162009.54 RUR (v tom chisle kreditnie sredstva 162009.54 RUR). Uchet rashodov http://p.vtb24.ru/smartc ",
                "payment",
                "0755",
                "59.00",
                ""
        );
        checkBankSms(
                parser,
                "Karta *9950 Pokupka, 75.00 RUR .PEKARNYA NA KANTEMIRO 16.01.18 20:21 MSK Ostatok 11105.62 RUR",
                "expense",
                "9950",
                "75.00",
                ".PEKARNYA NA KANTEMIRO"
        );
        checkBankSms(
                parser,
                "Karta *1602 Popolnenie, 11200.00 RUR  16.01.18 10:51 MSK Ostatok 11355.62 RUR",
                "popolnenie",
                "1602",
                "11200.00",
                ""
        );
        checkBankSms(
                parser,
                "Karta *6958: oplata SMS-paketa \"Karti+ SMS\" 59 RUR; 01.03.2018. Ustanovite prilozhenie dly ucheta I kontrilyi Vashih pokupok: http://vtb.ru/smartsms",
                "payment",
                "6958",
                "59",
                ""
        );
    }
}
