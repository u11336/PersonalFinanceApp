package app.gui.handler;

import app.gui.MainFrame;
import app.gui.panel.StatisticsPanel;
import app.saveLoad.SaveData;
import app.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class ChartHandler extends Handler {

    public ChartHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ((StatisticsPanel) frame.getRightPanel()).nextType();
        super.actionPerformed(actionEvent);
    }
}
