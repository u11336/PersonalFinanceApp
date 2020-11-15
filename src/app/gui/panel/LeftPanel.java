package app.gui.panel;

import app.gui.MainFrame;
import app.model.Currency;
import app.model.Statistics;
import app.saveLoad.SaveData;
import app.settings.Format;
import app.settings.Style;
import app.settings.TextConstants;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;

public class LeftPanel extends AbstractPanel {

    public LeftPanel(MainFrame frame) {
        super(frame);
        init();
    }

    @Override
    protected void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(Style.BORDER_LEFT_PANEL);
        JLabel headerBC = new JLabel(TextConstants.getConstant("BALANCE_CURRENCIES"));
        headerBC.setFont(Style.FONT_LABEL_HEADER);
        headerBC.setIcon(Style.ICON_LEFT_PANEL_BALANCE_CURRENCIES);
        headerBC.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(headerBC);
        
        addBalanceCurrency();

        add(Box.createVerticalStrut(Style.PADDING_PANEL_BIG));

        JLabel headerB = new JLabel(TextConstants.getConstant("BALANCE"));
        headerB.setFont(Style.FONT_LABEL_HEADER);
        headerB.setIcon(Style.ICON_LEFT_PANEL_BALANCE);
        headerB.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        add(headerB);
        addBalance();
    }

    private void addBalance() {
        for(Currency currency : SaveData.getInstance().getCurrencies()) {
            add(Box.createVerticalStrut(Style.PADDING_BALANCE));
            add(new PanelBalanceCurrency(currency, Statistics.getBalance(currency)));
        }
    }

    private void addBalanceCurrency() {
        for(Currency currency : SaveData.getInstance().getCurrencies()) {
            add(Box.createVerticalStrut(Style.PADDING_BALANCE));
            add(new PanelBalanceCurrency(currency, Statistics.getBalanceCurrency(currency)));
        }
    }

    private class PanelBalanceCurrency extends JPanel{
        public PanelBalanceCurrency(Currency currency, double amount) {
            super();
            setLayout(new BorderLayout());
            setBackground(Style.COLOR_LEFT_PANEL_BALANCE);
            setBorder(Style.BORDER_PANEL);

            JLabel currencyLabel = new JLabel(currency.getTitle());
            JLabel amountLabel = new JLabel(Format.amount(amount, currency));

            currencyLabel.setFont(Style.FONT_LABEL_LEFT_PANEL_CURRENCY);
            currencyLabel.setFont(Style.FONT_LABEL_LEFT_PANEL_AMOUNT);

            add(currencyLabel, BorderLayout.WEST);
            add(Box.createRigidArea(Style.DIMENSION_PADDING_BALANCE));
            add(amountLabel, BorderLayout.EAST);
        }

    }
}
