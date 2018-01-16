package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import org.w3c.dom.Document;

public class GazpromSmsTest extends AbsXmlBankSmsTest {

    public GazpromSmsTest(Document xmlDocument) {
        super("gazprom", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Telecard; Card8381; Oplata; Summa 559 RUR; 17.12.17 09:19:32; MONETKA; dostupno: 1790.52 RUR",
                "expense",
                "8381",
                "559",
                "MONETKA"
        );

        checkBankSms(
                parser,
                "Telecard; Card1091; 15.05.14 12:31:11; SUPERMARKET TECHNO; Oplata; 9150 RUB; dostupno: 49794.88 RUB",
                "expense",
                "1091",
                "9150",
                "SUPERMARKET TECHNO"
        );

        checkBankSms(
                parser,
                "Telecard; Card1745; Poluchen perevod; Summa 8000 RUR; 14.12.17 10:04:38; PEREVOD MEZHDU KARTAMI; dostupno: 10099.38 RUR; ispolzovano: 59900.62 RUR",
                "cardToCard",
                "1745",
                "8000",
                ""
        );

        checkBankSms(
                parser,
                "Telecard; Card1745; Oplata; Summa 370 RUR; 22.12.17 08:36:33; YALYA; dostupno: 5953.47 RUR; ispolzovano: 64046.53 RUR",
                "expense",
                "1745",
                "370",
                "YALYA"
        );

        checkBankSms(
                parser,
                "Telecard; Card1745; Oplata; Summa 237 RUR; 22.12.17 08:28:22; MOROSHKA; dostupno: 6323.47 RUR; ispolzovano: 63676.53 RUR",
                "expense",
                "1745",
                "237",
                "MOROSHKA"
        );

        checkBankSms(
                parser,
                "Card8381; Oplata v I-net; Summa 165 RUR; 21.12.17 14:46:31; GOOGLE *androidmarket; dostupno: 112.36 RUR",
                "expense",
                "8381",
                "165",
                "GOOGLE *androidmarket"
        );

        checkBankSms(
                parser,
                "Telecard; Card8381; Snyatie nalichnih; Summa 14900 RUR; 14.12.17 13:23:35; GAZPROMBANK; dostupno: 11599.23 RUR",
                "vida4a_ATM",
                "8381",
                "14900",
                "GAZPROMBANK"
        );

        checkBankSms(
                parser,
                "Telecard; Card5621;Card1691;CUP Standard;Card1963;Card9047; 10.01.18 12:52:12; Zachislenie; 21162.48 RUR; dostupno: 46786.71 RUR",
                "zachislenie",
                "5621",
                "21162.48",
                ""
        );

        checkBankSms(
                parser,
                "Telecard; Card9047; Perevod; Summa 9000 RUR; 09.01.18 18:09:02; PEREVOD NA KARTU; dostupno: 44603.23 RUR",
                "perevod",
                "9047",
                "9000",
                ""
        );

        checkBankSms(
                parser,
                "Telecard; Card1691; Predauth; Summa 525 RUR; 15.01.18 17:16:56; YANDEX.TAXI; dostupno: 406651.48 RUR",
                "expense",
                "1691",
                "525",
                "YANDEX.TAXI"
        );
    }
}
