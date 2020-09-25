package com.skmmobile.banksmsparser;

import java.util.List;

public interface SmsParserFactory {
    BankSmsParser createSmsParser(String bankName);

    List<String> createSystemSmsPatternList();
}
