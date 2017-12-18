package com.skmmobile.banksmsparser;


import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class LoadXmlParserTests extends Assert{

    @Test
    public void loadXmlParser() throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File(ConstTests.BANK_SMS_XML));

        XmlBankParser bankParser = new XmlBankParser();
        bankParser.init(xmlDocument, "alfabank");

        assertEquals("alfabank", bankParser.getBankName());
        assertTrue("Шаблон не содержит данных", bankParser.getOperationCount() > 0);
    }

    @Test
    public void getBankIdListTest() throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File(ConstTests.BANK_SMS_XML));

        System.out.println("Список банков:");
        List<String> ids = XmlBankParser.obtainBankIdList(xmlDocument);
        for(String id: ids)
            System.out.println(id);

        assertTrue("Шаблон не содержит данных", ids.size() > 0);

        System.out.println("\nСписок телефонов:");
        Map<String, String> phones = XmlBankParser.obtainBankPhoneMap(xmlDocument);
        for(String phone: phones.keySet())
            System.out.println(phone + ": " + phones.get(phone));

        System.out.println("\nСписок системных смс:");
        List<String> systemSms = XmlBankParser.obtainSystemSmsPatternList(xmlDocument);
        for(String sms: systemSms)
            System.out.println(sms);
    }
}