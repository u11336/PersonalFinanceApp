package app.gui;

import app.settings.Style;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainButton extends JButton implements MouseListener {
    public MainButton(String title, ImageIcon icon, ActionListener listener, String action) {
        super(title);
        setIcon(icon);
        addActionListener(listener);
        setActionCommand(action);
        addMouseListener(this);

        setFont(Style.FONT_BTN_MAIN);
        setFocusPainted(false);
        setBackground(Style.COLOR_BTN_BG_NORMAL);
    }

    public MainButton(String title, ActionListener listener, String action) {
        this(title, null, listener, action);
    }

    public MainButton(ImageIcon icon, ActionListener listener, String action) {
        this("", icon, listener, action);
    }

        @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        ((MainButton) mouseEvent.getSource()).setBackground(Style.COLOR_BTN_BG_HOVER);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        ((MainButton) mouseEvent.getSource()).setBackground(Style.COLOR_BTN_BG_NORMAL);
    }

    @Override
    public void updateUI() {
        super.updateUI();
    }

    @Override
    public String getUIClassID() {
        return super.getUIClassID();
    }

    @Override
    public boolean isDefaultButton() {
        return super.isDefaultButton();
    }

    @Override
    public boolean isDefaultCapable() {
        return super.isDefaultCapable();
    }

    @Override
    public void setDefaultCapable(boolean b) {
        super.setDefaultCapable(b);
    }

    @Override
    public void removeNotify() {
        super.removeNotify();
    }

    @Override
    public AccessibleContext getAccessibleContext() {
        return super.getAccessibleContext();
    }
}
