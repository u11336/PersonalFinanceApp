package app.gui.handler;

import app.gui.MainFileChooser;
import app.gui.MainFrame;
import app.gui.dialog.ConfirmDialog;
import app.gui.dialog.ErrorDialog;
import app.gui.panel.*;
import app.gui.table.TableData;
import app.saveLoad.SaveData;
import app.settings.HandlerCode;
import app.settings.Settings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class MenuViewHandler extends Handler {

    public MenuViewHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        FunctionsHandler handler = frame.getRightPanel().getTableData().getFunctionshandler();
        switch(actionEvent.getActionCommand()){
            case HandlerCode.MENU_VIEW_OVERVIEW:{
                showOverviewPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_ACCOUNTS:{
                showAccountPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_ARTICLES:{
                showArticlePanel();
                break;
            }
            case HandlerCode.MENU_VIEW_TRANSACTIONS:{
                showTransactionPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_TRANSFERS:{
                showTransferPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_CURRENCIES:{
                showCurrencyPanel();
                break;
            }
            case HandlerCode.MENU_VIEW_STATISTICS:{
                showStatisticPanel();
                break;
            }
        }
        super.actionPerformed(actionEvent);
    }

    protected void showOverviewPanel(){
        frame.setRightPanel(new OverviewPanel(frame));
    }
    protected void showAccountPanel(){
        frame.setRightPanel(new AccountPanel(frame));
    }
    protected void showArticlePanel(){
        frame.setRightPanel(new ArticlePanel(frame));
    }
    protected void showTransactionPanel(){
        frame.setRightPanel(new TransactionPanel(frame));
    }
    protected void showTransferPanel(){
        frame.setRightPanel(new TransferPanel(frame));
    }
    protected void showCurrencyPanel(){
        frame.setRightPanel(new CurrencyPanel(frame));
    }
    protected void showStatisticPanel(){
        frame.setRightPanel(new StatisticsPanel(frame));
    }
}
