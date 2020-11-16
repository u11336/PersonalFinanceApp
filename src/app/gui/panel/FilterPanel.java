package app.gui.panel;

import app.gui.MainButton;
import app.gui.MainFrame;
import app.gui.handler.FilterHandler;
import app.saveLoad.SaveData;
import app.settings.Format;
import app.settings.HandlerCode;
import app.settings.Style;

import java.awt.*;

public class FilterPanel extends AbstractPanel{

    public FilterPanel(MainFrame frame) {
        super(frame);
        init();
    }

    @Override
    protected void init() {

        FlowLayout layout = new FlowLayout();
        layout.setVgap(0);
        setLayout(layout);
        MainButton left = new MainButton(Style.ICON_LEFT, new FilterHandler(frame), HandlerCode.LEFT);
        MainButton step = new MainButton(Format.getTitleFilter(SaveData.getInstance().getFilter()), new FilterHandler(frame), HandlerCode.STEP);
        MainButton right = new MainButton(Style.ICON_RIGHT, new FilterHandler(frame), HandlerCode.RIGHT);

        setBorder(Style.BORDER_FILTER_PANEL);

        step.setFont(Style.FONT_BTN_FILTER);
        step.setPreferredSize(new Dimension(Style.WIDTH_FILTER_BTN, left.getPreferredSize().height));

        add(left);
        add(step);
        add(right);
    }
}
