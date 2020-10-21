package app.settings;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Comparator;
public final class Style {
    public static final Color COLOR_BTN_BG_NORMAL = new Color(240,240,240);
    public static final Color COLOR_BTN_BG_HOVER = Color.YELLOW;

    public static final Font FONT_BTN_TOOLBAR = new Font("Roboto-Light", Font.BOLD, 14);
    public static final Font FONT_BTN_MAIN = new Font("Roboto-Light", Font.BOLD, 14);

    public static final EmptyBorder BORDER_PANEL = new EmptyBorder(10,10,10,10);

    public static final ImageIcon ICON_MAIN = new ImageIcon("images/main.png");
    public static final ImageIcon ICON_TOOLBAR_OVERVIEW = new ImageIcon("images/overview.png");
    public static final ImageIcon ICON_TOOLBAR_ACCOUNTS = new ImageIcon("images/accounts.png");
    public static final ImageIcon ICON_TOOLBAR_ARTICLES = new ImageIcon("images/articles.png");
    public static final ImageIcon ICON_TOOLBAR_TRANSACTIONS = new ImageIcon("images/transactions.png");
    public static final ImageIcon ICON_TOOLBAR_TRANSFERS = new ImageIcon("images/transfers.png");
    public static final ImageIcon ICON_TOOLBAR_CURRENCIES = new ImageIcon("images/currencies.png");
    public static final ImageIcon ICON_TOOLBAR_STATISCTICS = new ImageIcon("images/statistics.png");
}
