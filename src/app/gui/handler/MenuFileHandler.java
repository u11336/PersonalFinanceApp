package app.gui.handler;

import app.gui.MainFileChooser;
import app.gui.MainFrame;
import app.gui.dialog.ConfirmDialog;
import app.gui.dialog.ErrorDialog;
import app.saveLoad.SaveData;
import app.settings.HandlerCode;
import app.settings.Settings;
import app.settings.TextConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class MenuFileHandler extends Handler {

    private final MainFileChooser fc;

    public MenuFileHandler(MainFrame frame) {
        super(frame);
        fc = new MainFileChooser(frame);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch(actionEvent.getActionCommand()){
            case HandlerCode.MENU_FILE_NEW:{
                Settings.setFileSave(null);
                SaveData.getInstance().clear();
                break;
            }
            case HandlerCode.MENU_FILE_OPEN:{
                int result = fc.open();
                if(result == JFileChooser.APPROVE_OPTION){
                    Settings.setFileSave(fc.getSelectedFile());
                    SaveData.getInstance().clear();
                    SaveData.getInstance().load();
                }
                break;
            }
            case HandlerCode.MENU_FILE_SAVE:{
                if(Settings.getFileSave() == null){
                    int result = fc.save();
                    if (result == JFileChooser.APPROVE_OPTION) {
                        String path = fc.getSelectedFile().getAbsolutePath();
                        String ext = path.substring(path.lastIndexOf(".") + 1);
                        if (ext.equals(Settings.SAVE_EXT)) Settings.setFileSave(new File(path));
                        else Settings.setFileSave(new File(path + "." + Settings.SAVE_EXT));
                    }
                }
                if(Settings.getFileSave() != null) SaveData.getInstance().save();
                break;
            }
            case HandlerCode.MENU_FILE_UPDATE_CURRENCIES:{
                try {
                    SaveData.getInstance().updateCurrencies();
                } catch (Exception e) {
                    ErrorDialog.show(frame, "ERROR_UPDATE_CURRENCIES");
                }
                break;
            }
            case HandlerCode.MENU_FILE_EXIT:{
                if(SaveData.getInstance().isSaved()) System.exit(0);
                else{
                    int result = ConfirmDialog.show(frame, "CONFIRM_EXIT_TEXT", "CONFIRM_EXIT_TITLE");
                    if(result == JOptionPane.YES_OPTION) System.exit(0);
                }
                break;
            }
        }
        super.actionPerformed(actionEvent);
    }
}
