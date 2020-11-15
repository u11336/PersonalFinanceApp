package app;

import app.exception.ModelException;
import app.gui.MainFrame;
import app.model.*;
import app.saveLoad.SaveData;
import app.settings.Settings;
import app.settings.TextConstants;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class PersonalFinanceApp {
    public static void main(String[] args) throws ModelException {
        init();
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
        SaveData sd = SaveData.getInstance();
//            sd.updateCurrencies();
        System.out.println(sd);
//        testModel();
    }

    public static void init() {
        try {
            Settings.init();
            TextConstants.initData();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_AVENIR_LT55_ROMAN));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void testModel() throws ModelException {
        Currency c1 = new Currency("Ruble", "RUB", 1, true, true);
        Currency c2 = new Currency("Dollar", "USD", 1.5, true, false);
        Currency c3 = new Currency("Euro", "EUR", 2.4, true, false);
        Currency c4 = new Currency("Hrivna", "UAH", 1.2, true, false);

        Account ac1 = new Account("Wallet", c1, 5000);
        Account ac2 = new Account("Visa", c2, 3500);
        Account ac3 = new Account("Deposit RUB", c1, 1420);
        Account ac4 = new Account("Deposit USD", c2, 2970);

        Article ar1 = new Article("Grocery");
        Article ar2 = new Article("Utilities");
        Article ar3 = new Article("Transport");
        Article ar4 = new Article("Interest rate");

        ArrayList<Currency> currencies = new ArrayList<>();
        currencies.add(c1);
        currencies.add(c2);
        currencies.add(c3);
        currencies.add(c4);

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);
        accounts.add(ac4);

        ArrayList<Article> articles = new ArrayList<>();
        articles.add(ar1);
        articles.add(ar2);
        articles.add(ar3);
        articles.add(ar4);

        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(ac3, ar3, -321, "taxi"));
        transactions.add(new Transaction(ac2, ar2, -1000, "Second apt"));
        transactions.add(new Transaction(ac1, ar1, -812, "Eggs"));
        transactions.add(new Transaction(ac4, ar4, +136, new Date(new Date().getTime() - (long) 864000000 * 30)));

        ArrayList<Transfer> transfers = new ArrayList<>();
        transfers.add(new Transfer(ac2, ac1, 250, 250));
        transfers.add(new Transfer(ac4, ac3, 192, 192));
        transfers.add(new Transfer(ac1, ac4, 576, 557));

        for(Account a : accounts){
            a.setAmountFromTransactionsAndTransfers(transactions, transfers);
        }

        SaveData sd = SaveData.getInstance();
        sd.setAccounts(accounts);
        sd.setArticles(articles);
        sd.setCurrencies(currencies);
        sd.setTransfers(transfers);
        sd.setTransactions(transactions);

        sd.save();
//        sd.load();
        System.out.println(sd);
    }
}