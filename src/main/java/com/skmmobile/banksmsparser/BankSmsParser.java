package com.skmmobile.banksmsparser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankSmsParser {
    private static String TAG = "BankSmsParser";

    private final Set<Operation> operationSet = new HashSet<>();

    private static String wrapEscape(String src) {
        char[] chars = src.toCharArray();
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

    protected void addOperationTemplate(Operation operation) {
        operationSet.add(operation);
    }

    public String getBankName() {
        return "indefinite";
    }

    public int getOperationCount() {
        return operationSet.size();
    }

    public Result parseSms(String text1) {
        String text = wrapEscape(text1);
        Result result = null;
        Operation curOperation = null;
        for (Operation operation : operationSet) {
            if (operation.typeRex.matcher(text).matches()) {
                curOperation = operation;
                result = new Result(operation.type);
                Matcher m;
                if (operation.cardIdRex != null) {
                    m = operation.cardIdRex.matcher(text);
                    if (m.find()) {
                        //App.SystemLog(TAG, "account: " + m.group());
                        result.cardIdStr = m.group(operation.cardIdRexGroup);
                    } else {
                        result.cardIdStr = operation.defCardId;
                    }
                }
                if (operation.amountRex != null) {
                    m = operation.amountRex.matcher(text);
                    if (m.find()) {
                        //App.SystemLog(TAG, "amount: " + m.group());
                        try {
                            String src = m.group(operation.amountRexGroup);
                            src = operation.decDelim.equals("") ? src : src.replace(operation.decDelim, "");
                            src = src.replace(operation.decChar, ".");
                            result.amount = new BigDecimal(src);
                        } catch (Exception e) {
                            result.amount = BigDecimal.ZERO;
                        }
                    } else {
                        result.amount = BigDecimal.ZERO;
                    }
                }
                if (operation.dateRex != null) {
                    m = operation.dateRex.matcher(text);
                    if (m.find()) {
                        //App.SystemLog(TAG, "date: " + m.group());
                    }
                }
                if (operation.detailRex != null) {
                    m = operation.detailRex.matcher(text);
                    if (m.find()) {
                        result.details = m.group(operation.detailRexGroup);
                    } else {
                        result.details = "indefinite";
                    }
                }
            }
        }

        if (result != null && (result.cardIdStr.equals(Operation.INDEFINITE_CARD_ID) | result.amount.compareTo(BigDecimal.ZERO) == 0)) {
            Context.LOGGER.debug(text);

            Context.LOGGER.debug("pattern:" + curOperation.typeRex.pattern());
            Context.LOGGER.debug(curOperation.cardIdRex != null ? "cardId: " + curOperation.cardIdRex.pattern() + "; group=" + curOperation.cardIdRexGroup : "cardId: no pattern!!!");
            Context.LOGGER.debug(curOperation.amountRex != null ? "amount: " + curOperation.amountRex.pattern() + "; group=" + curOperation.amountRexGroup : "amount: no pattern!!!");
            Context.LOGGER.debug(curOperation.dateRex != null ? "date: " + curOperation.dateRex.pattern() + "; group=" + curOperation.dateRexGroup : "date: no pattern!!!");
            Context.LOGGER.debug(curOperation.detailRex != null ? "details: " + curOperation.detailRex.pattern() + "; group=" + curOperation.detailRexGroup : "details: no pattern!!!");

            Context.LOGGER.debug("out: " + result.toString());
            return null;
        } else {
            return result;
        }
    }

    public static class Result {
        String type;
        String cardIdStr;
        BigDecimal amount;
        Date date;
        String details;

        public Result(String type) {
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

        @Override
        public String toString() {
            return getClass().getSimpleName() + ": "
                    + "type: " + type
                    + " cardId: " + (cardIdStr != null ? cardIdStr : "indefinite")
                    + " amount: " + (amount == null ? "indefinite" : amount.toPlainString())
                    + " date: " + (date != null ? date.toString() : "indefinite")
                    + " details: " + (details != null ? details : "indefinite")
                    ;
        }
    }

    public static class Operation {
        private static final String INDEFINITE_CARD_ID = "";

        private String type;
        private Pattern typeRex;
        private Pattern cardIdRex;
        private Pattern amountRex;
        private Pattern dateRex;
        private Pattern detailRex;
        private int cardIdRexGroup = 0;
        private int amountRexGroup = 0;
        private int dateRexGroup = 0;
        private int detailRexGroup = 0;
        private String defCardId = INDEFINITE_CARD_ID;
        private CharSequence decChar = ".";
        private CharSequence decDelim = "";

        public Operation(String type) {
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

    // Шаблоны системных sms для исключения
    private static final List<String> systemSmsTemplate = new ArrayList<>();

    static {
        systemSmsTemplate.add("Задолженность по налогу.*");
        systemSmsTemplate.add("Vhod v Tinkoff.ru.*");
        systemSmsTemplate.add("Вход в Сбербанк Онлайн для Android.*");
        systemSmsTemplate.add(".*пароль:\\s\\d+.*");
        systemSmsTemplate.add("(Сбербанк Онлайн).*(перевел).*");
    }

    public static void initSystemSms(List<String> list) {
        systemSmsTemplate.clear();
        systemSmsTemplate.addAll(list);
    }

    public static boolean isSystemBankSms(String text1) {
        String text = wrapEscape(text1);
        Pattern p;
        for (String s : systemSmsTemplate) {
            p = Pattern.compile(s);
            if (p.matcher(text).matches())
                return true;
        }
        return false;
    }

    /**
     * Проверка, что в наборе нет одинаковых шаблонов
     *
     * @return
     */
    public boolean check() {
        Set<String> matches = new HashSet<>();
        for (Operation op : operationSet) {
            if (matches.contains(op.typeRex.pattern()))
                return false;
            matches.add(op.typeRex.pattern());
        }
        return true;
    }
}
