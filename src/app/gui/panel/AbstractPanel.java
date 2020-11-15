package app.gui.panel;

import app.gui.MainFrame;
import app.gui.Refresh;

import javax.swing.*;

public abstract class AbstractPanel extends JPanel implements Refresh {

    protected final MainFrame frame;

    public AbstractPanel (MainFrame frame){
        this.frame = frame;
    }

    @Override
    public void refresh() {
        removeAll();
        init();
    }

    protected abstract void init();


}
