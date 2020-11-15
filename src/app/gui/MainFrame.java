package app.gui;

import app.gui.dialog.*;
import app.gui.menu.MainMenu;
import app.gui.panel.LeftPanel;
import app.gui.toolbar.MainToolBar;
import app.settings.Style;
import app.settings.TextConstants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh {

    private final GridBagConstraints constraints;
    private final MainMenu mb;
    public final LeftPanel leftPanel;
    private final MainToolBar tb;

    public MainFrame(){
        super(TextConstants.getConstant("PROGRAM_NAME"));

//        new AccountAddEditDialog(this).showDialog();
//        new ArticleAddEditDialog(this).showDialog();
//        new CurrencyAddEditDialog(this).showDialog();
//        new TransferAddEditDialog(this).showDialog();
//        new TransactionAddEditDialog(this).showDialog();

        setResizable(false); // окно неизменяемое
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // при закрытии окна завершается программа

        mb = new MainMenu(this);
        setJMenuBar(mb);

        setLayout(new GridBagLayout()); //компоновщик (причем довольно гибкий. делает layout в виде таблицы)

        constraints = new GridBagConstraints();

        //первая ячейка в первой строке
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2; // ячека шириной в 2 столбца

        tb = new MainToolBar();
        add(tb, constraints);


        //размечаем левую панель
        constraints.gridy = 1; // x не меняем так как нам нужен все тот же верхний ряд
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH; // привязываем панельку к верху
        leftPanel = new LeftPanel(this);
        add(leftPanel, constraints);

        pack();
        setLocationRelativeTo(null); // центруем окно
    }

    @Override // метод и сам интерфейс нужны для того чтобы производить обновление гуи при изменении данных
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        mb.refresh();
        pack();
    }

    public MainMenu getMenu() {
        return mb;
    }
}
