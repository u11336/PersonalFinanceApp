package app.gui.table.model;

import app.model.Transaction;
import app.model.Transfer;
import app.saveLoad.SaveData;
import app.settings.Format;

public class TransferTableModel extends MainTableModel {

    public static final int DATE = 0;
    public static final int FROM_ACCOUNT = 1;
    public static final int TO_ACCOUNT = 2;
    public static final int FROM_AMOUNT = 3;
    public static final int TO_AMOUNT = 4;
    public static final int NOTICE  = 5;


    public TransferTableModel(String[] columns){
        super(SaveData.getInstance().getFilterTransfer(), columns);
    }

    @Override
    protected void updateData() {
        data = SaveData.getInstance().getTransfers();
    }

    @Override
    public Object getValueAt(int row, int column) {
        if(data.isEmpty()) return null;
        Transfer transfer = (Transfer) data.get(row);
        switch (column){
            case DATE:
                return Format.dateDay(transfer.getDate());
            case FROM_ACCOUNT:
                return transfer.getFromAccount().getTitle();
            case TO_ACCOUNT:
                return transfer.getToAccount().getTitle();
            case FROM_AMOUNT:
                return Format.amount(transfer.getFromAmount(), transfer.getFromAccount().getCurrency());
            case TO_AMOUNT:
                return Format.amount(transfer.getToAmount(), transfer.getToAccount().getCurrency());
            case NOTICE:
                return transfer.getNotice();
        }
        return null;
    }
}
