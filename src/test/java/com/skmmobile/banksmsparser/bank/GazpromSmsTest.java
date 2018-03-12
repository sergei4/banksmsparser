package com.skmmobile.banksmsparser.bank;

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
                "Card8381",
                "559",
                "MONETKA"
        );
        checkBankSms(
                parser,
                "Telecard; Card1091; 15.05.14 12:31:11; SUPERMARKET TECHNO; Oplata; 9150 RUB; dostupno: 49794.88 RUB",
                "expense",
                "Card1091",
                "9150",
                "SUPERMARKET TECHNO"
        );
        checkBankSms(
                parser,
                "Telecard; Card1745; Poluchen perevod; Summa 8000 RUR; 14.12.17 10:04:38; PEREVOD MEZHDU KARTAMI; dostupno: 10099.38 RUR; ispolzovano: 59900.62 RUR",
                "popolnenie",
                "Card1745",
                "8000",
                ""
        );
        checkBankSms(
                parser,
                "Telecard; Card1745; Oplata; Summa 370 RUR; 22.12.17 08:36:33; YALYA; dostupno: 5953.47 RUR; ispolzovano: 64046.53 RUR",
                "expense",
                "Card1745",
                "370",
                "YALYA"
        );
        checkBankSms(
                parser,
                "Telecard; Card1745; Oplata; Summa 1 RUR; 22.12.17 08:36:33; YALYA; dostupno: 5953.47 RUR; ispolzovano: 64046.53 RUR",
                "expense",
                "Card1745",
                "1",
                "YALYA"
        );
        checkBankSms(
                parser,
                "Telecard; Card1745; Oplata; Summa 237 RUR; 22.12.17 08:28:22; MOROSHKA; dostupno: 6323.47 RUR; ispolzovano: 63676.53 RUR",
                "expense",
                "Card1745",
                "237",
                "MOROSHKA"
        );
        checkBankSms(
                parser,
                "Card8381; Oplata v I-net; Summa 165 RUR; 21.12.17 14:46:31; GOOGLE *androidmarket; dostupno: 112.36 RUR",
                "expense",
                "Card8381",
                "165",
                "GOOGLE *androidmarket"
        );
        checkBankSms(
                parser,
                "Card8381; Oplata v I-net; Summa 1 RUR; 21.12.17 14:46:31; GOOGLE *androidmarket; dostupno: 112.36 RUR",
                "expense",
                "Card8381",
                "1",
                "GOOGLE *androidmarket"
        );
        checkBankSms(
                parser,
                "Telecard; Card8381; Snyatie nalichnih; Summa 14900 RUR; 14.12.17 13:23:35; GAZPROMBANK; dostupno: 11599.23 RUR",
                "cash_atm",
                "Card8381",
                "14900",
                "GAZPROMBANK"
        );
        checkBankSms(
                parser,
                "Telecard; Card8381; Snyatie nalichnih; Summa 1 RUR; 14.12.17 13:23:35; GAZPROMBANK; dostupno: 11599.23 RUR",
                "cash_atm",
                "Card8381",
                "1",
                "GAZPROMBANK"
        );
        checkBankSms(
                parser,
                "Telecard; Card5621;Card1691;CUP Standard;Card1963;Card9047; 10.01.18 12:52:12; Zachislenie; 21162.48 RUR; dostupno: 46786.71 RUR",
                "zachislenie",
                "Card5621",
                "21162.48",
                ""
        );
        checkBankSms(
                parser,
                "Telecard; Card5621;Card1691;CUP Standard;Card1963;Card9047; 10.01.18 12:52:12; Zachislenie; 1 RUR; dostupno: 46786.71 RUR",
                "zachislenie",
                "Card5621",
                "1",
                ""
        );
        checkBankSms(
                parser,
                "Telecard; Card9047; Perevod; Summa 9000 RUR; 09.01.18 18:09:02; PEREVOD NA KARTU; dostupno: 44603.23 RUR",
                "perevod",
                "Card9047",
                "9000",
                ""
        );
        checkBankSms(
                parser,
                "Telecard; Card9047; Perevod; Summa 1 RUR; 09.01.18 18:09:02; PEREVOD NA KARTU; dostupno: 44603.23 RUR",
                "perevod",
                "Card9047",
                "1",
                ""
        );
        checkBankSms(
                parser,
                "Telecard; Card1691; Predauth; Summa 525 RUR; 15.01.18 17:16:56; YANDEX.TAXI; dostupno: 406651.48 RUR",
                "expense",
                "Card1691",
                "525",
                "YANDEX.TAXI"
        );
        checkBankSms(
                parser,
                "Telecard; Card0125; Predauth; Summa 1 RUR; 06.01.18 12:35:39; YANDEX.TAXI; dostupno: 741.24 RUR",
                "expense",
                "Card0125",
                "1",
                "YANDEX.TAXI"
        );
        checkBankSms(
                parser,
                "Telecard; Card9284; Cash-in; Summa 2000.3 RUR; 17.01.18 14:00:05; GAZPROMBANK; dostupno: 3164.42 RUR",
                "popolnenie",
                "Card9284",
                "2000.3",
                ""
        );
        checkBankSms(
                parser,
                "Telecard; Card9284; Cash-in; Summa 1 RUR; 17.01.18 14:00:05; GAZPROMBANK; dostupno: 3164.42 RUR",
                "popolnenie",
                "Card9284",
                "1",
                ""
        );
        checkBankSms(
                parser,
                "Telecard; Card9284; Cash-in; Summa 0.3 RUR; 17.01.18 14:00:05; GAZPROMBANK; dostupno: 3164.42 RUR",
                "popolnenie",
                "Card9284",
                "0.3",
                ""
        );
        checkBankSms(
                parser,
                "Telecard; Card9284; Platezh; Summa 1000 RUR; 15.01.18 11:26:50; GAZPROMBANK; dostupno: 13089.42 RUR",
                "payment",
                "Card9284",
                "1000",
                ""
        );
        checkBankSms(
                parser,
                "Telecard; Card9284; Platezh; Summa 1.0 RUR; 15.01.18 11:26:50; GAZPROMBANK; dostupno: 13089.42 RUR",
                "payment",
                "Card9284",
                "1",
                ""
        );
        checkBankSms(
                parser,
                "Telecard; MC2591; Snyatie nalichnih; Summa 2800 RUR; 29.12.17 07:40:02; GAZPROMBANK; dostupno: 58.32 RUR",
                "cash_atm",
                "MC2591",
                "2800",
                "GAZPROMBANK"
        );
        checkBankSms(
                parser,
                "Telecard; MC2591; Oplata; Summa 673 RUR; 28.12.17 09:30:29; WILDBERRIES; dostupno: 2858.32 RUR",
                "expense",
                "MC2591",
                "673",
                "WILDBERRIES"
        );
        checkBankSms(
                parser,
                "Telecard; MC2591; 12.01.18 17:26:20; Zachislenie; 3525.54 RUR; dostupno: 3583.86 RUR",
                "zachislenie",
                "MC2591",
                "3525.54",
                ""
        );
        checkBankSms(
                parser,
                "Telecard; Card9284; Poluchen perevod; Summa 160 RUR; 19.01.18 13:45:37; GAZPROMBANK; dostupno: 224.42 RUR",
                "popolnenie",
                "Card9284",
                "160",
                ""
        );
        checkBankSms(
                parser,
                "Telecard; Card3086; Perevod; Summa 4500 RUR; 21.01.18 10:54:18; TINKOFF BANK CARD2CARD; dostupno: 1126.76 RUR",
                "perevod",
                "Card3086",
                "4500",
                ""
        );
        checkBankSms(
                parser,
                "*5818 -423р MAGAZIN GORIZONT 01.03.18 13:46 Доступно 7323.53р",
                "expense",
                "5818",
                "423",
                ""
        );
        checkBankSms(
                parser,
                "*3193 +1500р  07.03.18 09:58 Доступно 10369.58р",
                "popolnenie",
                "3193",
                "1500",
                ""
        );
        checkBankSms(
                parser,
                "*9047 +45824.88р 07.03.18 15:27 Доступно 46140.08р",
                "popolnenie",
                "9047",
                "45824.88",
                ""
        );
    }
}
