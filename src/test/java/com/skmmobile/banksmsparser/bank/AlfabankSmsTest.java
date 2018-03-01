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
                "expense",
                "9857",
                "110",
                "RU/CHELYABINSK/SOKOL FIT DER NOVOE PO"
        );
        checkBankSms(
                parser,
                "4*0537; Pokupka; Uspeshno; Summa: 5141,00 RUR; Ostatok: 130731,27 RUR; RU/CHELYABINSK/LENTA 212; 05.12.2017 19:46:57",
                "expense",
                "0537",
                "5141",
                "RU/CHELYABINSK/LENTA 212"
        );
        checkBankSms(
                parser,
                "**1175; Pokupka; Uspeshno; Summa: 155 RUR; Ostatok: 412,55 RUR; RU/Chelyabinsk/VKUSNYE PRODUKTY; 28.02.2018 15:32:35",
                "expense",
                "1175",
                "155",
                "RU/Chelyabinsk/VKUSNYE PRODUKTY"
        );
        checkBankSms(
                parser,
                "**7897; Pokupka; Uspeshno; Summa: 193,03 RUR; Ostatok: 4453,79 RUR; RU/SANKT-PETERBU/AO UK START; 28.02.2018 19:47:47",
                "expense",
                "7897",
                "193.03",
                "RU/SANKT-PETERBU/AO UK START"
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
                "**4228; Postupleniye; Summa: 1500 RUR; Ostatok: 1609,11 RUR; 28.02.2018; Podrobnosti v mobilnom banke alfabank.ru/app",
                "popolnenie",
                "4228",
                "1500",
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
                "cash_atm",
                "9857",
                "25200",
                "RU/CHELYABINSK/Alfa Acq"
        );
        checkBankSms(
                parser,
                "**9857; Vydacha nalichnyh; Uspeshno; Summa: 25200,00 RUR; Ostatok: 42843,16 RUR; RU/CHELYABINSK/Alfa Acq; 18.12.2017 11:48:45",
                "cash_atm",
                "9857",
                "25200",
                "RU/CHELYABINSK/Alfa Acq"
        );
        // BYN
        checkBankSms(
                parser,
                "Karta 5.3854\n" +
                        "Perevod (Spisanie)\n" +
                        "Uspeshno\n" +
                        "Summa:27.28 BYN\n" +
                        "Ostatok:22.72 BYN\n" +
                        "Na vremya:16:16:11\n" +
                        "BLR/INTERNET-BANK ALFA/Internet\n" +
                        "05.02.2018 16:16:01",
                "perevod",
                "5.3854",
                "27.28",
                ""
        );
        checkBankSms(
                parser,
                "Karta 5.3854\n" +
                        "Oplata tovarov/uslug\n" +
                        "Uspeshno\n" +
                        "Summa:73.34 BYN\n" +
                        "Ostatok:83.39 BYN\n" +
                        "Na vremya:18:43:30\n" +
                        "BLR/MINSK/GIPPO TRADE CENTRE\n" +
                        "05.02.2018 18:43:27",
                "expense",
                "5.3854",
                "73.34",
                ""
        );
    }
}
