package app.gui.table.model;

import app.model.Account;
import app.saveLoad.SaveData;
import app.settings.Format;

import java.util.ArrayList;
import java.util.Arrays;

public class AccountTableModel extends MainTableModel {

    public static final int TITLE = 0;
    public static final int AMOUNT = 1;

    public AccountTableModel(String[] columns){
        super(SaveData.getInstance().getAccounts(), columns);
    }

    @Override
    protected void updateData() {
        data = SaveData.getInstance().getAccounts();
    }

    @Override
    public Object getValueAt(int row, int column) {
        if(data.isEmpty()) return null;
        Account account = (Account) data.get(row);
        switch (column){
            case TITLE:
                return account.getTitle();
            case AMOUNT:
                return Format.amount(account.getAmount(), account.getCurrency());
        }
        return null;
    }
}
