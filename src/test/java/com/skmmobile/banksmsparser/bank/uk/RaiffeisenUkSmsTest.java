package com.skmmobile.banksmsparser.bank.uk;

import com.skmmobile.banksmsparser.bank.AbsXmlBankSmsTest;
import org.w3c.dom.Document;

@Deprecated
public class RaiffeisenUkSmsTest extends AbsXmlBankSmsTest {

    public RaiffeisenUkSmsTest(Document xmlDocument) {
        super("raiffeisen_uk", xmlDocument);
    }

    @Override
    protected void smsTest() {
        checkBankSms(
                "Vasha operatsija: 28.02.2018 17:56:44 VISA Gold/6155 131.00 UAH McDonald's 041 dostupna suma 7031.24 UAH",
                "unknown",
                "VISA Gold/6155",
                "131",
                ""
        );
        checkBankSms(
                "28.02.2018 na Vash rakhunok kartkovyi 1219648400(UAH) bulo zarakhovano sumu 7090.26 UAH",
                "popolnenie",
                "1219648400",
                "7090.26",
                ""
        );
        checkBankSms(
                "Vasha operatsija: 12.03.2018 20:03:58 Visa Gold/0013 56.51 UAH BeerMarket25Y113DA4AFZI0 dostupna suma 1647.17 UAH",
                "unknown",
                "Visa Gold/0013",
                "56.51",
                ""
        );
        checkBankSms(
                "Vasha operatsija: 12.03.2018 17:53:33 Visa Fishka/8027 200.00 UAH Moskovskyi 9 korp. av., dostupna suma 1703.68 UAH",
                "unknown",
                "Visa Fishka/8027",
                "200",
                ""
        );
        checkBankSms(
                "Vasha operatsija: 31.03.2018 17:46:00 MasterCard Unembossed/2768 3943.00 UAH OSTIN dostupna suma 28187.18 UAH",
                "unknown",
                "MasterCard Unembossed/2768",
                "3943",
                ""
        );
        checkBankSms(
                "Bezgotivkove zarakhuvannya: 25.03.2018 16:06:37 Mastercard Standard/8514 150.00 UAH RAIFFEISEN ONLINE UAH DCCC dostupna suma 5171.37 UAH",
                "unknown",
                "Mastercard Standard/8514",
                "150",
                ""
        );
        checkBankSms(
                "Popovnennja sumy: 03.04.2018 09:52:10 Visa Fishka/6399 68.00 UAH v 03.04.2018T095210 P2PProg dostupna suma 12999.27 UAH",
                "popolnenie",
                "Visa Fishka/6399",
                "68",
                ""
        );
        checkBankSms(
                "25.01.2019 na rakhunok 1014426400(UAH) zarakhovano 640.00 UAH. Uvaga! Z 01.02.2019 vsi SMS vid Banku budut z nomeru - Raiffeisen. Detali na www.aval.ua",
                "popolnenie",
                "1014426400",
                "640.00",
                ""
        );
    }
}
