package com.skmmobile.banksmsparser;


import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class SmsXmlFileTests extends Assert{

    private static String getAttribute(Node node, String name){
        Node attr = node.getAttributes().getNamedItem(name);
        return attr == null ? "" : attr.getNodeValue();
    }

    public void loadXmlParser() throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File(ConstTests.BANK_SMS_XML));

        BankSmsParser bankParser = XmlBankParser.obtain(xmlDocument, "alfabank");

        assertEquals("alfabank", bankParser.getBankName());
        assertTrue("Шаблон не содержит данных", bankParser.getOperationCount() > 0);
    }

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

    public void impBankInfo() throws Exception{
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File("files/banks.xml"));
        NodeList bankList = xmlDocument.getElementsByTagName("bank");
        Iterator<Node> iterator = XmlNodeIterator.obtain(bankList);
        while (iterator.hasNext()){
            Node node = iterator.next();
            System.out.println(getAttribute(node, "caption")+": " + getAttribute(node, "serv_numbers"));
        }
    }

    @Test
    public void checkDuplicatePhones() throws Exception {

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document xmlDocument = docBuilder.parse (new File(ConstTests.BANK_SMS_XML));
        NodeList bankPhoneList = xmlDocument.getElementsByTagName("service_phone");
        Map<String, String[]> bankPhonesMap = new HashMap<>();
        Iterator<Node> iterator = XmlNodeIterator.obtain(bankPhoneList);
        while (iterator.hasNext()){
            Node phones = iterator.next();
            String bankId = getAttribute(phones, "bankId");
            String phoneStr = phones.getFirstChild().getNodeValue();
            bankPhonesMap.put(bankId, phoneStr.split(","));
        }

        for(String bank1: bankPhonesMap.keySet()){
            String[] phones1 = bankPhonesMap.get(bank1);
            for(String phone1: phones1){
                for(String bank2: bankPhonesMap.keySet()){
                    if(!bank2.equals(bank1)){
                        String[] phones2 = bankPhonesMap.get(bank2);
                        for (String phone2 : phones2)
                            assertNotEquals(bank1 + " и " + bank2 + " содержат тел: " + phone1, phone1, phone2);
                    }
                }
            }
        }
    }

    private static class XmlNodeIterator implements Iterator<Node>{
        private int curId =-1;
        private int count = 0;
        private NodeList nodeList;

        private XmlNodeIterator(NodeList nodeList){
            this.nodeList = nodeList;
            count = nodeList.getLength();
        }

        static Iterator<Node> obtain(NodeList nodeList){
            return new XmlNodeIterator(nodeList);
        }

        @Override
        public boolean hasNext() {
            return count != 0 && (curId < count - 1);
        }

        @Override
        public Node next() {
            return !hasNext() ? null : nodeList.item(++curId);
        }

        @Override
        public void remove() {
            throw new RuntimeException("not implemented");
        }
    }
}