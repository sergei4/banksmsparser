package com.skmmobile.banksmsparser;

/**
 * Статический шаблон для обработки смс банка Tinkoff.
 * шаблоны перенесены в xml
 */

@Deprecated
public class TinkoffSmsParser extends BankSmsParser {

    @Override
    public String getBankName() {
        return "tinkoff";
    }

    public TinkoffSmsParser() {
        SmsPattern smsPattern;
        // Pokupka. Karta *9930. Summa 167.90 RUB. PYATEROCHKA, CHELYABINSK. 05.12.2017 16:20. Dostupno 41711.07 RUB. Tinkoff.ru
        smsPattern = new SmsPattern(CATEGORY_EXPENSE);
        smsPattern.setTypePattern("Pokupka.*");
        smsPattern.setCardIdRex("(?<=(Karta\\s\\*))\\d{4}");
        smsPattern.setAmountRex("(?<=Summa\\s)(\\d+\\.\\d{2})");
        smsPattern.setDetailRex("(RUB|USD|EUR).\\s(.*)\\.\\s\\d{2}\\.\\d{2}", 2);
        addSmsPattern(smsPattern);

        // Покупка. Карта *0380. 126 RUB. YANDEX.GOODS. Баланс 22601 RUB
        // Покупка. Карта *9930. 175 RUB. GRANDVERA. Доступно 54093 RUB
        smsPattern = new SmsPattern(CATEGORY_EXPENSE);
        smsPattern.setTypePattern("Покупка.*");
        smsPattern.setCardIdRex("(?<=(Карта\\s\\*))\\d{4}");
        smsPattern.setAmountRex("\\d{4}.\\s(\\d*.?\\d{1,2})\\s", 1);
        smsPattern.setDetailRex("(?<=(RUB|USD|EUR)\\.\\s).*(?=\\.\\s(Баланс|Доступно))");
        addSmsPattern(smsPattern);

        // Jur. perevod. Karta *9930. Summa 3270.63 RUB. iBank. 07.12.2017 10:11. Dostupno 56644.39 RUB. Tinkoff.ru
        smsPattern = new SmsPattern("jur.perevod");
        smsPattern.setTypePattern("Jur. perevod.*");
        smsPattern.setCardIdRex("(?<=(Karta\\s\\*))\\d{4}");
        smsPattern.setAmountRex("(?<=Summa\\s)(\\d+\\.\\d{2})");
        smsPattern.setDetailRex("(RUB|USD|EUR).\\s(.*)\\.\\s\\d{2}\\.\\d{2}", 2);
        addSmsPattern(smsPattern);

        // Popolnenie. Karta *9930. Summa 8000 RUB. Card2Card. 07.12.2017 15:31. Dostupno 61967.41 RUB. Tinkoff.ru
        smsPattern = new SmsPattern("popolnenie");
        smsPattern.setTypePattern("Popolnenie.*");
        smsPattern.setCardIdRex("(?<=(Karta\\s\\*))\\d{4}");
        smsPattern.setAmountRex("(?<=Summa\\s)\\d+\\.?\\d{1,2}");
        smsPattern.setDetailRex("(RUB|USD|EUR).\\s(.*)\\.\\s\\d{2}\\.\\d{2}", 2);
        addSmsPattern(smsPattern);

        // Vnutrenniy perevod sebe. Karta *9930. Summa 25000 RUB. mBank. 09.12.2017 05:20. Dostupno 61972.03 RUB. Tinkoff.ru
        smsPattern = new SmsPattern("perevod");
        smsPattern.setTypePattern("Vnutrenniy perevod sebe.*");
        smsPattern.setCardIdRex("(?<=(Karta\\s\\*))\\d{4}");
        smsPattern.setAmountRex("(?<=Summa\\s)\\d+\\.?\\d{1,2}");
        //smsPattern.setDetailRex("(RUB|USD|EUR).\\s(.*)\\.\\s\\d{2}\\.\\d{2}", 2);
        addSmsPattern(smsPattern);

        // Perevod na kartu. Karta *9930. Summa 1000 RUB. TINKOFF BANK CARD2CARD. 12.12.2017 18:06. Dostupno 56706 RUB. Tinkoff.ru
        smsPattern = new SmsPattern("perevod_card");
        smsPattern.setTypePattern("Perevod na kartu.*");
        smsPattern.setCardIdRex("(?<=(Karta\\s\\*))\\d{4}");
        smsPattern.setAmountRex("(?<=Summa\\s)\\d+\\.?\\d{1,2}");
        //smsPattern.setDetailRex("(RUB|USD|EUR).\\s(.*)\\.\\s\\d{2}\\.\\d{2}", 2);
        addSmsPattern(smsPattern);
    }
}