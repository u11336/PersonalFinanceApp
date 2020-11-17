package app.gui.dialog;

import app.exception.ModelException;
import app.gui.MainButton;
import app.gui.MainFrame;
import app.model.Common;
import app.settings.HandlerCode;
import app.settings.Style;
import app.settings.TextConstants;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AddEditDialog extends JDialog {

    protected LinkedHashMap<String, JComponent> components = new LinkedHashMap<>();
    protected LinkedHashMap<String, ImageIcon> icons = new LinkedHashMap<>();
    protected LinkedHashMap<String, Object> values = new LinkedHashMap<>();
    protected Common c;

    public AddEditDialog(MainFrame frame){
        super(frame, TextConstants.getConstant("ADD"), true); // true означает что окно модальное
        setResizable(false);

    }

    public Common getCommon() {
        return c;
    }

    public void setCommon(Common c) {
        this.c = c;
    }
    
    public final void showDialog(){
        setDialog();
        setVisible(true);
    }

    public final void closeDialog(){
        setVisible(false);
        this.c = null;
        components.clear();
        icons.clear();
        values.clear();
        dispose();
    }

    public boolean isAdd(){
        return c == null;
    }


    abstract protected void init();
    abstract protected void setValues();
    abstract public Common getCommonFromForm() throws ModelException;

    private void setDialog() {
        init();
        if(isAdd()) {
            setTitle(TextConstants.getConstant("ADD"));
            setIconImage(Style.ICON_ADD.getImage());
        }
        else{
            setValues();
            setTitle("EDIT");
            setIconImage(Style.ICON_EDIT.getImage());
        }
        getContentPane().removeAll();
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        ((JPanel) getContentPane()).setBorder(Style.BORDER_DIALOG);
        for (Map.Entry<String, JComponent> entry : components.entrySet()) {
            String key = entry.getKey();
            JLabel label = new JLabel(TextConstants.getConstant(key));
            label.setIcon(icons.get(key));
            label.setFont(Style.FONT_DIALOG_LABEL);

            JComponent component = entry.getValue();
            if(component instanceof JTextField) {
                component.setPreferredSize(Style.DIMENSION_DIALOG_TEXTFIELD_SIZE);
                if(values.containsKey(key)) ((JTextField) component).setText("" + values.get(key));
            }
            else if(component instanceof JComboBox)
                if(values.containsKey(key)) ((JComboBox) component).setSelectedItem(values.get(key));
            else if(component instanceof JDatePickerImpl)
                if(values.containsKey(key)) ((UtilDateModel)((JDatePickerImpl) component).getModel()).setValue((Date) values.get(key));
            component.setAlignmentX(JComponent.LEFT_ALIGNMENT);
            add(label);
            add(Box.createVerticalStrut(Style.PADDING_DIALOG));
            add(component);
            add(Box.createVerticalStrut(Style.PADDING_DIALOG));
        }
        MainButton ok = new MainButton(TextConstants.getConstant("ADD"), Style.ICON_OK, null, HandlerCode.ADD);
        if(!isAdd()){
            ok.setActionCommand(HandlerCode.EDIT);
            ok.setText(TextConstants.getConstant("EDIT"));
        }

        MainButton cancel = new MainButton(TextConstants.getConstant("CANCEL"), Style.ICON_CANCEL, null, HandlerCode.CANCEL);

        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new BorderLayout());
        panelButtons.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        panelButtons.add(ok, BorderLayout.WEST);
        panelButtons.add(Box.createRigidArea(Style.DIMENSION_DIALOG_PADDING_BUTTON), BorderLayout.CENTER);
        panelButtons.add(cancel, BorderLayout.EAST);

        add(panelButtons);
        pack();
        setLocationRelativeTo(null);

    }

    protected class CommonComboBox extends JComboBox {
        public CommonComboBox(Object[] objs){
            super(objs);
            setRenderer(new DefaultListCellRenderer(){

                @Override
                public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    DefaultListCellRenderer renderer = (DefaultListCellRenderer) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    Common c = (Common) value;
                    if(c != null) renderer.setText(c.getValueForComboBox());
                    return renderer;
                }
            });
        }
    }
}
