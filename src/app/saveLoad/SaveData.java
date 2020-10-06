package app.saveLoad;

import app.model.Account;
import app.model.Currency;
import app.model.Transaction;
import app.model.Transfer;

import java.util.ArrayList;
import java.util.List;

public class SaveData {
    private static SaveData instance;

    private List<Record> records = new ArrayList<>();
    private List<Currency> currencies = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<Transfer> transfers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();

    private SaveData() {
    }

    public static SaveData getInstance() {
        if (instance == null) instance = new SaveData();
        return instance;
    }

    public List<Record> getRecords() {
        return records;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Transfer> getTransfers() {
        return transfers;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Currency getBaseCurrency() {
        for (Currency c : currencies)
            if (c.isBase()) return c;
        return  new Currency();
    }
}
