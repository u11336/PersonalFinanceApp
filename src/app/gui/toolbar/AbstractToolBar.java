package app.gui.toolbar;

import app.gui.MainButton;
import app.gui.Refresh;
import app.gui.handler.Handler;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public abstract class AbstractToolBar extends JPanel implements Refresh {
    private final Handler handler;

    public AbstractToolBar(EmptyBorder border, Handler handler){
        super();
        this.handler = handler;
        setBorder(border);
    }

    abstract protected void init();

    protected MainButton addButton(String title, ImageIcon icon, String action, boolean topIcon){
        MainButton btn = new MainButton(title, icon, handler, action);
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
