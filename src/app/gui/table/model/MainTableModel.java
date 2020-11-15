package app.gui.table.model;

import app.gui.Refresh;
import app.model.Common;
import app.settings.TextConstants;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class MainTableModel extends AbstractTableModel implements Refresh {

    protected List<? extends Common> data;
    protected List<String> columns = new ArrayList<>();

    public MainTableModel(List data, String[] columns) {
        this.data = data;
        this.columns = new ArrayList<>(Arrays.asList(columns));
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public String getColumnName(int columnIndex){
        return TextConstants.getConstant(columns.get(columnIndex));
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Object obj = getValueAt(0, columnIndex);
        if(obj == null) return Object.class;
        return obj.getClass();
    }

    @Override
    public void refresh() {
        updateData();
        fireTableStructureChanged();
        fireTableDataChanged();
    }

    protected abstract void updateData();
}
