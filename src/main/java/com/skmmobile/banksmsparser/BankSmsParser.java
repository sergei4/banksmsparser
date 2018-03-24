package com.skmmobile.banksmsparser;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankSmsParser {
    private static String TAG = "BankSmsParser";

    public static final String CATEGORY_EXPENSE = "expense";

    private final Set<SmsPattern> smsPatternSet = new HashSet<>();

    private static String wrapEscape(String src) {
        char[] chars = src.toCharArray();
        int size = chars.length;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char c = chars[i];
            if (c == '\n' | c == '\r') {
                result.append(" ");
            }
            else
                result.append(c);
        }
        return result.toString();
    }

    protected void addSmsPattern(SmsPattern smsPattern) {
        smsPatternSet.add(smsPattern);
    }

    public String getBankName() {
        return "indefinite";
    }

    public int getOperationCount(){
        return smsPatternSet.size();
    }

    public Result parseSms(String text1) {
        String text = wrapEscape(text1);
        Result result = null;
        for (SmsPattern smsPattern : smsPatternSet) {
            if (smsPattern.typeRex.matcher(text).matches()) {
                result = new Result(smsPattern.type);
                Matcher m;
                // определяем номер карты или счета
                if (smsPattern.cardIdRex != null) {
                    m = smsPattern.cardIdRex.matcher(text);
                    if (m.find()) {
                        //App.SystemLog(TAG, "account: " + m.group());
                        result.cardIdStr = m.group(smsPattern.cardIdRexGroup);
                    }
                    else
                        result.cardIdStr = smsPattern.defCardId;
                }
                // определяем сумму операции, по-умолчанию = 0
                if (smsPattern.amountRex != null) {
                    m = smsPattern.amountRex.matcher(text);
                    if (m.find()) {
                        //App.SystemLog(TAG, "amount: " + m.group());
                        try {
                            String src = m.group(smsPattern.amountRexGroup);
                            src = smsPattern.decDelimiter.equals("")? src : src.replace(smsPattern.decDelimiter, "");
                            src = src.replace(smsPattern.decChar, ".");
                            result.amount = new BigDecimal(src);
                        }
                        catch (Exception e){
                            result.amount = BigDecimal.ZERO;
                        }
                    }
                    else
                        result.amount = BigDecimal.ZERO;
                }
                // определяем сумму комиссии, по-умолчанию = 0, разделители как в сумме
                // Todo: Решить: нужно ли определять отдельные настройки для комиссии?
                if (smsPattern.commissionRex != null) {
                    m = smsPattern.commissionRex.matcher(text);
                    if (m.find()) {
                        //App.SystemLog(TAG, "amount: " + m.group());
                        try {
                            String src = m.group(smsPattern.commissionRexGroup);
                            src = smsPattern.decDelimiter.equals("")? src : src.replace(smsPattern.decDelimiter, "");
                            src = src.replace(smsPattern.decChar, ".");
                            result.commission = new BigDecimal(src);
                        }
                        catch (Exception e){
                            result.commission = BigDecimal.ZERO;
                        }
                    }
                    else
                        result.commission = BigDecimal.ZERO;
                }
                else
                    result.commission = BigDecimal.ZERO;
                // Определяем валюту, по-умолчанию пустая строка "";
                if(smsPattern.currencyRex != null){
                    m = smsPattern.currencyRex.matcher(text);
                    if (m.find()) {
                        result.currency = m.group(smsPattern.currencyRexGroup);
                    }
                    else
                        result.currency = "";
                }
                else
                    result.currency = "";
                // Определяем дополнительную информацию
                if (smsPattern.detailRex != null) {
                    m = smsPattern.detailRex.matcher(text);
                    if (m.find()) {
                        //App.SystemLog(TAG, "location: " + m.group());
                        result.details = m.group(smsPattern.detailRexGroup);
                    }
                    else
                        result.details = "indefinite";
                }
                // Определяем дату операции
                if (smsPattern.dateRex != null) {
                    m = smsPattern.dateRex.matcher(text);
                    if (m.find()) {
                        //App.SystemLog(TAG, "date: " + m.group());
                    }
                }
                // сразу возвращаем результат
                return result.cardIdStr.equals(SmsPattern.INDEFINITE_CARD_ID) | result.amount.compareTo(BigDecimal.ZERO) == 0 ? null : result;
            }
        }
        return null;
    }

    public static class Result {
        String type;
        String cardIdStr;
        BigDecimal amount;
        Date date;
        String details;
        BigDecimal commission;
        String currency;

        Result(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public String getCardIdStr() {
            return cardIdStr;
        }

        public BigDecimal getAmount() {
            return amount == null ? BigDecimal.ZERO : amount;
        }

        public Date getDate() {
            return date;
        }

        public String getDetails() {
            return details != null ? details : "";
        }

        public BigDecimal getCommission() {
            return commission;
        }

        public String getCurrency() {
            return currency;
        }

        @Override
        public String toString() {
            return getClass().getSimpleName() + ": "
                    + "type: "        + type
                    + " cardId: "     + (cardIdStr != null ? cardIdStr : "indefinite")
                    + " amount: "     + (amount == null ? "indefinite" : amount.toPlainString())
                    + " commission: " + (commission == null ? "indefinite" : commission.toPlainString())
                    + " date: "       + (date != null ? date.toString() : "indefinite")
                    + " details: "    + (details != null ? details : "indefinite")
                    + " currency: "   + (currency != null ? currency : "indefinite")
                    ;
        }
    }

    public static class SmsPattern {
        private static final String INDEFINITE_CARD_ID = "";

        private String type;
        private Pattern typeRex;
        private Pattern cardIdRex;
        private Pattern amountRex;
        private Pattern dateRex;
        private Pattern detailRex;
        private Pattern commissionRex;
        private Pattern currencyRex;
        private int cardIdRexGroup = 0;
        private int amountRexGroup = 0;
        private int dateRexGroup = 0;
        private int detailRexGroup = 0;
        private int commissionRexGroup = 0;
        private int currencyRexGroup = 0;
        // значения по-умолчанию
        private String defCardId = INDEFINITE_CARD_ID;
        private CharSequence decChar = ".";
        private CharSequence decDelimiter = "";

        public SmsPattern(String type) {
            this.type = type;
        }

        public void setTypePattern(String s) {
            typeRex = Pattern.compile(s);
        }

        public void setCardIdRex(String s) {
            setCardIdRex(s, 0);
        }

        public void setCardIdRex(String s, int group) {
            cardIdRex = Pattern.compile(s);
            cardIdRexGroup = group;
        }

        public void setAmountRex(String s) {
            setAmountRex(s, 0);
        }

        public void setAmountRex(String s, int group) {
            amountRex = Pattern.compile(s);
            amountRexGroup = group;
        }

        public void setDateRex(String s) {
            setDateRex(s, 0);
        }

        public void setDateRex(String s, int group) {
            dateRex = Pattern.compile(s);
            dateRexGroup = group;
        }

        public void setDetailRex(String s) {
            setDetailRex(s, 0);
        }

        public void setDetailRex(String s, int group) {
            detailRex = Pattern.compile(s);
            detailRexGroup = group;
        }

        public void setCurrencyRex(String s) {
            setCurrencyRex(s, 0);
        }

        public void setCurrencyRex(String s, int group) {
            currencyRex = Pattern.compile(s);
            currencyRexGroup = group;
        }

        public void setCommissionRex(String s) {
            setCommissionRex(s, 0);
        }

        public void setCommissionRex(String s, int group) {
            commissionRex = Pattern.compile(s);
            commissionRexGroup = group;
        }

        // Настройки для распознавания сумм
        public void setDecChar(CharSequence decChar) {
            this.decChar = decChar;
        }

        public void setDecDelimiter(CharSequence decDelimiter) {
            this.decDelimiter = decDelimiter;
        }

        // Устанавливаем значение cardId по-умолчанию
        public void setDefCardId(String defCardId) {
            this.defCardId = defCardId;
        }
    }

    // Шаблоны системных sms для исключения
    private static final List<Pattern> systemSmsTemplate = new LinkedList<>();
    static {
        systemSmsTemplate.add(Pattern.compile("Задолженность по налогу.*"));
        systemSmsTemplate.add(Pattern.compile("Vhod v Tinkoff.ru.*"));
        systemSmsTemplate.add(Pattern.compile("Вход в Сбербанк Онлайн для Android.*"));
        systemSmsTemplate.add(Pattern.compile(".*пароль:\\s\\d+.*"));
        systemSmsTemplate.add(Pattern.compile("(Сбербанк Онлайн).*(перевел).*"));
    }

    public static void initSystemSms(List<String> list){
        systemSmsTemplate.clear();
        for(String s: list)
            systemSmsTemplate.add(Pattern.compile(s));
    }

    public static boolean isSystemBankSms(String text1) {
        String text = wrapEscape(text1);
        for (Pattern p : systemSmsTemplate) {
            if (p.matcher(text).matches())
                return true;
        }
        return false;
    }

    /**
     * Проверка, что в наборе нет одинаковых шаблонов
     * @return
     */
    @Deprecated
    public boolean check() {
        Set<String> matches = new HashSet<>();
        for (SmsPattern op : smsPatternSet) {
            if (matches.contains(op.typeRex.pattern()))
                return false;
            matches.add(op.typeRex.pattern());
        }
        return true;
    }

    public boolean validate() {
        return check();
    }
}