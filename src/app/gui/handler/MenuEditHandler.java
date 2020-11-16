package app.gui.handler;

import app.gui.MainFileChooser;
import app.gui.MainFrame;
import app.gui.dialog.ConfirmDialog;
import app.gui.dialog.ErrorDialog;
import app.gui.table.TableData;
import app.saveLoad.SaveData;
import app.settings.HandlerCode;
import app.settings.Settings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class MenuEditHandler extends Handler {

    public MenuEditHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        FunctionsHandler handler = frame.getRightPanel().getTableData().getFunctionshandler();
        switch(actionEvent.getActionCommand()){
            case HandlerCode.MENU_EDIT_ADD:{
                handler.add();
                break;
            }
            case HandlerCode.MENU_EDIT_EDIT:{
                handler.edit();
                break;
            }
            case HandlerCode.MENU_EDIT_DELETE:{
                handler.delete();
                break;
            }
        }
        super.actionPerformed(actionEvent);
    }
}
