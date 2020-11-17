package app.gui.handler;

import app.exception.ModelException;
import app.gui.MainFrame;
import app.gui.dialog.AddEditDialog;
import app.gui.dialog.ErrorDialog;
import app.saveLoad.SaveData;
import app.settings.HandlerCode;

import java.awt.event.*;

public class AddEditDialogHandler extends Handler implements KeyListener, WindowListener {

    private final AddEditDialog dialog;

    public AddEditDialogHandler(MainFrame frame, AddEditDialog dialog) {
        super(frame);
        this.dialog = dialog;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        closeDialog();
    }
    
    @Override
    public void actionPerformed(ActionEvent actionEvent){
        try {
            switch (actionEvent.getActionCommand()){
                case HandlerCode.ADD:
                    SaveData.getInstance().add(dialog.getCommonFromForm());
                    break;
                case HandlerCode.EDIT:
                    SaveData.getInstance().edit(dialog.getCommon(), dialog.getCommonFromForm());
                    break;
                case HandlerCode.CANCEL:
                    closeDialog();
                    break;
            }
            super.actionPerformed(actionEvent);
        } catch (ModelException e) {
            ErrorDialog.show(frame, e.getMessage());
        }
    }

    private void closeDialog() {
        dialog.closeDialog();
    }


///////////////////////
    @Override
    public void keyTyped(KeyEvent keyEvent) { }

    @Override
    public void keyReleased(KeyEvent keyEvent) { }

    @Override
    public void windowOpened(WindowEvent windowEvent) { }

    @Override
    public void windowClosed(WindowEvent windowEvent) { }

    @Override
    public void windowIconified(WindowEvent windowEvent) { }

    @Override
    public void windowDeiconified(WindowEvent windowEvent) { }

    @Override
    public void windowActivated(WindowEvent windowEvent) { }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) { }
}
