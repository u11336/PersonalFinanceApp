package app.gui;

import app.settings.Style;
import app.settings.TextConstants;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.util.Date;
import java.util.Properties;

public class MainDatePicker {

    private final JDatePickerImpl datePicker;

    public MainDatePicker(){
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", TextConstants.getConstant("TODAY"));
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

        datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
        model.setValue(new Date());

        JButton btn = (JButton) datePicker.getComponent(1);
        btn.setIcon(Style.ICON_DATE);
        btn.setText("");
    }

    public JDatePickerImpl getDatePicker(){
        return datePicker;
    }

    public void setValue(Date date){
        ((UtilDateModel) datePicker.getModel()).setValue(date);
    }
}
