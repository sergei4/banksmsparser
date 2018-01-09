package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import org.w3c.dom.Document;

public class MTSSmsTest extends AbsXmlBankSmsTest {

    public MTSSmsTest(Document xmlDocument) {
        super("mtsbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Оплата VP *9707; 07.01 15:18; PYATEROCHKA 9114>EKATERINBURG RU; 699,25 RUB; Остаток: 655,74 RUB",
                BankSmsParser.CATEGORY_EXPENSE,
                "9707",
                "699.25",
                "PYATEROCHKA 9114>EKATERINBURG RU"
        );
        checkBankSms(
                parser,
                "Приход по счету карты VP *9707; 73,07 RUB; Остаток: 126,85 RUB",
                "popolnenie",
                "9707",
                "73.07",
                ""
        );
        checkBankSms(
                parser,
                "ПАО \"МТС-Банк\"уведомляет о переводе со счета 40817***3838 на карту 4042 XXXX XXXX 9707: 1,300.00 RUR; Остаток: 296,500.00 RUR; 06.01.2018 17:25",
                "perevod",
                "40817***3838",
                "1300",
                ""
        );
    }
}
