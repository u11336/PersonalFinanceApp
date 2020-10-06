package app.model;

import app.exception.ModelException;

import java.util.Date;

public class Transaction extends Common {
    private Account account;
    private Record record;
    private double amount;
    private String notice;
    private Date date;

    public Transaction() {
    }

    public Transaction(Account account, Record record, double amount, String notice, Date date) throws ModelException {
        if (account == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if (record == null) throw new ModelException(ModelException.RECORD_EMPTY);
        this.account = account;
        this.record = record;
        this.amount = amount;
        this.notice = notice;
        this.date = date;
    }

    public Transaction(Account account, Record record, double amount, String notice) throws ModelException {
        this(account, record, amount, notice, new Date());
    }

    public Transaction(Account account, Record record, double amount, Date date) throws ModelException {
        this(account, record, amount, "", date);
    }

    public Transaction(Account account, Record record, double amount) throws ModelException {
        this(account, record, amount, "", new Date());
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "account=" + account +
                ", record=" + record +
                ", amount=" + amount +
                ", notice='" + notice + '\'' +
                ", date=" + date +
                '}';
    }
}
