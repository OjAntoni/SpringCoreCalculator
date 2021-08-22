package org.example.gui;

import org.example.entity.Operation;
import org.example.service.Converter;
import org.example.service.IntegerConverter;
import org.example.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class CountButtonListener implements ActionListener {
    //TODO
    private Converter integerConverter;
    private OperationService operationService;

    @Override
    public void actionPerformed(ActionEvent e) {
        String text1 = MainWindow.input.getText();
        String text2 = MainWindow.input2.getText();
        String selectedItem = (String) MainWindow.jComboBox.getSelectedItem();
        long firstNum;
        long secondNum;
        try {
            firstNum= integerConverter.convert(text1);
            secondNum= integerConverter.convert(text2);
            Operation operation = operationService.createOperation(firstNum, secondNum, selectedItem);
            operationService.save(operation);
            JOptionPane.showMessageDialog(null, operation, "result", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Autowired
    public void setConverter(IntegerConverter integerConverter) {
        this.integerConverter = integerConverter;
    }

    @Autowired
    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }
}
