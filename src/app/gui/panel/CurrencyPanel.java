package app.gui.panel;

import app.gui.MainFrame;
import app.gui.table.ArticleTableData;
import app.gui.table.CurrencyTableData;
import app.gui.toolbar.FunctionsToolBar;
import app.settings.Style;

public class CurrencyPanel extends RightPanel {
    public CurrencyPanel(MainFrame frame){
        super(frame, new CurrencyTableData(), "CURRENCIES", Style.ICON_PANEL_CURRENCIES, new FunctionsToolBar());
    }
}
