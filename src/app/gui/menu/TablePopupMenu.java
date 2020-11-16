package app.gui.menu;

import app.gui.Refresh;
import app.gui.handler.FunctionsHandler;
import app.settings.HandlerCode;
import app.settings.Style;
import app.settings.TextConstants;

import javax.swing.*;

public class TablePopupMenu extends JPopupMenu implements Refresh {

    private final FunctionsHandler handler;

    public TablePopupMenu(FunctionsHandler handler) {
        super();
        this.handler = handler;
        init();
    }

    private void init() {
        JMenuItem editItem = new JMenuItem(TextConstants.getConstant("EDIT"));
        JMenuItem deleteItem = new JMenuItem(TextConstants.getConstant("DELETE"));

        editItem.setActionCommand(HandlerCode.EDIT);
        deleteItem.setActionCommand(HandlerCode.DELETE);

        editItem.addActionListener(handler);
        deleteItem.addActionListener(handler);

        editItem.setIcon(Style.ICON_MENU_POPUP_EDIT);
        deleteItem.setIcon(Style.ICON_MENU_POPUP_DELETE);

        add(editItem);
        add(deleteItem);
    }

    @Override
    public void refresh() {

    }
}
