package app.gui.toolbar;

import app.gui.handler.MainToolBarHandler;
import app.settings.HandlerCode;
import app.settings.Style;
import app.settings.TextConstants;

public final class MainToolBar extends AbstractToolBar {

    public MainToolBar(MainToolBarHandler handler){
        super(Style.BORDER_MAIN_TOOLBAR, handler);
        init();
    }

    @Override
    protected void init() {
        addButton(TextConstants.getConstant("TOOLBAR_OVERVIEW"), Style.ICON_TOOLBAR_OVERVIEW, HandlerCode.TOOLBAR_OVERVIEW, true);
        addButton(TextConstants.getConstant("TOOLBAR_ACCOUNTS"), Style.ICON_TOOLBAR_ACCOUNTS, HandlerCode.TOOLBAR_ACCOUNTS, true);
        addButton(TextConstants.getConstant("TOOLBAR_ARTICLES"), Style.ICON_TOOLBAR_ARTICLES, HandlerCode.TOOLBAR_ARTICLES, true);
        addButton(TextConstants.getConstant("TOOLBAR_TRANSACTIONS"), Style.ICON_TOOLBAR_TRANSACTIONS, HandlerCode.TOOLBAR_TRANSACTIONS, true);
        addButton(TextConstants.getConstant("TOOLBAR_TRANSFERS"), Style.ICON_TOOLBAR_TRANSFERS, HandlerCode.TOOLBAR_TRANSFERS, true);
        addButton(TextConstants.getConstant("TOOLBAR_CURRENCIES"), Style.ICON_TOOLBAR_CURRENCIES, HandlerCode.TOOLBAR_CURRENCIES, true);
        addButton(TextConstants.getConstant("TOOLBAR_STATISTICS"), Style.ICON_TOOLBAR_STATISTICS, HandlerCode.TOOLBAR_STATISTICS, true);
    }
}
