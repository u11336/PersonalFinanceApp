package app.gui.panel;

import app.gui.MainFrame;
import app.gui.dialog.AccountAddEditDialog;
import app.gui.dialog.TransactionAddEditDialog;
import app.gui.handler.FunctionsHandler;
import app.gui.table.TransactionTableData;
import app.gui.toolbar.FunctionsToolBar;
import app.settings.Style;

import javax.swing.*;

public class TransactionPanel extends RightPanel {
    public TransactionPanel(MainFrame frame){
        super(frame, new TransactionTableData(new FunctionsHandler(frame, new TransactionAddEditDialog(frame))), "TRANSACTIONS", Style.ICON_PANEL_TRANSACTIONS,
                new JPanel[] {new FunctionsToolBar(new FunctionsHandler(frame, new TransactionAddEditDialog(frame))), new FilterPanel(frame )});
    }
}
