package com.skmmobile.banksmsparser.bank;

import org.w3c.dom.Document;

public class MTSSmsTest extends AbsXmlBankSmsTest {

    public MTSSmsTest(Document xmlDocument) {
        super("mtsbank", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Оплата VP *9707; 07.01 15:18; PYATEROCHKA 9114>EKATERINBURG RU; 699,25 RUB; Остаток: 655,74 RUB",
                "expense",
                "VP *9707",
                "699.25",
                "PYATEROCHKA 9114>EKATERINBURG RU"
        );
        checkBankSms(
                "Приход по счету карты VP *9707; 73,07 RUB; Остаток: 126,85 RUB",
                "popolnenie",
                "VP *9707",
                "73.07",
                ""
        );
        checkBankSms(
                "ПАО \"МТС-Банк\"уведомляет о переводе со счета 40817***3838 на карту 4042 XXXX XXXX 9707: 1,300.00 RUR; Остаток: 296,500.00 RUR; 06.01.2018 17:25",
                "perevod",
                "40817***3838",
                "1300",
                ""
        );
        checkBankSms(
                "Погашение задолженности 2600 RUR по карте 5337***4579. Остаток мин. платежа 0 RUR. www.mtsbank.ru",
                "payment",
                "5337***4579",
                "2600",
                ""
        );
        checkBankSms(
                "Перевод на карту ES *4579; 19.01 16:19; TINKOFF BANK CARD2CARD>MOSCOW RU; 2 600,00 RUB; Лимит: 30 652,47 RUB",
                "perevod",
                "ES *4579",
                "2600",
                ""
        );
        checkBankSms(
                "Приход по счету карты ES *0482; 1 000,00 RUB; Лимит: 25 969,53 RUB; Собственные средства: 0,00 RUB; Кредит: 25 969,53 RUB",
                "popolnenie",
                "ES *0482",
                "1000",
                ""
        );
        checkBankSms(
                "Пополнение VP *4629; 25.01 16:32; 2 800,00 RUB; Остаток: 3 301,00 RUB",
                "popolnenie",
                "VP *4629",
                "2800",
                ""
        );
        checkBankSms(
                "Перевод на карту VP *4192; 19.01 19:19; VISA MONEY TRANSFER>Visa Direct RU; 1 425,00 RUB; Остаток: 1 604,74 RUB",
                "perevod",
                "VP *4192",
                "1425",
                ""
        );
        checkBankSms(
                "Списание 1425 RUR с карты 4042***4192 в счет погашения по Договору МТСУФА259539/810/17. www.mtsbank.ru\n",
                "payment",
                "4042***4192",
                "1425",
                ""
        );
        checkBankSms(
                "Оплата ES *2942; 07.03 14:07; OOO MIR VKUSA>NOVOSIBIRSK RU; 1 111,06 RUB; Остаток: 1 111,06 RUB",
                "expense",
                "ES *2942",
                "1111.06",
                "OOO MIR VKUSA>NOVOSIBIRSK RU"
        );
        checkBankSms(
                "Оплата ES *0576; 02.04 09:53; TD MISTER SLOYKIN>PYATIGORSK RU; 95,00 RUB; Лимит: 93 904,99 RUB",
                "expense",
                "ES *0576",
                "95",
                "TD MISTER SLOYKIN>PYATIGORSK RU"
        );
        checkBankSms(
                "Oplata VP *7325; 23.03 17:07; MAGNIT MK HANSTEN>SMOLENSK RU; 49,00 RUB; Ostatok: 5 744,36 RUB",
                "expense",
                "VP *7325",
                "49",
                "MAGNIT MK HANSTEN>SMOLENSK RU"
        );
        checkBankSms(
                "Oplata VP *6975; 31.03 16:34; MAGNIT MM PODIUM>ZERNOGRAD RU; 2 262,99 RUB; Ostatok: 3 532,45 RUB",
                "expense",
                "VP *6975",
                "2262.99",
                "MAGNIT MM PODIUM>ZERNOGRAD RU"
        );
        checkBankSms(
                "Perevod na kartu VP *9179; 28.03 18:31; MS VPP DEPOSIT FOR MTSBANK>MOSCOW RU; 49 000,00 RUB; Ostatok: 50 801,00 RUB\n",
                "perevod",
                "VP *9179",
                "49000",
                ""
        );
        checkBankSms(
                "Popolnenie VP *6975; 02.04 18:50; 25 000,00 RUB; Ostatok: 28 532,45 RUB\n",
                "popolnenie",
                "VP *6975",
                "25000",
                ""
        );
        checkBankSms(
                "Oplata VP *7445; 09.07 13:31; A-3>A-3.RU RU; 412,92 RUB; Limit: 8 648,25 RUB",
                "expense",
                "VP *7445",
                "412.92",
                "A-3>A-3.RU RU"
        );
        checkBankSms(
                "Oplata VP *7445; 04.07 11:26; TINKOFF*UTILITIES>MOSCOW RU; 1 629,31 RUB; Limit: 15 690,12 RUB",
                "expense",
                "VP *7445",
                "1629.31",
                "TINKOFF*UTILITIES>MOSCOW RU"
        );
        checkBankSms(
                "Prihod po schetu karty VP *6975; 28,44 RUB; Ostatok: 2 858,63 RUB",
                "popolnenie",
                "VP *6975",
                "28.44",
                ""
        );
        checkBankSms(
                "Перевод со счета 4081**4363 на карту *6975: 2000.00 RUR. ПАО \"МТС-Банк\"",
                "perevod",
                "*6975",
                "2000",
                ""
        );
        checkBankSms(
                "Поступление на счет 4081**4363 8000.00 RUR от Куницын Е.В.; Остаток: 41572.71 RUR. ПАО \"МТС-Банк\"",
                "popolnenie",
                "4081**4363",
                "8000",
                ""
        );
        checkBankSms(
                "Oplata EW *3586; 09.08 17:25; I LOVE SUSHI>Dubna RU; 567,00 RUB; Limit: 18 276,00 RUB",
                "expense",
                "EW *3586",
                "567",
                "I LOVE SUSHI>Dubna RU"
        );
        checkBankSms(
                "Оплата ES *0576; 04.08 17:56; GASTRANOMCHIK>PYATIGORSK RU; 168,00 RUB; Лимит: 119 678,27 RUB",
                "expense",
                "ES *0576",
                "168",
                "GASTRANOMCHIK>PYATIGORSK RU"
        );
        checkBankSms(
                "Oplata VP *2092; 03.08 20:27; IP MIKHAJJLOVA S A>VSEVLZ RU; 145,00 RUB; Limit: 59 635,61 RUB",
                "expense",
                "VP *2092",
                "145",
                "IP MIKHAJJLOVA S A>VSEVLZ RU"
        );
        checkBankSms(
                "Popolnenie VP *9136; 25.07 18:15; 100,00 RUB; Ostatok: 100,00 RUB",
                "popolnenie",
                "VP *9136",
                "100",
                ""
        );
        checkBankSms(
                "Списание комиссии 50 RUR за SMS-Банк-Инфо по карте *7737. МТС Банк",
                "payment",
                "*7737",
                "50",
                ""
        );
        checkBankSms(
                "Списание комиссии 50 RUR за SMS-Банк-Инфо по карте 5337***0955. www.mtsbank.ru\n",
                "payment",
                "5337***0955",
                "50",
                ""
        );
        checkBankSms(
                "Oplata VC *2481; 18.05 15:28; HVOSTUSHCI>KOROLEV RU; 293,80 RUB; Ostatok: 200,92 RUB",
                "expense",
                "VC *2481",
                "293.80",
                "HVOSTUSHCI>KOROLEV RU"
        );
        checkBankSms(
                "Perevod na kartu ES *8949; 20.07 19:57; SBOL>MOSCOW RU; 10 300,00 RUB; Limit: 10 303,02 RUB",
                "perevod",
                "ES *8949",
                "10300.00",
                ""
        );
        checkBankSms(
                "Nalichnye VC *4154; 02.06 13:16; 25 TRUDOVOY SLAVY STR>KRASNODAR RU; 5 000,00 RUB; Ostatok: 83 272,65 RUB",
                "cash_atm",
                "VC *4154",
                "5000",
                ""
        );
        checkBankSms(
                "Popolnenie VP *2601; 13.08 14:04; 3 000,00 RUB; Limit: 3 101,97 RUB",
                "popolnenie",
                "VP *2601",
                "3000",
                ""
        );
        checkBankSms(
                "Перевод с карты ES *7737; 28.04 11:24; TINKOFF BANK CARD2CARD>MOSCOW RU; 1 000,00 RUB; Остаток: 38 716,14 RUB",
                "perevod",
                "ES *7737",
                "1000",
                ""
        );
        checkBankSms(
                "Perevod s karty VC *4154; 31.05 15:55; P2P ROSBANK>Moscow RU; 9 999,00 RUB; Ostatok: 88 272,65 RUB",
                "perevod",
                "VC *4154",
                "9999",
                ""
        );
        checkBankSms(
                "Oplata EW *3586; 20.08 15:15; \"KAFE STULYA\">DUBNA RU; 1 063,00 RUB; Limit: 15 501,20 RUB",
                "expense",
                "EW *3586",
                "1063",
                "\"KAFE STULYA\">DUBNA RU"
        );
        checkBankSms(
                "Oplata *2594; 13.11 18:50; OAO CPPC>Moscow RU; 22,00 RUB; Ostatok: 1 487,72 RUB",
                "expense",
                "*2594",
                "22",
                "OAO CPPC>Moscow RU"
        );
        checkBankSms(
                "Оплата    *1955; 08.11 20:57; HOFF KAZAN>KAZAN RU; 2 697,00 RUB; Остаток: 1 400,56 RUB",
                "expense",
                "*1955",
                "2697",
                "HOFF KAZAN>KAZAN RU"
        );
        checkBankSms(
                "Пополнение    *1955; 08.11 20:46; 700,00 RUB; Остаток: 4 097,56 RUB",
                "popolnenie",
                "*1955",
                "700",
                ""
        );
        checkBankSms(
                "Perevod s karty MR *7191; 09.10 08:07; TRANSF OWN>MOSCOW RU; 2 000,00 RUB; Ostatok: 350,44 RUB",
                "perevod",
                "MR *7191",
                "2000",
                ""
        );
        checkBankSms(
                "Prihod po schetu karty MR *7191; 12 000,00 RUB; Ostatok: 12 350,44 RUB",
                "popolnenie",
                "MR *7191",
                "12000",
                ""
        );
        checkBankSms(
                "Perevod s karty *4809; 13.11 07:34; MC VPP PAYMENT FROM MTSBANK>MOSCOW RU; 2 045,00 RUB; Ostatok: 3 192,04 RUB",
                "perevod",
                "*4809",
                "2045",
                ""
        );
        checkBankSms(
                "Perevod na kartu *4809; 10.11 04:19; TRANSF OTHER>MOSCOW RU; 400,00 RUB; Ostatok: 5 386,04 RUB",
                "perevod",
                "*4809",
                "400",
                ""
        );
        checkBankSms(
                "Popolnenie *6187; 08.11 19:42; 5 000,00 RUB; Ostatok: 5 032,93 RUB",
                "popolnenie",
                "*6187",
                "5000",
                ""
        );
        checkBankSms(
                "Списание со счета 4081**2523 3000.00 RUR в пользу Баранова В.А.; Остаток: 41970.87 RUR. ПАО \"МТС-Банк\"",
                "payment",
                "4081**2523",
                "3000",
                ""
        );
        checkBankSms(
                "Светлана Викторовна, на карту *4809 зачислен кэшбэк за предыдущую неделю: 54.23 RUR. Приятных выходных! Ваш МТС Банк",
                "popolnenie",
                "*4809",
                "54.23",
                ""
        );
    }
}