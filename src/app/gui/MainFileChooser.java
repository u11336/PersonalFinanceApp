package app.gui;

import app.settings.Settings;
import app.settings.TextConstants;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFileChooser extends JFileChooser {

    private final MainFrame frame;

    public MainFileChooser(MainFrame frame){
        this.frame = frame;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Program Files", Settings.SAVE_EXT);
        setFileFilter(filter);
        setAcceptAllFileFilterUsed(false);
        setCurrentDirectory(Settings.SAVE_DIR);

        UIManager.put("FileChooser.homeFolderToolTipText", TextConstants.getConstant("FC_HOME"));
        UIManager.put("FileChooser.saveDialogTitleText", TextConstants.getConstant("FC_SAVE"));
        UIManager.put("FileChooser.openDialogTitleText", TextConstants.getConstant("FC_OPEN"));
        UIManager.put("FileChooser.lookInLabelText", TextConstants.getConstant("FC_LOOK"));
        UIManager.put("FileChooser.saveInLabelText", TextConstants.getConstant("FC_LOOK"));

        UIManager.put("FileChooser.openButtonText", TextConstants.getConstant("FC_OPEN"));
        UIManager.put("FileChooser.openButtonToolTipText", TextConstants.getConstant("FC_OPEN"));
        UIManager.put("FileChooser.saveButtonText", TextConstants.getConstant("FC_SAVE"));
        UIManager.put("FileChooser.saveButtonToolTipText", TextConstants.getConstant("FC_SAVE"));
        UIManager.put("FileChooser.cancelButtonText", TextConstants.getConstant("FC_CANCEL"));
        UIManager.put("FileChooser.cancelButtonToolTipText", TextConstants.getConstant("FC_CANCEL"));

        UIManager.put("FileChooser.fileNameLabelText", TextConstants.getConstant("FC_NAME_FILE"));
        UIManager.put("FileChooser.filesOfTypeLabelText", TextConstants.getConstant("FC_TYPE_FILE"));


        UIManager.put("FileChooser.upFolderToolTipText", TextConstants.getConstant("FC_UP"));
        UIManager.put("FileChooser.newFolderToolTipText", TextConstants.getConstant("FC_NEW_DIRECTORY"));
        UIManager.put("FileChooser.listViewButtonToolTipText", TextConstants.getConstant("FC_LIST"));
        UIManager.put("FileChooser.detailsViewButtonToolTipText", TextConstants.getConstant("FC_TABLE"));
        UIManager.put("FileChooser.fileNameHeaderText", TextConstants.getConstant("FC_NAME"));
        UIManager.put("FileChooser.fileSizeHeaderText", TextConstants.getConstant("FC_SIZE"));
        UIManager.put("FileChooser.fileTypeHeaderText", TextConstants.getConstant("FC_TYPE"));
        UIManager.put("FileChooser.fileDateHeaderText", TextConstants.getConstant("FC_DATE"));
        UIManager.put("FileChooser.fileAttrHeaderText", TextConstants.getConstant("FC_ATTR"));

        UIManager.put("FileChooser.acceptAllFileFilterText", TextConstants.getConstant("FC_ALL_FILTER"));

        updateUI();
    }

    public int open(){
        return super.showOpenDialog(frame);
    }

    public int save(){
        return super.showSaveDialog(frame);
    }
}
