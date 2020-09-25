package com.skmmobile.banksmsparser.parser;

import com.skmmobile.banksmsparser.BankSmsParser;
import com.skmmobile.banksmsparser.Context;
import com.skmmobile.banksmsparser.SmsTextNormalizer;
import com.sun.istack.internal.NotNull;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;

public class BaseBankSmsParser implements BankSmsParser {

    private final String bankName;
    private final List<SmsPattern> operations;
    private final SmsTextNormalizer normalizer = new BaseSmsTextNormalizer();

    public BaseBankSmsParser(String bankName, List<SmsPattern> operations) {
        this.bankName = bankName;
        this.operations = operations;
    }

    @Deprecated
    protected void addOperationTemplate(SmsPattern operation) {
        operations.add(operation);
    }

    public String getBankName() {
        return bankName;
    }

    public int getOperationCount() {
        return operations.size();
    }

    public Result parseSms(String smsText) {
        String text = normalizer.normalize(smsText);
        SmsPattern curOperation = null;
        String cardId = null;
        BigDecimal amount = null;
        Date date = null;
        String details = null;

        for (SmsPattern operation : operations) {
            if (operation.typeRex.matcher(text).matches()) {
                curOperation = operation;
                cardId = parseCardId(operation, text);
                amount = parseAmount(operation, text);
                date = parseDate(operation, text);
                details = parseDetails(operation, text);
            }
        }

        if (curOperation == null) {
            return null;
        }

        if (cardId.equals("") || amount == null || amount.compareTo(BigDecimal.ZERO) == 0) {

            Context.LOGGER.debug(text);

            Context.LOGGER.debug("pattern:" + curOperation.typeRex.pattern());
            Context.LOGGER.debug(curOperation.cardIdRex != null ? "cardId: " + curOperation.cardIdRex.pattern() + "; group=" + curOperation.cardIdRexGroup : "cardId: no pattern!!!");
            Context.LOGGER.debug(curOperation.amountRex != null ? "amount: " + curOperation.amountRex.pattern() + "; group=" + curOperation.amountRexGroup : "amount: no pattern!!!");
            Context.LOGGER.debug(curOperation.dateRex != null ? "date: " + curOperation.dateRex.pattern() + "; group=" + curOperation.dateRexGroup : "date: no pattern!!!");
            Context.LOGGER.debug(curOperation.detailRex != null ? "details: " + curOperation.detailRex.pattern() + "; group=" + curOperation.detailRexGroup : "details: no pattern!!!");

            return null;
        }

        return new Result(curOperation.type, cardId, amount, date, details);
    }

    @NotNull
    private String parseCardId(SmsPattern operation, String text) {
        Matcher m;
        if (operation.cardIdRex != null) {
            m = operation.cardIdRex.matcher(text);
            if (m.find()) {
                return m.group(operation.cardIdRexGroup);
            } else {
                return operation.defCardId;
            }
        }
        return "";
    }

    @NotNull
    private BigDecimal parseAmount(SmsPattern operation, String text) {
        Matcher m;
        if (operation.amountRex != null) {
            m = operation.amountRex.matcher(text);
            if (m.find()) {
                try {
                    String src = m.group(operation.amountRexGroup);
                    src = operation.decDelim.equals("") ? src : src.replace(operation.decDelim, "");
                    src = src.replace(operation.decChar, ".");
                    return new BigDecimal(src);
                } catch (Exception e) {
                    return BigDecimal.ZERO;
                }
            } else {
                return BigDecimal.ZERO;
            }
        }
        return BigDecimal.ZERO;
    }

    private Date parseDate(SmsPattern operation, String text) {
        return null;
    }

    @NotNull
    private String parseDetails(SmsPattern operation, String text) {
        Matcher m;
        if (operation.detailRex != null) {
            m = operation.detailRex.matcher(text);
            if (m.find()) {
                return m.group(operation.detailRexGroup);
            } else {
                return "indefinite";
            }
        }
        return "";
    }
}
