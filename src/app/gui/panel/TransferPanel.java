package app.gui.panel;

import app.gui.MainFrame;
import app.gui.dialog.AccountAddEditDialog;
import app.gui.dialog.TransferAddEditDialog;
import app.gui.handler.FunctionsHandler;
import app.gui.table.TransferTableData;
import app.gui.toolbar.FunctionsToolBar;
import app.settings.Style;

import javax.swing.*;

public class TransferPanel extends RightPanel {
    public TransferPanel(MainFrame frame){
        super(frame, new TransferTableData(new FunctionsHandler(frame, new TransferAddEditDialog(frame))), "TRANSFERS", Style.ICON_PANEL_TRANSFERS,
                new JPanel[] {new FunctionsToolBar(new FunctionsHandler(frame, new TransferAddEditDialog(frame))), new FilterPanel(frame )});
    }
}
