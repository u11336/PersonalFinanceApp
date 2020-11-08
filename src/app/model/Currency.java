package app.model;

import app.exception.ModelException;
import app.saveLoad.SaveData;

import java.util.Objects;

public class Currency extends Common {
    private String title;
    private String code;
    private double rate;
    private boolean isOn;
    private boolean isBase;


    public Currency() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public boolean isBase() {
        return isBase;
    }

    public void setBase(boolean base) {
        isBase = base;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", rate=" + rate +
                ", isOn=" + isOn +
                ", isBase=" + isBase +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;
        Currency currency = (Currency) o;
        return Objects.equals(code, currency.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    public Currency(String title, String code, double rate, boolean isOn, boolean isBase) throws ModelException {
        if (title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (code.length() == 0) throw new ModelException((ModelException.CODE_EMPTY));
        if (rate <= 0) throw new ModelException((ModelException.RATE_INCORRECT));
        this.title = title;
        this.code = code;
        this.rate = rate;
        this.isOn = isOn;
        this.isBase = isBase;
    }

    @Override
    public String getValueForComboBox() {
        return title;
    }

    public double getRateByCurrency(Currency currency) {
        return rate / currency.rate;
    }

    public void postAdd(SaveData s){
        clearBase(s);
    }

    public void postEdit(SaveData s){
        clearBase(s);
        for(Account a : s.getAccounts()){
            if(a.getCurrency().equals(s.getOldCommon())) a.setCurrency(this);
        }
    }

    private void clearBase(SaveData s) {
        if (isBase){
            rate = 1;
            Currency old = (Currency) s.getOldCommon();
            for(Currency c : s.getCurrencies()){
                if(!this.equals(c)) {
                    c.setBase(false);
                    if(old != null) c.setRate(c.rate / old.rate);
                }
            }
        }
    }

}
