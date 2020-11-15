package app.gui.table.renderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TableHeaderIconRenderer extends DefaultTableCellRenderer {

    private final JLabel label;

    public TableHeaderIconRenderer(ImageIcon icon) {
        super();
        label = new JLabel(icon);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        TableCellRenderer tcr = table.getTableHeader().getDefaultRenderer();
        Component renderer = tcr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setFont(renderer.getFont());
        label.setForeground(renderer.getForeground());
        label.setBorder(((JComponent) renderer).getBorder());
        return label;
    }
}
