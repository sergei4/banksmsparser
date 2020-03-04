package com.skmmobile.banksmsparser;

/**
 * Статический шаблон для обработки смс банка Сбербанк России.
 * шаблоны перенесены в xml
 */

@Deprecated
public class SberbankSmsParser extends BankSmsParser {
    @Override
    public String getBankName() {
        return "sberbank";
    }

    public SberbankSmsParser() {
        Operation operation;

        // VISA6168 06.12.17 11:30 списание 700р Баланс: 2682.45р
        operation = new Operation("spisanie");
        operation.setTypePattern(".*списание\\s\\d.*");
        operation.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        operation.setAmountRex("(?<=списание\\s)\\d*\\.?\\d{1,2}");
        addOperationTemplate(operation);

        // VISA6470 04.12.17 08:18 оплата 200р MTS OAO Баланс: 4278.81р
        operation = new Operation("expense");
        operation.setTypePattern(".*оплата\\s\\d.*");
        operation.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        operation.setAmountRex("(?<=оплата\\s)\\d*\\.?\\d{1,2}");
        operation.setDetailRex("р\\s(.*)(?=\\s(Б|б)аланс)", 1);
        addOperationTemplate(operation);

        // MIR-3075 13.12.17 17:39 покупка 1200р VNUKOVO.AIRLINES AEROP Баланс: 1276.46р
        operation = new Operation("expense");
        operation.setTypePattern(".*покупка\\s\\d.*");
        operation.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        operation.setAmountRex("(?<=покупка\\s)\\d*\\.?\\d{1,2}");
        operation.setDetailRex("р\\s(.*)(?=\\s(Б|б)аланс)", 1);
        addOperationTemplate(operation);

        // VISA6168 02.12.17 08:45 зачисление 30000р ATM 335417 Баланс: 33382.45р
        operation = new Operation("zachislenie_ATM");
        operation.setTypePattern(".*зачисление\\s\\d.*ATM.*");
        operation.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        operation.setAmountRex("(?<=зачисление\\s)\\d*\\.?\\d{1,2}");
        operation.setDetailRex("р\\s(.*)(?=\\s(Б|б)аланс)", 1);
        addOperationTemplate(operation);

        // VISA6168 09.12.17 19:07 зачисление 10000р с Вашего вклада. Баланс: 12682.45р
        // MAES0515 11.12.17 12:24 зачисление пенсии 10471.91р Баланс: 12934.80р
        operation = new Operation("zachislenie");
        operation.setTypePattern(".*зачисление\\s\\d*[^\\s]*\\s(?!ATM).*");
        operation.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        operation.setAmountRex("зачисление\\s(пенсии\\s)?(\\d*\\.?\\d{1,2})", 2);
        addOperationTemplate(operation);

        // VISA6168 13.12.17 14:18 выдача 5000р ATM 861320 Баланс: 97.45р
        operation = new Operation("vida4a_ATM");
        operation.setTypePattern(".*выдача\\s\\d.*ATM.*");
        operation.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        operation.setAmountRex("(?<=выдача\\s)\\d*\\.?\\d{1,2}");
        operation.setDetailRex("р\\s(.*)(?=\\s(Б|б)аланс)", 1);
        addOperationTemplate(operation);

        // VISA0000 10.12.17 оплата Мобильного банка за 10/12/2017-09/01/2018 60р Баланс: 00000.00р
        operation = new Operation("pay_iBank");
        operation.setTypePattern(".*оплата\\sМобильного\\sбанка.*");
        operation.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        operation.setAmountRex("(\\/\\d{4}\\s)(\\d*\\.?\\d{1,2})", 2);
        addOperationTemplate(operation);

        // VISA0000: перевод 400р. на карту получателя ВЕРОНИКА АЛЕКСАНДРОВНА П. выполнен. Подробнее в выписке по карте http://sberbank.ru/sms/h2/
        operation = new Operation("perevod");
        operation.setTypePattern(".*перевод.*");
        operation.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        operation.setAmountRex("(?<=перевод\\s)\\d*\\.?\\d{1,2}");
        addOperationTemplate(operation);
    }
}