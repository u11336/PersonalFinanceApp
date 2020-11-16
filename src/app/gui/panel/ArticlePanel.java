package app.gui.panel;

import app.gui.MainFrame;
import app.gui.dialog.AccountAddEditDialog;
import app.gui.dialog.ArticleAddEditDialog;
import app.gui.handler.FunctionsHandler;
import app.gui.table.ArticleTableData;
import app.gui.toolbar.FunctionsToolBar;
import app.settings.Style;

public class ArticlePanel extends RightPanel {
    public ArticlePanel(MainFrame frame){
        super(frame, new ArticleTableData(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))), "ARTICLES", Style.ICON_PANEL_ARTICLES, new FunctionsToolBar(new FunctionsHandler(frame, new ArticleAddEditDialog(frame))));
    }
}
