package com.skmmobile.banksmsparser;

/**
 * Статический шаблон для обработки смс банка Альфа-Банк.
 * шаблоны перенесены в xml
 */

@Deprecated
public class AlfaBankSmsParser extends BankSmsParser {
    @Override
    public String getBankName() {
        return "alfabank";
    }

    public AlfaBankSmsParser() {
        SmsPattern smsPattern;
        // 5*9857; Pokupka; Uspeshno; Summa: 110,00 RUR; Ostatok: 137372,27 RUR; RU/CHELYABINSK/SOKOL FIT DER NOVOE PO; 04.12.2017 13:33:17
        smsPattern = new SmsPattern(BankSmsParser.CATEGORY_EXPENSE);
        smsPattern.setTypePattern(".*\\sPokupka\\;.*");
        smsPattern.setCardIdRex("(?<=(4|5)\\*)\\d{4}");
        smsPattern.setAmountRex("Summa:\\s(\\d+\\,\\d{2})",1 );
        smsPattern.setDetailRex("\\sOstatok:\\s[0-9,]*\\sRUR;\\s([^;]*);", 1);
        smsPattern.setDecChar(",");
        addSmsPattern(smsPattern);

        // 5*9857; Postupleniye; Summa: 1300,00 RUR; Ostatok: 137482,27 RUR; 03.12.2017; Otkrojte schet 'Semejnyj' v mobil'nom banke https://alfabank.ru/app
        smsPattern = new SmsPattern("popolnenie");
        smsPattern.setTypePattern(".*Postupleniye\\;.*");
        smsPattern.setCardIdRex("(?<=(4|5)\\*)\\d{4}");
        smsPattern.setAmountRex("Summa:\\s(\\d+\\,\\d{2})",1 );
        //smsPattern.setDetailRex("\\sOstatok:\\s[0-9,]*\\sRUR;\\s([^;]*);", 1);
        smsPattern.setDecChar(",");
        addSmsPattern(smsPattern);

        // Spisanie so scheta 408*32167 na summu 1,500.00 RUR, poluchatel platezha 408*32255; 04.12.2017 21:28:02
        smsPattern = new SmsPattern("perevod");
        smsPattern.setTypePattern("Spisanie so scheta.*");
        smsPattern.setCardIdRex("Spisanie\\sso\\sscheta\\s(.*)\\sna", 1);
        smsPattern.setAmountRex("na summu\\s(.*)\\sRUR",1 );
        //smsPattern.setDetailRex("\\sOstatok:\\s[0-9,]*\\sRUR;\\s([^;]*);", 1);
        smsPattern.setDecDelimiter(",");
        addSmsPattern(smsPattern);
    }
}
