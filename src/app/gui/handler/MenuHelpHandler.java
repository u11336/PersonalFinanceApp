package app.gui.handler;

import app.gui.MainFrame;
import app.gui.dialog.AboutDialog;
import app.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class MenuHelpHandler extends Handler {

    public MenuHelpHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        new AboutDialog().setVisible(true);
        super.actionPerformed(actionEvent);
    }
}
