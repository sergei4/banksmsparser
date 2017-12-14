package com.skmmobile.banksmsparser;


import com.sun.org.apache.xerces.internal.dom.DeferredCDATASectionImpl;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class XmlBankParser extends BankSmsParser {

    private static final String ATTR_ID       = "id";
    private static final String ATTR_NAME     = "name";
    private static final String ATTR_CATEGORY = "category";
    private static final String ATTR_GROUP    = "group";

    private static final String NODE_BANK     = "bank";
    private static final String NODE_PATTERN  = "pattern";
    private static final String NODE_MATCH    = "match";
    private static final String NODE_CARD_ID  = "cardId";
    private static final String NODE_AMOUNT   = "amount";
    private static final String NODE_DETAIL   = "detail";
    private static final String NODE_DEC_CHAR = "decimal_char";
    private static final String NODE_DEC_GROUP_CAHR = "decimal_group_char";

    private String bankName;

    private static String getAttribute(Node node, String name){
        Node attr = node.getAttributes().getNamedItem(name);
        return attr == null ? "" : attr.getNodeValue();
    }

    private static int getIntAttribute(Node node, String name){
        String value = getAttribute(node, name);
        return value.equals("") ? 0 : Integer.valueOf(value);
    }

    private PatternParameter obtainPatternParameter(Node paramNode){
        PatternParameter patternParameter = new PatternParameter();
        patternParameter.group = getIntAttribute(paramNode, ATTR_GROUP);

        NodeList childNodeList = paramNode.getChildNodes();
        int count = childNodeList.getLength();
        for(int i=0; i<count; i++){
            Node node = childNodeList.item(i);
            if(node.getNodeType() == Node.CDATA_SECTION_NODE){
                patternParameter.patternStr = ((DeferredCDATASectionImpl) node).getData();
            }

        }
        return patternParameter;
    }

    public static List<String> obtainBankIdList(Document document) {
        NodeList bankList = document.getElementsByTagName(NODE_BANK);
        List<String> result = new ArrayList<>();
        int count = bankList.getLength();
        for (int i = 0; i < count; i++) {
            result.add(getAttribute(bankList.item(i), ATTR_ID));
        }
        return result;
    }

    public void init(Document document, String bankName){
        NodeList bankList = document.getElementsByTagName(NODE_BANK);
        int count = bankList.getLength();
        for (int i = 0; i < count; i++) {
            Node bank = bankList.item(i);
            String xBankName = getAttribute(bank, ATTR_ID);
            if (xBankName.equals(bankName)) {
                this.bankName = xBankName;
                NodeList bankChildNodes = bank.getChildNodes();
                int childCount = bankChildNodes.getLength();
                for (int j = 0; j < childCount; j++) {
                    Node bankChildNode = bankChildNodes.item(j);
                    if(bankChildNode.getNodeType() == Node.ELEMENT_NODE && bankChildNode.getNodeName().equals(NODE_PATTERN)){
                        String category = getAttribute(bankChildNode, ATTR_CATEGORY);
                        Operation operation = new Operation(category);
                        NodeList patternParams = bankChildNode.getChildNodes();
                        int paramCount = patternParams.getLength();
                        for (int cp = 0; cp < paramCount; cp++) {
                            Node parameterNode = patternParams.item(cp);
                            if(parameterNode.getNodeType() == Node.ELEMENT_NODE){
                                PatternParameter parameter;
                                switch (parameterNode.getNodeName()){
                                    case NODE_MATCH:
                                        parameter = obtainPatternParameter(parameterNode);
                                        operation.setTypePattern(parameter.patternStr);
                                        break;
                                    case NODE_CARD_ID:
                                        parameter = obtainPatternParameter(parameterNode);
                                        operation.setCardIdRex(parameter.patternStr, parameter.group);
                                        break;
                                    case NODE_AMOUNT:
                                        parameter = obtainPatternParameter(parameterNode);
                                        operation.setAmountRex(parameter.patternStr, parameter.group);
                                        break;
                                    case NODE_DETAIL:
                                        parameter = obtainPatternParameter(parameterNode);
                                        operation.setDetailRex(parameter.patternStr, parameter.group);
                                        break;
                                    case NODE_DEC_CHAR:
                                        String decChar = parameterNode.getFirstChild().getNodeValue();
                                        operation.setDecChar(decChar);
                                        break;
                                    case NODE_DEC_GROUP_CAHR:
                                        String decGropChar = parameterNode.getFirstChild().getNodeValue();
                                        operation.setDecDelim(decGropChar);
                                        break;
                                }
                            }
                        }
                        addOperationTemplate(operation);
                    }
                }
            }
        }
    }

    public static class Builder {
        private String bankName;
        private Document document;

        public static Builder newInstance(){
            return new Builder();
        }

        public Builder setXmlDocument(Document document){
            this.document = document;
            return this;
        }

        public Builder setBankName(String bankName){
            this.bankName = bankName;
            return this;
        }

        public XmlBankParser build(){
            XmlBankParser instance = new XmlBankParser();
            instance.init(document, bankName);
            return instance;
        }
    }

    private static class PatternParameter{
        String patternStr;
        int group;
    }

    public String getBankName() {
        return bankName != null ? bankName : "";
    }
}
