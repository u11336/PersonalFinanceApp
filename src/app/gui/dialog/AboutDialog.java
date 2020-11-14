package app.gui.dialog;

import app.settings.Style;
import app.settings.TextConstants;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class AboutDialog extends JDialog {
    public AboutDialog(){
        super();
        init();
        setTitle(TextConstants.getConstant("DIALOG_ABOUT_TITLE"));
        setIconImage(Style.ICON_ABOUT.getImage());
        setResizable(false);
    }

    private void init() {
        JEditorPane pane = new JEditorPane("text/html", TextConstants.getConstant("ABOUT"));
        pane.setEditable(false);
        pane.setOpaque(false);

        // делаем ссылку в описании кликабельной
        pane.addHyperlinkListener(hyperlinkEvent -> {
            if(HyperlinkEvent.EventType.ACTIVATED.equals(hyperlinkEvent.getEventType())){
                try {
                    Desktop.getDesktop().browse(hyperlinkEvent.getURL().toURI());
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });

        add(pane);
        pack();
        setLocationRelativeTo(null);
    }
}
