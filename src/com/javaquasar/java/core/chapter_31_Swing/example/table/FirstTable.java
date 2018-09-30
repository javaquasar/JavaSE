package com.javaquasar.java.core.chapter_31_Swing.example.table;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * Created by Java Quasar on 16.05.17.
 */
public class FirstTable extends JFrame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Object[][] data = {{"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}}; // данные в ячейках
    JTable table = new JTable(data, new Object[]{"x", "y", "Сумма", "b"});
    JButton button = new JButton("Рассчитать");

    public FirstTable() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600); // размеры окна
        setLocation(300, 150);
        setTitle("Суммы"); // определяем заголовок окна
        getContentPane().add(table.getTableHeader(), BorderLayout.NORTH); // шапка таблицы - сверху
        getContentPane().add(table, BorderLayout.CENTER); // таблица - в центре
        button.addActionListener(this);
        getContentPane().add(button, BorderLayout.SOUTH); // кнопка - снизу
        pack(); // подгоняем размеры окна под его содержимое
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            table.editCellAt(0, 0); // устанавливаем редактор таблицы в исходное состояние
            for (int i = 0; i < data.length; i++) {
                int x = Integer.parseInt((String) data[i][0]);
                int y = Integer.parseInt((String) data[i][1]);
                int z = x + y;
                data[i][2] = z + "";
            }
            repaint(); // перерисовываем окно после обновления данных
        } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(this, "Неправильные данные!");
        }
    }

    public static void main(String[] args) {
        new FirstTable().setVisible(true);
    }
}
