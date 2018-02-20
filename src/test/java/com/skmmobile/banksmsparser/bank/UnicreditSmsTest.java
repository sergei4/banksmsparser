package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import org.w3c.dom.Document;

public class UnicreditSmsTest extends AbsXmlBankSmsTest {

    public UnicreditSmsTest(Document xmlDocument) {
        super("unicreditbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                parser,
                "Карта 1139 07.01.2018 11:34 Покупка 1850.00 RUB. Доступно: 37203.74 RUR LUKOIL.AZS 87 59P CHUSOVOY",
                BankSmsParser.CATEGORY_EXPENSE,
                "1139",
                "1850.00",
                ""
        );
        checkBankSms(
                parser,
                "Карта 1139 07.01.2018 11:58 Покупка 170.00 RUB. Доступно: 37033.74 RUR MBU SOK CHUSOVOY",
                BankSmsParser.CATEGORY_EXPENSE,
                "1139",
                "170",
                ""
        );
        checkBankSms(
                parser,
                "Карта 1139 11.01.2018 11:21 Баланс карты увеличен на 3108.43 RUB. Доступно: 16487.57 RUR",
                "zachislenie",
                "1139",
                "3108.43",
                ""
        );
        checkBankSms(
                parser,
                "15.02.2018 Баланс карты 1139 увеличен на 204.58 RUB. Доступно: 44738.49 RUB",
                "zachislenie",
                "1139",
                "204.58",
                ""
        );
    }
}
