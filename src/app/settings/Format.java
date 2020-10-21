package app.settings;

import app.model.Currency;
import app.model.Filter;
import org.w3c.dom.Text;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Format {
    public static String amount(double amount) {
        return String.format(Settings.FORMAT_AMOUNT, amount);
    }

    public static String amount(double amount, Currency currency) {
        return amount(amount) + " " + currency.getCode();
    }

    public static String rate(double rate) {
        return String.format(Settings.FORMAT_AMOUNT, rate);
    }

    public static String rate(double rate, Currency currency) {
        return rate(rate) + " " + currency.getCode();
    }

    public static String dateDay(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_DAY);
    }

    public static String dateMonth(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_MONTH);
    }

    public static String dateYear(Date date) {
        return dateFormat(date, Settings.FORMAT_DATE_YEAR);
    }

    private static String dateFormat(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, new MainDateFormatSymbols());
        return sdf.format(date);
    }

    public static double fromAmountToNumber(String amount) throws NumberFormatException {
        amount = amount.replaceAll(",", ".");
        return Double.parseDouble(amount);
    }

    public static String yesNo(boolean yes) {
        if (yes) return TextConstants.getConstant("YES");
        return TextConstants.getConstant("NO");

    }

    public static String getTitleFilter(Filter filter) {
        Date time = filter.getTo();
        switch (filter.getStep()) {
            case Filter.STEP_DAY:
                return dateDay(time);
            case Filter.STEP_MONTH:
                return dateMonth(time);
            case Filter.STEP_YEAR:
                return dateYear(time);
        }
        return null;
    }

    private static class MainDateFormatSymbols extends DateFormatSymbols {
        public String[] getMonths(){
            return TextConstants.getMonths();
        }
    }
}
