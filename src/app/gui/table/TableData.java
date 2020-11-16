package app.gui.table;

import app.gui.Refresh;
import app.gui.handler.FunctionsHandler;
import app.gui.handler.Handler;
import app.gui.menu.TablePopupMenu;
import app.gui.table.model.MainTableModel;
import app.gui.table.renderer.MainTableCellRenderer;
import app.gui.table.renderer.TableHeaderIconRenderer;
import app.settings.Style;
import app.settings.TextConstants;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public abstract class TableData extends JTable implements Refresh {

    private final TablePopupMenu popupMenu;
    private final ImageIcon[] icons;
    private final String[] columns;
    private final FunctionsHandler handler;

    public TableData(MainTableModel tableModel, FunctionsHandler handler, String[] columns, ImageIcon[] icons) {
        super(tableModel);
        this.handler = handler;
        this.popupMenu = new TablePopupMenu(handler);
        this.columns = columns;
        this.icons = icons;

        getTableHeader().setFont(Style.FONT_TABLE_HEADER);
        setFont(Style.FONT_TABLE);
        setRowHeight(getRowHeight() + Style.TABLE_ADD_ROW_HEIGHT);

        setAutoCreateRowSorter(true);
        setPreferredScrollableViewportSize(Style.DIMENSION_TABLE_SHOW_SIZE);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        addMouseListener(handler);
        addKeyListener(handler);

        for (int i = 0; i < columns.length; i++) {
            getColumn(TextConstants.getConstant(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
        }

        MainTableCellRenderer renderer = new MainTableCellRenderer();
        setDefaultRenderer(String.class, renderer);
        setComponentPopupMenu(popupMenu);
    }

    @Override
    public JPopupMenu getComponentPopupMenu(){
        Point p = getMousePosition();
        if(p != null) {
            int row = rowAtPoint(p);
            if (isRowSelected(row)) setRowSelectionInterval(row, row);
            else return null;
        }
        return super.getComponentPopupMenu();
    }

    @Override
    public void refresh() {
        int selectedRow = getSelectedRow();
        ((MainTableModel) getModel()).refresh();
        for (int i = 0; i < columns.length; i++) {
            getColumn(TextConstants.getConstant(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
        }
        if(selectedRow != -1 && selectedRow < getRowCount()){
            setRowSelectionInterval(selectedRow, selectedRow);
            requestFocus();
        }
        init();
    }

    protected void init(){

    }

    public FunctionsHandler getFunctionshandler() {
        return handler;
    };
}
