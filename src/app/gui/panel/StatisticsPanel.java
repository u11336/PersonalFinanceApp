package app.gui.panel;

import app.gui.Chart;
import app.gui.MainFrame;
import app.model.Statistics;
import app.saveLoad.SaveData;
import app.settings.Style;
import app.settings.TextConstants;

import javax.swing.*;

public class StatisticsPanel extends RightPanel {

    public static final int TYPE_INC = 0;
    public static final int TYPE_EXP = 1;
    private int type = TYPE_INC;

    public StatisticsPanel(MainFrame frame) {
        super(frame, null, "STATISTICS", Style.ICON_PANEL_STATISTICS, new JPanel[]{
                new FilterPanel(frame),
                new StatisticsTypePanel(frame, "CHART_INC"),
                new Chart(Statistics.getDataForChartOnIncArticles(),
                        "CHART_INC",
                        SaveData.getInstance().getBaseCurrency().getCode()).getPanel()
        });
    }

    public void nextType(){
        type++;
        if(type > TYPE_EXP) type = TYPE_INC;
    }

    @Override
    public void refresh(){
        Chart chart = null;
        String title = null;
        if(type == TYPE_INC){
            title = "CHART_INC";
            chart = new Chart(Statistics.getDataForChartOnIncArticles(), "CHART_INC", SaveData.getInstance().getBaseCurrency().getCode());
        }
        else if(type == TYPE_EXP) {
            title = "CHART_EXP";
            chart = new Chart(Statistics.getDataForChartOnExpArticles(), "CHART_EXP", SaveData.getInstance().getBaseCurrency().getCode());
        }
        setPanels(new JPanel[]{ new FilterPanel(frame), new StatisticsTypePanel(frame, title), chart.getPanel()});
        super.refresh();
    }

}
