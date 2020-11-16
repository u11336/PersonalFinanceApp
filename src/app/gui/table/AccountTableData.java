package app.gui.table;

import app.gui.handler.FunctionsHandler;
import app.gui.table.model.AccountTableModel;
import app.settings.Style;

import javax.swing.*;

public class AccountTableData extends TableData {
    private static final String[] columns = new String[]{"TITLE", "AMOUNT"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE, Style.ICON_AMOUNT};

    public AccountTableData(FunctionsHandler handler){
        super(new AccountTableModel(columns), handler, columns, icons);
    }


}

