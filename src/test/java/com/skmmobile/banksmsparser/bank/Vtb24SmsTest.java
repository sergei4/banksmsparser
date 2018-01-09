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
                BankSmsParser.CATEGORY_EXPENSE,
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
                "spisanie",
                "1020",
                "600",
                ""
        );

        checkBankSms(
                parser,
                "Karta *1020: spisanie 100.00 RUR; W.QIWI.RU; 20.12.2017 14:22, dostupno 100.00 RUR.",
                "spisanie",
                "1020",
                "100",
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
                "cash_ATM",
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
                "Karta *0755: zachislenie 9205.00 RUR; 35, MIYASNITSKAYA; 28.12.2017 12:13, dostupno 160988.72 RUR (v tom chisle kred. 160988.72 RUR).",
                "popolnenie",
                "0755",
                "9205",
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
    }
}
