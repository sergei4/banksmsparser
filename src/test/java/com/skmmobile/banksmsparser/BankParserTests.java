package com.skmmobile.banksmsparser;

import com.skmmobile.banksmsparser.bank.AlfabankSmsTest;
import com.skmmobile.banksmsparser.bank.BinbankSmsTest;
import com.skmmobile.banksmsparser.bank.GazpromSmsTest;
import com.skmmobile.banksmsparser.bank.MTSSmsTest;
import com.skmmobile.banksmsparser.bank.QiwiSmsTest;
import com.skmmobile.banksmsparser.bank.RaiffeisenSmsTest;
import com.skmmobile.banksmsparser.bank.SberbankSmsTest;
import com.skmmobile.banksmsparser.bank.TinkoffSmsTest;
import com.skmmobile.banksmsparser.bank.UbrrSmsTest;
import com.skmmobile.banksmsparser.bank.UnicreditSmsTest;
import com.skmmobile.banksmsparser.bank.Vtb24SmsTest;
import com.skmmobile.banksmsparser.bank.by.BelarusbankSmsTest;
import com.skmmobile.banksmsparser.bank.by.MTBankSmsTest;
import com.skmmobile.banksmsparser.bank.by.MinbankSmsTest;
import com.skmmobile.banksmsparser.bank.by.PriorBankSmsTest;
import com.skmmobile.banksmsparser.bank.by.SbsIbankSmsTest;
import com.skmmobile.banksmsparser.bank.kz.HalykbankSmsTest;
import com.skmmobile.banksmsparser.bank.kz.KaspibankSmsTest;
import com.skmmobile.banksmsparser.bank.kz.QazkomSmsTest;
import com.skmmobile.banksmsparser.bank.uk.OschadbankSmsTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class BankParserTests extends Assert {

    private void isSystemSms(String text){
        Assert.assertTrue("Не удалось распознать служебное смс", BankSmsParser.isSystemBankSms(text));
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
    public void XmlIsSystemSmsTest() throws Exception{
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
    }

    @Test
    public void MainSmsParserTest() throws Exception {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse(new File(ConstTests.BANK_SMS_XML));

        // Проверка банков
        new TinkoffSmsTest(xmlDocument){}.check();
        new SberbankSmsTest(xmlDocument){}.check();
        new AlfabankSmsTest(xmlDocument){}.check();
        new Vtb24SmsTest(xmlDocument){}.check();
        new GazpromSmsTest(xmlDocument){}.check();
        new QiwiSmsTest(xmlDocument){}.check();
        new MinbankSmsTest(xmlDocument){}.check();
        new SbsIbankSmsTest(xmlDocument){}.check();
        new UbrrSmsTest(xmlDocument){}.check();
        new BinbankSmsTest(xmlDocument){}.check();
        new RaiffeisenSmsTest(xmlDocument){}.check();
        new MTSSmsTest(xmlDocument){}.check();
        new UnicreditSmsTest(xmlDocument){}.check();
        new OschadbankSmsTest(xmlDocument){}.check();
        new KaspibankSmsTest(xmlDocument){}.check();
        new HalykbankSmsTest(xmlDocument){}.check();
        new QazkomSmsTest(xmlDocument){}.check();
        new BelarusbankSmsTest(xmlDocument){}.check();
        new PriorBankSmsTest(xmlDocument){}.check();
        new MTBankSmsTest(xmlDocument){}.check();
    }
}

