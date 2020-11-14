package app.gui.dialog;

import app.gui.MainFrame;
import app.settings.TextConstants;

import javax.swing.*;

public class ErrorDialog {
    public static void show(MainFrame frame, String text){
        JOptionPane.showMessageDialog(frame, text, TextConstants.getConstant("ERROR"), JOptionPane.ERROR_MESSAGE);
    }
}
