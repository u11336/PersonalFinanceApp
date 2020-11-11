package app.gui;

import app.settings.Style;
import app.settings.TextConstants;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private GridBagConstraints constraints;

    public MainFrame(){
        super(TextConstants.getConstant("PROGRAMM_NAME"));
        setResizable(false); // окно не изменяемое
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // при закрытии окна завершается программа

        setLayout(new GridBagLayout()); //компоновщик (причем довольно гибкий. делает layout в виде таблицы)

        constraints = new GridBagConstraints();

        //первая ячейка в первой строке
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2; // ячека шириной в 2 столбца

        //размечаем левую панель
        constraints.gridy = 1; // x не меняем так как нам нужен все тот же верхний ряд
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH; // привязываем панельку к верху
        // TODO: 11/11/20 add left panel

        pack();

        setLocationRelativeTo(null); // центруем окно
    }
}
