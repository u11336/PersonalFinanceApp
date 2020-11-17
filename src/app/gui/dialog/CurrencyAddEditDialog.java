package app.gui.dialog;

import app.exception.ModelException;
import app.gui.MainFrame;
import app.model.Currency;
import app.settings.Format;
import app.settings.Settings;
import app.settings.Style;
import app.settings.TextConstants;

import javax.swing.*;

public class CurrencyAddEditDialog extends AddEditDialog {
    public CurrencyAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        components.put("LABEL_TITLE", new JTextField());
        components.put("LABEL_CODE", new JComboBox(Settings.CURRENCY_CODES));
        components.put("LABEL_RATE", new JTextField());
        components.put("LABEL_ON", new JComboBox(new String[]{TextConstants.getConstant("YES"), TextConstants.getConstant("NO")}));
        components.put("LABEL_BASE", new JComboBox(new String[]{TextConstants.getConstant("YES"), TextConstants.getConstant("NO")}));

        icons.put("LABEL_TITLE", Style.ICON_TITLE);
        icons.put("LABEL_CODE", Style.ICON_CODE);
        icons.put("LABEL_RATE", Style.ICON_RATE);
        icons.put("LABEL_ON", Style.ICON_ON);
        icons.put("LABEL_BASE", Style.ICON_BASE);

        values.put("LABEL_RATE", Format.amount(1));
    }

    @Override
    protected void setValues() {
        Currency currency = (Currency) c;
        values.put("LABEL_TITLE", currency.getTitle());
        values.put("LABEL_CODE", currency.getCode());
        values.put("LABEL_RATE", currency.getRate());
        if(currency.isOn()) values.put("LABEL_ON", TextConstants.getConstant("YES"));
        else values.put("LABEL_ON", TextConstants.getConstant("NO"));
        if(currency.isBase()) values.put("LABEL_BASE", TextConstants.getConstant("YES"));
        else values.put("LABEL_BASE", TextConstants.getConstant("NO"));
    }

    @Override
    public Currency getCommonFromForm() throws ModelException {
        try {
            String title = ((JTextField) components.get("LABEL_TITLE")).getText();
            String code = (String) ((JComboBox) components.get("LABEL_CODE")).getSelectedItem();
            String rate = ((JTextField) components.get("LABEL_RATE")).getText();
            boolean isOn = false;
            if(((JComboBox)components.get("LABEL_ON")).getSelectedItem().equals(TextConstants.getConstant("YES")))
                isOn = true;
            boolean isBase = false;
            if(((JComboBox)components.get("LABEL_BASE")).getSelectedItem().equals(TextConstants.getConstant("YES")))
                isBase = true;
            if(!isBase && c != null && ((Currency) c).isBase()) throw new ModelException(ModelException.NO_BASE_CURRENCY);
            return new Currency(title, code, Format.fromAmountToNumber(rate), isOn, isBase);
        }
        catch(NumberFormatException e){
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }
}
