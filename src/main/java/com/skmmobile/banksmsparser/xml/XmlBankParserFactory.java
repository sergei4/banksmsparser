package com.skmmobile.banksmsparser.xml;

import com.skmmobile.banksmsparser.BankSmsParser;
import com.skmmobile.banksmsparser.SmsParserFactory;
import com.skmmobile.banksmsparser.parser.BaseBankSmsParser;
import com.skmmobile.banksmsparser.parser.SmsPattern;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XmlBankParserFactory implements SmsParserFactory {

    private static final String ATTR_ID = "id";
    private static final String ATTR_BANK_ID = "bankId";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_CATEGORY = "category";
    private static final String ATTR_GROUP = "group";
    private static final String ATTR_DEFAULT = "default";

    private static final String NODE_BANKS = "banks";
    private static final String NODE_BANK = "bank";
    private static final String NODE_PHONES = "bank_phones";
    private static final String NODE_PHONE = "phone";
    private static final String NODE_SERVICE_PHONE = "service_phone";
    private static final String NODE_SYSTEM_SMS = "system_sms";
    private static final String NODE_PATTERNS = "patterns";
    private static final String NODE_PATTERN = "pattern";
    private static final String NODE_MATCH = "match";
    private static final String NODE_CARD_ID = "cardId";
    private static final String NODE_AMOUNT = "amount";
    private static final String NODE_DETAIL = "detail";
    private static final String NODE_DEC_CHAR = "decimal_char";
    private static final String NODE_DEC_GROUP_CHAR = "decimal_group_char";

    private final Document document;

    public XmlBankParserFactory(Document document) {
        this.document = document;
    }

    private static String getAttribute(Node node, String name) {
        Node attr = node.getAttributes().getNamedItem(name);
        return attr == null ? "" : attr.getNodeValue();
    }

    private static int getIntAttribute(Node node, String name) {
        String value = getAttribute(node, name);
        return value.equals("") ? 0 : Integer.parseInt(value);
    }

    private PatternParameter obtainPatternParameter(Node paramNode) {
        PatternParameter patternParameter = new PatternParameter();
        patternParameter.group = getIntAttribute(paramNode, ATTR_GROUP);

        NodeList childNodeList = paramNode.getChildNodes();
        int count = childNodeList.getLength();
        for (int i = 0; i < count; i++) {
            Node node = childNodeList.item(i);
            if (node.getNodeType() == Node.CDATA_SECTION_NODE) {
                patternParameter.patternStr = node.getNodeValue();
            }
        }
        return patternParameter;
    }

    @Deprecated
    public static List<String> obtainBankIdList(Document document) {
        NodeList bankList = document.getElementsByTagName(NODE_BANK);
        List<String> result = new ArrayList<>();
        int count = bankList.getLength();
        for (int i = 0; i < count; i++) {
            result.add(getAttribute(bankList.item(i), ATTR_ID));
        }
        return result;
    }

    @Deprecated
    public static void obtainBankPhoneMap(Map<String, String> phoneMap, Document document) {
        NodeList bankList;
        bankList = document.getElementsByTagName(NODE_SERVICE_PHONE);
        int count = bankList.getLength();
        for (int i = 0; i < count; i++) {
            String bankId = getAttribute(bankList.item(i), ATTR_BANK_ID);
            String phoneStr = bankList.item(i).getFirstChild().getNodeValue();
            String[] phoneList = phoneStr.split(",");
            for (String phone : phoneList)
                phoneMap.put(phone, bankId);
        }
    }

    public List<String> createSystemSmsPatternList() {
        NodeList smsNodeList = document.getElementsByTagName(NODE_SYSTEM_SMS);
        List<String> result = new ArrayList<>();
        int count = smsNodeList.getLength();
        for (int i = 0; i < count; i++) {
            NodeList smsNodeParams = smsNodeList.item(i).getChildNodes();
            int itemCount = smsNodeParams.getLength();
            for (int j = 0; j < itemCount; j++) {
                Node node = smsNodeParams.item(j);
                if (node.getNodeType() == Node.CDATA_SECTION_NODE) {
                    result.add(node.getNodeValue());
                }
            }
        }
        return result;
    }

    public BankSmsParser createSmsParser(String bankName) {
        List<SmsPattern> operations = new ArrayList<>();
        NodeList bankPatternsList = document.getElementsByTagName(NODE_PATTERNS);
        int count = bankPatternsList.getLength();
        for (int i = 0; i < count; i++) {
            Node bank = bankPatternsList.item(i);
            String xBankName = getAttribute(bank, ATTR_BANK_ID);
            if (xBankName.equals(bankName)) {
                bankName = xBankName;
                NodeList bankChildNodes = bank.getChildNodes();
                int childCount = bankChildNodes.getLength();
                for (int j = 0; j < childCount; j++) {
                    Node bankChildNode = bankChildNodes.item(j);
                    if (bankChildNode.getNodeType() == Node.ELEMENT_NODE && bankChildNode.getNodeName().equals(NODE_PATTERN)) {
                        String category = getAttribute(bankChildNode, ATTR_CATEGORY);
                        SmsPattern smsPattern = new SmsPattern(category);
                        NodeList patternParams = bankChildNode.getChildNodes();
                        int paramCount = patternParams.getLength();
                        for (int cp = 0; cp < paramCount; cp++) {
                            Node parameterNode = patternParams.item(cp);
                            if (parameterNode.getNodeType() == Node.ELEMENT_NODE) {
                                PatternParameter parameter;
                                switch (parameterNode.getNodeName()) {
                                    case NODE_MATCH:
                                        parameter = obtainPatternParameter(parameterNode);
                                        smsPattern.setTypePattern(parameter.patternStr);
                                        break;
                                    case NODE_CARD_ID:
                                        parameter = obtainPatternParameter(parameterNode);
                                        smsPattern.setCardIdRex(parameter.patternStr, parameter.group);
                                        smsPattern.setDefCardId(getAttribute(parameterNode, ATTR_DEFAULT));
                                        break;
                                    case NODE_AMOUNT:
                                        parameter = obtainPatternParameter(parameterNode);
                                        smsPattern.setAmountRex(parameter.patternStr, parameter.group);
                                        break;
                                    case NODE_DETAIL:
                                        parameter = obtainPatternParameter(parameterNode);
                                        smsPattern.setDetailRex(parameter.patternStr, parameter.group);
                                        break;
                                    case NODE_DEC_CHAR:
                                        String decChar = parameterNode.getFirstChild().getNodeValue();
                                        smsPattern.setDecChar(decChar);
                                        break;
                                    case NODE_DEC_GROUP_CHAR:
                                        String decGropChar = parameterNode.getFirstChild().getNodeValue();
                                        smsPattern.setDecDelim(decGropChar);
                                        break;
                                }
                            }
                        }
                        operations.add(smsPattern);
                    }
                }
            }
        }

        return new BaseBankSmsParser(bankName, operations);
    }

    private static class PatternParameter {
        String patternStr;
        int group;
    }
}
