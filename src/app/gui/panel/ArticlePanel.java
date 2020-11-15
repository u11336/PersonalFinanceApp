package app.gui.panel;

import app.gui.MainFrame;
import app.gui.table.ArticleTableData;
import app.gui.toolbar.FunctionsToolBar;
import app.settings.Style;

public class ArticlePanel extends RightPanel {
    public ArticlePanel(MainFrame frame){
        super(frame, new ArticleTableData(), "ARTICLES", Style.ICON_PANEL_ARTICLES, new FunctionsToolBar());
    }
}
