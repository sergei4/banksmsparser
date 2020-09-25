package com.skmmobile.banksmsparser.parser;

import java.util.ArrayList;

class FakeBankSmsParser extends BaseBankSmsParser {

    FakeBankSmsParser() {
        super("fakebanksms", new ArrayList<SmsPattern>());
        SmsPattern operation;
        // 5*9857; Pokupka; Uspeshno; Summa: 110,00 RUR; Ostatok: 137372,27 RUR; RU/CHELYABINSK/SOKOL FIT DER NOVOE PO; 04.12.2017 13:33:17
        operation = new SmsPattern("expense");
        operation.setTypePattern(".*\\sPokupka\\;.*");
        operation.setCardIdRex("(?<=(4|5)\\*)\\d{4}");
        operation.setAmountRex("Summa:\\s(\\d+\\,\\d{2})",1 );
        operation.setDetailRex("\\sOstatok:\\s[0-9,]*\\sRUR;\\s([^;]*);", 1);
        operation.setDecChar(",");
        addOperationTemplate(operation);

        // 5*9857; Postupleniye; Summa: 1300,00 RUR; Ostatok: 137482,27 RUR; 03.12.2017; Otkrojte schet 'Semejnyj' v mobil'nom banke https://alfabank.ru/app
        operation = new SmsPattern("popolnenie");
        operation.setTypePattern(".*Postupleniye\\;.*");
        operation.setCardIdRex("(?<=(4|5)\\*)\\d{4}");
        operation.setAmountRex("Summa:\\s(\\d+\\,\\d{2})",1 );
        //operation.setDetailRex("\\sOstatok:\\s[0-9,]*\\sRUR;\\s([^;]*);", 1);
        operation.setDecChar(",");
        addOperationTemplate(operation);

        // Spisanie so scheta 408*32167 na summu 1,500.00 RUR, poluchatel platezha 408*32255; 04.12.2017 21:28:02
        operation = new SmsPattern("perevod");
        operation.setTypePattern("Spisanie so scheta.*");
        operation.setCardIdRex("Spisanie\\sso\\sscheta\\s(.*)\\sna", 1);
        operation.setAmountRex("na summu\\s(.*)\\sRUR",1 );
        //operation.setDetailRex("\\sOstatok:\\s[0-9,]*\\sRUR;\\s([^;]*);", 1);
        operation.setDecDelim(",");
        addOperationTemplate(operation);
    }
}
