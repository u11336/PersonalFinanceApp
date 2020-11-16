package app.saveLoad;

import app.exception.ModelException;
import app.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SaveData {
    private static SaveData instance;

    private List<Article> articles = new ArrayList<>();
    private List<Currency> currencies = new ArrayList<>();
    private List<Transaction> transactions = new ArrayList<>();
    private List<Transfer> transfers = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private final Filter filter;
    private Common oldCommon;
    private boolean saved = true;

    private SaveData() {
        load();
        this.filter = new Filter();
    }

    public void load(){
        SaveLoad.load(this);
        sort();
        for(Account a : accounts)
            a.setAmountFromTransactionsAndTransfers(transactions, transfers);
    }

    public void clear(){
        articles.clear();
        currencies.clear();
        transfers.clear();
        transactions.clear();
    }

    private void sort() {
        this.articles.sort((Article t1, Article t2) -> t1.getTitle().compareToIgnoreCase(t2.getTitle()));
        this.accounts.sort((Account t1, Account t2) -> t1.getTitle().compareToIgnoreCase(t2.getTitle()));
        this.transactions.sort((Transaction t1, Transaction t2) -> (int) t1.getDate().compareTo(t2.getDate()));
        this.transfers.sort((Transfer t1, Transfer t2) -> (int) t1.getDate().compareTo(t2.getDate()));
        this.currencies.sort((currency, t1) -> {
            if(currency.isBase()) return -1;
            if(t1.isBase()) return 1;
            if(currency.isOn() ^ t1.isOn()){
                if(currency.isOn()) return 1;
                else return -1;
            }
            return currency.getTitle().compareToIgnoreCase(t1.getTitle());
        });
    }

    public void save(){
        SaveLoad.save(this);
        saved = true;
    }

    public boolean isSaved(){
        return saved;
    }

    public static SaveData getInstance() {
        if (instance == null) instance = new SaveData();
        return instance;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setArticles(List<Article> articles) {
        if(articles != null) this.articles = articles;
    }

    public void setCurrencies(List<Currency> currencies) {
        if(currencies != null) this.currencies = currencies;
    }

    public void setTransactions(List<Transaction> transactions) {
        if(transactions != null) this.transactions = transactions;
    }

    public void setTransfers(List<Transfer> transfers) {
        if(transfers != null) this.transfers = transfers;
    }

    public void setAccounts(List<Account> accounts) {
        if(accounts != null) this.accounts = accounts;
    }

    public List<Article> getArticles() {
        return articles;
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

    public ArrayList<Currency> getEnableCurrencies(){
        ArrayList<Currency> list = new ArrayList<>();
        for(Currency c : currencies)
            if(c.isOn()) list.add(c);
        return list;
    }

    public List<Transaction> getFilterTransaction(){
        ArrayList<Transaction> list = new ArrayList<>();
        for (Transaction t : transactions)
            if(filter.checkDate(t.getDate())) list.add(t);
        return list;
    }

    public List<Transfer> getFilterTransfer(){
        ArrayList<Transfer> list = new ArrayList<>();
        for (Transfer t : transfers)
            if(filter.checkDate(t.getDate())) list.add(t);
        return list;
    }

    public List<Transaction> getTransactionsOnCount(int count){
        return new ArrayList<>(transactions.subList(0, Math.min(count, transactions.size())));
    }

    public Common getOldCommon(){
        return oldCommon;
    }

    public void add(Common c) throws ModelException {
        List ref = getRef(c);
        if(ref.contains(c)) throw new ModelException(ModelException.EXISTS);
        ref.add(c);
        c.postAdd(this);
        sort();
        saved = false;
    }

    public void edit(Common oldC, Common newC) throws ModelException {
        List ref = getRef(oldC);
        if(ref.contains(newC) && oldC != ref.get(ref.indexOf(newC))) throw new ModelException(ModelException.EXISTS);
        ref.set(ref.indexOf(oldC), newC);
        oldCommon = oldC;
        newC.postEdit(this);
        saved = false;
    }

    public void remove(Common c){
        getRef(c).remove(c);
        c.postRemove(this);
        saved = false;
    }

    public void updateCurrencies() throws Exception {
        HashMap<String, Double> rates = RateCurrency.getRates(getBaseCurrency());
        for(Currency c : currencies)
            c.setRate(rates.get(c.getCode()));
        for (Account a : accounts)
            a.getCurrency().setRate(rates.get(a.getCurrency().getCode()));
        saved = false;
    }

    private List getRef(Common c) {
        if(c instanceof Account) return accounts;
        if(c instanceof Article) return articles;
        if(c instanceof Transaction) return transactions;
        if(c instanceof Transfer) return transfers;
        if(c instanceof Currency) return currencies;
        return null;
    }

    @Override
    public String toString() {
        return "SaveData{" +
                "articles=" + articles +
                ", currencies=" + currencies +
                ", transactions=" + transactions +
                ", transfers=" + transfers +
                ", accounts=" + accounts +
                '}';
    }
}
