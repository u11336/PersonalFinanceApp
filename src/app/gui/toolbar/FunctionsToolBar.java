package app.gui.toolbar;

import app.gui.EnableEditDelete;
import app.gui.MainButton;
import app.settings.HandlerCode;
import app.settings.Style;
import app.settings.TextConstants;

public final class FunctionsToolBar extends AbstractToolBar implements EnableEditDelete {

    private MainButton editBtn;
    private MainButton deleteBtn;

    public FunctionsToolBar(){
        super(Style.BORDER_FUNCTIONS_TOOLBAR);
        init();
    }

    @Override
    protected void init() {
        addButton(TextConstants.getConstant("ADD"), Style.ICON_ADD, HandlerCode.ADD, false);
        editBtn = addButton(TextConstants.getConstant("EDIT"), Style.ICON_EDIT, HandlerCode.EDIT, false);
        deleteBtn = addButton(TextConstants.getConstant("DELETE"), Style.ICON_DELETE, HandlerCode.DELETE, false);

    }

    @Override
    public void setEnableEditDelete(boolean enable) {
        editBtn.setEnabled(enable);
        deleteBtn.setEnabled(enable);
    }
}
