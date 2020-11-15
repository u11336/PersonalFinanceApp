package app.gui.panel;

import app.gui.MainFrame;
import app.gui.table.TransactionTableData;
import app.gui.table.TransferTableData;
import app.gui.toolbar.FunctionsToolBar;
import app.settings.Style;

public class TransferPanel extends RightPanel {
    public TransferPanel(MainFrame frame){
        super(frame, new TransferTableData(), "TRANSFERS", Style.ICON_PANEL_TRANSFERS, new FunctionsToolBar());
    }
}
