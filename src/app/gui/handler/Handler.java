package app.gui.handler;

import app.gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Handler implements ActionListener {
    protected final MainFrame frame;

    public Handler(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        frame.refresh();
    }
}
