package app.gui.handler;

import app.gui.MainFrame;
import app.gui.dialog.ConfirmDialog;
import app.saveLoad.SaveData;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindowHandler extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent windowEvent) {
        if(SaveData.getInstance().isSaved()) System.exit(0);
        else{
            int result = ConfirmDialog.show((MainFrame) windowEvent.getWindow(), "CONFIRM_EXIT_TEXT", "CONFIRM_EXIT_TITLE");
            if(result == JOptionPane.YES_OPTION) System.exit(0);
        }
    }
}
