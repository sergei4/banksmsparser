package com.skmmobile.banksmsparser.parser;

import com.skmmobile.banksmsparser.SmsTextNormalizer;
import com.skmmobile.banksmsparser.SmsTypeValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SystemSmsValidator implements SmsTypeValidator {

    private SmsTextNormalizer normalizer = new BaseSmsTextNormalizer();

    private List<Pattern> patterns;

    public SystemSmsValidator(List<String> stringPattern) {
        this.patterns = new ArrayList<>();
        for (String s : stringPattern) {
            patterns.add(Pattern.compile(s));
        }
    }

    @Override
    public boolean validate(String smsText) {
        String text = normalizer.normalize(smsText);
        for (Pattern p : patterns) {
            if (p.matcher(text).matches()) {
                return true;
            }
        }
        return false;
    }
}
