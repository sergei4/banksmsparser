package com.skmmobile.banksmsparser;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;

import java.io.File;
import java.math.BigDecimal;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class BankParserTests extends Assert {

    private static final String RESULT_IS_NULL = "Не удалось разобрать строку";

    private void isSystemSms(String text){
        Assert.assertTrue("Не удалось распознать служебное смс", BankSmsParser.isSystemBankSms(text));
    }

    @Test
    @Deprecated
    public void IsSystemSmsTest() {
        isSystemSms("Задолженность по налогу на транспорт");
        isSystemSms("Vhod v Tinkoff.ru uspeshno vypolnen");
        isSystemSms("Вход в Сбербанк Онлайн для Android 19:32 02.12.17");
        isSystemSms("Списание средств: Tinkoff Bank (RUB 15000.00); пароль: 244265. Не сообщайте пароль НИКОМУ. Только мошенники запрашивают пароли");
        isSystemSms("Сбербанк Онлайн. ЕВГЕНИЙ АЛЕКСАНДРОВИЧ У. перевел(а) Вам 3040.00 RUB");
    }

    @Test
    public void XmlIsSystemSmsTest() throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File(ConstTests.BANK_SMS_XML));
        BankSmsParser.initSystemSms(XmlBankParser.obtainSystemSmsPatternList(xmlDocument));

        isSystemSms("Задолженность по налогу на транспорт");
        isSystemSms("Vhod v Tinkoff.ru uspeshno vypolnen");
        isSystemSms("Вход в Сбербанк Онлайн для Android 19:32 02.12.17");
        isSystemSms("Списание средств: Tinkoff Bank (RUB 15000.00); пароль: 244265. Не сообщайте пароль НИКОМУ. Только мошенники запрашивают пароли");
        isSystemSms("Сбербанк Онлайн. ЕВГЕНИЙ АЛЕКСАНДРОВИЧ У. перевел(а) Вам 3040.00 RUB");
        isSystemSms("VISA5538 19.12.17 09:11 ОТКАЗ (недостаточно средств) покупка 1432р OOO SEMEYNAYA APTEKA");
    }

    private void checkBankSms(BankSmsParser parser, String smsText, String type, String cardId, String amountStr, String details){
        BankSmsParser.Result result;
        BigDecimal amount;

        Assert.assertFalse("Смс определилось как служебное", BankSmsParser.isSystemBankSms(smsText));
        result = parser.parseSms(smsText);
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals(type, result.getType());
        assertEquals(cardId, result.getCardIdStr());
        amount = new BigDecimal(amountStr);
        assertTrue("Проверьте сумму. Ожидалось: " + result.getAmount().toPlainString(),result.getAmount().compareTo(amount) == 0);
        assertEquals(details, result.getDetails());
    }

    @Test
    public void TinkoffParserTest() {
        TinkoffParserTestImpl(new TinkoffSmsParser(), false);
    }

    @Test
    public void XmlTinkoffParserTest() throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File(ConstTests.BANK_SMS_XML));

        TinkoffParserTestImpl(XmlBankParser.obtain(xmlDocument, "tinkoff"), true);
    }

    private void TinkoffParserTestImpl(BankSmsParser parser, boolean xml){
        assertEquals("tinkoff", parser.getBankName());
        TinkoffBaseParserTestImpl(parser);
        if(xml)
            TinkoffXmlBaseParserTestImpl(parser);
    }

    private void TinkoffBaseParserTestImpl(BankSmsParser parser){
        // <editor-fold desc="12.12.2017">
        checkBankSms(
                parser,
                "Pokupka. Karta *9930. Summa 167.90 RUB. PYATEROCHKA, CHELYABINSK. 05.12.2017 16:20. Dostupno 41711.07 RUB. Tinkoff.ru",
                BankSmsParser.CATEGORY_EXPENSE,
                "9930",
                "167.90",
                "PYATEROCHKA, CHELYABINSK"
        );

        checkBankSms(
                parser,
                "Покупка. Карта *0380. 126 RUB. YANDEX.GOODS. Баланс 22601 RUB",
                BankSmsParser.CATEGORY_EXPENSE,
                "0380",
                "126",
                "YANDEX.GOODS"
        );

        checkBankSms(
                parser,
                "Покупка. Карта *9930. 175 RUB. GRANDVERA. Доступно 54093 RUB",
                BankSmsParser.CATEGORY_EXPENSE,
                "9930",
                "175",
                "GRANDVERA"
        );

        checkBankSms(
                parser,
                "Jur. perevod. Karta *9930. Summa 3270.63 RUB. iBank. 07.12.2017 10:11. Dostupno 56644.39 RUB. Tinkoff.ru",
                "jur.perevod",
                "9930",
                "3270.63",
                "iBank"
        );

        checkBankSms(
                parser,
                "Popolnenie. Karta *9930. Summa 8000 RUB. Card2Card. 07.12.2017 15:31. Dostupno 61967.41 RUB. Tinkoff.ru",
                "popolnenie",
                "9930",
                "8000",
                "Card2Card"
        );

        checkBankSms(
                parser,
                "Покупка. Карта *0380. 38 RUB. YANDEX.GOODS. Доступно 20225 RUB",
                BankSmsParser.CATEGORY_EXPENSE,
                "0380",
                "38",
                "YANDEX.GOODS"
        );

        checkBankSms(
                parser,
                "Vnutrenniy perevod sebe. Karta *9930. Summa 25000 RUB. mBank. 09.12.2017 05:20. Dostupno 61972.03 RUB. Tinkoff.ru",
                "perevod",
                "9930",
                "25000",
                ""
        );

        checkBankSms(
                parser,
                "Perevod na kartu. Karta *9930. Summa 1000 RUB. TINKOFF BANK CARD2CARD. 12.12.2017 18:06. Dostupno 56706 RUB. Tinkoff.ru",
                "perevod_card",
                "9930",
                "1000",
                ""
        );
        //</editor-fold>
    }

    private void TinkoffXmlBaseParserTestImpl(BankSmsParser parser){
        checkBankSms(
                parser,
                "Платеж. Карта *7733. 100 RUB. Megafon. Баланс *** RUB",
                "expense",
                "7733",
                "100",
                "Megafon"
        );

        checkBankSms(
                parser,
                "Снятие. Карта *7733. 3000 RUB. ATM 450704 180-1. Доступно **** RUB",
                "cash_ATM",
                "7733",
                "3000",
                "ATM 450704 180-1"
        );
    }

    @Test
    public void SberbankParserTest(){
        SberbankParserTestImpl(new SberbankSmsParser());
    }

    @Test
    public void XmlSberbankParserTest() throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File(ConstTests.BANK_SMS_XML));

        SberbankParserTestImpl(XmlBankParser.obtain(xmlDocument, "sberbank"));
    }

    private void SberbankParserTestImpl(BankSmsParser parser) {
        assertEquals("sberbank", parser.getBankName());
        //<editor-fold desc="12.12.2017">
        checkBankSms(
                parser,
                "VISA6168 06.12.17 11:30 списание 700р Баланс: 2682.45р",
                "spisanie",
                "VISA6168",
                "700",
                ""
        );

        checkBankSms(
                parser,
                "VISA6470 04.12.17 08:18 оплата 200р MTS OAO Баланс: 4278.81р",
                BankSmsParser.CATEGORY_EXPENSE,
                "VISA6470",
                "200",
                "MTS OAO"
        );

        checkBankSms(
                parser,
                "VISA6168 02.12.17 19:32 списание 30000р SBERBANK ONL@IN KARTA-VKLAD Баланс: 3382.45р",
                "spisanie",
                "VISA6168",
                "30000",
                ""
        );

        checkBankSms(
                parser,
                "VISA6168 02.12.17 08:45 зачисление 30000р ATM 335417 Баланс: 33382.45р",
                "zachislenie_ATM",
                "VISA6168",
                "30000",
                "ATM 335417"
        );

        checkBankSms(
                parser,
                "VISA6168 09.12.17 19:07 зачисление 10000р с Вашего вклада. Баланс: 12682.45р",
                "zachislenie",
                "VISA6168",
                "10000",
                ""
        );

        checkBankSms(
                parser,
                "VISA6168 11.12.17 18:13 зачисление 6300р с Вашего вклада. Баланс: 8982.45р",
                "zachislenie",
                "VISA6168",
                "6300",
                ""
        );
        //</editor-fold>

        checkBankSms(
                parser,
                "MIR-3075 12.12.17 19:31 покупка 171.76р PYATEROCHKA 8456 Баланс: 2476.46р",
                BankSmsParser.CATEGORY_EXPENSE,
                "MIR-3075",
                "171.76",
                "PYATEROCHKA 8456"
        );

        checkBankSms(
                parser,
                "VISA5538 13.12.17 16:18 покупка 558р SUPERMARKET EVROPA Баланс: 3256.88р",
                BankSmsParser.CATEGORY_EXPENSE,
                "VISA5538",
                "558",
                "SUPERMARKET EVROPA"
        );

        checkBankSms(
                parser,
                "VISA5538 11.12.17 20:46 покупка 557.90р BURGER KING 0287 Баланс: 279.88р",
                BankSmsParser.CATEGORY_EXPENSE,
                "VISA5538",
                "557.90",
                "BURGER KING 0287"
        );

        checkBankSms(
                parser,
                "MAES0515 11.12.17 12:24 зачисление пенсии 10471.91р Баланс: 12934.80р",
                "zachislenie",
                "MAES0515",
                "10471.91",
                ""
        );

        checkBankSms(
                parser,
                "MAES0515 11.12.17 12:27 списание 12000р SBERBANK ONL@IN KARTA-VKLAD Баланс: 934.80р",
                "spisanie",
                "MAES0515",
                "12000",
                ""
        );

        checkBankSms(
                parser,
                "MAES0515 10.12.17 05:43 зачисление 1856.68р SO VKLADA N*013008564017-1856.68RUR Баланс: 2462.89р",
                "zachislenie",
                "MAES0515",
                "1856.68",
                ""
        );

        checkBankSms(
                parser,
                "ORPS5161 09.12.17 11:44 списание 2000р Баланс: 229.11р",
                "spisanie",
                "ORPS5161",
                "2000",
                ""
        );

        checkBankSms(
                parser,
                "ORPS5161 08.12.17 16:25 списание 1р Баланс: 2229.11р",
                "spisanie",
                "ORPS5161",
                "1",
                ""
        );

        checkBankSms(
                parser,
                "ORPS5161 08.12.17 16:12 зачисление 1р Баланс: 2309.21р",
                "zachislenie",
                "ORPS5161",
                "1",
                ""
        );

        checkBankSms(
                parser,
                "ORPS5161 08.12.17 16:10 зачисление 5000р с Вашего вклада. Баланс: 6020.21р",
                "zachislenie",
                "ORPS5161",
                "5000",
                ""
        );

        checkBankSms(
                parser,
                "MIR-3075 13.12.17 22:51 зачисление 31600р Баланс: 32474.66р",
                "zachislenie",
                "MIR-3075",
                "31600",
                ""
        );

        checkBankSms(
                parser,
                "ECMC8559 13.12.17 16:49 зачисление 15000р ATM 10853020 Баланс: 0",
                "zachislenie_ATM",
                "ECMC8559",
                "15000",
                "ATM 10853020"
        );

        checkBankSms(
                parser,
                "VISA6168 13.12.17 14:18 выдача 5000р ATM 861320 Баланс: 97682.45р",
                "vida4a_ATM",
                "VISA6168",
                "5000",
                "ATM 861320"
        );

        checkBankSms(
                parser,
                "VISA0000 10.12.17 оплата Мобильного банка за 10/12/2017-09/01/2018 60р Баланс: 00000.00р",
                "pay_iBank",
                "VISA0000",
                "60",
                ""
        );

        checkBankSms(
                parser,
                "VISA0000: перевод 400р. на карту получателя ВЕРОНИКА АЛЕКСАНДРОВНА П. выполнен. Подробнее в выписке по карте http://sberbank.ru/sms/h2/",
                "perevod",
                "VISA0000",
                "400",
                ""
        );

        checkBankSms(
                parser,
                "MAES7424 14.12.17 09:39 оплата 400р Баланс",
                BankSmsParser.CATEGORY_EXPENSE,
                "MAES7424",
                "400",
                "indefinite"
        );

        checkBankSms(
                parser,
                "MAES0151 14.12.17 10:05 покупка 95.60р Stolovaya 56 Баланс: 17.76р",
                BankSmsParser.CATEGORY_EXPENSE,
                "MAES0151",
                "95.60",
                "Stolovaya 56"
        );

    }

    @Test
    public void AlfaBankParserTest(){
        AlfaBankParserTestImpl(new AlfaBankSmsParser());
    }

    @Test
    public void XmlAlfaBankParserTest() throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File(ConstTests.BANK_SMS_XML));

        AlfaBankParserTestImpl(XmlBankParser.obtain(xmlDocument, "alfabank"));
    }

    private void AlfaBankParserTestImpl(BankSmsParser parser) {
        assertEquals("alfabank", parser.getBankName());
        checkBankSms(
                parser,
                "5*9857; Pokupka; Uspeshno; Summa: 110,00 RUR; Ostatok: 137372,27 RUR; RU/CHELYABINSK/SOKOL FIT DER NOVOE PO; 04.12.2017 13:33:17",
                BankSmsParser.CATEGORY_EXPENSE,
                "9857",
                "110",
                "RU/CHELYABINSK/SOKOL FIT DER NOVOE PO"
        );

        checkBankSms(
                parser,
                "4*0537; Pokupka; Uspeshno; Summa: 5141,00 RUR; Ostatok: 130731,27 RUR; RU/CHELYABINSK/LENTA 212; 05.12.2017 19:46:57",
                BankSmsParser.CATEGORY_EXPENSE,
                "0537",
                "5141",
                "RU/CHELYABINSK/LENTA 212"
        );

        checkBankSms(
                parser,
                "5*9857; Postupleniye; Summa: 1300,00 RUR; Ostatok: 137482,27 RUR; 03.12.2017; Otkrojte schet 'Semejnyj' v mobil'nom banke https://alfabank.ru/app",
                "popolnenie",
                "9857",
                "1300",
                ""
        );

        checkBankSms(
                parser,
                "Spisanie so scheta 408*32167 na summu 1,500.00 RUR, poluchatel platezha 408*32255; 04.12.2017 21:28:02",
                "perevod",
                "408*32167",
                "1500",
                ""
        );
    }

    @Test
    public void XmlVtb24BankParserTest() throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File(ConstTests.BANK_SMS_XML));

        Vtb24BankParserTestImpl(XmlBankParser.obtain(xmlDocument, "vtb24"));
    }

    private void Vtb24BankParserTestImpl(BankSmsParser parser) {
        assertEquals("vtb24", parser.getBankName());
        checkBankSms(
                parser,
                "Karta *0000: Oplata 303.50 RUR; VREMYA ZDOROVYA; 14.11.2017 19:41, dostupno сумма RUR. VTB24",
                BankSmsParser.CATEGORY_EXPENSE,
                "0000",
                "303.5",
                "VREMYA ZDOROVYA"
        );
    }

    @Test
    public void XmlGazpromBankParserTest() throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File(ConstTests.BANK_SMS_XML));

        GarpromBankParserTestImpl(XmlBankParser.obtain(xmlDocument, "gazprom"));
    }

    private void GarpromBankParserTestImpl(BankSmsParser parser) {
        assertEquals("gazprom", parser.getBankName());
        checkBankSms(
                parser,
                "Telecard; Card8381; Oplata; Summa 559 RUR; 17.12.17 09:19:32; MONETKA; dostupno: 1790.52 RUR",
                BankSmsParser.CATEGORY_EXPENSE,
                "8381",
                "559",
                "MONETKA"
        );

        checkBankSms(
                parser,
                "Telecard; Card1745; Poluchen perevod; Summa 8000 RUR; 14.12.17 10:04:38; PEREVOD MEZHDU KARTAMI; dostupno: 10099.38 RUR; ispolzovano: 59900.62 RUR",
                "cardToCard",
                "1745",
                "8000",
                ""
        );
    }
}
