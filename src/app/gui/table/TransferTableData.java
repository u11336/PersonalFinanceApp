package app.gui.table;

import app.gui.table.model.TransferTableModel;
import app.gui.table.renderer.MainTableCellRenderer;
import app.settings.Style;
import app.settings.TextConstants;

import javax.swing.*;
import java.awt.*;

public class TransferTableData extends TableData {
    private static final String[] columns = new String[]{"DATE", "FROM_ACCOUNT", "TO_ACCOUNT", "FROM_AMOUNT", "TO_AMOUNT", "NOTICE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_DATE, Style.ICON_ACCOUNT, Style.ICON_ACCOUNT, Style.ICON_AMOUNT,
            Style.ICON_AMOUNT, Style.ICON_NOTICE};

    public TransferTableData(){
        super(new TransferTableModel(columns), columns, icons);
        init();
    }

    @Override
    protected final void init() {
        getColumn(TextConstants.getConstant("FROM_AMOUNT")).setCellRenderer(new TableCellAmountRenderer(Style.COLOR_EXP));
        getColumn(TextConstants.getConstant("TO_AMOUNT")).setCellRenderer(new TableCellAmountRenderer(Style.COLOR_INC));
    }

    private class TableCellAmountRenderer extends MainTableCellRenderer {

        private final Color color;

        public TableCellAmountRenderer(Color color){
            this.color = color;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            renderer.setForeground(color);
            return renderer;
        }
    }
}

