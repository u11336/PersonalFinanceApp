package app.gui.dialog;

import app.gui.MainFrame;
import app.settings.TextConstants;

import javax.swing.*;

public class ConfirmDialog {
    public static int show(MainFrame frame, String text, String title){
        String[] options = {TextConstants.getConstant("YES"), TextConstants.getConstant("NO")};
        int result = JOptionPane.showOptionDialog(frame, text, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        return result;
    }
}
