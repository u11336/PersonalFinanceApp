package app.gui.panel;

import app.gui.MainFrame;
import app.gui.table.TableData;
import app.gui.table.TransactionTableData;
import app.model.Transaction;
import app.settings.Settings;
import app.settings.Style;

import javax.swing.*;

public class OverviewPanel extends RightPanel {
    public OverviewPanel(MainFrame frame){
        super(frame, new TransactionTableData(Settings.OVERVIEW_ROWS_NUMBER), "LAST_TRANSACTIONS", Style.ICON_PANEL_OVERVIEW);
    }
}
