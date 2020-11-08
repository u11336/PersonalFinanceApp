package app.model;

import app.exception.ModelException;
import app.saveLoad.SaveData;

import java.util.List;
import java.util.Objects;

public class Account extends Common {
    private String title;
    private Currency currency;
    private double startAmount;
    private double amount;

    public Account() {
    }

    public Account(String title, Currency currency, double startAmount) throws ModelException {
        if (title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (currency == null) throw new ModelException(ModelException.CURRENCY_EMPTY);
        this.title = title;
        this.currency = currency;
        this.startAmount = startAmount;
    }

    public double getAmount() {
        return amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(title, account.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String getValueForComboBox() {
        return title;
    }

    public void setAmountFromTransactionsAndTransfers(List<Transaction> transactions, List<Transfer> transfers) {
        this.amount = startAmount;
        for (Transaction transaction : transactions) {
            if (transaction.getAccount().equals(this)) {
                this.amount += transaction.getAmount();
            }
        }

        for (Transfer transfer : transfers) {
            if (transfer.getFromAccount().equals(this)) {
                this.amount -= transfer.getFromAmount();
            }
        }
        for (Transfer transfer : transfers) {
            if (transfer.getToAccount().equals(this)) {
                this.amount += transfer.getToAmount();
            }
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "title='" + title + '\'' +
                ", currency=" + currency +
                ", stertAmount=" + startAmount +
                ", amount=" + amount +
                '}';
    }

    @Override
    public void postAdd(SaveData s){
        setAmountFromTransactionsAndTransfers(s.getTransactions(), s.getTransfers());
    }

    @Override
    public void postEdit(SaveData s) {
        for(Transaction t : s.getTransactions()){
            if(t.getAccount().equals(s.getOldCommon())) t.setAccount(this);
        }
        for(Transfer t : s.getTransfers()){
            if(t.getFromAccount().equals(s.getOldCommon())) t.setFromAccount(this);
            if(t.getToAccount().equals(s.getOldCommon())) t.setToAccount(this);
        }
        setAmountFromTransactionsAndTransfers(s.getTransactions(), s.getTransfers());
    }
}
