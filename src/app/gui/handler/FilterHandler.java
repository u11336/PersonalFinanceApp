package app.gui.handler;

import app.gui.MainFrame;
import app.saveLoad.SaveData;
import app.settings.HandlerCode;

import java.awt.event.ActionEvent;

public class FilterHandler extends Handler {

    public FilterHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        switch(actionEvent.getActionCommand()){
            case HandlerCode.LEFT:{
                SaveData.getInstance().getFilter().prev();
                break;
            }
            case HandlerCode.RIGHT:{
                SaveData.getInstance().getFilter().next();
                break;
            }
            case HandlerCode.STEP:{
                SaveData.getInstance().getFilter().nextPeriod();
                break;
            }
        }
        super.actionPerformed(actionEvent);
    }
}
