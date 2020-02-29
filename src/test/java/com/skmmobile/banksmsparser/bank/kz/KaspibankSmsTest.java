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
                "Покупка: 4134т\n" +
                        "GAZOILPROM AZS\n" +
                        "Доступно: 2852т",
                "expense",
                "kaspigold",
                "4134",
                ""
        );
        checkBankSms(
                "Покупка: 6707т\n" +
                        "MAGNUM AF 19-5\n" +
                        "Доступно: 139 296,44т",
                "expense",
                "kaspigold",
                "6707",
                ""
        );
        checkBankSms(
                "Перевод: 6000тНа Kaspi GoldДоступно: 133 296,44т",
                "perevod",
                "kaspigold",
                "6000",
                ""
        );
        checkBankSms(
                "Перевод: 6000т\n" +
                        "На Kaspi Gold\n" +
                        "Доступно: 133 296,44т",
                "perevod",
                "kaspigold",
                "6000",
                ""
        );
        checkBankSms(
                "Пополнение: 8000т\n" +
                        "С Kaspi Депозита \n" +
                        "Доступно: 146 003,44т",
                "popolnenie",
                "kaspigold",
                "8000",
                ""
        );
        checkBankSms(
                "Пополнение: 112 000т\n" +
                        "В Kaspi Терминале \n" +
                        "Доступно: 146 003,44т",
                "popolnenie",
                "kaspigold",
                "112000",
                ""
        );
        checkBankSms(
                "Снятие: 10 000т\n" +
                        "В Банкомате ATM VN ALMATY SAMAL-2 D 111\n" +
                        "Доступно: 173 721,18т",
                "cash_ATM",
                "kaspigold",
                "10000",
                ""
        );

        // Kapibank
        checkBankSms(
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
                "Kaspi Депозит D-007\n" +
                        "Проценты за декабрь: +201 569,73т\n" +
                        "На Депозите: 17 588 751,96т",
                "popolnenie",
                "D-007",
                "201569.73",
                ""
        );
        checkBankSms(
                "Kaspi Депозит D-006\n" +
                        "Платеж на Kaspi.kz: 2000т\n" +
                        "На Депозите: 49 023,74т",
                "oplata",
                "D-006",
                "2000",
                ""
        );
        checkBankSms(
                "Kaspi Депозит D-006\n" +
                        "Оплата кредита: 48 000т\n" +
                        "На Депозите: 1023,74т",
                "payment",
                "D-006",
                "48000",
                ""
        );
        checkBankSms(
                "Kaspi Депозит D-005\n" +
                        "Перевод: 3USD\n" +
                        "На Депозит D-004\n" +
                        "На Депозите: 1739USD",
                "perevod",
                "D-005",
                "3",
                ""
        );
    }
}
