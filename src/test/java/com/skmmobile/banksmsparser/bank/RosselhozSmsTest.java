package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class RosselhozSmsTest extends AbsXmlBankSmsTest {

    public RosselhozSmsTest(Document xmlDocument) {
        super("rosselhoz", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "RSHB 19/01 00:16:01 oplata uslug 80.00 RUR s karty *7329 v VISA QIWI WALLET MOSCOW RU",
                "expense",
                "7329",
                "80",
                ""
        );
        checkBankSms(
                parser,
                "RSHB 19/01 00:16:01 oplata uslug 1,892.00 RUR s karty *7329 v VISA QIWI WALLET MOSCOW RU",
                "expense",
                "7329",
                "1892.00",
                ""
        );
        checkBankSms(
                parser,
                "RSHB 20/01 13:16:23 pokupka 1,892.00 RUR odobr. karta *7329 WILDBERRIES KOSTROMA RU",
                "expense",
                "7329",
                "1892.00",
                ""
        );
        checkBankSms(
                parser,
                "РСХБ 16/01 05:48:06 покупка 1,892.00 RUR одобр. Доступно 3,582.10 карта *7888 IRIS-SOVETSKAYA USSURIYSK RU",
                "expense",
                "7888",
                "1892.00",
                ""
        );
        checkBankSms(
                parser,
                "РСХБ 15/01 10:27:17 SMS сервис для телефона 79244395128 счет *4657 оплачен,сумма 59.00 дост. 173.26",
                "expense",
                "счет *4657",
                "59.00",
                ""
        );
        checkBankSms(
                parser,
                "РСХБ 15/01 11:19:49 счет *4657 пополнение 4,168.94 RUR одобр. Доступно 4,342.20",
                "popolnenie",
                "счет *4657",
                "4168.94",
                ""
        );
        checkBankSms(
                parser,
                "РСХБ 17/01 16:17:30 АТМ выдача наличных 3,500.00 RUR одобр. Доступно 82.10 карта *7888 ATM 1601 USSURIYSK RU",
                "cash_atm",
                "7888",
                "3500",
                ""
        );
        checkBankSms(
                parser,
                "RSHB 22/01 17:57:29 pokupka 300.00 RUR odobr. karta *7329 PYATEROCHKA 6625 KOSTROMA RU",
                "expense",
                "7329",
                "300",
                ""
        );
    }
}
