package app.exception;

import app.settings.TextConstants;

public class ModelException extends Exception {

    public static final int TITLE_EMPTY = 1;
    public static final int EXISTS = 2;
    public static final int DATE_FORMAT = 3;
    public static final int CODE_EMPTY = 4;
    public static final int CURRENCY_EMPTY = 5;
    public static final int ARTICLE_EMPTY = 6;
    public static final int ACCOUNT_EMPTY = 7;
    public static final int RATE_INCORRECT = 8;
    public static final int AMOUNT_FORMAT = 9;
    public static final int NO_BASE_CURRENCY = 10;


    public final int code;

    public ModelException(int code) {
        this.code = code;
    }

    public String getMessage() {
        switch (code) {
            case TITLE_EMPTY:
                return TextConstants.getConstant("ERROR_TITLE_EMPTY");
            case EXISTS:
                return TextConstants.getConstant("ERROR_EXISTS");
            case DATE_FORMAT:
                return TextConstants.getConstant("ERROR_DATE_FORMAT");
            case CODE_EMPTY:
                return TextConstants.getConstant("ERROR_CODE_EMPTY");
            case CURRENCY_EMPTY:
                return TextConstants.getConstant("ERROR_CURRENCY_EMPTY");
            case ARTICLE_EMPTY:
                return TextConstants.getConstant("ERROR_ARTICLE_EMPTY");
            case ACCOUNT_EMPTY:
                return TextConstants.getConstant("ERROR_ACCOUNT_EMPTY");
            case RATE_INCORRECT:
                return TextConstants.getConstant("ERROR_RATE_INCORRECT");
            case AMOUNT_FORMAT:
                return TextConstants.getConstant("ERROR_AMOUNT_FORMAT");
            case NO_BASE_CURRENCY:
                return TextConstants.getConstant("ERROR_NO_BASE_CURRENCY");
        }
        return "";
    }
}
