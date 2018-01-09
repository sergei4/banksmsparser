package com.skmmobile.banksmsparser.bank.kz;

import com.skmmobile.banksmsparser.BankSmsParser;
import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;
import org.w3c.dom.Document;

public class KaspibankSmsTest extends AbsXmlBankSmsTest {

    public KaspibankSmsTest(Document xmlDocument) {
        super("kaspibank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        // Kapigold
        checkBankSms(
                parser,
                "Покупка: 6707т\n" +
                        "MAGNUM AF 19-5\n" +
                        "Доступно: 139 296,44т",
                BankSmsParser.CATEGORY_EXPENSE,
                "kaspigold",
                "6707",
                ""
        );
        // Kapibank
        checkBankSms(
                parser,
                "Перевод: 6000т\n" +
                        "На Kaspi Gold\n" +
                        "Доступно: 133 296,44т",
                "perevod",
                "kaspigold",
                "6000",
                ""
        );
        checkBankSms(
                parser,
                "Kaspi Депозит D-007\n" +
                        "Пополнение: 20 000т\n" +
                        "В Kaspi Терминале\n" +
                        "На Депозите: 17 608 751,96т",
                "popolnenie",
                "D-007",
                "20000",
                ""
        );
        checkBankSms(
                parser,
                "Kaspi Депозит D-007\n" +
                        "Проценты за декабрь: +201 569,73т\n" +
                        "На Депозите: 17 588 751,96т",
                "popolnenie",
                "D-007",
                "201569.73",
                ""
        );
    }
}
