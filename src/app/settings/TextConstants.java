package app.settings;

import java.util.HashMap;
import java.util.Map;

public final class TextConstants {
    private static final Map<String, String> data = new HashMap<>();

    public static String getConstant(String key) {
        if(data.containsKey(key)) return data.get(key);
        System.out.println("Такого ключа не существует"); // for refactoring
        return "";
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


        data.put("ERROR_TITLE_EMPTY", "Вы не ввели название!");
        data.put("ERROR_EXISTS", "Такая запись уже существует!");
        data.put("ERROR_DATE_FORMAT", "Некорректный формат даты!");
        data.put("ERROR_CODE_EMPTY", "Вы не указали код!");
        data.put("ERROR_CURRENCY_EMPTY", "Вы не выбрали валюту!");
        data.put("ERROR_ARTICLE_EMPTY", "Вы не выбрали статью!");
        data.put("ERROR_ACCOUNT_EMPTY", "Вы не выбрали счет!");
        data.put("ERROR_RATE_INCORRECT", "Некорректное значение курса!");
        data.put("ERROR_AMOUNT_FORMAT", "Некорректный формат суммы!");
        data.put("ERROR_NO_BASE_CURRENCY", "Необходима базовая валюта!");

        data.put("YES", "YES YES YES");
        data.put("NO", "NO NO NO");
        // IF ENGLISH
    }
}
