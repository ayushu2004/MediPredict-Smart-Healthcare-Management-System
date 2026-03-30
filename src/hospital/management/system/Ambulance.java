package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {

    Ambulance() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 900, 550);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 40, 900, 450);
        table.setBackground(new Color(90, 156, 163));
        table.setFont(new Font("Tahoma", Font.BOLD, 12));
        panel.add(table);

        try {
            conn c = new conn();
            String q = "select * from Ambulance";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Name");
        label1.setBounds(28, 11, 100, 14);
        label1.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label1);

        JLabel label2 = new JLabel("Gender");
        label2.setBounds(230, 11, 100, 14);
        label2.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label2);

        JLabel label3 = new JLabel("Available");
        label3.setBounds(520, 11, 100, 14);
        label3.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label3);

        JLabel label4 = new JLabel("Car_name");
        label4.setBounds(366, 11, 100, 14);
        label4.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label4);

        JLabel label5 = new JLabel("Location");
        label5.setBounds(750, 11, 100, 14);
        label5.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(label5);

        JButton exit = new JButton("BACK");
        exit.setBounds(450, 510, 120, 30);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.white);
        panel.add(exit);

        exit.addActionListener(e -> setVisible(false));

        setSize(900, 600);
        setLayout(null);
        setLocation(430, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ambulance();
    }
}