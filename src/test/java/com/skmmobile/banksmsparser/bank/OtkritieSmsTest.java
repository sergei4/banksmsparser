package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class OtkritieSmsTest extends AbsXmlBankSmsTest {

    public OtkritieSmsTest(Document xmlDocument) {
        super("otkritie", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Вы заплатили 94.97 р. в UNIVERSAM картой *0988. Доступно 13 080.74 р.",
                "expense",
                "0988",
                "94.97",
                ""
        );
        checkBankSms(
                "Вы заплатили 1 964.39 р. в GAZPROMNEFT AZS 143 картой *0988. Доступно 14 902.21 р.",
                "expense",
                "0988",
                "1964.39",
                ""
        );
        checkBankSms(
                "Вы сняли 10 000 р. в банкомате CENTRAL OFFICE с карты *0988. Доступно 16 866.6 р.",
                "cash_atm",
                "0988",
                "10000",
                ""
        );
        checkBankSms(
                "На карту *0988 зачислено 27 004.5 р. Доступно 27 004.5 р.",
                "popolnenie",
                "0988",
                "27004.5",
                ""
        );
        checkBankSms(
                "На карту *0988 зачислено 27 004 р. Доступно 27 004.5 р.",
                "popolnenie",
                "0988",
                "27004",
                ""
        );
        checkBankSms(
                "Вы внесли 25 000 р. в банкомате DO 153 на карту *2368. Доступно 48 699.18 р.",
                "popolnenie",
                "2368",
                "25000",
                ""
        );
        checkBankSms(
                "Операция по карте *1698 на 24 117 р. Доступно 213.99 р.",
                "unknown",
                "1698",
                "24117",
                ""
        );
        checkBankSms(
                "Вы заплатили 850 р. в SERVISNYY TSENTR картой *4013. Доступно 4 657.48 р.",
                "expense",
                "4013",
                "850",
                ""
        );
        checkBankSms(
                "Карта *4013 Зачислено 6.00 RUR Деньги станут доступны в течение часа 24.02.18",
                "popolnenie",
                "*4013",
                "6",
                ""
        );
        checkBankSms(
                "Вы перевели 5 481 р. с карты *7237. Доступно 576.92 р.",
                "payment",
                "7237",
                "5481",
                ""
        );
        checkBankSms(
                "Платёж 1 570 р. в restoran BOCHKAR. Карта *8680. Доступно 68 882.03 р.",
                "expense",
                "8680",
                "1570",
                ""
        );
        checkBankSms(
                "Снятие 4 400 р. Карта *8680. Доступно 107 902.7 р.",
                "cash_atm",
                "8680",
                "4400",
                ""
        );
        checkBankSms(
                "Карта 4460*2368 Зачислено 22.89 RUR Деньги станут доступны в течение часа 22.01.18",
                "popolnenie",
                "4460*2368",
                "22.89",
                ""
        );
        checkBankSms(
                "Покупка по карте: *1304 49.00 р. Место G.CO HELPPAY# GOOGLE*SKM  Баланс: 1397.09 р. i.binbank.ru",
                "expense",
                "1304",
                "49",
                ""
        );
        checkBankSms(
                "Вам перевели  14 199 р. на карту *3686. Доступно 50 660.71 р.\n",
                "poplnenie",
                "3686",
                "14199",
                ""
        );
        checkBankSms(
                "Pokupka po karte: *1304 72.80 r. Mesto SANKT-PETERBU PEREKRESTOK  Balans: 17414.05 r. i.binbank.ru",
                "expense",
                "1304",
                "72.80",
                ""
        );
        checkBankSms(
                "Списание с карты *1304 900 р. Место S.-PETERBURG Alfa Iss 24A KOLOMYAZS  Баланс: 3487.18 р. i.binbank.ru",
                "payment",
                "1304",
                "900",
                ""
        );
        checkBankSms(
                "Карта MC *1304 пополнена на 5348 р.. Доступно всего 5348,07 р..  Телефон 8 800 200 50 75",
                "popolnenie",
                "MC *1304",
                "5348",
                ""
        );
        checkBankSms(
                "Перевод с карты *1304 на счет 531 р. . Баланс: 4817.07 р.. i.binbank.ru",
                "perevod",
                "1304",
                "531",
                ""
        );
    }
}
