package app.gui;

import app.settings.Style;
import app.settings.TextConstants;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public final class Chart {
    private DefaultPieDataset dataset;
    private String title;
    private String currencyTitle;

    public Chart(HashMap<String, Double> data, String title, String currencyTitle){
        setData(data);
        this.title = TextConstants.getConstant(title);
        this.currencyTitle = currencyTitle;
    }

    private void setData(HashMap<String, Double> data) {
        dataset = new DefaultPieDataset();
        for (Map.Entry<String, Double> entry : data.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
    }

    public JPanel getPanel(){
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, true);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setToolTipGenerator(new StandardPieToolTipGenerator("{0} : {1} " + currencyTitle + " ({2})"));
        JPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(Style.DIMENSION_CHART);
        if(dataset.getItemCount() == 0) {
            panel.setLayout(new GridBagLayout());
            JLabel label = new JLabel(TextConstants.getConstant("CHART_NO_DATA"));
            label.setFont(Style.FONT_LABEL_HEADER);
            panel.add(label)
        }
        return panel;
    }
}
