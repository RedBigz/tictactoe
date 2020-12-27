package com.redbigz.tictactoe;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Board extends Actions {
    public static JFrame f = new JFrame();
    public static String symbol = "X";

    public static void nextTurn() {
        symbol = symbol == "O" ? "X" : "O";
    }

    public static void init() {

        f.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //Create GUI

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        //Create Board

        int x = 1;
        int y;
        int yy;

        while (x <= 3) {

            y = 3;
            yy = 1;

            while (y > 0) {

                y = y - 1;

                JButton btn = new JButton(" ");

                btn.setBounds((x * 200) - 200, (y * 200), 200, 200);
                btn.setBorder(new LineBorder(Color.WHITE));

                final int fx = x;
                final int fy = yy;
                btn.addActionListener((a) -> { if (btn.getText() == " ") { nextTurn(); } btn.setText(btn.getText() == " " ? symbol : btn.getText()); });
                btn.setFont(new Font("Arial", Font.PLAIN, 40));

                f.add(btn);

                yy++;

            }

            x++;

        }

        //Start GUI
        f.setTitle("Tic Tac Toe");
        f.setSize(600, 600);
        f.setLayout(null);
        f.setVisible(true);

    }
}
