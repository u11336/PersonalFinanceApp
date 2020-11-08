package app.model;

import app.saveLoad.SaveData;

abstract public class Common {

    public Common(){

    }
    public String getValueForComboBox(){
        return null;
    }
    public void postAdd(SaveData s) {}
    public void postEdit(SaveData s) {}
    public void postRemove(SaveData s) {}
}
