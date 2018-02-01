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
                "expense",
                "VP *9707",
                "699.25",
                "PYATEROCHKA 9114>EKATERINBURG RU"
        );
        checkBankSms(
                parser,
                "Приход по счету карты VP *9707; 73,07 RUB; Остаток: 126,85 RUB",
                "popolnenie",
                "VP *9707",
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
        checkBankSms(
                parser,
                "Погашение задолженности 2600 RUR по карте 5337***4579. Остаток мин. платежа 0 RUR. www.mtsbank.ru",
                "payment",
                "5337***4579",
                "2600",
                ""
        );
        checkBankSms(
                parser,
                "Перевод на карту ES *4579; 19.01 16:19; TINKOFF BANK CARD2CARD>MOSCOW RU; 2 600,00 RUB; Лимит: 30 652,47 RUB",
                "perevod",
                "ES *4579",
                "2600",
                ""
        );
        checkBankSms(
                parser,
                "Приход по счету карты ES *0482; 1 000,00 RUB; Лимит: 25 969,53 RUB; Собственные средства: 0,00 RUB; Кредит: 25 969,53 RUB",
                "popolnenie",
                "ES *0482",
                "1000",
                ""
        );
        checkBankSms(
                parser,
                "Пополнение VP *4629; 25.01 16:32; 2 800,00 RUB; Остаток: 3 301,00 RUB",
                "popolnenie",
                "VP *4629",
                "2800",
                ""
        );
        checkBankSms(
                parser,
                "Перевод на карту VP *4192; 19.01 19:19; VISA MONEY TRANSFER>Visa Direct RU; 1 425,00 RUB; Остаток: 1 604,74 RUB",
                "perevod",
                "VP *4192",
                "1425",
                ""
        );
        checkBankSms(
                parser,
                "Списание 1425 RUR с карты 4042***4192 в счет погашения по Договору МТСУФА259539/810/17. www.mtsbank.ru\n",
                "payment",
                "4042***4192",
                "1425",
                ""
        );
    }
}
