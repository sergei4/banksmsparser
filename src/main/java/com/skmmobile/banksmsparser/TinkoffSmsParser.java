package com.skmmobile.banksmsparser;

import org.w3c.dom.Document;

/**
 * Статический шаблон для обработки смс банка Tinkoff.
 * шаблоны перенесены в xml
 */

public class TinkoffSmsParser extends BankSmsParser {

    @Override
    public String getBankName() {
        return "tinkoff";
    }

    public TinkoffSmsParser() {
        Operation operation;
        // Pokupka. Karta *9930. Summa 167.90 RUB. PYATEROCHKA, CHELYABINSK. 05.12.2017 16:20. Dostupno 41711.07 RUB. Tinkoff.ru
        operation = new Operation(CATEGORY_EXPENSE);
        operation.setTypePattern("Pokupka.*");
        operation.setCardIdRex("(?<=(Karta\\s\\*))\\d{4}");
        operation.setAmountRex("(?<=Summa\\s)(\\d+\\.\\d{2})");
        operation.setDetailRex("(RUB|USD|EUR).\\s(.*)\\.\\s\\d{2}\\.\\d{2}", 2);
        addOperationTemplate(operation);

        // Покупка. Карта *0380. 126 RUB. YANDEX.GOODS. Баланс 22601 RUB
        // Покупка. Карта *9930. 175 RUB. GRANDVERA. Доступно 54093 RUB
        operation = new Operation(CATEGORY_EXPENSE);
        operation.setTypePattern("Покупка.*");
        operation.setCardIdRex("(?<=(Карта\\s\\*))\\d{4}");
        operation.setAmountRex("\\d{4}.\\s(\\d*.?\\d{1,2})\\s", 1);
        operation.setDetailRex("(?<=(RUB|USD|EUR)\\.\\s).*(?=\\.\\s(Баланс|Доступно))");
        addOperationTemplate(operation);

        // Jur. perevod. Karta *9930. Summa 3270.63 RUB. iBank. 07.12.2017 10:11. Dostupno 56644.39 RUB. Tinkoff.ru
        operation = new Operation("jur.perevod");
        operation.setTypePattern("Jur. perevod.*");
        operation.setCardIdRex("(?<=(Karta\\s\\*))\\d{4}");
        operation.setAmountRex("(?<=Summa\\s)(\\d+\\.\\d{2})");
        operation.setDetailRex("(RUB|USD|EUR).\\s(.*)\\.\\s\\d{2}\\.\\d{2}", 2);
        addOperationTemplate(operation);

        // Popolnenie. Karta *9930. Summa 8000 RUB. Card2Card. 07.12.2017 15:31. Dostupno 61967.41 RUB. Tinkoff.ru
        operation = new Operation("popolnenie");
        operation.setTypePattern("Popolnenie.*");
        operation.setCardIdRex("(?<=(Karta\\s\\*))\\d{4}");
        operation.setAmountRex("(?<=Summa\\s)\\d+\\.?\\d{1,2}");
        operation.setDetailRex("(RUB|USD|EUR).\\s(.*)\\.\\s\\d{2}\\.\\d{2}", 2);
        addOperationTemplate(operation);

        // Vnutrenniy perevod sebe. Karta *9930. Summa 25000 RUB. mBank. 09.12.2017 05:20. Dostupno 61972.03 RUB. Tinkoff.ru
        operation = new Operation("perevod");
        operation.setTypePattern("Vnutrenniy perevod sebe.*");
        operation.setCardIdRex("(?<=(Karta\\s\\*))\\d{4}");
        operation.setAmountRex("(?<=Summa\\s)\\d+\\.?\\d{1,2}");
        //operation.setDetailRex("(RUB|USD|EUR).\\s(.*)\\.\\s\\d{2}\\.\\d{2}", 2);
        addOperationTemplate(operation);

        // Perevod na kartu. Karta *9930. Summa 1000 RUB. TINKOFF BANK CARD2CARD. 12.12.2017 18:06. Dostupno 56706 RUB. Tinkoff.ru
        operation = new Operation("perevod_card");
        operation.setTypePattern("Perevod na kartu.*");
        operation.setCardIdRex("(?<=(Karta\\s\\*))\\d{4}");
        operation.setAmountRex("(?<=Summa\\s)\\d+\\.?\\d{1,2}");
        //operation.setDetailRex("(RUB|USD|EUR).\\s(.*)\\.\\s\\d{2}\\.\\d{2}", 2);
        addOperationTemplate(operation);
    }
}