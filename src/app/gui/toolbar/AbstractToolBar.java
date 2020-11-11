package app.gui.toolbar;

import app.gui.MainButton;
import app.gui.Refresh;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public abstract class AbstractToolBar extends JPanel implements Refresh {
    public AbstractToolBar(EmptyBorder border){
        super();
        setBorder(border);
    }

    abstract protected void init();

    protected MainButton addButton(String title, ImageIcon icon, String action, boolean topIcon){
        MainButton btn = new MainButton(title, icon, null, action);
        if(topIcon) {
            btn.setHorizontalTextPosition(SwingConstants.CENTER);
            btn.setVerticalTextPosition(SwingConstants.BOTTOM);
        }
        else{
            btn.setHorizontalTextPosition(SwingConstants.RIGHT);
            btn.setVerticalTextPosition(SwingConstants.CENTER);
        }
        add(btn);
        return btn;
    }

    @Override
    public void refresh() {
        removeAll();
        init();
    }
}
