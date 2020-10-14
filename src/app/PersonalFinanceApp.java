package app;

import app.settings.Settings;
import app.settings.TextConstants;

import java.awt.*;
import java.io.IOException;

public class PersonalFinanceApp {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        Settings.init();
        TextConstants.initData();
        //add font
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_AVENIR_LT55_ROMAN));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}