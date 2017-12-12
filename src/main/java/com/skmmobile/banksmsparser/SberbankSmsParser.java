package com.skmmobile.banksmsparser;

public class SberbankSmsParser extends BankSmsParser {

    public SberbankSmsParser() {
        Operation operation;

        // VISA6168 06.12.17 11:30 списание 700р Баланс: 2682.45р
        operation = new Operation("spisanie");
        operation.setTypePattern(".*списание\\s\\d.*");
        operation.setCardIdRex("VISA\\d{4}");
        operation.setAmountRex("(?<=списание\\s)\\d+\\.?\\d{1,2}");
        addOperationTemplate(operation);

        // VISA6470 04.12.17 08:18 оплата 200р MTS OAO Баланс: 4278.81р
        operation = new Operation(CATEGORY_EXPENSE);
        operation.setTypePattern(".*оплата\\s\\d.*");
        operation.setCardIdRex("VISA\\d{4}");
        operation.setAmountRex("(?<=оплата\\s)\\d+\\.?\\d{1,2}");
        operation.setDetailRex("р\\s(.*)(?=\\s(Б|б)аланс)", 1);
        addOperationTemplate(operation);

        // VISA6168 02.12.17 08:45 зачисление 30000р ATM 335417 Баланс: 33382.45р
        operation = new Operation("zachislenie_ATM");
        operation.setTypePattern(".*зачисление\\s\\d.*ATM.*");
        operation.setCardIdRex("VISA\\d{4}");
        operation.setAmountRex("(?<=зачисление\\s)\\d+\\.?\\d{1,2}");
        operation.setDetailRex("р\\s(.*)(?=\\s(Б|б)аланс)", 1);
        addOperationTemplate(operation);

        // VISA6168 09.12.17 19:07 зачисление 10000р с Вашего вклада. Баланс: 12682.45р
        operation = new Operation("zachislenie");
        operation.setTypePattern(".*зачисление\\s\\d*[^\\s]*\\s(?!ATM).*");
        operation.setCardIdRex("VISA\\d{4}");
        operation.setAmountRex("(?<=зачисление\\s)\\d+\\.?\\d{1,2}");
        addOperationTemplate(operation);
    }
}