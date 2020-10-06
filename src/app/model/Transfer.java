package app.model;

import app.exception.ModelException;

import java.util.Date;

public class Transfer {
    private Account fromAccount;
    private Account toAccount;
    private double fromAmount;
    private double toAmount;
    private String notice;
    private Date date;

    public Transfer() {
    }

    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, String notice, Date date) throws ModelException {
        if (fromAccount == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if (toAccount == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if (fromAmount < 0 || toAmount < 0) throw new ModelException(ModelException.AMOUNT_FORMAT);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.notice = notice;
        this.date = date;
    }

    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, String notice) throws ModelException {
        this(fromAccount, toAccount, fromAmount, toAmount, notice, new Date());
    }

    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, Date date) throws ModelException {
        this(fromAccount, toAccount, fromAmount, toAmount, "", date);
    }

    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount) throws ModelException {
        this(fromAccount, toAccount, fromAmount, toAmount, "", new Date());
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public double getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(double fromAmount) {
        this.fromAmount = fromAmount;
    }

    public double getToAmount() {
        return toAmount;
    }

    public void setToAmount(double toAmount) {
        this.toAmount = toAmount;
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
        return "Transfer{" +
                "fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", fromAmount=" + fromAmount +
                ", toAmount=" + toAmount +
                ", notice='" + notice + '\'' +
                ", date=" + date +
                '}';
    }
}
