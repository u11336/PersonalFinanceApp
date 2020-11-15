package app.gui.panel;

import app.gui.MainFrame;
import app.gui.table.TransactionTableData;
import app.gui.toolbar.FunctionsToolBar;
import app.settings.Style;

public class TransactionPanel extends RightPanel {
    public TransactionPanel(MainFrame frame){
        super(frame, new TransactionTableData(), "TRANSACTIONS", Style.ICON_PANEL_TRANSACTIONS, new FunctionsToolBar());
    }
}
