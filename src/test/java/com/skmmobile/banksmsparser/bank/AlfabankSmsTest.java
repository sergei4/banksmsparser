package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import org.w3c.dom.Document;

public class AlfabankSmsTest extends AbsXmlBankSmsTest {

    public AlfabankSmsTest(Document xmlDocument) {
        super("alfabank", xmlDocument);
    }

    @Override
    protected void smsTest() {
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

        checkBankSms(
                parser,
                "5*9857; Vydacha nalichnyh; Uspeshno; Summa: 25200,00 RUR; Ostatok: 42843,16 RUR; RU/CHELYABINSK/Alfa Acq; 18.12.2017 11:48:45",
                "vida4a_ATM",
                "9857",
                "25200",
                "RU/CHELYABINSK/Alfa Acq"
        );
        checkBankSms(
                parser,
                "5*7654; Vydacha nalichnyh; Uspeshno; Summa: 300,00 RUR; Ostatok: 7073,49 RUR; RU/ROSTOV-ON-DON/Alfa Iss; 28.12.2017 20:44:03",
                "vida4a_ATM",
                "7654",
                "300",
                "RU/ROSTOV-ON-DON/Alfa Iss"
        );
    }
}
