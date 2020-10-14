package app.settings;

import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.prefs.Preferences;

public class Settings {

    public static final File FONT_AVENIR_LT55_ROMAN = new File("fonts/avenir_LT55_roman.ttf");
    public static final File SAVE_DIR = new File("saves/");
    public static final String SAVE_EXT = "sv";

    public static final String FORMAT_AMOUNT = "%.2f"; // get the whole number and round up to 2 decimals
    public static final String FORMAT_RATE = "%.4f";
    public static final String FORMAT_DATE_DAY = "dd.MM.yyyy";
    public static final String FORMAT_DATE_MONTH = "MMMM yyyy";
    public static final String FORMAT_DATE_YEAR = "yyyy";

    public static final int OVERVIEW_ROWS_NUMBER = 10;

    public static final String[] CURRENCY_CODES = new String[]{"UZS", "RUB", "USD", "EUR"};

    private static final File FILE_SETTINGS = new File("saves/settings.ini");
    private static File FILE_SAVE = new File("saves/default.sv"); // default save file


    public static File getFileSave() {
        return FILE_SAVE;
    }

    public static void setFileSave(File fileSave) {
        FILE_SAVE = fileSave;
        save();
    }

    private static void save() {
        try {
            Wini ini = new Wini(FILE_SETTINGS);
            ini.put("Settings", "FILE_SAVE", FILE_SAVE.getAbsolutePath().replace("\\", "\\\\"));
            ini.store();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        try {
            Ini ini = new Ini(FILE_SETTINGS);
            Preferences prefs = new IniPreferences(ini);
            String file = prefs.node("Settings").get("FILE_SAVE", null);
            if (file != null) FILE_SAVE = new File(file);
            setLocale();
        } catch (IOException e) {
            save();
        }
    }

    private static void setLocale() {
        Locale.setDefault(new Locale("ru"));
    }

}
