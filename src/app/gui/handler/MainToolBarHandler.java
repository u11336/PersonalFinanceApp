package app.gui.handler;

import app.gui.MainFrame;
import app.gui.panel.*;
import app.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MainToolBarHandler extends MenuViewHandler {

    public MainToolBarHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch(actionEvent.getActionCommand()){
            case HandlerCode.TOOLBAR_OVERVIEW:{
                showOverviewPanel();
                break;
            }
            case HandlerCode.TOOLBAR_ACCOUNTS:{
                showAccountPanel();
                break;
            }
            case HandlerCode.TOOLBAR_ARTICLES:{
                showArticlePanel();
                break;
            }
            case HandlerCode.TOOLBAR_TRANSACTIONS:{
                showTransactionPanel();
                break;
            }
            case HandlerCode.TOOLBAR_TRANSFERS:{
                showTransferPanel();
                break;
            }
            case HandlerCode.TOOLBAR_CURRENCIES:{
                showCurrencyPanel();
                break;
            }
            case HandlerCode.TOOLBAR_STATISTICS:{
                showStatisticPanel();
                break;
            }
        }
        super.actionPerformed(actionEvent);
    }
}
