package com.skmmobile.banksmsparser;

import com.skmmobile.banksmsparser.bank.*;
import com.skmmobile.banksmsparser.bank.by.*;
import com.skmmobile.banksmsparser.bank.kz.FortebankSmsTest;
import com.skmmobile.banksmsparser.bank.kz.HalykbankSmsTest;
import com.skmmobile.banksmsparser.bank.kz.KaspibankSmsTest;
import com.skmmobile.banksmsparser.bank.kz.QazkomSmsTest;
import com.skmmobile.banksmsparser.bank.uk.OschadbankSmsTest;
import com.skmmobile.banksmsparser.bank.uk.RaiffeisenUkSmsTest;
import com.skmmobile.banksmsparser.bank.uk.UkrsibbankSmsTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BankParserTests extends Assert {

    private void isSystemSms(String text){
        Assert.assertTrue("Не удалось распознать служебное смс:\n" + text, BankSmsParser.isSystemBankSms(text));
    }

    @Before
    public void before() throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse(new File(ConstTests.BANK_SMS_XML));
        // Загружаем системные смс
        BankSmsParser.initSystemSms(XmlBankParser.obtainSystemSmsPatternList(xmlDocument));
    }

    @Test
    public void XmlIsSystemSmsTest() throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File(ConstTests.BANK_SMS_XML));
        BankSmsParser.initSystemSms(XmlBankParser.obtainSystemSmsPatternList(xmlDocument));

        isSystemSms("Задолженность по налогу на транспорт");
        isSystemSms("Vhod v Tinkoff.ru uspeshno vypolnen");
        isSystemSms("Вход в Сбербанк Онлайн для Android 19:32 02.12.17");
        isSystemSms("Списание средств: Tinkoff Bank (RUB 15000.00); пароль: 244265. Не сообщайте пароль НИКОМУ. Только мошенники запрашивают пароли");
        isSystemSms("Сбербанк Онлайн. ЕВГЕНИЙ АЛЕКСАНДРОВИЧ У. перевел(а) Вам 3040.00 RUB");
        isSystemSms("VISA5538 19.12.17 09:11 ОТКАЗ (недостаточно средств) покупка 1432р OOO SEMEYNAYA APTEKA");
        isSystemSms("Uspeshnaja otmena operacii: 5*9857; Summa: 150000,00 RUR; Vydacha nalichnyh Otmena; RU/CHELYABINSK/Alfa Acq; 18.12.2017 11:46:39. Alfa-bank.");
        isSystemSms("VTB24-Online: Obrabotano rasporyazhenie 434233798 (Mezhdu svoimi schetami / obmen valyuti)");
        isSystemSms("Odnorazovyi kod dlia smeny parolia v Visa QIWI Wallet 9327. Nikomu ne soobshchaite.");
        isSystemSms("Karta 4890*2285, kod 201, ostalnye rekvizity karty na http://w.qiwi.com");
        isSystemSms("Summa 1000.00 RUB. Poluchatel: Google AdWords. Kod: 377329. Nikomu ego ne soobshchaite.");
        isSystemSms("Nikomu ne govorite etot kod! SMS-kod: 7738 Operatsiya: platezh QIWI Wallet na summu 900.00 RUB. Tinkoff.ru");
        isSystemSms("Vash kod (#1):7322 Summa:255.00RUB TELE2 Deistvuet 10 minut");
        isSystemSms("Уважаемый ЕВГЕНИЙ СЕРГЕЕВИЧ! ПАО МИнБанк поздравляет Вас с Днем Рождения и желает крепкого здоровья и финансового благополучия!");
        isSystemSms("Совершен вход в Ваш Сбербанк Онлайн 14:12 25.12.17. Если вход произведен не Вами, обратитесь в контактный центр");
        isSystemSms("Пароль для входа в Сбербанк Онлайн: 66666. НИКОМУ не сообщайте пароль.");
        isSystemSms("Zavtra budet vypolnena regulyarnaya operatsiya: MTS, 300 RUB www.tinkoff.ru");
        isSystemSms("Vypolnena regulyarnaya operatsiya: MTS, 300 RUB www.tinkoff.ru");
        isSystemSms("Parol: 9827. Podtverdite oplatu shtrafov GIBDD na summu 250.00 RUR");
        isSystemSms("Vam vistavlen schet na summu 250.00 RUR ot GIBDD po avtoplatezhu 7431928825. Podtverdite schet na click.alfabank.ru. Alfa-Bank.");
        isSystemSms("Otklyuchen SMS-paket \"Bazoviy\".");
        isSystemSms("Уважаемый клиент, устройство iPhone отключено от Push-кодов");
        isSystemSms("Уважаемый клиент, устройство Samsung SM-G930F подключено к Push-кодам");
        isSystemSms("Kod 036227. Vhod v VTB24-Online. VTB24");
        isSystemSms("Сбербанк Онлайн. 16.12.2017 19:18:15 АЛЕКСЕЙ НИКОЛАЕВИЧ, выполнена регистрация в приложении Android. Не вводите и никому не сообщайте свой номер телефона, данные паспорта или карт.");
        isSystemSms("Пароль для регистрации Android - 50248. Никому не сообщайте пароль. Если вы не совершали регистрацию, позвоните по номеру 900.");
        isSystemSms("16.12.2017 19:17:48 АЛЕКСЕЙ НИКОЛАЕВИЧ, Вы успешно прошли регистрацию в Сбербанк Онлайн! Совершайте операции по картам, вкладам, кредитам. К вашим услугам переводы и платежи в адрес более 50 тысяч поставщиков!");
        isSystemSms("Ваш пароль для регистрации в Сбербанк Онлайн: 10648. Никому не сообщайте пароль. Если вы не совершали регистрацию, позвоните по номеру 900");
        isSystemSms("Karta 5*6163; Podkluchenie k Samsung Pay SMS code: 259536");
        isSystemSms("Vasha karta 4*0755 podkluchena k Samsung Pay. Esli vy ne sovershali operaciu srochno svyagites s VTB24 po ukazannomu na karte telefonu.");
        isSystemSms("АЛЕКСЕЙ НИКОЛАЕВИЧ, карта VISA4575 успешно привязана в мобильное устройство. Теперь Вы можете совершать покупки с помощью приложения.");
        isSystemSms("АЛЕКСЕЙ НИКОЛАЕВИЧ, для привязки карты VISA4575 в мобильном устройстве введите код 141811 в приложение.");
        isSystemSms("Nikomu ne soobshaite etot kod: 0414 - Vhod v Smart SMS");
        isSystemSms("Do 20.12.2017 neobhodimo vnesti na schet karty *0755 summu 11217.41 RUR. (minimal'nyj platyozh na 10.12.2017). VTB24");
        isSystemSms("Vasha karta *5884.Kod dlya provedeniya tranzakcii 8979. http://www.kinomax.ru. Summa 240.00 RUB. Nikomu ne govorite kod! ");
        isSystemSms("ECMC9886 28.12.17 07:19 отмена авторизации 939р Баланс: 972.03р");
        isSystemSms(
                "UVAGA! Nikomu ne povidomliayte kod 1353 dlya perekazu mizh vashymy kartkamy.\n" +
                "Detali www.oschadbank.ua/ib");
        isSystemSms(
                "08.01.18 18:19:39 \n" +
                "Vitaemo! Vy uspishno uvijshly do WEB(Mobile)-bankingu.\n" +
                "Detali 0800210800");
        isSystemSms("Михаил Сергеевич, новый автомобиль ждет Вас! Получите 2407000р. в кредит под 11.8%, ежемесячный платеж 42234р. Или воспользуйтесь 10% скидкой на новое авто по одной из программ: \"Первый\" или \"Семейный\"! Подробнее: https://goo.gl/hsguxq АО ЮниКредит Банк. 88007002636");
        isSystemSms("Nikomu ne govorite etot SMS-kod: 8867. Vy vhodite v mobil'niy bank 11:24 12.01.2018 IP217.118.93.160. Esli vhod proizvodite ne vy, pozvonite v bank: 88005551010");
        isSystemSms("Ваше кодовое слово изменено. Если изменения вносили не вы, перезвоните нам: 88005551010. Tinkoff.ru");
        isSystemSms("Samsung Pay подключен для карты *3402");
        isSystemSms("Vash bonus po aktsii Privedi Druga 3 mesyatsa obsluzhivaniya po debetovoy karte aktivirovan. Vash Tinkoff Bank Tinkoff.ru");
        isSystemSms("ECMC4773: 11.01.18 13:59 карта разблокирована. Если Вы не совершали данную операцию, обратитесь в Контактный центр Сбербанка");
        isSystemSms("ECMC4773: В связи с подозрением на компрометацию карты и для сохранности Ваших средств карта заблокирована банком. Для получения рекомендаций, как восстановить работоспособность карты, обратитесь в Контактный центр Сбербанка");
        isSystemSms("EUROPAY4773:11.01.18,13:47. Покупка на 33000.00 RUB, TINKOFF BANK CARD2CARDRUS, отклонена как подозрительная. В течение 30 минут банк проведет проверку операции и вы получите смс с результатом.");
        isSystemSms("1733: Уважаемый клиент! Проверка завершена, вы можете провести операцию повторно. Приносим извинения за доставленные неудобства. Сбербанк");
        isSystemSms("Сейчас мы позвоним вам и сообщим ПИН-код по вашей карте. Перезвоните, если пропустите звонок: 88005551010. Tinkoff.ru");
        isSystemSms("Spasibo, chto vybrali nas! Vasha karta *3402 gotova k ispolzovaniyu, nikomu ne soobschayte ee rekvizity i PIN-kod. Tinkoff.ru");
        isSystemSms("Максим Иванович, время встречи с представителем банка изменено. Встреча состоится сегодня с 11:00 до 13:00. Tinkoff.ru");
        isSystemSms("Segodnya v period s 13:00 do 15:00 k vam priedet predstavitel banka Dmitriy, +79278681761. Predstavitel sfotografiruet vas i dokumenty. Tinkoff.ru");
        isSystemSms("Zavtra s 13:00 do 15:00 naznachena vstrecha po adresu LENINSKOGO KOMSOMOLA d.56 kv.45. Vozmite pasport. 88005552273. Tinkoff.ru");
        isSystemSms("Сбербанк Онлайн. Изменение настроек оповещений - Пароль для подтверждения изменений - 12164");
        isSystemSms("Vy zashli v Binbank online 2.0 v 00.00 10.01.2018. Esli Vy etogo ne delali, pozvonite po telefonu 88002002080");
        isSystemSms("Вход в мобильное приложение 01.01 18:35 МСК. Если вход совершили не вы, срочно обратитесь в банк");
        isSystemSms("Dlya operacii v STOLOTO.RU na summu 500.00 RUB vash odnorazoviy parol 84587. Ne soobshayte etot parol nikomu,v tom chisle sotrudnikam bankov.");
        isSystemSms("Dlya operacii v PEREVOD S KARTY na summu 10000.00 RUB vash odnorazoviy parol 74056. Ne soobshayte etot parol nikomu,v tom chisle sotrudnikam bankov.");
        isSystemSms("Вы сменили пароль. Переводы с карт Альфа-Банка в Клике и Мобайле будут доступны через сутки. Пожалуйста, воспользуйтесь сервисом на сайте банка в разделе \"Банковские карты и переводы\"");
        isSystemSms("Пароль: 4954 для подтверждения входа. Никому не сообщайте пароль.");
        isSystemSms("Иван Валерьевич, не ждите Деда Мороза! Исполняйте все желания сами с кредитной картой 100 дней без %! Ваши привилегии - 0% в течение 100 дней и 0% за снятие наличных до 50000 р. в месяц. Узнайте свои условия и закажите карту: 88001004334 или https://alfabank.ru/ml/v2/?id=1DD1ZET");
        isSystemSms("Добрый день, Ваш депозит Победа+ досрочно закрыт на сумму 51,790.15 RUR. Альфа-Банк.");
        isSystemSms("Parol dlya vhoda - 0763. Proverte adres banka - https://click.alfabank.ru/... Nikomu ne soobshayte parol, dazhe sotrudnikam banka.");
        isSystemSms("Dlya izmeneniya nastroek shablonov Vash odnorazoviy parol: 0388.");
        isSystemSms("Регистрация устройства Redmi Note 4. Пароль 715303 никому не сообщайте.");
        isSystemSms("Вы совершаете интернет-платеж. НИКОМУ не сообщайте этот код: 994977");
        isSystemSms("Перевод по произвольным реквизитам c карты *0125 от 26.12.17 06:31:11, код авторизации: 960746, на сумму: 3000 RUR. Средства перечислены по указанным Вами реквизитам");
        isSystemSms("Ирина Александровна, Подарков много не бывает! Только до 31 января 2018 г. оформите потребительский кредит в Газпромбанке по ставке от 11,9% годовых на сумму до 3,5 млн руб. Подробная информация на сайте www.gazprombank.ru, в офисах Банка, а также по тел.8 800 100 07 01, *0701 (для абонентов МТС, Билайн, Мегафон, Теле2, Мотив). Банк ГПБ (АО). Ген.лиц. Банка России №354. Не является офертой.");
        isSystemSms("Карта ****4680 подключена к услуге \"SMS-оповещение\". Тарифный план \"Информационный\". Хотите пополнить мобильный с карты? Отправьте \"minb*4680*100\" на номер 79067886411");
        isSystemSms("Vhod v bank-klient. 16.01.2018 06:06:30MSK. IP:95.188.118.210. Login: ***001");
        isSystemSms("Сбербанк Онлайн. Внимательно проверьте реквизиты операции: карта списания **** 1224, карта зачисления **** 4160, сумма 2500,00 RUB. Пароль для подтверждения данной операции - 32783. Никому не сообщайте свой пароль и не подтверждайте операции в системе, которые Вы не совершали.");
        isSystemSms("ECMC4553 05.01.18 20:33 отмена покупки 1р Баланс: 22061.80р");
        isSystemSms("Для оплаты с карты VISA5196 телефона MegafonKV 9284494898 на 100р отправьте код 93197 на номер 900");
        isSystemSms("Валерий Владимирович, откройте вклад в Сбербанке и будьте уверены в сохранности Ваших средств. Сделайте это в любом отделении или в Сбербанк Онлайн (ставка выше, чем в отделении): https://sberbank.ru/sms/vkdl/  ПАО Сбербанк");
        isSystemSms("Vypiska ot 14.01 po karte *0658. Nachisleno protsentov: 156.52 rub. Cashback: 209 rub. Balans na 14.01: 30897.38 rub. Tinkoff.ru");
        isSystemSms("Android Pay подключен для карты *9498");
        isSystemSms("Отказ WWW.RZD.RU. Карта *1039. Недостаточно средств");
        isSystemSms("VTB-Online: Obrabotano rasporyazhenie 453580068 (Tele2).");
        isSystemSms("VTB-Online: Obrabotano rasporyazhenie 453581511 (Perevod  so svoey karti na kartu drugogo klienta VTB).");
        isSystemSms("Business: Kod podtverzhdeniya 905337");
        isSystemSms("Юлия, оформите карту Банка «Открытие» и получайте дополнительные преимущества! Оплачивайте картой ваши ежедневные покупки и получайте кешбэк, скидки на топливо или оплату поездок и многое другое. Подробнее: open.ru/cards_dcno, 88005003003. Банк «Открытие»");
        isSystemSms("Ваш код для входа в сервис \"Бизнес 365\": 1472");
        isSystemSms("Otmena \n" +
                "Pokupka \n" +
                "4301****2661 \n" +
                "Summa: 401.70 RUB \n" +
                "Term: GAZPROMNEFT AZS 022     > \n" +
                "MCC: 5541 \n" +
                "25.12.17 22:57");
        isSystemSms("Password 595369 PP N50 ot 22.12.2017 na summu 102,000.00 RUB sch deb: 40802810762450000819 sch cred: 40817810315010000002");
        isSystemSms("Password 807317");
        isSystemSms("Антон Валерьевич! УБРиР снижает ставки по кредитам! Предлагаем до 724000 р. под 17% годовых. Будем рады видеть Вас в отделениях ПАО КБ \"УБРиР\". 88001000200\n");
        isSystemSms("Отмена. Карта *1286. 1 RUB. YANDEX.TAXI. Доступно 16594.56 RUB");
        isSystemSms("Для перевода 500р получателю СВЕТЛАНА ГЕННАДЬЕВНА Б. на карту ECMC9922 с карты ECMC3179 отправьте код 97298 на номер 900. Комиссия не взимается. Добавьте сообщение получателю, набрав его после кода. Например, 97298 сообщение получателю.");
        isSystemSms("Автоплатеж \"Свет и одн\" с карты ECMC5700 на сумму 489.77 руб. будет исполнен 08.01.18. Комиссия 0.00 руб. Для отмены операции отправьте СМС с кодом 58622 на номер 900");
        isSystemSms("Автоплатеж \"Дет.Сад Ульяна\" произвел проверку: на текущий момент у Вас нет неоплаченных счетов. Проверка будет осуществляться каждые три дня. В случае появления новых счетов, вы получите СМС");
        isSystemSms("Иван Валерьевич, для оплаты счета от \"ПАО ТНС энерго НН\" за Лицевой счет 522042019435 на сумму 480.35 руб. с карты VISA4881 отправьте код 52429 на номер 900. Срок действия кода - 3 дня. Комиссия составит 0.00 руб. ПАО Сбербанк");
        isSystemSms("Иван Валерьевич, для оплаты счета от \"ДОМ.RU\" за Номер договора 520008419079 на сумму 841 руб. с карты VISA4881 отправьте код 63351 на номер 900. Срок действия кода - 3 дня. Комиссия составит 0.00 руб. ПАО Сбербанк");
        isSystemSms("VISA4881 03.01.18 19:25 отмена оплаты услуг 300р Баланс: 21401.53р");
        isSystemSms("Иван Валерьевич, если хранить сбережения, то в надежном банке! Откройте вклад в Сбербанке и будьте уверены в сохранности Ваших средств. Просто обратитесь в ближайшее отделение или оформите вклад в интернет - банке Сбербанк Онлайн по ставке выше, чем в отделении: https://sberbank.ru/sms/vkdl/  ПАО Сбербанк");
        isSystemSms("QUIK 13.01.18 21:39:08 Пароль для входа в систему 23513");
        isSystemSms("QUIK 16.01.2018 17:36:06  Поручение №41936390 на вывод 9000.00 RUR: счет 43X6N, Фондовый рынок. Пароль для подтверждения вывода 75522");
        isSystemSms("Сбербанк Онлайн. 16:35 09.01.18 Вам отправлено письмо из службы помощи.");
        isSystemSms("VISA4570: услуга Копилка на \"Управляй ОнЛ йн 6м - 1г руб. \" 10% от расходов подключена.");
        isSystemSms("VISA4570: услуга Копилка на \"Управляй ОнЛ йн 6м - 1г руб. \" 10% от зачислений подключена.");
        isSystemSms("Услуга Копилка на \"Управляй ОнЛ йн 3м - 6м руб. \" с карты VISA4570 отключена.");
        isSystemSms("VISA4570: не удалось пополнить Копилку \"Управляй ОнЛ йн 3м - 6м руб. \" на 6.5руб. по техническим причинам. Копилка 10% от расходов исполнена не будет.");
        isSystemSms("Сообщение доставлено. SMS successfully delivered.");
        isSystemSms("Александр Сергеевич, Вы можете оплатить новый счет от АО ДГК за Лицевой счет 052716306 на сумму 3206.34 руб. Для оплаты с карты VISA2374 отправьте SMS с кодом 65148 на номер 900 в течение трех дней. Комиссия составит 0.00 руб. ПАО Сбербанк");
        isSystemSms("Александр Сергеевич, Вы можете оплатить новый счет от АО ДГК за Лицевой счет 052716306 на сумму 3206.34 руб. Для оплаты с карты VISA2374 отправьте sms с кодом 65148 на номер 900 в течение трех дней. Комиссия составит 0.00 руб. ПАО Сбербанк");
        isSystemSms("ECMC5700 Баланс: 8334.84р");
        isSystemSms("Операция не выполнена. По телефону получателя не найдены карты для перевода.");
        isSystemSms("Любовь Владимировна, напоминаем Вам, что платеж по кредиту в размере 22598.20 RUR необходимо внести на Ваш счет сегодня до 21.00. Сбербанк");
        isSystemSms("Максим Юрьевич! Напоминаем, что Ваша карта Maestro находится в отделении Сбербанка по адресу: г.Новосибирск ул.Челюскинцев 30/1. Приглашаем Вас для ее получения. Сбербанк");
        isSystemSms("VISA3336 16.01.18 16:30 отмена выдачи наличных 500р ATM 191307 Баланс: 13807.91р");
        isSystemSms("Неизвестный смс-запрос. Отправьте СПРАВКА на номер 900, чтобы получить список популярных запросов.");
        isSystemSms("Сбербанк ОнЛайн. Канал доставки оповещений изменен на SMS.");
        isSystemSms("ЕЛЕНА СЕРГЕЕВНА! Уведомляем Вас о наличии просроченной задолженности по\n" +
                "Кредитной карте №5484 *** 8040 - 11.97 RUB на 06.01.2018\n" +
                "Тел. 88003333138. ПАО Сбербанк\n");
        isSystemSms("Для перевода 662.07руб. с карты VISA4570 по услуге Копилка на \"Управляй ОнЛ йн 3м - 6м руб. \" сверх установленного Вами лимита 500руб. отправьте СМС с кодом 14187 на номер 900.");
        isSystemSms("Не удалось исполнить Автоплатеж \"штрафы гибдд\": на карте VISA3872 недостаточно средств для оплаты счета на сумму 250 руб. Платеж будет проведен в течение трех дней после пополнения баланса карты");
        isSystemSms("Автоплатеж \"свет\" с карты VISA0619 отключен.");
        isSystemSms("Telecard; Card0020; ZAPROS BALANSA; 29.12.17 07:38:53; GAZPROMBANK; dostupno: 96.98 RUR");
        isSystemSms("Telecard; Card0125; OTMENA; Predauth; Summa 1 RUR; 06.01.18 12:35:40; YANDEX.TAXI; dostupno: 741.24 RUR");
        isSystemSms("Telecard; Card1691; Отказ. Превышен установленный лимит; 03.01.18 18:02:28; SHELE-FESHN KHAUS");
        isSystemSms("Олег Рудольфович, до 31.01.2018 для Вас действует специальное предложение! Кредит предварительно одобрен: сумма 600 000 руб., ставка 17,5% годовых. Успейте оформить кредит, либо кредитную карту в МКБ Онлайн online.mkb.ru. ПАО«МОСКОВСКИЙ КРЕДИТНЫЙ БАНК» тел. 88001004888 Не оферта.");
        isSystemSms("MKB Mobile: Odnorazoviy kod:3719 Ne soobschaite etot kod nikomu, vvodite ego tolko v MKB Mobile");
        isSystemSms("MKB Mobile: vhod v sistemu 16.01.2018 18:35:45 (MSK), blokirovka dostupa: SMS \"Online\" na +79037672667");
        isSystemSms("Ne soobschaite etot kod nikomu! Dlya podtverzhdeniya rashodnoi operacii v EUROAUTO na summu 920 RUB kod: 90151620");
        isSystemSms("MKB informiruet: 16.01.2018 vklad P11461815 popolnen. Podrobnee v MKB Mobile. https://mkb.ru/m/");
        isSystemSms("Введите код 9226 для подтверждения заявки на сайте МТС Банка.");
        isSystemSms("Vitaemo! Vy zarejestruvalysya v Oshchad 24/7. Uvijty: online.oschadbank.ua");
        isSystemSms("Vypolnen vhod v internet-bank PSB-Retail v 13:29 MSK. Esli Vy ne sovershali vhod, obratites' v Promsvyaz'bank po t.88003330303");
        isSystemSms("SMS51 Podtverdite vhod v internet-bank. Vvedite kod 280719");
        isSystemSms("667747 - код подтверждения. Подписание документа \"Заявление о предоставлении услуги SMS - подтверждения при входе\". Никому не говорите этот код. psbank.ru");
        isSystemSms("Выполнен вход в систему 10.01.2018 08:37:37 МСК. Если вы не совершали вход, обратитесь в Промсвязьбанк по т. 8 800 333 25 50.");
        isSystemSms("Akkaunt: 481776******8788 summa: 14000.00 RUB. Poluchatel: Visa Direct (Rossiia). Kod: 365193. Nikomu ego ne soobshchaite.");
        isSystemSms("Регистрация успешно завершена. Спасибо, что воспользовались нашим сервисом. Мобильное приложение кошелька: mob.qiwi.ru.");
        isSystemSms("9803 - код для регистрации в Visa QIWI Wallet. Никому не сообщайте.");
        isSystemSms("Karta **0368.Operacija rezervirovanija za pokupku ot 18/12/17 na summu 270.00 RUR otmenena. 18/01/18.");
        isSystemSms("Napominaem, 27.12.2017 predstoit spisanie platezha po Vashemu kreditu v razmere 12552.59 rub. VTB24");
        isSystemSms("Karta:5*2262; NLStarCom RUB 10 350.00 20/12/2017; 3DS SMS code:641608");
        isSystemSms("Karta *2262: Oplata  otklonena 112.00 EUR; Ticketmaster ES S.A.U.; 18.12.2017 23:18, dostupno 112910.45 RUR (v tom chisle kred. 112910.45 RUR)");
        isSystemSms("Karta: 5*8615; MOSENERGOSBYT, RUB 1 794.24 , 3DS SMS-code: 240980; 18/12/2017");
        isSystemSms("Minimal'nyj  platezh po karte *3149 sostavlyaet 15.66 RUR. (na 05.01.2018), data platezha 20.01.2018.  VTB");
        isSystemSms("Ocherednoj platezh po Vashemu kreditu sostavlyaet  7297.22 rub., data platezha  do 22.01.2018. VTB. Info online http://p.vtb24.ru/mob");
        isSystemSms("Dlya vhoda v VTB-Online:\n" +
                "\n" +
                "- parol': 548694 (neobhodimo smenit' do 03.01.2018 17:56)\n" +
                "- login: ispol'zujte nomer vashej karty ili login s cheka bankomata.\n" +
                "Skachajte prilozhenie p.vtb24.ru/mob ili zajdite na online.vtb.ru\n");
        isSystemSms("Karta *6929: spisanie  otkloneno  (nehvatka sredstv)4000.00 RUR; CARD2CARD ALFA_MOBILE; 17.01.2018 15:10, dostupno 2928.55 RUR.\n");
        isSystemSms("Vi voshli v mobilnoe prilozhenie VTB24-Online, 20.12.2017 18:49.");
        isSystemSms("11.01.18 08:47:59 \r\n" +
                "Vitaemo! Vy actyvuvaly kartky 4790-2998.\r\n" +
                "Detali 0800210800");
        isSystemSms("Pervaya chast' koda dlya snyatiya nalichnyh: 39758. Vtoraya chast' otpravlena na nomer 7012422225");
        isSystemSms("Konfidencialno. Kod podtverzhdenija: 5262. Vhod v Raiffeisen-Online. Po voprosam zvonite 88007000072. Raiffeisenbank");
        isSystemSms("Автоплатеж \"МТС\" с карты VISA6034 изменен. Дата следующего платежа 19.12.17");
        isSystemSms("VISA2906 заблокирована. Остаток на счете карты -149.92р");
        isSystemSms("Otkaz. Karta *0380. Summa 3420.00 RUB. Prevyshen rashodniy limit. MAXIMILIANS, CHELYABINSK. 30.11.2017 20:56. Dostupno s uchetom rashodnogo limita 1995.12 RUB. Tinkoff.ru");
        isSystemSms("Отказ DOROGAYA YA. Карта *7788. Неправильный ПИН-код");
        isSystemSms("Никому не сообщайте Ваш ключ: 2633. Перевод c карты Visa Classic + 489042******5665 на счет 40817810950500126989. Сумма 10000.00 RUR");
        isSystemSms("Гузель Хайдаровна, с наступающим Новым годом и Рождеством! Желаем постоянного движения вперед и достижения всех Ваших целей! Ваш Альфа-Банк");
        isSystemSms("Vam vistavlen schet 6572924 na summu 37891.54 RUR ot oblako.travel. Podtverdite schet na click.alfabank.ru ili Alfa-Mobile. Alfa-Bank");
        isSystemSms("Максим Валерьевич! Ваша заявка на кредитную карту \"Visa Classic 100 дней без %\" предварительно одобрена. Ожидайте звонка сотрудника банка для уточнения дополнительной информации.");
        isSystemSms("Людмила Рустамовна, ваш одноразовый код доступа – 3084. Сообщите его сотруднику Альфа-Банка для идентификации");
        isSystemSms("Для внесения в банкомате Альфа-Банка на счет 408*632 код 2369");
        isSystemSms("Экономьте свое время – совершайте платежи по карте Сбербанка по SMS.\r\n" +
                "Отправьте на номер 900:" +
                "Для оплаты своего мобильного на 100р БЕЗ КОМИССИИ: «100»." +
                "Для перевода 500р  на карту получателя по номеру его телефона: «ПЕРЕВОД 9ХХХХХХХХХ 500»");
        isSystemSms("15.01.2018; Информация по кредитной карте 5570****2518:  Минимальный " +
                "платеж не оплачен в сумме: 802.10RUR Срок платежа: до 25.01.2018. Обращаем " +
                "Ваше внимание! При погашении кредита через банкоматы, киоски или систему " +
                "Телебанк, денежные средства поступят на счет на следующий рабочий день. ");

        // загружаем данные из файла
        checkFile(ConstTests.SYSTEM_SMS_ALL);
        checkFile(ConstTests.SYSTEM_SMS_RAIFFEISEN);
    }

    private void checkFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fileReader = new FileReader(file);

        StringBuilder cmdStrBuilder = new StringBuilder();

        int i;
        while ((i = fileReader.read()) != -1) {
            cmdStrBuilder.append((char) i);
        }

        String[] system_sms = cmdStrBuilder.toString().split("\n\n");
        for(String sms: system_sms){
            isSystemSms(sms);
        }

        fileReader.close();
    }

    @Test
    public void MainSmsParserTest() throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse(new File(ConstTests.BANK_SMS_XML));

        // Проверка банков
        new TinkoffSmsTest(xmlDocument).check();
        new SberbankSmsTest(xmlDocument).check();
        new AlfabankSmsTest(xmlDocument).check();
        new Vtb24SmsTest(xmlDocument).check();
        new GazpromSmsTest(xmlDocument).check();
        new QiwiSmsTest(xmlDocument).check();
        new MinbankSmsTest(xmlDocument).check();
        new SbsIbankSmsTest(xmlDocument).check();
        new UbrrSmsTest(xmlDocument).check();
        new BinbankSmsTest(xmlDocument).check();
        new RaiffeisenSmsTest(xmlDocument).check();
        new MTSSmsTest(xmlDocument).check();
        new UnicreditSmsTest(xmlDocument).check();
        new OschadbankSmsTest(xmlDocument).check();
        new KaspibankSmsTest(xmlDocument).check();
        new HalykbankSmsTest(xmlDocument).check();
        new QazkomSmsTest(xmlDocument).check();
        new BelarusbankSmsTest(xmlDocument).check();
        new PriorBankSmsTest(xmlDocument).check();
        new MTBankSmsTest(xmlDocument).check();
        new OtkritieSmsTest(xmlDocument).check();
        new MKBSmsTest(xmlDocument).check();
        new RosbankSmsTest(xmlDocument).check();
        new RosselhozSmsTest(xmlDocument).check();
        new PromsvyazbankSmsTest(xmlDocument).check();
        new RocketBankSmsTest(xmlDocument).check();
        new ChelinvestSmsTest(xmlDocument).check();
        new AvangardSmsTest(xmlDocument).check();
        new BelbankSmsTest(xmlDocument).check();
        new BelapbSmsTest(xmlDocument).check();
        new ParitetbankSmsTest(xmlDocument).check();
        new KreditEuroBankSmsTest(xmlDocument).check();
        new AkbarsSmsTest(xmlDocument).check();
        new PochtaBankSmsTest(xmlDocument).check();
        new KartaSovestSmsTest(xmlDocument).check();
        new RaiffeisenUkSmsTest(xmlDocument).check();
        new UkrsibbankSmsTest(xmlDocument).check();
        new RnkbSmsTest(xmlDocument).check();
        new FortebankSmsTest(xmlDocument).check();
        new BelgazprombankSmsTest(xmlDocument).check();
        new VozrogdenieSmsTest(xmlDocument).check();
        new YandexmoneySmsTest(xmlDocument).check();
        new HomecreditSmsTest(xmlDocument).check();
    }
}

