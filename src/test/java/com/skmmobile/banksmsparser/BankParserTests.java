package com.skmmobile.banksmsparser;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BankParserTests extends Assert {

    private static final String RESULT_IS_NULL = "Не удалось разобрать строку";

    private void isSystemSms(String text){
        Assert.assertTrue("Не удалось распознать служебное смс", BankSmsParser.isSystemBankSms(text));
    }

    @Test
    public void IsSystemSmsTest() {
        isSystemSms("Задолженность по налогу на транспорт");
        isSystemSms("Vhod v Tinkoff.ru uspeshno vypolnen");
        isSystemSms("Вход в Сбербанк Онлайн для Android 19:32 02.12.17");
        isSystemSms("Списание средств: Tinkoff Bank (RUB 15000.00); пароль: 244265. Не сообщайте пароль НИКОМУ. Только мошенники запрашивают пароли");
    }

    @Test
    public void TinkoffParserTest() {
        BankSmsParser parser = new TinkoffSmsParser();
        BankSmsParser.Result result;
        BigDecimal amount;

        result = parser.parseSms("Pokupka. Karta *9930. Summa 167.90 RUB. PYATEROCHKA, CHELYABINSK. 05.12.2017 16:20. Dostupno 41711.07 RUB. Tinkoff.ru");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals(BankSmsParser.CATEGORY_EXPENSE, result.getType());
        assertEquals("9930", result.getCardIdStr());
        amount = new BigDecimal("167.90");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("PYATEROCHKA, CHELYABINSK", result.getDetails());

        result = parser.parseSms("Покупка. Карта *0380. 126 RUB. YANDEX.GOODS. Баланс 22601 RUB");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals(BankSmsParser.CATEGORY_EXPENSE, result.getType());
        assertEquals("0380", result.getCardIdStr());
        amount = new BigDecimal("126");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("YANDEX.GOODS", result.getDetails());

        result = parser.parseSms("Покупка. Карта *9930. 175 RUB. GRANDVERA. Доступно 54093 RUB");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals(BankSmsParser.CATEGORY_EXPENSE, result.getType());
        assertEquals("9930", result.getCardIdStr());
        amount = new BigDecimal("175");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("GRANDVERA", result.getDetails());

        result = parser.parseSms("Jur. perevod. Karta *9930. Summa 3270.63 RUB. iBank. 07.12.2017 10:11. Dostupno 56644.39 RUB. Tinkoff.ru");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals("jur.perevod", result.getType());
        assertEquals("9930", result.getCardIdStr());
        amount = new BigDecimal("3270.63");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("iBank", result.getDetails());

        result = parser.parseSms("Popolnenie. Karta *9930. Summa 8000 RUB. Card2Card. 07.12.2017 15:31. Dostupno 61967.41 RUB. Tinkoff.ru");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals("popolnenie", result.getType());
        assertEquals("9930", result.getCardIdStr());
        amount = new BigDecimal("8000");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("Card2Card", result.getDetails());

        result = parser.parseSms("Покупка. Карта *0380. 38 RUB. YANDEX.GOODS. Доступно 20225 RUB");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals(BankSmsParser.CATEGORY_EXPENSE, result.getType());
        assertEquals("0380", result.getCardIdStr());
        amount = new BigDecimal("38");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("YANDEX.GOODS", result.getDetails());

        result = parser.parseSms("Vnutrenniy perevod sebe. Karta *9930. Summa 25000 RUB. mBank. 09.12.2017 05:20. Dostupno 61972.03 RUB. Tinkoff.ru");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals("perevod", result.getType());
        assertEquals("9930", result.getCardIdStr());
        amount = new BigDecimal("25000");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("", result.getDetails());

        result = parser.parseSms("Perevod na kartu. Karta *9930. Summa 1000 RUB. TINKOFF BANK CARD2CARD. 12.12.2017 18:06. Dostupno 56706 RUB. Tinkoff.ru");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals("perevod_card", result.getType());
        assertEquals("9930", result.getCardIdStr());
        amount = new BigDecimal("1000");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("", result.getDetails());
    }

    @Test
    public void SberbankParserTest() {
        BankSmsParser parser = new SberbankSmsParser();
        BankSmsParser.Result result;
        BigDecimal amount;

        result = parser.parseSms("VISA6168 06.12.17 11:30 списание 700р Баланс: 2682.45р");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals("spisanie", result.getType());
        assertEquals("VISA6168", result.getCardIdStr());
        amount = new BigDecimal("700");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("", result.getDetails());

        result = parser.parseSms("VISA6470 04.12.17 08:18 оплата 200р MTS OAO Баланс: 4278.81р");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals(BankSmsParser.CATEGORY_EXPENSE, result.getType());
        assertEquals("VISA6470", result.getCardIdStr());
        amount = new BigDecimal("200");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("MTS OAO", result.getDetails());

        result = parser.parseSms("VISA6168 02.12.17 19:32 списание 30000р SBERBANK ONL@IN KARTA-VKLAD Баланс: 3382.45р");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals("spisanie", result.getType());
        assertEquals("VISA6168", result.getCardIdStr());
        amount = new BigDecimal("30000");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("", result.getDetails());

        result = parser.parseSms("VISA6168 02.12.17 08:45 зачисление 30000р ATM 335417 Баланс: 33382.45р");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals("zachislenie_ATM", result.getType());
        assertEquals("VISA6168", result.getCardIdStr());
        amount = new BigDecimal("30000");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("ATM 335417", result.getDetails());

        result = parser.parseSms("VISA6168 09.12.17 19:07 зачисление 10000р с Вашего вклада. Баланс: 12682.45р");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals("zachislenie", result.getType());
        assertEquals("VISA6168", result.getCardIdStr());
        amount = new BigDecimal("10000");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("", result.getDetails());

        result = parser.parseSms("VISA6168 11.12.17 18:13 зачисление 6300р с Вашего вклада. Баланс: 8982.45р");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals("zachislenie", result.getType());
        assertEquals("VISA6168", result.getCardIdStr());
        amount = new BigDecimal("6300");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("", result.getDetails());
    }

    @Test
    public void AlfaBankParserTest() {
        BankSmsParser parser = new AlfaBankSmsParser();
        BankSmsParser.Result result;
        BigDecimal amount;

        result = parser.parseSms("5*9857; Pokupka; Uspeshno; Summa: 110,00 RUR; Ostatok: 137372,27 RUR; RU/CHELYABINSK/SOKOL FIT DER NOVOE PO; 04.12.2017 13:33:17");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals(BankSmsParser.CATEGORY_EXPENSE, result.getType());
        assertEquals("9857", result.getCardIdStr());
        amount = new BigDecimal("110");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("RU/CHELYABINSK/SOKOL FIT DER NOVOE PO", result.getDetails());

        result = parser.parseSms("4*0537; Pokupka; Uspeshno; Summa: 5141,00 RUR; Ostatok: 130731,27 RUR; RU/CHELYABINSK/LENTA 212; 05.12.2017 19:46:57");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals(BankSmsParser.CATEGORY_EXPENSE, result.getType());
        assertEquals("0537", result.getCardIdStr());
        amount = new BigDecimal("5141");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("RU/CHELYABINSK/LENTA 212", result.getDetails());

        result = parser.parseSms("5*9857; Postupleniye; Summa: 1300,00 RUR; Ostatok: 137482,27 RUR; 03.12.2017; Otkrojte schet 'Semejnyj' v mobil'nom banke https://alfabank.ru/app");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals("popolnenie", result.getType());
        assertEquals("9857", result.getCardIdStr());
        amount = new BigDecimal("1300");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("", result.getDetails());

        result = parser.parseSms("Spisanie so scheta 408*32167 na summu 1,500.00 RUR, poluchatel platezha 408*32255; 04.12.2017 21:28:02");
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals("perevod", result.getType());
        assertEquals("408*32167", result.getCardIdStr());
        amount = new BigDecimal("1500");
        assertTrue(result.getAmount().compareTo(amount) == 0);
        assertEquals("", result.getDetails());
    }
}
