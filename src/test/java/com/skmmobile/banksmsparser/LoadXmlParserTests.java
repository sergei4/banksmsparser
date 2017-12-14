package com.skmmobile.banksmsparser;


import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class LoadXmlParserTests extends Assert{

    @Test
    public void loadXmlParser() throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File("banksmsparser/files/banksmspatterns.xml"));

        XmlBankParser bankParser = new XmlBankParser();
        bankParser.init(xmlDocument, "alfabank");

        assertEquals("alfabank", bankParser.getBankName());
        assertTrue("Шаблон не содержит данных", bankParser.getOperationCount() > 0);

    }

    @Test
    public void getBankIdListTest() throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File("banksmsparser/files/banksmspatterns.xml"));

        List<String> ids = XmlBankParser.obtainBankIdList(xmlDocument);
        for(String id: ids)
            System.out.println(id);
    }
}
