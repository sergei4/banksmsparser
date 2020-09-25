package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import com.skmmobile.banksmsparser.SmsParserFactory;
import com.skmmobile.banksmsparser.SmsTypeValidator;
import com.skmmobile.banksmsparser.parser.BaseBankSmsParser;
import com.skmmobile.banksmsparser.parser.SystemSmsValidator;
import org.junit.Assert;

import java.math.BigDecimal;

public abstract class AbsXmlBankSmsTest extends Assert {
    protected String bankName;
    protected BankSmsParser parser;
    private final SmsTypeValidator systemSmsValidator;

    private static final String RESULT_IS_NULL = "Не удалось разобрать строку";

    public AbsXmlBankSmsTest(String bankName, SmsParserFactory smsParserFactory) {
        this.bankName = bankName;
        this.parser = smsParserFactory.createSmsParser(bankName);
        this.systemSmsValidator = new SystemSmsValidator(smsParserFactory.createSystemSmsPatternList());
    }

    protected void checkBankSms(String smsText, String type, String cardId, String amountStr) {
        checkBankSms(parser, smsText, type, cardId, amountStr, "");
    }

    protected void checkBankSms(String smsText, String type, String cardId, String amountStr, String details) {
        checkBankSms(parser, smsText, type, cardId, amountStr, details);
    }

    protected void checkBankSms(BankSmsParser parser, String smsText, String type, String cardId, String amountStr, String details) {
        BaseBankSmsParser.Result result;
        BigDecimal amount;

        Assert.assertFalse("Смс определилось как служебное", systemSmsValidator.validate(smsText));
        result = parser.parseSms(smsText);
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals(type, result.getType());
        assertEquals(cardId, result.getCardIdStr());
        amount = new BigDecimal(amountStr);
        assertTrue("Проверьте сумму. Ожидалось: " + result.getAmount().toPlainString(), result.getAmount().compareTo(amount) == 0);
        assertEquals(details, result.getDetails());
    }

    protected abstract void smsTest();

    public void check() {
//        assertEquals(bankName, parser.getBankName());
//        assertTrue("BankSmsParser содержит дубликаты", parser.check());
        smsTest();
    }
}
