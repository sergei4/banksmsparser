package com.skmmobile.banksmsparser.bank;

import com.skmmobile.banksmsparser.BankSmsParser;
import com.skmmobile.banksmsparser.XmlBankParser;
import org.junit.Assert;
import org.w3c.dom.Document;

import java.math.BigDecimal;

public abstract class AbsXmlBankSmsTest extends Assert{
    protected String bankName;
    protected BankSmsParser parser;

    private static final String RESULT_IS_NULL = "Не удалось разобрать строку";

    public AbsXmlBankSmsTest(String bankName, Document xmlDocument) {
        this.bankName = bankName;
        this.parser = XmlBankParser.obtain(xmlDocument, bankName);
    }

    protected void checkBankSms(BankSmsParser parser, String smsText, String type, String cardId, String amountStr, String details){
        checkBankSms(parser, smsText, type, cardId, amountStr, details, "", "0");
    }

    /**
     * Основной метод для проверки смс
     * @param parser
     * @param smsText
     * @param type
     * @param cardId
     * @param amountStr
     * @param details
     * @param currency
     * @param commissionStr
     */
    protected void checkBankSms(BankSmsParser parser, String smsText, String type, String cardId, String amountStr, String details, String currency, String commissionStr){
        BankSmsParser.Result result;
        BigDecimal amount;
        BigDecimal commission;

        Assert.assertFalse("Смс определилось как служебное", BankSmsParser.isSystemBankSms(smsText));
        result = parser.parseSms(smsText);
        assertNotNull(RESULT_IS_NULL, result);
        assertEquals(type, result.getType());
        assertEquals(cardId, result.getCardIdStr());
        amount = new BigDecimal(amountStr);
        assertTrue("Проверьте сумму. Ожидалось: " + result.getAmount().toPlainString(),result.getAmount().compareTo(amount) == 0);
        assertEquals(details, result.getDetails());
        commission = new BigDecimal(commissionStr);
        assertTrue("Проверьте сумму. Ожидалось: " + result.getCommission().toPlainString(),result.getCommission().compareTo(commission) == 0);
        assertEquals("Валюта определена с ошибкой", currency, result.getCurrency());
    }

    protected abstract void smsTest();

    public void check() {
        assertEquals(bankName, parser.getBankName());
        assertTrue("BankSmsParser содержит дубликаты", parser.validate());
        smsTest();
    }
}