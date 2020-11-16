package app.gui;

import app.gui.dialog.*;
import app.gui.menu.MainMenu;
import app.gui.panel.*;
import app.gui.toolbar.MainToolBar;
import app.settings.Style;
import app.settings.TextConstants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame implements Refresh {

    private final GridBagConstraints constraints;
    private final MainMenu mb;
    public final LeftPanel leftPanel;
    public RightPanel rightPanel;
    private final MainToolBar tb;

    public MainFrame(){
        super(TextConstants.getConstant("PROGRAM_NAME"));

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

        //default panel render
        setRightPanel(new TransferPanel(this));

        pack();
        setLocationRelativeTo(null); // центруем окно
    }

    private void setRightPanel(RightPanel panel) {
        if(rightPanel != null) remove(rightPanel);
        constraints.gridy = 1;
        constraints.gridx = 1;
        rightPanel = panel;
        panel.setBorder(Style.BORDER_PANEL);
        add(rightPanel, constraints);
        pack();
    }

    @Override // метод и сам интерфейс нужны для того чтобы производить обновление гуи при изменении данных
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        mb.refresh();
        tb.refresh();
        leftPanel.refresh();
        rightPanel.refresh();
        pack();
    }

    public MainMenu getMenu() {
        return mb;
    }

    public RightPanel getRightPanel() {
        return rightPanel;
    }
}
