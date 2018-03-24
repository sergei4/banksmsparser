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
        SmsPattern smsPattern;

        // VISA6168 06.12.17 11:30 списание 700р Баланс: 2682.45р
        smsPattern = new SmsPattern("spisanie");
        smsPattern.setTypePattern(".*списание\\s\\d.*");
        smsPattern.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        smsPattern.setAmountRex("(?<=списание\\s)\\d*\\.?\\d{1,2}");
        addSmsPattern(smsPattern);

        // VISA6470 04.12.17 08:18 оплата 200р MTS OAO Баланс: 4278.81р
        smsPattern = new SmsPattern(CATEGORY_EXPENSE);
        smsPattern.setTypePattern(".*оплата\\s\\d.*");
        smsPattern.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        smsPattern.setAmountRex("(?<=оплата\\s)\\d*\\.?\\d{1,2}");
        smsPattern.setDetailRex("р\\s(.*)(?=\\s(Б|б)аланс)", 1);
        addSmsPattern(smsPattern);

        // MIR-3075 13.12.17 17:39 покупка 1200р VNUKOVO.AIRLINES AEROP Баланс: 1276.46р
        smsPattern = new SmsPattern(CATEGORY_EXPENSE);
        smsPattern.setTypePattern(".*покупка\\s\\d.*");
        smsPattern.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        smsPattern.setAmountRex("(?<=покупка\\s)\\d*\\.?\\d{1,2}");
        smsPattern.setDetailRex("р\\s(.*)(?=\\s(Б|б)аланс)", 1);
        addSmsPattern(smsPattern);

        // VISA6168 02.12.17 08:45 зачисление 30000р ATM 335417 Баланс: 33382.45р
        smsPattern = new SmsPattern("zachislenie_ATM");
        smsPattern.setTypePattern(".*зачисление\\s\\d.*ATM.*");
        smsPattern.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        smsPattern.setAmountRex("(?<=зачисление\\s)\\d*\\.?\\d{1,2}");
        smsPattern.setDetailRex("р\\s(.*)(?=\\s(Б|б)аланс)", 1);
        addSmsPattern(smsPattern);

        // VISA6168 09.12.17 19:07 зачисление 10000р с Вашего вклада. Баланс: 12682.45р
        // MAES0515 11.12.17 12:24 зачисление пенсии 10471.91р Баланс: 12934.80р
        smsPattern = new SmsPattern("zachislenie");
        smsPattern.setTypePattern(".*зачисление\\s\\d*[^\\s]*\\s(?!ATM).*");
        smsPattern.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        smsPattern.setAmountRex("зачисление\\s(пенсии\\s)?(\\d*\\.?\\d{1,2})", 2);
        addSmsPattern(smsPattern);

        // VISA6168 13.12.17 14:18 выдача 5000р ATM 861320 Баланс: 97.45р
        smsPattern = new SmsPattern("vida4a_ATM");
        smsPattern.setTypePattern(".*выдача\\s\\d.*ATM.*");
        smsPattern.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        smsPattern.setAmountRex("(?<=выдача\\s)\\d*\\.?\\d{1,2}");
        smsPattern.setDetailRex("р\\s(.*)(?=\\s(Б|б)аланс)", 1);
        addSmsPattern(smsPattern);

        // VISA0000 10.12.17 оплата Мобильного банка за 10/12/2017-09/01/2018 60р Баланс: 00000.00р
        smsPattern = new SmsPattern("pay_iBank");
        smsPattern.setTypePattern(".*оплата\\sМобильного\\sбанка.*");
        smsPattern.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        smsPattern.setAmountRex("(\\/\\d{4}\\s)(\\d*\\.?\\d{1,2})", 2);
        addSmsPattern(smsPattern);

        // VISA0000: перевод 400р. на карту получателя ВЕРОНИКА АЛЕКСАНДРОВНА П. выполнен. Подробнее в выписке по карте http://sberbank.ru/sms/h2/
        smsPattern = new SmsPattern("perevod");
        smsPattern.setTypePattern(".*перевод.*");
        smsPattern.setCardIdRex("(MIR-|VISA|MAES|ORPS|ECMC)\\d{4}");
        smsPattern.setAmountRex("(?<=перевод\\s)\\d*\\.?\\d{1,2}");
        addSmsPattern(smsPattern);
    }
}