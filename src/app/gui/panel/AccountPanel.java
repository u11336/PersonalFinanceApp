package app.gui.panel;

import app.gui.MainFrame;
import app.gui.dialog.AccountAddEditDialog;
import app.gui.handler.FunctionsHandler;
import app.gui.table.AccountTableData;
import app.gui.table.TransactionTableData;
import app.gui.toolbar.FunctionsToolBar;
import app.settings.Settings;
import app.settings.Style;

public class AccountPanel extends RightPanel {
    public AccountPanel(MainFrame frame){
        super(frame, new AccountTableData(new FunctionsHandler(frame, new AccountAddEditDialog(frame))), "ACCOUNTS",
                Style.ICON_PANEL_ACCOUNTS, new FunctionsToolBar(new FunctionsHandler(frame, new AccountAddEditDialog(frame))));
    }
}
