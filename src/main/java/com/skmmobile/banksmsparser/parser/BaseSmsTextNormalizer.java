package com.skmmobile.banksmsparser.parser;

import com.skmmobile.banksmsparser.SmsTextNormalizer;

public class BaseSmsTextNormalizer implements SmsTextNormalizer {
    @Override
    public String normalize(String text) {
        char[] chars = text.toCharArray();
        int size = chars.length;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char c = chars[i];
            if (c == '\n' | c == '\r') {
                result.append(" ");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
