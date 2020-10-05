package settings;

import java.util.HashMap;
import java.util.Map;

public final class TextConstants {
    private static final Map<String, String> data = new HashMap<>();

    public static String getConstant(String key) {
        return data.get(key);
    }

    public static String[] getMonths() {
        String months[] = new String[12];
        months[0] = getConstant("JANUARY");
        months[1] = getConstant("FEBRUARY");
        months[2] = getConstant("MARCH");
        months[3] = getConstant("APRIL");
        months[4] = getConstant("MAY");
        months[5] = getConstant("JUNE");
        months[6] = getConstant("JULY");
        months[7] = getConstant("AUGUST");
        months[8] = getConstant("SEPTEMBER");
        months[9] = getConstant("OCTOBER");
        months[10] = getConstant("NOVEMBER");
        months[11] = getConstant("DECEMBER");
        return months;
    }


    public static void initData() {
        // IF RUSSIA
        data.put("PROGRAMM_NAME", "Личный Финансист");
        data.put("MENU_FILE", "Файл");
        data.put("MENU_EDIT", "Правка");
        data.put("MENU_VIEW", "Вид");
        data.put("MENU_HELP", "Помощь");

        data.put("JANUARY", "Январь");
        data.put("FEBRUARY", "Февраль");
        data.put("MARCH", "Март");
        data.put("APRIL", "Апрель");
        data.put("MAY", "Май");
        data.put("JUNE", "Июнь");
        data.put("JULY", "Июль");
        data.put("AUGUST", "Август");
        data.put("SEPTEMBER", "Сентябрь");
        data.put("OCTOBER", "Октябрь");
        data.put("NOVEMBER", "Ноябрь");
        data.put("DECEMBER", "Декабрь");

        // IF ENGLISH
    }
}
