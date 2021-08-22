package org.example.gui;

import org.example.entity.Operation;
import org.example.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Component
public class HistoryWindow extends JFrame implements Goable{

    public OperationService operationService;

    public HistoryWindow(){
        super("Main window");
        this.setBounds(150, 150, 100, 200);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }

    public void go(){
        Container contentPane = this.getContentPane();
        JList<String> list = new JList<>(getArrayOfOperations());
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(list);
        contentPane.add(listScroller);
        this.setVisible(true);
    }


    @Autowired
    public void setOperationService(OperationService operationService) {
        this.operationService = operationService;
    }

    private String[] getArrayOfOperations(){
        List<Operation> operations = operationService.getOperations();
        String[] array = new String[operations.size()];
        for (int i = 0; i < operations.size(); i++) {
            array[i] = operations.get(i).toString();
        }
        return array;
    }
}
