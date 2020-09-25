package com.skmmobile.banksmsparser.parser;

import java.util.regex.Pattern;

public class SmsPattern {
    final String type;
    Pattern typeRex;
    Pattern cardIdRex;
    Pattern amountRex;
    Pattern dateRex;
    Pattern detailRex;
    int cardIdRexGroup = 0;
    int amountRexGroup = 0;
    int dateRexGroup = 0;
    int detailRexGroup = 0;
    String defCardId = "";
    CharSequence decChar = ".";
    CharSequence decDelim = "";

    public SmsPattern(String type) {
        this.type = type;
    }

    public void setTypePattern(String s) {
        typeRex = Pattern.compile(s);
    }

    public void setCardIdRex(String s) {
        cardIdRex = Pattern.compile(s);
    }

    public void setCardIdRex(String s, int group) {
        cardIdRex = Pattern.compile(s);
        cardIdRexGroup = group;
    }

    public void setAmountRex(String s) {
        amountRex = Pattern.compile(s);
    }

    public void setAmountRex(String s, int group) {
        amountRex = Pattern.compile(s);
        amountRexGroup = group;
    }

    public void setDateRex(String s) {
        dateRex = Pattern.compile(s);
    }

    public void setDetailRex(String s) {
        detailRex = Pattern.compile(s);
    }

    public void setDetailRex(String s, int group) {
        detailRex = Pattern.compile(s);
        detailRexGroup = group;
    }

    public void setDecChar(CharSequence decChar) {
        this.decChar = decChar;
    }

    public void setDecDelim(CharSequence decDelim) {
        this.decDelim = decDelim;
    }

    public void setDefCardId(String defCardId) {
        this.defCardId = defCardId;
    }
}
