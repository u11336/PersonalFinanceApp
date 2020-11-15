package app.gui.table.model;

import app.model.Account;
import app.model.Article;
import app.saveLoad.SaveData;
import app.settings.Format;

public class ArticleTableModel extends MainTableModel {

    public static final int TITLE = 0;

    public ArticleTableModel(String[] columns){
        super(SaveData.getInstance().getArticles(), columns);
    }

    @Override
    protected void updateData() {
        data = SaveData.getInstance().getArticles();
    }

    @Override
    public Object getValueAt(int row, int column) {
        if(data.isEmpty()) return null;
        return ((Article) data.get(row)).getTitle();
    }
}
