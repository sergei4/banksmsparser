package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class RosbankSmsTest extends AbsXmlBankSmsTest {

    public RosbankSmsTest(Document xmlDocument) {
        super("rosbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Karta **0368.Sovershena pokupka na summu 1000.00 RUR. YOTA. Ostatok: 2482.77 RUR. 18/01/18.",
                "expense",
                "0368",
                "1000",
                ""
        );
        checkBankSms(
                "Schet A*891: Popolnenie 9082.00 RUB; Dostupno: 10042.19 RUB; 19/01/18",
                "popolnenie",
                "A*891",
                "9082",
                ""
        );
        checkBankSms(
                "Schet C*476: Popolnenie 36.02 RUB; Dostupno: 36.02 RUB; 15/01/18",
                "popolnenie",
                "C*476",
                "36.02",
                ""
        );
        checkBankSms(
                "Karta **1234.Proizvedeno snjatie 100.00 RUR v ATM. ATM 751689 3 KOLLONTAY. Ostatok: 1765.77 RUR. 25/01/18.",
                "cash_atm",
                "1234",
                "100",
                ""
        );
        checkBankSms(
                "Karta **9253.Proizvedeno snyatie 6200.00 RUR v ATM.CHAPAEVA, 5.So scheta spisano 6200.00 RUR.Ostatok:17.03 RUR.26/01/18.",
                "cash_atm",
                "9253",
                "6200",
                ""
        );
        checkBankSms(
                "Schet A*123: Spisanie   15424.55 RUB; Dostupno: 23236.19 RUB; 07/02/18",
                "payment",
                "A*123",
                "15424.55",
                ""
        );
        checkBankSms(
                "Счет L*683: Пополнение 91357.38 RUB; Доступно: 91357.38 RUB; 10/04/19. Подробнее http://rosbank.ru/app.",
                "popolnenie",
                "L*683",
                "91357.38",
                ""
        );
        checkBankSms(
                "Счет A*461: Пополнение 19261.00 RUB; Доступно: 21035.67 RUB; 05/04/19. Подробнее http://rosbank.ru/app.",
                "popolnenie",
                "A*461",
                "19261",
                ""
        );
        checkBankSms(
                "Счет C*957: Списание   11085.54 RUB; Доступно: 692710.28 RUB; 14/04/19. Подробнее http://rosbank.ru/app.",
                "payment",
                "C*957",
                "11085.54",
                ""
        );
        checkBankSms(
                "S karty **3548 perevedeno 20000.00 RUR.P2P ROSBANK. Spisano 20300.00 RUR. Ostatok:5618.41 RUR 24.04.19",
                "perevod",
                "3548",
                "20300",
                ""
        );
        checkBankSms(
                "Karta **0895: ATM Ulitsa Dvortsovaya Dom vnesena summa 22000.00 (RUR). Zachisleno 22000.00 (RUR). Ostatok: 23856.08; 19.06.19",
                "cash_atm",
                "0895",
                "22000",
                ""
        );
        checkBankSms(
                "Karta **0895.Pokupka na summu 1300.00 RUR.IB.ROSBANK.RU >. Spisano 1300.00 RUR.Ostatok:18022.77 RUR 21.06.19",
                "expense",
                "0895",
                "1300",
                ""
        );
        checkBankSms(
                "Karta**6194 FGBOU VO RANHIGS 122.00 RUB. Ostatok 9855.34 RUB",
                "unknown",
                "6194",
                "122",
                ""
        );
        checkBankSms(
                "Karta**6194 LENINA 9 1260.00 RUB. Ostatok 9977.34 RUB",
                "unknown",
                "6194",
                "1260",
                ""
        );
    }
}
