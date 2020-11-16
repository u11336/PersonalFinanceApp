package app.gui.handler;

import app.gui.MainFrame;
import app.gui.dialog.AddEditDialog;
import app.gui.dialog.ConfirmDialog;
import app.gui.table.TableData;
import app.gui.table.model.MainTableModel;
import app.model.Common;
import app.saveLoad.SaveData;
import app.settings.HandlerCode;

import javax.swing.*;
import java.awt.event.*;

public class FunctionsHandler extends Handler implements MouseListener, KeyListener {

    private final AddEditDialog dialog;

    public FunctionsHandler(MainFrame frame, AddEditDialog dialog) {
        super(frame);
        this.dialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        switch (actionEvent.getActionCommand()){
            case HandlerCode.ADD:
                add();
                break;
            case HandlerCode.EDIT:
                edit();
                break;
            case HandlerCode.DELETE:
                delete();
                break;
        }
        super.actionPerformed(actionEvent);
    }

    private void delete() {
        Common c = getSelectedColumn();
        if (c != null) {
            int result = ConfirmDialog.show(frame, "CONFIRM_DELETE_TEXT", "CONFIRM_DELETE_TITLE");
            if(result == JOptionPane.YES_OPTION){
                SaveData.getInstance().remove(c);
            }
        }
    }

    private void edit() {
        showAddEditDialog(getSelectedColumn());
    }

    private void add() {
        showAddEditDialog(null);
    }

    private Common getSelectedColumn(){
        TableData td = frame.getRightPanel().getTableData();
        Common c = ((MainTableModel) td.getModel()).getCommonByRow(td.getSelectedRow());
        return c;
    }

    private void showAddEditDialog(Common c){
        dialog.setCommon(c);
        dialog.showDialog();
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_DELETE) delete();
        frame.refresh();
        frame.getRightPanel().getTableData().requestFocus();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(mouseEvent.getSource() instanceof TableData) {
            if(mouseEvent.getClickCount() == 2 && mouseEvent.getButton() == MouseEvent.BUTTON1){
                showAddEditDialog(getSelectedColumn());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if(mouseEvent.getSource() instanceof TableData){
            if(mouseEvent.getButton() == MouseEvent.BUTTON3){
                TableData td = frame.getRightPanel().getTableData();
                int row = td.rowAtPoint(mouseEvent.getPoint());
                td.setRowSelectionInterval(row, row);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
