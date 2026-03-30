package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable table;

    Room() {

        setTitle("Room Panel");
        setSize(900, 600);
        setLocationRelativeTo(null); // center
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 900, 600);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);


        URL url = getClass().getResource("/icon/roomm.png");

        if (url != null) {
            ImageIcon imageIcon = new ImageIcon(url);
            Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);

            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(600, 200, 200, 200);
            panel.add(label);
        } else {
            System.out.println("Image not found! Put it in: src/icon/room.png");
        }

        table = new JTable();
        table.setBounds(10, 40, 500, 400);
        table.setBackground(new Color(90, 156, 163));
        panel.add(table);

        try {

            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel label1 = new JLabel("Room No");
        label1.setBounds(12, 15, 80, 15);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(135, 15, 80, 15);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(260, 15, 80, 15);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JLabel label4 = new JLabel("Bed type");
        label4.setBounds(385, 15, 80, 15);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        JButton exit = new JButton("exit");
        exit.setBounds(200, 430, 120, 30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.white);
        panel.add(exit);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);

            }
        });

        setSize(800,550);
        setLayout(null);
        setLocation(200,200);
        setVisible(true);
    }

        public static void main(String[] args) {
            new Room();
        }
    }