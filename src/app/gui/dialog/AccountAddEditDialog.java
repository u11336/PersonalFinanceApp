package app.gui.dialog;

import app.exception.ModelException;
import app.gui.MainFrame;
import app.model.Account;
import app.model.Common;
import app.model.Currency;
import app.saveLoad.SaveData;
import app.settings.Format;
import app.settings.Style;

import javax.swing.*;
import java.text.NumberFormat;

public class AccountAddEditDialog extends AddEditDialog {
    public AccountAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        components.put("LABEL_TITLE", new JTextField());
        components.put("LABEL_CURRENCY", new CommonComboBox(SaveData.getInstance().getEnableCurrencies().toArray()));
        components.put("LABEL_START_AMOUNT", new JTextField());

        icons.put("LABEL_TITLE", Style.ICON_TITLE);
        icons.put("LABEL_CURRENCY", Style.ICON_CURRENCY);
        icons.put("LABEL_START_AMOUNT", Style.ICON_AMOUNT);

        values.put("LABEL_START_AMOUNT", Format.amount(0));
    }

    @Override
    protected void setValues() {
        Account account = (Account) c;
        values.put("LABEL_TITLE", account.getTitle());
        values.put("LABEL_CURRENCY", account.getCurrency());
        values.put("LABEL_START_AMOUNT", account.getStartAmount());
    }

    @Override
    public Common getCommonFromForm() throws ModelException {
        try {
            String title = ((JTextField) components.get("LABEL_TITLE")).getText();
            String startAmount = ((JTextField) components.get("LABEL_AMOUNT")).getText();
            Currency currency = (Currency) ((CommonComboBox) components.get("LABEL_CURRENCY")).getSelectedItem();
            return new Account(title, currency, Format.fromAmountToNumber(startAmount));
        }
        catch(NumberFormatException e){
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }
}
