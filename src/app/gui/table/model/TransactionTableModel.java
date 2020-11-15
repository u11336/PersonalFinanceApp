package app.gui.table.model;

import app.model.Transaction;
import app.saveLoad.SaveData;
import app.settings.Format;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;

public class TransactionTableModel extends MainTableModel {

    public static final int DATE = 0;
    public static final int ACCOUNT = 1;
    public static final int ARTICLE = 2;
    public static final int AMOUNT = 3;
    public static final int NOTICE  = 4;

    private int count = -1;

    public TransactionTableModel(String[] columns){
        super(SaveData.getInstance().getFilterTransaction());
        this.columns = new ArrayList<>(Arrays.asList(columns));
    }

    public TransactionTableModel(String[] columns, int count){
        super(SaveData.getInstance().getTransactionsOnCount(count));
        this.columns = new ArrayList<>(Arrays.asList(columns));
        this.count = count;
    }

    @Override
    protected void updateData() {
        if(count == -1) data = SaveData.getInstance().getFilterTransaction();
        else data = SaveData.getInstance().getTransactionsOnCount(count);
    }

    @Override
    public Object getValueAt(int row, int column) {
        if(data.isEmpty()) return null;
        Transaction transaction = (Transaction) data.get(row);
        switch (column){
            case DATE:
                return Format.dateDay(transaction.getDate());
            case ACCOUNT:
                return transaction.getAccount().getTitle();
            case ARTICLE:
                return transaction.getArticle().getTitle();
            case AMOUNT:
                return transaction.getAmount();
            case NOTICE:
                return transaction.getNotice();
        }
        return null;
    }
}
