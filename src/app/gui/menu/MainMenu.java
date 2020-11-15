package app.gui.menu;

import app.gui.EnableEditDelete;
import app.gui.MainFrame;
import app.gui.Refresh;
import app.settings.HandlerCode;
import app.settings.Style;
import app.settings.TextConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenu extends JMenuBar implements Refresh, EnableEditDelete {

    // buttons
    private JMenuItem menuEdit;
    private JMenuItem menuDelete;
    private final MainFrame frame;

    public MainMenu (MainFrame frame){
        super();
        this.frame = frame;
        init();
    }

    private void init() {
        //init menu
        JMenu file = new JMenu(TextConstants.getConstant("MENU_FILE"));
        JMenu edit = new JMenu(TextConstants.getConstant("MENU_EDIT"));
        JMenu view = new JMenu(TextConstants.getConstant("MENU_VIEW"));
        JMenu help = new JMenu(TextConstants.getConstant("MENU_HELP"));

        file.setIcon(Style.ICON_MENU_FILE);
        edit.setIcon(Style.ICON_MENU_EDIT);
        view.setIcon(Style.ICON_MENU_VIEW);
        help.setIcon(Style.ICON_MENU_HELP);

        add(file);
        add(edit);
        add(view);
        add(help);

        addMenuItem(file, TextConstants.getConstant("MENU_FILE_NEW"), Style.ICON_MENU_FILE_NEW, HandlerCode.MENU_FILE_NEW, KeyEvent.VK_N);
        addMenuItem(file, TextConstants.getConstant("MENU_FILE_OPEN"), Style.ICON_MENU_FILE_OPEN, HandlerCode.MENU_FILE_OPEN, KeyEvent.VK_O);
        addMenuItem(file, TextConstants.getConstant("MENU_FILE_SAVE" ), Style.ICON_MENU_FILE_SAVE, HandlerCode.MENU_FILE_SAVE, KeyEvent.VK_S);
        addMenuItem(file, TextConstants.getConstant("MENU_FILE_UPDATE_CURRENCIES"), Style.ICON_MENU_FILE_UPDATE_CURRENCIES, HandlerCode.MENU_FILE_UPDATE_CURRENCIES);
        addMenuItem(file, TextConstants.getConstant("MENU_FILE_EXIT"), Style.ICON_MENU_FILE_EXIT, HandlerCode.MENU_FILE_EXIT);

        addMenuItem(edit, TextConstants.getConstant("MENU_EDIT_ADD"), Style.ICON_MENU_EDIT_ADD, HandlerCode.MENU_EDIT_ADD);
        menuEdit = addMenuItem(edit, TextConstants.getConstant("MENU_EDIT_EDIT"), Style.ICON_MENU_EDIT_EDIT, HandlerCode.MENU_EDIT_EDIT);
        menuDelete = addMenuItem(edit, TextConstants.getConstant("MENU_EDIT_DELETE"), Style.ICON_MENU_EDIT_DELETE, HandlerCode.MENU_EDIT_DELETE);
        menuEdit.setEnabled(false);
        menuDelete.setEnabled(false);

        addMenuItem(view, TextConstants.getConstant("MENU_VIEW_OVERVIEW"), Style.ICON_MENU_VIEW_OVERVIEW, HandlerCode.MENU_VIEW_OVERVIEW);
        addMenuItem(view, TextConstants.getConstant("MENU_VIEW_ACCOUNTS"), Style.ICON_MENU_VIEW_ACCOUNTS, HandlerCode.MENU_VIEW_ACCOUNTS);
        addMenuItem(view, TextConstants.getConstant("MENU_VIEW_ARTICLES"), Style.ICON_MENU_VIEW_ARTICLES, HandlerCode.MENU_VIEW_ARTICLES);
        addMenuItem(view, TextConstants.getConstant("MENU_VIEW_TRANSACTIONS"), Style.ICON_MENU_VIEW_TRANSACTIONS, HandlerCode.MENU_VIEW_TRANSACTIONS);
        addMenuItem(view, TextConstants.getConstant("MENU_VIEW_TRANSFERS"), Style.ICON_MENU_VIEW_TRANSFERS, HandlerCode.MENU_VIEW_TRANSFERS);
        addMenuItem(view, TextConstants.getConstant("MENU_VIEW_CURRENCIES"), Style.ICON_MENU_VIEW_CURRENCIES, HandlerCode.MENU_VIEW_CURRENCIES);
        addMenuItem(view, TextConstants.getConstant("MENU_VIEW_STATISTICS"), Style.ICON_MENU_VIEW_STATISTICS, HandlerCode.MENU_VIEW_STATISTICS);

        addMenuItem(help, TextConstants.getConstant("MENU_HELP_ABOUT"), Style.ICON_MENU_HELP_ABOUT, HandlerCode.MENU_HELP_ABOUT);
    }

    private JMenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action, int key){
        JMenuItem item = new JMenuItem(title);
        item.setActionCommand(action);
        item.setIcon(icon);
        if(key != 0) {
            KeyStroke shortKey = KeyStroke.getKeyStroke(key, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
            item.setAccelerator(shortKey);
        }
        menu.add(item);
        return item;
    }

    private JMenuItem addMenuItem(JMenu menu, String title, ImageIcon icon, String action){
        return addMenuItem(menu, title, icon, action, 0);
    }


    @Override
    public void setEnableEditDelete(boolean enable) {
        menuEdit.setEnabled(enable);
        menuDelete.setEnabled(enable);
    }

    @Override
    public void refresh() {
        removeAll();
        init();
    }
}