package com.skmmobile.banksmsparser;

import com.skmmobile.banksmsparser.parser.BaseBankSmsParser;

import java.math.BigDecimal;
import java.util.Date;

public interface BankSmsParser {

    BaseBankSmsParser.Result parseSms(String smsText);

    class Result {
        String type;
        String cardIdStr;
        BigDecimal amount;
        Date date;
        String details;

        public Result(String type, String cardIdStr, BigDecimal amount, Date date, String details) {
            this.type = type;
            this.cardIdStr = cardIdStr;
            this.amount = amount;
            this.date = date;
            this.details = details;
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
                    + " cardId: " + (cardIdStr != null ? cardIdStr : "{null}")
                    + " amount: " + (amount == null ? "{null}" : amount.toPlainString())
                    + " date: " + (date != null ? date.toString() : "{null}")
                    + " details: " + (details != null ? details : "{null}");
        }
    }
}
