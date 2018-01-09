package com.skmmobile.banksmsparser;

import com.skmmobile.banksmsparser.bank.*;
import com.skmmobile.banksmsparser.bank.by.MinbankSmsTest;
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
import java.math.BigDecimal;

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
    }
}

