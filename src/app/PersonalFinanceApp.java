package app;

import app.settings.TextConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PersonalFinanceApp {
    public static void main(String[] args) {
        init();
        System.out.println(TextConstants.getConstant("JANUARY"));
    }

    public static void init() {
        TextConstants.initData();

        //add font
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/avenir_LT55_roman.ttf")));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
}