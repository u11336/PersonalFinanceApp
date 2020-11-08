package app.model;

import app.exception.ModelException;
import app.saveLoad.SaveData;

import java.util.Objects;

public class Article extends Common {
    private String title;

    public Article() {
    }

    public Article(String title) throws ModelException {
        if (title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Record{" +
                "title='" + title + '\'' +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String getValueForComboBox() {
        return title;
    }

    @Override
    public void postEdit(SaveData s){
        for(Transaction t : s.getTransactions())
            if(t.getArticle().equals(s.getOldCommon())) t.setArticle(this);
    }
}
