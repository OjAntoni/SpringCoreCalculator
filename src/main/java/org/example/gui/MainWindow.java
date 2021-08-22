package org.example.gui;

import org.example.entity.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

@Component
public class MainWindow extends JFrame implements Goable {

    private ActionListener countButtonListener;
    private ActionListener historyButtonListener;
    static JTextField input = new JTextField();
    static JTextField input2 = new JTextField();
    static JComboBox<String> jComboBox = new JComboBox<>(Operation.getOperations());

    public MainWindow(){
        super("Main window");
        this.setBounds(150, 150, 400, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void go(){
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new GridLayout(4, 2, 10, 5));
        JLabel firstNumber = new JLabel("First number");
        contentPane.add(firstNumber);

        contentPane.add(input);

        JLabel operationLabel = new JLabel("Operation");
        contentPane.add(operationLabel);

        jComboBox.setSelectedIndex(0);
        contentPane.add(jComboBox);

        JLabel secondNumber = new JLabel("Second number number");
        contentPane.add(secondNumber);

        contentPane.add(input2);

        JButton historyButton = new JButton("My history");
        historyButton.addActionListener(historyButtonListener);
        contentPane.add(historyButton);

        JButton countButton = new JButton("count");
        countButton.addActionListener(countButtonListener);
        contentPane.add(countButton);

        setVisible(true);
    }

    @Autowired
    public void setCountButtonListener(ActionListener countButtonListener) {
        this.countButtonListener = countButtonListener;
    }

    @Autowired
    public void setHistoryButtonListener(ActionListener historyButtonListener) {
        this.historyButtonListener = historyButtonListener;
    }
}
